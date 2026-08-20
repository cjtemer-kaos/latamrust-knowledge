# zustand-patterns

Zustand: 1) create: const useStore = create((set) => ({ count: 0, inc: () => set((s) => ({count: s.count + 1})) })). 2) Selectors: useStore((s) => s.count). 3) Middleware: persist, devtools. 4) Slices: combine stores. 5) Async actions. 6) TypeScript: create<State>().
