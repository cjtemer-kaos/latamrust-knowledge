#!/usr/bin/env python3
"""
CobbleVerse Launcher v5.0 - Fusionado
Google Drive + Java 21 auto + Skins sync (install + play) + Update
"""
import tkinter as tk
from tkinter import ttk, messagebox
import subprocess, threading, os, re, time, json, sys, logging
import urllib.request, shutil, zipfile

# ── Paths ─────────────────────────────────────────────────────
if getattr(sys, "frozen", False):
    BASE_DIR = os.path.dirname(sys.executable)
else:
    BASE_DIR = os.path.dirname(os.path.abspath(__file__))
ASSETS = os.path.join(BASE_DIR, "assets")
LOG_FILE = os.path.join(BASE_DIR, "launcher.log")
CONFIG_FILE = os.path.join(BASE_DIR, "config.json")
GAME_DIR = os.path.join(os.path.expanduser("~"), "AppData", "Roaming", "LatamRust")
TEMP_DIR = os.path.join(os.environ.get("TEMP", os.path.expanduser("~")), "CobbleVerse_Temp")
GDRIVE_ID = "1h0ohkqZrSO2XX-ZIXYx7Ru0lAKqj9--n"
GDRIVE_URL = f"https://drive.google.com/uc?export=download&id={GDRIVE_ID}"
SKINS_API = "https://api.github.com/repos/cjtemer-kaos/cobbleverse-pack/releases/tags/skins-v1"
# Resource pack individual publicado como release GitHub (respack-*). Se descarga a
# GAME_DIR/resourcepacks/ si falta o difiere en tamaño. Redundancia: el servidor tam
#bien fuerza el pack al conectar (require-resource-pack=true).
RESPACK_UPDATES = [
    ("LATAMRUST_ES_1.21.1.zip",
     "https://github.com/cjtemer-kaos/cobbleverse-pack/releases/download/respack-v1/LATAMRUST_ES_1.21.1.zip"),
]
# Rutas relativas a GAME_DIR de archivos OBSOLETOS a BORRAR en cada ACTUALIZAR
# (ej. datapack "No Hunger" que dio problemas; agregar futuros archivos aqui)
OBSOLETE_FILES = [
    os.path.join("datapacks", "COBBLEVERSE - No Hunger.zip"),
]
VERSION = "5.0.0"

logging.basicConfig(filename=LOG_FILE, level=logging.DEBUG,
    format="%(asctime)s %(levelname)s %(message)s")
log = logging.getLogger("cv")

# ── Colors ────────────────────────────────────────────────────
C = {"bg":"#111118","bg2":"#1a1a24","card":"#1e1e2e","input":"#16161f",
     "border":"#2c2c3e","accent":"#5b9bf5","accent2":"#4a8ae0",
     "green":"#40b882","red":"#e94560","yellow":"#f0b232",
     "text":"#e0e0ee","text2":"#8888a8","text3":"#555570","white":"#ffffff"}

def fmt_time(s):
    if s<60: return f"{int(s)}s"
    if s<3600: return f"{int(s//60)}m {int(s%60)}s"
    return f"{int(s//3600)}h {int((s%3600)//60)}m"

def cfg_load():
    try:
        with open(CONFIG_FILE) as f: return json.load(f)
    except: return {"username":"Jugador","ram":"8","version":"0.0.0"}

def cfg_save(d):
    with open(CONFIG_FILE,"w") as f: json.dump(d,f,indent=2)

def installed():
    m=os.path.join(GAME_DIR,"mods")
    if not os.path.isdir(m): return False
    return any("fabric-api" in f for f in os.listdir(m))

# ── Java 21 ───────────────────────────────────────────────────
JAVA_DIR = os.path.join(GAME_DIR, "jdk-21")
JAVA_URL = "https://download.oracle.com/java/21/archive/jdk-21.0.7_windows-x64_bin.zip"

def find_java():
    for p in [os.path.join(JAVA_DIR,"jdk","bin","java.exe"),
              os.path.join(GAME_DIR,"jvm","bin","java.exe")]:
        if os.path.exists(p): return p
    jh = os.environ.get("JAVA_HOME","")
    if jh and os.path.exists(os.path.join(jh,"bin","java.exe")):
        return os.path.join(jh,"bin","java.exe")
    for p in ["java","javaw"]:
        try:
            subprocess.run([p,"-version"], capture_output=True, timeout=5)
            return p
        except: pass
    return None

