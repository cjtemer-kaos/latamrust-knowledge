# docker-compose

Docker Compose: 1) docker-compose.yml define servicios. 2) depends_on para ordering. 3) networks para aislamiento. 4) volumes para persistencia. 5) env_file para variables. 6) profiles para variantes. Ejemplo: services: {web: {build: ., ports: ['8000:8000']}, db: {image: postgres:16, volumes: ['pgdata:/var/lib/postgresql/data']}}.
