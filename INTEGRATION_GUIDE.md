# Integration Guide - How I Work

## Brain Protocol

### Before Responding (RAG automatic)
- Use `brain_recall(query)` with the topic for relevant persistent knowledge
- Use `rag_search(query)` from MCP bridge for semantic search in 394+ knowledge items
- If technical/code topic, use `search_observations(query)` for previous experiences
- Inject obtained knowledge as context before generating response

### After Learning Something New (Shared Memory)
- Use `add_observation(content, topics=[...])` to save important findings to FTS5 memory
- Use `brain_remember(key, content)` for permanent learning that must survive any reset
- Use `add_task_finding(task_id, finding)` for relevant discoveries during a task
- Everything saved to `D:\ias\proyectos\supernexus-v2\brain\`

### In Each Session
- On start: `brain_recall("general")` for general context
- When receiving complex message: `rag_search(topic)` + `search_observations(topic)` before responding
- After resolving something: save learning with `add_observation`
- After finishing important task: `brain_remember("lesson: ...", content)`

## Work Protocol (MANDATORY RULES)

### 1. NEVER say something is ready without verifying
- BEFORE declaring "ready": take screenshot with Playwright/Chrome DevTools
- VERIFY: assets load (JS, CSS, images), no console errors
- ALWAYS show evidence (screenshot, curl output, etc.)
- If can't verify, say "can't verify" instead of assuming

### 2. Use autonomous tools ALWAYS
- Playwright MCP: for screenshots, navigation, UI testing
- Chrome DevTools: for web page debugging
- Brave Search: for official documentation before implementing
- Context7: for updated library docs
- nexus-bridge MCPs: for system tasks
- DON'T ask user to verify something you can verify

### 3. Use available skills
- Load relevant skills before starting (see `available_skills` in system prompt)
- Follow workflows documented in each skill
- Don't reinvent the wheel if a skill exists

### 4. Analyze with official documentation
- ALWAYS search official docs before implementing something new
- Use Context7 or Brave Search for updated documentation
- Don't depend only on training data (may be outdated)

### 5. Integrate with SuperNEXUS Brain
- Use `brain_recall(query)` before responding about ecosystem topics
- Use `add_observation(content, topics=[...])` to save learnings
- Use `search_observations(query)` for previous experiences
- Brain is at `D:\ias\proyectos\supernexus-v2\brain\` — share knowledge

### 6. Analyze ecosystem tools
- When reviewing sibling projects (Hermes, Agent Zero, etc.), identify tools/patterns to copy
- Document findings in brain with `brain_remember`
- Don't just describe — propose how to integrate

## Verificación Autónoma (MANDATORY)
NEVER ask the user to verify something you can verify. Use your tools:
- **Chrome DevTools MCP**: `chrome-devtools_new_page`, `chrome-devtools_take_snapshot`, `chrome-devtools_take_screenshot`, `chrome-devtools_list_console_messages` — for UI verification in browser
- **curl/Invoke-WebRequest**: to verify server serves correct files (status code, content-length, JS/CSS hash)
- **Bash**: to verify processes, files, logs
- **webfetch**: to verify external URLs

## Streaming Setup
- StreamElements Account: "kaosmcs" (cjtemer@gmail.com)
- Overlay: "Alertas Kick + YouTube"
- OBS: Browser source added to Main scene (17 items total)

## Work Protocol Summary
1. Inspect before editing
2. Stay read-only if audit/review only
3. Prefer repo-local scripts
4. Don't claim fixed until proving command reruns
5. Don't claim pushed unless branch actually moved upstream

## Output Format
```
SURFACE
- repo
- branch
- requested mode

EVIDENCE
- failing command / diff / test

ACTION
- what changed

STATUS
- inspected / changed locally / verified locally / committed / pushed / blocked
```
