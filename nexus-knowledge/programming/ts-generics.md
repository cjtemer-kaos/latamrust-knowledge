# ts-generics

TypeScript generics: tipos parametrizados. 1) function identity<T>(arg: T): T. 2) Interface con T: Repository<T> { findById(id: string): T }. 3) Constraints: <T extends HasId>. 4) Utility types: Partial<T>, Pick<T, K>, Omit<T, K>, Record<K,V>. 5) Conditional types: T extends U ? X : Y. 6) Mapped types: { [K in keyof T]: ... }.
