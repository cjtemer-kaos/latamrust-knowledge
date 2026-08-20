# Transformer Architecture Fundamentals

Transformer: self-attention mechanism replacing RNNs. Encoder stacks (bidirectional, BERT-like) + Decoder stacks (autoregressive, GPT-like). Key components: Multi-Head Attention (Q,K,V projections, scaled dot-product score = QK^T/sqrt(d_k)), Positional Encoding (sin/cos or learned), Feed-Forward Network (ReLU/GELU), LayerNorm, Residual connections. Scaled dot-product: softmax(QK^T/sqrt(d_k))V. Masking: padding mask (ignore pads) + causal mask (prevent looking ahead in decoder). FlashAttention: IO-aware exact attention for 2x+ speed.
