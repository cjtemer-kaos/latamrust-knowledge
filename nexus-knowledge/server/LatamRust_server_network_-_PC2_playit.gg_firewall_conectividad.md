# LatamRust server network - PC2, playit.gg, firewall, conectividad

LATAMRUST SERVER NETWORK - Configuracion de red

PC2 (192.168.1.16):
- IP interna: 192.168.1.16
- Nombre: PC2-NEXUS
- SSH: puerto 22, user cjtr
- MCSS: puerto 8080
- MC Server: puerto 55555
- RCON: puerto 25575
- Backend LatamRust: puerto 9001
- SuperNEXUS: puerto 9000

PLAYIT.GG:
- Tunnel: california-street.gl.joinmc.link
- Puerto externo: 25565 -> 55555
- Permite conexion desde internet

FIREWALL:
- PC1 inbound bloqueado para puertos 9000/9091/9002/8888
- Necesita elevation admin para abrir con netsh
- SMB funciona PC1->PC2 pero PC2->PC1 puede no funcionar

CONECTIVIDAD:
- PC1->PC2: SSH funciona, SMB funciona
- PC2->PC1: SSH funciona, SMB puede no funcionar
- Internet: via playit.gg tunnel

IMPORTANTE:
- Nunca reiniciar MC sin confirmar con usuario
- MCSS auto-restarta el server despues de stop
- Gamerule sendCommandFeedback se resetea al restart
