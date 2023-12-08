
INSERT INTO videojuegos (Nombre, Precio, Categoria) VALUES
('The Legend of Zelda', 1499.99, 'Aventura'),
('Cyberpunk 2077', 1299.99, 'Ciencia Ficción'),
('Red Dead Redemption 2', 1399.99, 'Acción'),
('FIFA 23', 899.99, 'Deportes'),
('Call of Duty: Warzone', 1199.99, 'Shooter'),
('Among Us', 149.99, 'Multijugador'),
('Minecraft', 499.99, 'Sandbox'),
('Super Mario Odyssey', 1299.99, 'Plataformas'),
('Assassins Creed Valhalla', 1399.99, 'Aventura'),
('Fortnite', 150.90, 'Battle Royale');

INSERT INTO proveedores (Nombre, Telefono, Domicilio, Correo) VALUES
('GamingTech', 123456789, 'Gaming Avenue #42', 'info@gamingtech.com'),
('World Distributors', 987654321, 'Distribution Street #17', 'sales@worlddistributors.com'),
('Epic Supplies', 555111222, 'Epic Lane #5', 'support@epicsupplies.net'),
('GameGear', 999888777, 'Gear Plaza #23', 'sales@gamegear.co'),
('Techtronics', 333222111, 'Tech Road #8', 'contact@techtronics.biz'),
('Futuristic Gaming', 777666555, 'Future Lane #11', 'info@futuristicgaming.org'),
('Speedy Suppliers', 444555666, 'Speedy Avenue #33', 'speedy@suppliers.com'),
('Fantasy Electronics', 666777888, 'Fantasy Plaza #19', 'fantasy@electronics.net'),
('Starship Deliveries', 111222333, 'Starship Street #7', 'support@starshipdeliveries.co'),
('Legendary Suppliers', 888999000, 'Legend Plaza #13', 'info@legendarysuppliers.org');

INSERT INTO tiendas (Nombre, Domicilio) VALUES
('Game Haven', 'Gaming Street #21'),
('Tech Universe', 'Tech Square #15'),
('Epic Gaming', 'Epic Road #8'),
('Future Games', 'Future Avenue #12'),
('Speedy Gaming', 'Speedy Lane #28'),
('Fantasy Games', 'Fantasy Plaza #6'),
('Starship Games', 'Starship Street #3'),
('Legendary Games', 'Legend Lane #9'),
('Virtual Fun', 'Virtual Avenue #14'),
('Pixel Paradise', 'Pixel Road #17');

INSERT INTO clientes (Nombre, ApellidoP, ApellidoM, Fecha_Nacimiento, Telefono, Domicilio, Correo) VALUES
('Juan', 'García', 'López', '1990-05-15', 555123456, 'Calle Principal #123 ', 'juan.garcia@gmail.com'),
('María', 'Martínez', 'Ruiz', '1985-08-22', 555789012, 'Avenida Central #456', 'maria.martinez@outlook.com'),
('Pedro', 'Hernández', 'Fernández', '1993-02-10', 555456789, 'Calle Secundaria #789', 'pedro.hernandez@hotmail.com'),
('Ana', 'González', 'Sánchez', '1988-11-30', 555234567, 'Avenida Principal #9822', 'ana.gonzalez@gmail.com'),
('Carlos', 'Díaz', 'Pérez', '1995-07-03', 555890123, 'Calle Central #9263', 'carlos.diaz@outlook.com'),
('Laura', 'Rodríguez', 'Gómez', '1980-04-18', 555345678, 'Avenida Secundaria #1234', 'laura.rodriguez@hotmail.com'),
('Miguel', 'López', 'Vargas', '1998-09-25', 555901234, 'Calle Principal #9782', 'miguel.lopez@gmail.com'),
('Isabel', 'Fernández', 'Gutiérrez', '1983-06-12', 555456789, 'Avenida Central #671', 'isabel.fernandez@hotmail.com'),
('David', 'Gómez', 'García', '1991-12-08', 555123456, 'Calle Secundaria #871', 'david.gomez@gmail.com'),
('Sofía', 'Pérez', 'Martínez', '1987-03-04', 555789012, 'Avenida Principal #777', 'sofia.perez@outlook.com');

