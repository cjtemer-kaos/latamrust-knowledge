# github-actions-advanced

Advanced GitHub Actions: 1) Reusable workflows: uses: ./.github/workflows/ci.yml. 2) Composite actions: action.yml. 3) Matrix strategy: { os: [ubuntu, windows], python: [3.11, 3.12] }. 4) Concurrency: concurrency: { group: ${{ github.workflow }} }. 5) Environments: protection rules.
