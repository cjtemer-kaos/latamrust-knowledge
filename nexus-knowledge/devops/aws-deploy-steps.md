# aws-deploy-steps

Deploy a AWS en 5 pasos: 1) ECR: docker push imagen. 2) ECS Task Definition: definir container. 3) ECS Service: run tasks con load balancer. 4) Route53: DNS routing. 5) CloudWatch: monitoring. Alternativa serverless: Lambda + API Gateway + DynamoDB. Costo: ~$0 para tráfico bajo.
