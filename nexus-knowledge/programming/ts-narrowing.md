# ts-narrowing

TS type narrowing: 1) typeof x === 'string'. 2) 'prop' in obj. 3) instanceof Class. 4) Custom type guards: function isUser(x: any): x is User. 5) Discriminated unions: { type: 'a', ... } | { type: 'b', ... }. 6) Assertion functions.
