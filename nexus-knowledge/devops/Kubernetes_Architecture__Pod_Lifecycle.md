# Kubernetes Architecture & Pod Lifecycle

K8s: control plane (API server, scheduler, controller-manager, etcd) + worker nodes (kubelet, kube-proxy, container runtime). Pod: smallest unit, ephemeral, one+ containers share network/IP/storage. Init containers run before app containers. Pod lifecycle: Pending -> Running -> Succeeded/Failed. Probes: liveness (restart if fails), readiness (traffic if passes), startup (slow-start containers). Resource requests (guaranteed) vs limits (capped). QoS: Guaranteed, Burstable, BestEffort.
