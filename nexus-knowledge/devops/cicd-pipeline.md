# cicd-pipeline

CI/CD Pipeline design: 1) Lint → Test → Build → Deploy. 2) Feature branch → PR → Merge to main → Deploy staging → Deploy prod. 3) Blue-green: deploy nuevo al lado del viejo. 4) Canary: % tráfico a nuevo. 5) Feature flags: toggle features. 6) Rollback automático si health check falla.
