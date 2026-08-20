# celery-patterns

Celery patterns: 1) @celery.task def my_task(): ... 2) my_task.delay(args). 3) Task queue: Redis/RabbitMQ. 4) Result backend. 5) Periodic tasks: beat schedule. 6) Chaining: task1 | task2. 7) Group: group(task1, task2). 8) Retry: autoretry_for. 9) Monitoring: Flower.
