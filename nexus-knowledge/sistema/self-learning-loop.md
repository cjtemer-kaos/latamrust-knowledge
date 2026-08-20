# self-learning-loop

SelfLearningLoop implementado en src/core/self_learning_loop.py (150 lines). Actor de ciclo continuo que recibe outcomes via msg_type=learn. Retroalimenta AdaptiveRouter con resultados, identifica patrones de error, y ajusta pesos del router. Integrado en DirectorNexus via _init_self_learning().
