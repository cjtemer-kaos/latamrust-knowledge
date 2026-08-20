# fastapi-crud-example

FastAPI CRUD: @app.post('/items') async def create(item: Item): db.add(item); return item. @app.get('/items/{id}') async def read(id: int): return db.get(id). @app.put('/items/{id}') async def update(id: int, item: Item): db[id] = item. @app.delete('/items/{id}') async def delete(id: int): del db[id].
