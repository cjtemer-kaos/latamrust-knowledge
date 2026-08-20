# js-iterators

Iterators & Generators: function* gen() { yield 1; yield 2; }. for (const x of gen()). Symbol.iterator protocol. Custom iterators: { [Symbol.iterator]() { return { next() { ... } } } }. Useful for lazy sequences, infinite streams.
