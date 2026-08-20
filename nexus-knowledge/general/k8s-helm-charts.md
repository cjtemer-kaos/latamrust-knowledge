# k8s-helm-charts

Helm charts structure: Chart.yaml, values.yaml, templates/. Template syntax: {{ .Values.image.repository }}:{{ .Values.image.tag }}. Conditionals: {{ if .Values.ingress.enabled }}. Loops: {{ range .Values.ingress.hosts }}. Hooks: pre-install, post-upgrade.