INSERT INTO empleados (Nombre, ApellidoP, ApellidoM, NSS, Fecha_Nacimiento, CURP, Telefono, Domicilio, Sueldo) VALUES
('Alejandro', 'Hernández', 'Gómez', '123456789', '1990-05-15', 'HERA900515HDFLRX01', 555123456, 'Calle Principal #567', 3000),
('Carmen', 'Martínez', 'Ruiz', '987654321', '1985-08-22', 'MARC850822MDFLRX02', 555789012, '#Avenida Central #416', 3200),
('Daniel', 'González', 'Sánchez', '567890123', '1993-02-10', 'GODS930210HDFLRX03', 555456789, '#Calle Secundaria #628', 2800),
('Eva', 'Díaz', 'Pérez', '456789012', '1988-11-30', 'DIPE881130MDFLRX04', 555234567, 'Avenida Principal #729', 3400),
('Francisco', 'Rodríguez', 'Gómez', '234567890', '1995-07-03', 'ROGF950703HDFLRX05', 555890123, 'Calle Central #189', 3100),
('Gabriela', 'López', 'Fernández', '890123456', '1980-04-18', 'LOFG800418MDFLRX06', 555345678, 'Avenida Secundaria #882', 3300),
('Héctor', 'Fernández', 'Vargas', '678901234', '1998-09-25', 'FEVH980925HDFLRX07', 555901234, 'Calle Principal #671', 2900),
('Inés', 'Gómez', 'Gutiérrez', '012345678', '1983-06-12', 'GOGI830612MDFLRX08', 555456789, 'Avenida Central #743', 3500),
('José', 'Pérez', 'Martínez', '345678901', '1991-12-08', 'PEMJ911208HDFLRX09', 555123456, 'Calle Secundaria #912', 3200),
('Karla', 'Martínez', 'Sánchez', '901234567', '1987-03-04', 'MASA870304MDFLRX10', 555789012, 'Avenida Principal #723', 3000);

/*INSERT INTO compra (id_videojuego, id_tienda, id_cliente, Cantidad, Total, Fecha) VALUES
(1, 1, 1, 2, (SELECT Precio * 2 FROM videojuegos WHERE id_videojuego = 1), '2023-01-05'),
(3, 2, 3, 3, (SELECT Precio * 3 FROM videojuegos WHERE id_videojuego = 3), '2023-02-10'),
(5, 3, 5, 1, (SELECT Precio * 1 FROM videojuegos WHERE id_videojuego = 5), '2023-03-15'),
(7, 4, 7, 5, (SELECT Precio * 5 FROM videojuegos WHERE id_videojuego = 7), '2023-04-20'),
(2, 5, 9, 7, (SELECT Precio * 7 FROM videojuegos WHERE id_videojuego = 2), '2023-05-25'),
(4, 6, 2, 2, (SELECT Precio * 2 FROM videojuegos WHERE id_videojuego = 4), '2023-06-30'),
(6, 7, 4, 5, (SELECT Precio * 5 FROM videojuegos WHERE id_videojuego = 6), '2023-07-05'),
(8, 8, 6, 1, (SELECT Precio * 1 FROM videojuegos WHERE id_videojuego = 8), '2023-08-10'),
(10, 9, 8, 9, (SELECT Precio * 9 FROM videojuegos WHERE id_videojuego = 10), '2023-09-15'),
(9, 10, 10, 12, (SELECT Precio * 12 FROM videojuegos WHERE id_videojuego = 9), '2023-10-20');*/

INSERT INTO trabaja (id_tienda, id_empleado, Hora_Entrada, Hora_Salida, Turno) VALUES
(1, 1, '09:00:00', '18:00:00', 'Matutino'),
(2, 2, '10:00:00', '19:00:00', 'Vespertino'),
(3, 3, '08:30:00', '17:30:00', 'Matutino'),
(4, 4, '11:00:00', '20:00:00', 'Vespertino'),
(5, 5, '10:30:00', '19:30:00', 'Matutino'),
(6, 6, '09:00:00', '18:00:00', 'Vespertino'),
(7, 7, '08:00:00', '17:00:00', 'Matutino'),
(8, 8, '11:30:00', '20:30:00', 'Vespertino'),
(9, 9, '09:30:00', '18:30:00', 'Matutino'),
(10, 10, '10:00:00', '19:00:00', 'Vespertino');

/*INSERT INTO proveen (id_videojuego, id_proveedor, id_tienda, Cantidad, Fecha) VALUES
(1, 1, 1, 20, '2023-01-05'),
(3, 2, 2, 15, '2023-02-10'),
(5, 3, 3, 30, '2023-03-15'),
(7, 4, 4, 10, '2023-04-20'),
(2, 5, 5, 25, '2023-05-25'),
(4, 6, 6, 12, '2023-06-30'),
(6, 7, 7, 40, '2023-07-05'),
(8, 8, 8, 18, '2023-08-10'),
(10, 9, 9, 35, '2023-09-15'),
(9, 10, 10, 8, '2023-10-20');*/

/*INSERT INTO atiende (id_tienda, id_cliente, id_empleado, Fecha_Atencion) VALUES
(1, 1, 1, '2023-01-05'),
(2, 2, 2, '2023-02-10'),
(3, 3, 3, '2023-03-15'),
(4, 4, 4, '2023-04-20'),
(5, 5, 5, '2023-05-25'),
(6, 6, 6, '2023-06-30'),
(7, 7, 7, '2023-07-05'),
(8, 8, 8, '2023-08-10'),
(9, 9, 9, '2023-09-15'),
(10, 10, 10, '2023-10-20');*/

INSERT INTO inventario (id_videojuego, id_tienda, Stock) VALUES
(1, 1, 15),
(2, 2, 30),
(3, 3, 25),
(4, 4, 20),
(5, 5, 18),
(6, 6, 40),
(7, 7, 22),
(8, 8, 28),
(9, 9, 35),
(10, 10, 12);

