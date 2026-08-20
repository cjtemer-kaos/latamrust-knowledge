# docker-advanced

Docker avanzado: 1) Multi-stage builds: FROM python:3.13 AS builder → FROM python:3.13-slim. 2) Docker Bake: buildx con --platform linux/amd64,linux/arm64. 3) Build secrets: --mount=type=secret. 4) Health checks: HEALTHCHECK CMD curl -f http://localhost/ || exit 1. 5) Resource limits: --cpus=2 --memory=512m. 6) Named volumes para persistencia.
