# sql-optimization-examples

SQL optimization ejemplos:
-- Índice compuesto
CREATE INDEX idx_users_email_active ON users(email, active);
-- Query lenta → rápida
-- ANTES: SELECT * FROM orders WHERE user_id IN (SELECT id FROM users WHERE active)
-- DESPUÉS: SELECT o.* FROM orders o JOIN users u ON o.user_id = u.id WHERE u.active
-- Covering index
CREATE INDEX idx_cover ON products(category, price) INCLUDE (name, description);
-- Partitioning
CREATE TABLE logs (id BIGINT, created_at TIMESTAMP) PARTITION BY RANGE (created_at);