def install_java(cb=None):
    os.makedirs(JAVA_DIR, exist_ok=True)
    zp = os.path.join(TEMP_DIR,"jdk-21.zip")
    os.makedirs(TEMP_DIR, exist_ok=True)
    try:
        if cb: cb("Descargando Java 21...", 0)
        req = urllib.request.Request(JAVA_URL, headers={"User-Agent":"CobbleVerse/5.0"})
        with urllib.request.urlopen(req, timeout=120) as resp:
            total = int(resp.headers.get("Content-Length",0))
            dl = 0
            with open(zp,"wb") as f:
                while True:
                    chunk = resp.read(1024*1024)
                    if not chunk: break
                    f.write(chunk); dl += len(chunk)
                    if cb and total>0: cb(f"Java 21: {dl//1048576}/{total//1048576}MB", dl/total*100)
        if cb: cb("Extrayendo Java 21...", 95)
        with zipfile.ZipFile(zp) as zf:
            for name in zf.namelist():
                if name.endswith("/bin/java.exe"):
                    jdk_dir = name.split("/bin/")[0]
                    zf.extractall(JAVA_DIR)
                    extracted = os.path.join(JAVA_DIR, jdk_dir)
                    target = os.path.join(JAVA_DIR, "jdk")
                    if os.path.exists(target): shutil.rmtree(target)
                    os.rename(extracted, target)
                    break
        try: os.remove(zp)
        except: pass
        java = os.path.join(JAVA_DIR,"jdk","bin","java.exe")
        return java if os.path.exists(java) else None
    except Exception as e:
        log.error(f"Java install failed: {e}")
        return None

