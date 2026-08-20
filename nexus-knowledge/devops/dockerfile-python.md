# dockerfile-python

Dockerfile Python optimizado:
FROM python:3.13-slim AS builder
WORKDIR /app
COPY requirements.txt .
RUN pip install --no-cache-dir -r requirements.txt
COPY . .
FROM python:3.13-slim
WORKDIR /app
COPY --from=builder /app .
RUN adduser --disabled-password --no-create-home appuser
USER appuser
EXPOSE 8000
CMD ["python", "main.py"]
Multi-stage: builder compila, slim ejecuta. No root. Minimal image.
