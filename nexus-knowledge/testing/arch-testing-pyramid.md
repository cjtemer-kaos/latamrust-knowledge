# arch-testing-pyramid

Testing Pyramid: 1) Unit tests (base): rápidos, aislados, muchos. 2) Integration tests (medio): componentes interactuando. 3) E2E tests (punta): usuario real, lentos. Ratio ideal: 70% unit, 20% integration, 10% E2E. Anti-pattern: ice cream cone (muchos E2E, pocos unit). Tools: pytest, jest, cypress.
