create database prueba;
use prueba;
CREATE TABLE IF NOT EXISTS CUSTOMER (
    id INT PRIMARY KEY AUTO_INCREMENT,
    document_type VARCHAR(50),
    document_number VARCHAR(50),
    name VARCHAR(50),
	phone VARCHAR(50)
);

INSERT INTO CUSTOMER (id, document_type, document_number, name, phone) VALUES 
(1, 'DNI', '12345678', 'Juan Pérez', '555-1234'),
(2, 'CE', '1234567', 'Ana Gómez', '555-5678'),
(3, 'CE', '87654321', 'Luis Rodríguez', '555-9101');
