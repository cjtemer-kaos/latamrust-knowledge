# httpx-cheat

httpx: async with httpx.AsyncClient() as client: resp = await client.get(url); data = resp.json(). Timeout: client = httpx.AsyncClient(timeout=30). Retries: httpx.AsyncClient(transport=httpx.HTTPTransport(retries=3)).
