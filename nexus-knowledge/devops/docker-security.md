# docker-security

Docker security: 1) Non-root user: USER 1001. 2) Read-only filesystem: --read-only. 3) Capabilities: --cap-drop ALL --cap-add NET_BIND_SERVICE. 4) No --privileged. 5) Scan images: trivy, snyk. 6) Signed images: docker content trust. 7) Secrets in Docker Swarm.
