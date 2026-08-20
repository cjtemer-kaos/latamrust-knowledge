# CI/CD: GitHub Actions Deep Dive

GitHub Actions: workflow (.github/workflows/*.yml), trigger (push, PR, schedule, workflow_dispatch), runner (GitHub-hosted/self-hosted), job (runs-on + steps), step (run or uses). Matrix strategy: strategy.matrix.os/node/version. Cache actions/cache for dependencies. Reusable workflows: caller invokes called workflow with secrets:inherit. Environments: protection rules + secrets per env. Artifacts: upload/download between jobs. OIDC for cloud auth (no static creds). Composite actions for reusable step groups.
