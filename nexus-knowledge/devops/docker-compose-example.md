# docker-compose-example

Compose: services: {web: {build: ., ports: ['8000:8000'], depends_on: ['db']}, db: {image: 'postgres:16', volumes: ['pgdata:/var/lib/postgresql/data']}}; volumes: {pgdata: {}}
