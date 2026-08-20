# Python Decorators

Decorators wrap functions to add behavior. Real pattern: @lru_cache for memoization, @contextmanager for context managers, @property for computed attrs. Custom decorator with args: def retry(max_attempts=3):
 def decorator(fn):
  @functools.wraps(fn)
  def wrapper(*args,**kwargs):
   for i in range(max_attempts):
    try: return fn(*args,**kwargs)
    except: pass
   raise
  return wrapper
 return decorator
Keep @functools.wraps to preserve metadata.
