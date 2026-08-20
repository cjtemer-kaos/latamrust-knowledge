# Docker Networking Deep Dive

Docker network drivers: bridge (default, isolated per host, port mapping), host (no isolation, container uses host network), overlay (multi-host via VXLAN, Swarm/K8s), macvlan (assign MAC to container, direct LAN access), ipvlan (L2/L3 mode). DNS: embedded DNS at 127.0.0.11, service discovery via container name. Network policies for isolation. Container-to-container communication: same bridge = direct, different bridges = need routing. Expose vs publish ports. User-defined bridge: auto DNS resolution.
