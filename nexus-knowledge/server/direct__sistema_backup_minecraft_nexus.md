# Direct: Sistema backup Minecraft NEXUS

Category: Server
Tags: backup, minecraft, mc_backup_service, retencion, hardlink
Created: 2026-08-19T14:34:11.954811

---

SISTEMA DE BACKUP de Minecraft implementado en latamrust-nexus (2026-08-19): modulo src/core/mc_backup_service.py (clase MCBackupService + BackupScheduler). Donde guarda: <server>/backups/<tipo>_<timestamp> (server real D:/SERVIDOR/servers/LATAMRUST COBBLEMON). Que guarda: world (level.dat, region/, playerdata/) excluyendo uid.dat, session.lock, crash-reports. Como: copia por hardlinks (shutil.copytree copy_function=os.link) instantanea para el world de 57GB. Retencion: mantiene 5 backups, borra los viejos (_prune). Programado: BackupScheduler cada 6h. Botones UI: agregado 'Crear Backup' (POST /api/minecraft/backup) + listar/refresh en McBackupsView.tsx. server_dir corregido de la ruta vieja (COBBLEVERSE Pokemon Adventure) a la real (servers/LATAMRUST COBBLEMON) en data/minecraft_config.json y en el default del codigo. Endpoints: GET/POST /api/minecraft/backups|backup verificados: world_size 57.9GB detectado, 1 backup existente listado.
