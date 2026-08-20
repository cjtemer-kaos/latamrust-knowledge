# CI/CD: GitLab CI & Jenkins

GitLab CI: .gitlab-ci.yml, stages (ordered), jobs per stage, runner executors (docker, shell, k8s). Cache vs artifacts. DAG pipelines: needs: keyword for parallel stages. Rules: conditions per job (if, changes, exists). Jenkins: Pipeline as Code with Jenkinsfile (declarative or scripted). Jenkins agent (master+node). Shared Libraries for reuse. Blue Ocean UI. Both support: webhooks, environment injection, secrets management, test reporting, multi-branch pipelines.
