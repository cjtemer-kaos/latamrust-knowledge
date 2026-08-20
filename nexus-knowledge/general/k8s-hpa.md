# k8s-hpa

K8s HPA: apiVersion: autoscaling/v2. kind: HorizontalPodAutoscaler. spec: { scaleTargetRef: {apiVersion: apps/v1, kind: Deployment, name: myapp}, minReplicas: 2, maxReplicas: 10, metrics: [{type: Resource, resource: {name: cpu, target: {type: Utilization, averageUtilization: 70}}}] }.
