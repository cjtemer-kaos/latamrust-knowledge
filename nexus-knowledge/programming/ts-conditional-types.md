# ts-conditional-types

Conditional types: T extends U ? X : Y. Distributive: (A | B) extends U ? X : Y distributes over union. Infer keyword: T extends (infer U)[] ? U : never. Template literal types: `${A}_${B}`.
