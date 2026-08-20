# AWS Core Services Overview

Compute: EC2 (VMs), Lambda (serverless FaaS, max 15min/9000MB), ECS/EKS (containers), Fargate (serverless containers). Storage: S3 (object, 11 9s durability), EBS (block, per EC2), EFS (NFS, multi-AZ). Database: RDS (relational, Multi-AZ/Read Replicas), DynamoDB (NoSQL, auto-scale), ElastiCache (Redis/Memcached). Network: VPC (subnets, NACLs, SG), CloudFront (CDN), Route53 (DNS), ALB/NLB (load balancing). IAM: Users, Groups, Roles, Policies (least privilege, resource-based vs identity-based).
