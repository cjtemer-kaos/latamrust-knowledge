# Kubernetes Storage & Security Contexts

Storage: emptyDir (ephemeral), hostPath (node filesystem), PV/PVC (persistent storage with reclaim policies: Retain/Delete/Recycle), StorageClass (dynamic provisioning), CSI drivers. StatefulSet: stable network identity, ordered deployment, each pod gets own PVC. SecurityContext: runAsUser, fsGroup, privileged, capabilities (drop all, add specific), seccomp, AppArmor. PodSecurityContext vs container SecurityContext. PodSecurityStandards: Privileged, Baseline, Restricted.
