# terraform-modules

Terraform modules: module 'vpc' { source = './modules/vpc' ; cidr = '10.0.0.0/16' }. Outputs: output 'vpc_id' { value = module.vpc.vpc_id }. Variables: variable 'cidr' { type = string }. Best practices: 1 module per resource type. Version constraints. Remote state.
