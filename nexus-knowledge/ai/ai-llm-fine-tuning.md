# ai-llm-fine-tuning

LLM fine-tuning guide: 1) Collect instruction data (input/output pairs). 2) Format: JSONL with system/user/assistant roles. 3) LoRA config: rank=16, alpha=32. 4) Learning rate: 2e-5. 5) Batch size: 4-8. 6) Epochs: 2-5. 7) Evaluation: loss + human eval. 8) Tools: HuggingFace PEFT, Axolotl.
