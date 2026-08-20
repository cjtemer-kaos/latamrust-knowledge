# gh-actions-deploy

Deploy: name: Deploy; on: push: {branches: [main]}; jobs: {deploy: {runs-on: ubuntu-latest, steps: [{uses: actions/checkout@v4}, {run: docker build -t app .}, {run: docker push registry/app}]}}