# ── Launcher ──────────────────────────────────────────────────
class Launcher:
    def __init__(self):
        self.root = tk.Tk()
        self.root.title("LatamRust Cobbleverse")
        self.root.geometry("560x580")
        self.root.configure(bg=C["bg"])
        self.root.resizable(False, False)
        self.cfg = cfg_load()
        self._build()
        self.root.mainloop()

    def _build(self):
        tk.Frame(self.root, bg=C["bg2"], height=40).pack(fill="x")
        hdr = tk.Frame(self.root, bg=C["bg"])
        hdr.pack(fill="x", padx=30, pady=(18,5))
        tk.Label(hdr, text="LATAMRUST", font=("Segoe UI",28,"bold"), fg=C["accent"], bg=C["bg"]).pack()
        tk.Label(hdr, text="COBBLEVERSE", font=("Segoe UI",14,"bold"), fg=C["white"], bg=C["bg"]).pack()
        tk.Label(hdr, text="Fabric 1.21.1  |  PvE  |  20 Jugadores", font=("Segoe UI",9), fg=C["text2"], bg=C["bg"]).pack(pady=(2,0))
        self.status = tk.Label(self.root, text="", font=("Segoe UI",11,"bold"), fg=C["accent"], bg=C["bg"], wraplength=500)
        self.status.pack(pady=(12,2))
        self.detail = tk.Label(self.root, text="", font=("Segoe UI",9), fg=C["text2"], bg=C["bg"], wraplength=500)
        self.detail.pack()
        style = ttk.Style(); style.theme_use("default")
        style.configure("CV.Horizontal.TProgressbar", background=C["accent"], troughcolor=C["card"], thickness=5)
        self.progress = ttk.Progressbar(self.root, length=480, mode="determinate", style="CV.Horizontal.TProgressbar")
        card = tk.Frame(self.root, bg=C["card"], highlightbackground=C["border"], highlightthickness=1)
        card.pack(fill="x", padx=30, pady=8)
        r1 = tk.Frame(card, bg=C["card"]); r1.pack(fill="x", padx=15, pady=(10,4))
        tk.Label(r1, text="USUARIO", font=("Segoe UI",9,"bold"), fg=C["text2"], bg=C["card"]).pack(side="left")
        self.username = tk.Entry(r1, width=25, font=("Segoe UI",12), bg=C["input"], fg=C["text"], insertbackground=C["text"], highlightbackground=C["border"], highlightthickness=1, bd=0)
        self.username.insert(0, self.cfg.get("username","Jugador"))
        self.username.pack(side="right", ipady=4)
        r2 = tk.Frame(card, bg=C["card"]); r2.pack(fill="x", padx=15, pady=(0,10))
        tk.Label(r2, text="RAM", font=("Segoe UI",9,"bold"), fg=C["text2"], bg=C["card"]).pack(side="left")
        self.ram_var = tk.StringVar(value=self.cfg.get("ram","8"))
        tk.Spinbox(r2, from_=2, to=32, width=3, textvariable=self.ram_var, font=("Segoe UI",11), bg=C["input"], fg=C["text"], buttonbackground=C["card"], bd=0).pack(side="right", padx=(0,5))
        tk.Label(r2, text="GB", font=("Segoe UI",9), fg=C["text3"], bg=C["card"]).pack(side="right")
        bf = tk.Frame(self.root, bg=C["bg"]); bf.pack(pady=10)
        self.install_btn = tk.Button(bf, text="INSTALAR", font=("Segoe UI",13,"bold"), bg=C["accent"], fg=C["white"], width=14, bd=0, cursor="hand2", command=self._on_install)
        self.install_btn.pack(side="left", padx=8)
        self.play_btn = tk.Button(bf, text="JUGAR", font=("Segoe UI",13,"bold"), bg=C["green"], fg=C["white"], width=14, bd=0, cursor="hand2", command=self._on_play)
        self.play_btn.pack(side="left", padx=8)
        self.update_btn = tk.Button(self.root, text="ACTUALIZAR", font=("Segoe UI",10), bg=C["card"], fg=C["text2"], width=32, bd=0, cursor="hand2", command=self._on_update)
        self.update_btn.pack(pady=(0,3))
        tk.Label(self.root, text="by KAOS_MCS", font=("Segoe UI",9), fg=C["text3"], bg=C["bg"]).pack(side="bottom", pady=(0,8))
        self._refresh()

    def _refresh(self):
        if installed():
            self.install_btn.config(state="disabled", bg=C["card"], fg=C["text3"], text="✓ INSTALADO")
            self.play_btn.config(state="normal", bg=C["green"], fg=C["white"])
            self.update_btn.pack(pady=(0,3))
            self.progress.pack_forget()
            self.status.config(text="¡Juego listo! Presiona JUGAR", fg=C["green"])
            self.detail.config(text="")
        else:
            self.install_btn.config(state="normal", bg=C["accent"], fg=C["white"], text="INSTALAR")
            self.play_btn.config(state="disabled", bg=C["card"], fg=C["text3"])
            self.update_btn.pack_forget()
            self.progress.pack_forget()
            self.status.config(text="Presiona INSTALAR para comenzar", fg=C["accent"])

    def _set(self, m, c=C["accent"]): self.status.config(text=m, fg=c)
    def _det(self, m): self.detail.config(text=m)
    def _prog(self, v): self.progress["value"] = max(0,min(v,100))

    def _on_install(self):
        self.install_btn.config(state="disabled", text="INSTALANDO...")
        self.play_btn.config(state="disabled")
        self.progress.pack(pady=5); self.progress["value"] = 0
        self._set("Iniciando...")
        threading.Thread(target=self._install, daemon=True).start()

    def _on_update(self):
        self.update_btn.config(state="disabled", text="BUSCANDO...")
        self._set("Buscando actualizaciones...")
        threading.Thread(target=self._check_update, daemon=True).start()

    def _check_update(self):
        try:
            # 0) Borrar archivos obsoletos (ej. datapack No Hunger)
            for rel in OBSOLETE_FILES:
                p = os.path.join(GAME_DIR, rel)
                try:
                    if os.path.exists(p):
                        os.remove(p)
                        log.info(f"Obsoleto eliminado: {rel}")
                except Exception as e:
                    log.warning(f"No se pudo borrar {rel}: {e}")

            # 0.5) Resource packs (respack-*): descargar a resourcepacks/ si falta/desactualizado
            rp_dir = os.path.join(GAME_DIR, "resourcepacks")
            os.makedirs(rp_dir, exist_ok=True)
            for rp_name, rp_url in RESPACK_UPDATES:
                rp_path = os.path.join(rp_dir, rp_name)
                try:
                    if os.path.exists(rp_path):
                        req_head = urllib.request.Request(rp_url, method="HEAD", headers={"User-Agent":"CobbleVerse/5.0"})
                        with urllib.request.urlopen(req_head, timeout=15) as h:
                            remote_size = int(h.headers.get("Content-Length", 0) or 0)
                        if remote_size and os.path.getsize(rp_path) == remote_size:
                            continue  # ya esta al dia
                    log.info(f"Descargando resource pack: {rp_name}")
                    self.root.after(0, lambda n=rp_name: self._set(f"Descargando {n}..."))
                    urllib.request.urlretrieve(rp_url, rp_path)
                    log.info(f"Resource pack descargado: {rp_name}")
                except Exception as e:
                    log.warning(f"Resource pack {rp_name} no actualizado: {e}")

            req = urllib.request.Request(SKINS_API, headers={"User-Agent":"CobbleVerse/5.0"})
            with urllib.request.urlopen(req, timeout=15) as r: release = json.loads(r.read())
            remote = release.get("tag_name","")
            local = self.cfg.get("skins_version","")
            if remote != local:
                self.root.after(0, lambda: self._set(f"Actualización: {remote}"))
                self._sync_skins()
                cfg_save({**self.cfg, "skins_version": remote})
                self.root.after(0, lambda: (self._set("Skins actualizadas!", C["green"]), self.update_btn.config(state="normal", text="ACTUALIZAR")))
            else:
                self.root.after(0, lambda: (self._set("Todo actualizado", C["green"]), self.update_btn.config(state="normal", text="ACTUALIZAR")))
        except Exception as e:
            self.root.after(0, lambda: (self._set(f"Error: {e}", C["red"]), self.update_btn.config(state="normal", text="ACTUALIZAR")))

    def _on_play(self):
        user = self.username.get().strip()
        if not user: messagebox.showerror("Error","Ingresa tu nombre"); return
        cfg_save({**self.cfg, "username": user})
        self._set("Sincronizando skins...", C["green"])
        threading.Thread(target=self._sync_skins_then_play, args=(user,), daemon=True).start()

    def _sync_skins_then_play(self, user):
        """Sync skins from GitHub BEFORE launching game."""
        try:
            req = urllib.request.Request(SKINS_API, headers={"User-Agent":"CobbleVerse/5.0"})
            with urllib.request.urlopen(req, timeout=15) as resp:
                release = json.loads(resp.read())
            asset = next((a for a in release.get("assets",[]) if a["name"].endswith(".zip")), None)
            if asset:
                skins_zip = os.path.join(TEMP_DIR, "cobbleverse-skins.zip")
                skins_dst = os.path.join(GAME_DIR, "config", "easy_npc", "skin")
                os.makedirs(TEMP_DIR, exist_ok=True)
                os.makedirs(skins_dst, exist_ok=True)
                rc = subprocess.run(["curl","-L","-s","-o",skins_zip, asset["browser_download_url"]], timeout=30).returncode
                if rc == 0:
                    with zipfile.ZipFile(skins_zip, "r") as zf:
                        zf.extractall(skins_dst)
                try: os.remove(skins_zip)
                except: pass
        except: pass
        self._play(user)

    def _play(self, user):
        try:
            ram = int(self.ram_var.get().strip()) * 1024
            pmc = None
            for p in [os.path.join(GAME_DIR,"portablemc.exe"), os.path.join(BASE_DIR,"portablemc.exe")]:
                if os.path.exists(p): pmc = p; break
            if pmc:
                subprocess.Popen([pmc, "start", "fabric:1.21.1:0.18.4", "--main-dir", GAME_DIR, "-u", user, f"--jvm-arg=-Xms{ram}m,-Xmx{ram}m", "--jvm-policy=mojang"])
            else:
                java = find_java()
                if not java: raise Exception("Java no encontrado. Reinicia el launcher.")
                subprocess.Popen([java, f"-Xms{ram}m", f"-Xmx{ram}m", "-jar", os.path.join(GAME_DIR,"fabric-server.jar"), "nogui"])
            self.root.after(0, lambda: self._set("Juego abierto!", C["green"]))
        except Exception as e:
            self.root.after(0, lambda: self._set(f"Error: {e}", C["red"]))

    # ── Install ───────────────────────────────────────────────
    def _install(self):
        log.info("=== INSTALL STARTED ===")
        try:
            os.makedirs(GAME_DIR, exist_ok=True)
            os.makedirs(TEMP_DIR, exist_ok=True)
            # Step 1: Download
            log.info("Step 1: downloading from Google Drive")
            self.root.after(0, lambda: (self._set("Descargando modpack..."), self._det("Google Drive")))
            zp = os.path.join(TEMP_DIR, "cobbleverse.zip")
            try: os.remove(zp)
            except: pass
            self._dl_start = time.time()
            if not self._dl_gdrive(zp): raise Exception("Error descargando modpack")
            log.info("Step 1 DONE")
            # Step 2: Extract
            log.info("Step 2: extracting")
            self.root.after(0, lambda: (self._set("Extrayendo modpack..."), self._det("")))
            self._extract(zp)
            log.info("Step 2 DONE")
            # Step 3: Sync skins
            log.info("Step 3: syncing skins")
            self.root.after(0, lambda: (self._set("Sincronizando skins..."), self._det("")))
            self._sync_skins()
            log.info("Step 3 DONE")
            # Step 4: Download portablemc to GAME_DIR (permanent location)
            pmc_dest = os.path.join(GAME_DIR, "portablemc.exe")
            if not os.path.exists(pmc_dest):
                log.info("Step 4: downloading portablemc")
                self.root.after(0, lambda: self._set("Descargando portablemc..."))
                self._download_portablemc(pmc_dest)
            else:
                log.info("portablemc already exists")
            # Step 5: Java 21
            java = find_java()
            if not java:
                log.info("Step 5: installing Java 21")
                self.root.after(0, lambda: (self._set("Descargando Java 21..."), self._det("")))
                java = install_java(lambda m,p: self.root.after(0, lambda m=m,p=p: (self._set(m), self._prog(p))))
                if not java: log.warning("Java install failed")
            else: log.info(f"Java found: {java}")
            # Cleanup + verify
            try: shutil.rmtree(TEMP_DIR, ignore_errors=True)
            except: pass
            for _ in range(3):
                if installed(): break
                time.sleep(2)
            if not installed(): raise Exception("Instalacion falló - faltan archivos")
            cfg_save({**self.cfg, "username": self.username.get().strip(), "version": VERSION})
            log.info("=== INSTALL COMPLETED ===")
            self.root.after(0, lambda: (self._prog(100), self._set("Instalacion completa!", C["green"]), self._det(""), self.progress.pack_forget()))
            self.root.after(100, self._refresh)
        except Exception as e:
            log.error(f"FAIL: {e}")
            self.root.after(0, lambda: (self._set(str(e), C["red"]), self._det(""), self.progress.pack_forget()))
            self.root.after(100, self._refresh)

    def _dl_gdrive(self, dest):
        import gdown
        self._dl_start = time.time()
        try:
            gdown.download(id=GDRIVE_ID, output=dest, quiet=True)
            if os.path.exists(dest) and os.path.getsize(dest)>1000000:
                sz = os.path.getsize(dest)//1048576
                elapsed = time.time()-self._dl_start
                speed = os.path.getsize(dest)/elapsed/1048576 if elapsed>0 else 0
                log.info(f"Downloaded: {sz}MB in {elapsed:.0f}s ({speed:.0f}MB/s)")
                self.root.after(0, lambda: (self._prog(80), self._set(f"Descargado: {sz}MB"), self._det(f"{speed:.0f} MB/s")))
                return True
            return False
        except Exception as e:
            log.error(f"gdown error: {e}")
            return False

    def _download_portablemc(self, dest):
        """Download portablemc.exe from GitHub to permanent location."""
        try:
            api_url = "https://api.github.com/repos/mindstorm38/portablemc/releases/latest"
            req = urllib.request.Request(api_url, headers={"User-Agent":"CobbleVerse/5.0"})
            with urllib.request.urlopen(req, timeout=30) as r:
                release = json.loads(r.read())
            asset = next((a for a in release.get("assets",[])
                if "windows" in a["name"] and a["name"].endswith(".zip")), None)
            if not asset: raise Exception("portablemc Windows not found")
            zip_path = os.path.join(TEMP_DIR, "portablemc.zip")
            os.makedirs(TEMP_DIR, exist_ok=True)
            cmd = ["curl","-L","-H","User-Agent: CobbleVerse/5.0","-o",zip_path, asset["browser_download_url"]]
            subprocess.run(cmd, timeout=60)
            if os.path.exists(zip_path):
                with zipfile.ZipFile(zip_path) as zf:
                    exe = next((n for n in zf.namelist() if n.endswith("portablemc.exe")), None)
                    if exe:
                        zf.extract(exe, os.path.dirname(dest))
                        extracted = os.path.join(os.path.dirname(dest), exe)
                        if extracted != dest: shutil.move(extracted, dest)
                try: os.remove(zip_path)
                except: pass
                log.info(f"portablemc downloaded to {dest}")
        except Exception as e:
            log.error(f"portablemc download failed: {e}")

    def _sync_skins(self):
        try:
            req = urllib.request.Request(SKINS_API, headers={"User-Agent":"CobbleVerse/5.0"})
            with urllib.request.urlopen(req, timeout=30) as r: release = json.loads(r.read())
            asset = next((a for a in release.get("assets",[]) if a["name"].endswith(".zip")), None)
            if not asset: return
            skins_zip = os.path.join(TEMP_DIR, "cobbleverse-skins.zip")
            skins_dst = os.path.join(GAME_DIR, "config", "easy_npc", "skin")
            os.makedirs(TEMP_DIR, exist_ok=True)
            if not os.path.exists(skins_zip) or os.path.getsize(skins_zip)<100:
                subprocess.run(["curl","-L","-H","User-Agent: CobbleVerse/5.0","-o",skins_zip, asset["browser_download_url"]], timeout=30)
            if not os.path.exists(skins_zip) or os.path.getsize(skins_zip)<100: return
            os.makedirs(skins_dst, exist_ok=True)
            with zipfile.ZipFile(skins_zip) as zf:
                for name in zf.namelist():
                    if name.endswith("/"): continue
                    dest = os.path.join(skins_dst, name)
                    if not os.path.exists(dest):
                        os.makedirs(os.path.dirname(dest), exist_ok=True)
                        with zf.open(name) as src, open(dest,"wb") as dst: shutil.copyfileobj(src, dst)
            try: os.remove(skins_zip)
            except: pass
        except Exception as e: log.warning(f"Skins sync failed: {e}")

    def _extract(self, zp):
        with zipfile.ZipFile(zp) as zf:
            prefix = None
            for n in zf.namelist():
                if "/mods/" in n or n.endswith("/mods"):
                    prefix = n.split("/mods")[0]+"/"; break
            files = [n for n in zf.namelist() if n.startswith(prefix or "") and not n.endswith("/")]
            total = len(files); extracted = 0; start = time.time(); last = 0
            for name in files:
                rel = name[len(prefix):] if prefix else name
                if not rel: continue
                dest = os.path.join(GAME_DIR, rel)
                os.makedirs(os.path.dirname(dest), exist_ok=True)
                with zf.open(name) as src, open(dest,"wb") as dst: shutil.copyfileobj(src, dst)
                extracted += 1
                now = time.time()
                if now-last>=0.3:
                    last = now
                    pct = extracted/total if total>0 else 0
                    elapsed = now-start
                    rate = extracted/elapsed if elapsed>0 else 0
                    eta = (total-extracted)/rate if rate>0 else 0
                    bar = 80+pct*15
                    self.root.after(0, lambda b=bar,c=extracted,t=total,r=rate,e=eta:
                        (self._prog(b), self._set(f"Extrayendo: {c}/{t}"), self._det(f"{r:.0f} archivos/s")))

if __name__ == "__main__":
    Launcher()
