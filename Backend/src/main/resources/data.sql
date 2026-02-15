CREATE TABLE IF NOT EXISTS usuarios (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS productos (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    precio DOUBLE PRECISION
);

CREATE TABLE IF NOT EXISTS pedidos (
    id BIGSERIAL PRIMARY KEY,
    usuario_id BIGINT REFERENCES usuarios(id),
    total DOUBLE PRECISION,
    fecha TIMESTAMP
);

INSERT INTO usuarios (nombre, email) VALUES 
('Ana López', 'ana@test.com'), ('Pedro García', 'pedro@test.com'),
('María Ruiz', 'maria@test.com'), ('Juan Pérez', 'juan@test.com'),
('Laura Martínez', 'laura@test.com'), ('Carlos Sánchez', 'carlos@test.com'),
('Sofía Gómez', 'sofia@test.com'), ('Miguel Torres', 'miguel@test.com'),
('Elena Díaz', 'elena@test.com'), ('David Ramos', 'david@test.com');

INSERT INTO productos (nombre, precio) VALUES 
('Laptop Dell XPS', 999.99), ('iPhone 15 Pro', 899.99), 
('Monitor 24" 4K', 199.99), ('Teclado Mecánico RGB', 89.99),
('Ratón Logitech G Pro', 29.99), ('SSD 1TB NVMe', 79.99),
('RAM 16GB DDR5', 59.99), ('Webcam HD 1080p', 49.99),
('Auriculares Sony WH', 129.99), ('Tablet iPad Air', 299.99);

INSERT INTO pedidos (usuario_id, total, fecha) VALUES 
(1, 999.99, CURRENT_TIMESTAMP), (2, 899.99, CURRENT_TIMESTAMP),
(3, 199.99, CURRENT_TIMESTAMP), (4, 119.98, CURRENT_TIMESTAMP),
(5, 29.99, CURRENT_TIMESTAMP), (6, 79.99, CURRENT_TIMESTAMP),
(7, 59.99, CURRENT_TIMESTAMP), (8, 49.99, CURRENT_TIMESTAMP),
(9, 129.99, CURRENT_TIMESTAMP), (10, 299.99, CURRENT_TIMESTAMP);
