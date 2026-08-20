# gap3-prompt-compressor-llmlingua

PROMPT COMPRESSOR IMPLEMENTADO: src/core/prompt_compressor.py. PromptCompressor con: filler word removal (ES+EN), whitespace collapse, repeated pattern summarization, example truncation (keep first, note N more), code/URL/path/@mention preservation, CRITICAL/TODO/FIXME/WARNING marker preservation. estimate_tokens usa bytes/4 heuristic (grok-build pattern). compress returns <!--compressed from N to M tokens (ratio: X%)--> marker. 50% compression en filler-heavy text.
