"""nexus_memory_bridge.py — Puente Hermes <-> NEXUS (latamrust-nexus, cerebro/memoria principal).

Fusión completa: la memoria durable de Hermes vive en el cerebro de latamrust-nexus
(http://127.0.0.1:9001), NO en archivos separados. Este puente permite a Hermes
guardar y recuperar conocimiento directamente de NEXUS (que es infinito, SQLite+grafo).

Uso (desde Hermes / terminal):
  python nexus_memory_bridge.py learn "<contenido>" --topic "X" --category "server" --tags a,b
  python nexus_memory_bridge.py recall "query"          # buscar conocimiento (devuelve top N)
  python nexus_memory_bridge.py stats                    # estado del brain
  python nexus_memory_bridge.py graph                    # nodos del grafo

El puente usa la API de NEXUS en 9001 (latamrust-nexus, el sistema principal de esta PC).
"""
import sys, json, urllib.request, urllib.parse, argparse

NEXUS = "http://127.0.0.1:9001"

def api(method, path, body=None):
    url = NEXUS + path
    data = json.dumps(body).encode() if body else None
    req = urllib.request.Request(url, data=data, method=method,
        headers={"Content-Type": "application/json", "User-Agent": "hermes-nexus-bridge"})
    try:
        with urllib.request.urlopen(req, timeout=60) as r:
            return json.loads(r.read().decode("utf-8", "replace") or "{}")
    except urllib.error.HTTPError as e:
        return {"error": e.code, "msg": e.read().decode()[:200]}
    except Exception as e:
        return {"error": str(e)[:200]}

def learn(content, topic, category, tags):
    # /api/learn/direct espera UN objeto
    body = {"content": content, "topic": topic, "category": category, "tags": tags}
    return api("POST", "/api/learn/direct", body)

def recall(query, limit=5):
    # /api/memory/search es POST con {"query": ...} — bm25
    r = api("POST", "/api/memory/search", {"query": query})
    res = r.get("results", []) if isinstance(r, dict) else []
    return {"query": query, "count": len(res), "results": [{"id": x.get("id"), "score": x.get("bm25_score"), "preview": x.get("preview","")} for x in res[:limit]]}

def stats():
    return api("GET", "/api/brain/stats")

def graph():
    return api("GET", "/api/knowledge/graph")

def main():
    ap = argparse.ArgumentParser()
    sub = ap.add_subparsers(dest="cmd")
    p_learn = sub.add_parser("learn"); p_learn.add_argument("content"); p_learn.add_argument("--topic", default="general"); p_learn.add_argument("--category", default="general"); p_learn.add_argument("--tags", default="")
    p_recall = sub.add_parser("recall"); p_recall.add_argument("query"); p_recall.add_argument("--limit", type=int, default=5)
    p_stats = sub.add_parser("stats")
    p_graph = sub.add_parser("graph")
    a = ap.parse_args()
    if a.cmd == "learn":
        tags = [t.strip() for t in a.tags.split(",") if t.strip()]
        print(json.dumps(learn(a.content, a.topic, a.category, tags), ensure_ascii=False))
    elif a.cmd == "recall":
        print(json.dumps(recall(a.query, a.limit), ensure_ascii=False)[:2000])
    elif a.cmd == "stats":
        print(json.dumps(stats(), ensure_ascii=False))
    elif a.cmd == "graph":
        g = graph()
        nodos = g.get("nodes", [])
        print(f"nodos: {len(nodos)}")
        for n in nodos[:20]:
            print(f"  [{n.get('type')}] {n.get('label','')[:80]}")
    else:
        ap.print_help()

if __name__ == "__main__":
    main()
