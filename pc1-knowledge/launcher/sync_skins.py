#!/usr/bin/env python3
"""
Sync Easy NPC skins from server to GitHub release.
Copies ALL files (templates + any UUID skins created by admins).
"""
import os, json, zipfile, hashlib, sys

SERVER_SKINS = r"\\PC2-NEXUS\servidor\servers\LATAMRUST COBBLEMON\config\easy_npc\skin"
GITHUB_REPO = "cjtemer-kaos/cobbleverse-pack"
ZIP_NAME = "cobbleverse-skins.zip"
LOCAL_ZIP = os.path.join(os.path.dirname(__file__), ZIP_NAME)

def md5_file(path):
    h = hashlib.md5()
    with open(path, "rb") as f:
        for chunk in iter(lambda: f.read(8192), b""):
            h.update(chunk)
    return h.hexdigest()

def collect_skins():
    """Collect ALL PNG skins from server (templates + UUID skins)."""
    skins = {}
    for root, dirs, files in os.walk(SERVER_SKINS):
        for f in files:
            if f.lower().endswith(".png"):
                full = os.path.join(root, f)
                rel = os.path.relpath(full, SERVER_SKINS)
                skins[rel] = {
                    "size": os.path.getsize(full),
                    "md5": md5_file(full)
                }
    return skins

def create_zip():
    """Create ZIP with ALL skins."""
    with zipfile.ZipFile(LOCAL_ZIP, "w", zipfile.ZIP_DEFLATED) as zf:
        for root, dirs, files in os.walk(SERVER_SKINS):
            for f in files:
                if f.lower().endswith(".png"):
                    full = os.path.join(root, f)
                    arcname = os.path.relpath(full, SERVER_SKINS)
                    zf.write(full, arcname)
    size = os.path.getsize(LOCAL_ZIP)
    print(f"Created {ZIP_NAME}: {size//1024}KB")
    return size

def main():
    print("=== Easy NPC Skin Sync ===")
    print(f"Server: {SERVER_SKINS}")
    
    if not os.path.exists(SERVER_SKINS):
        print(f"ERROR: Server skins directory not found: {SERVER_SKINS}")
        sys.exit(1)
    
    skins = collect_skins()
    print(f"Found {len(skins)} skins (templates + UUID)")
    
    # Count by type
    templates = [k for k in skins if "_template" in k or "_skin_" in k]
    uuid_skins = [k for k in skins if k not in templates]
    print(f"  Templates: {len(templates)}")
    print(f"  UUID skins: {len(uuid_skins)}")
    
    if uuid_skins:
        print("\nUUID skins (created by admins):")
        for name in sorted(uuid_skins)[:10]:
            print(f"  {name}")
        if len(uuid_skins) > 10:
            print(f"  ... and {len(uuid_skins)-10} more")
    
    create_zip()
    
    print(f"\nNext steps:")
    print(f"1. Upload {ZIP_NAME} to GitHub release skins-v1")
    print(f"2. Players open launcher → ALL skins sync automatically")

if __name__ == "__main__":
    main()
