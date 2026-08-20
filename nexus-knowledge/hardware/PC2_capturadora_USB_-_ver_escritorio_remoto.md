# PC2 capturadora USB - ver escritorio remoto

PC2 (192.168.1.16) tiene capturadora USB conectada a su GPU. Para ver su escritorio: ffmpeg -f dshow -i video="USB Video" -frames:v 1 -update 1 pc2_screen.png y luego vision_analyze. Dispositivos detectados: USB Video y XHLC Camera. PC2 corre MCSS (LatamRust Cobblemon + SuperNexus online), Hermes, Playit.gg. Share: //PC2-NEXUS/share/
