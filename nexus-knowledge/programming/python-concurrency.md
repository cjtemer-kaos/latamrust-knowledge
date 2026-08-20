# python-concurrency

Python concurrency: 1) threading: I/O-bound, GIL limits CPU parallelism. 2) multiprocessing: CPU-bound, separate memory. 3) asyncio: single-threaded, high concurrency I/O. 4) concurrent.futures: ThreadPoolExecutor, ProcessPoolExecutor. 5) GIL: Global Interpreter Lock, one thread at a time for Python bytecode. 6) When to use which: I/O → asyncio, CPU → multiprocessing.
