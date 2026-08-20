# py-decorator-example

Decorator: def timer(func): import time; def wrapper(*args, **kwargs): start = time.time(); result = func(*args, **kwargs); print(f'{func.__name__}: {time.time()-start:.3f}s'); return result; return wrapper.
