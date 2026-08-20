# nexus-favorite-provider-auto-pick

**Auto-pick favorite provider on first load** (2026-06-02)

PROBLEM: Hardcoding `favorite: true` on ollama default forced ollama as favorite even when user had multiple pre-configured providers or ollama wasn't running.

FIX in `ui/src/stores/appStore.ts`:
1. `loadProviders()`: removed `favorite: true` from default ollama entry
2. New `pickInitialFavorite(providers)`: returns first provider with `enabled && models.length > 0`
3. Store init: if no favorite AND no defaultProviderId in localStorage → call pickInitialFavorite, mutate candidate to set `favorite = true`, saveProviders + saveDefaultProviderId
4. Store init: if favorite exists → sync defaultProviderId (idempotent)

E2E verified 3 scenarios (chrome-devtools):
- Empty localStorage: ollama auto-promoted, persisted
- 3 providers (groq, ollama, openrouter) no favorite: groq (first) auto-promoted
- Pre-existing favorite (zen): preserved, no change

Pattern: prefer auto-detection over hardcoded preferences on first run. User explicit choice overrides auto-pick after that.
