# supernexus-capacidades-nodos-nexushive

CAPACIDADES NEXUSHIVE Y NODOS: NexusHive es la red de agentes conectados. PC1=main (RTX 3060 12GB, puerto 9000). PC2=nodo remoto (192.168.1.50, puerto 22 SSH). list_nodes muestra todos los nodos. execute_remote_task ejecuta en nodo remoto. execute_on_remote_node ejecuta bash remoto. send_message/read_messages comunicacion entre agentes via tablero compartido. canales: general, tasks, memory, agents, system. Redis PubSub: redis_publish/redis_get_messages para comunicacion real-time. redis_heartbeat/list_agents para descubrimiento de agentes activos.
