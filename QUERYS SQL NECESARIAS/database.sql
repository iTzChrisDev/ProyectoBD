DROP DATABASE IF EXISTS gameshop_final;

CREATE DATABASE gameshop_final;

USE gameshop_final;

CREATE TABLE videojuegos (
    id_videojuego INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Precio DOUBLE NOT NULL,
    Categoria VARCHAR(50) NOT NULL
);

CREATE TABLE proveedores (
    id_proveedor INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Telefono BIGINT NOT NULL,
    Domicilio VARCHAR(50) NOT NULL,
    Correo VARCHAR(60) NOT NULL
);

CREATE TABLE tiendas (
    id_tienda INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    Domicilio VARCHAR(50) NOT NULL
);

CREATE TABLE clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    ApellidoP VARCHAR(50) NOT NULL,
    ApellidoM VARCHAR(50),
    Fecha_Nacimiento DATE NOT NULL,
    Telefono BIGINT NOT NULL,
    Domicilio VARCHAR(50) NOT NULL,
    Correo VARCHAR(60) NOT NULL
);

CREATE TABLE empleados (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    Nombre VARCHAR(50) NOT NULL,
    ApellidoP VARCHAR(50) NOT NULL,
    ApellidoM VARCHAR(50) NOT NULL,
    NSS VARCHAR(20) NOT NULL,
    Fecha_Nacimiento DATE NOT NULL,
    CURP VARCHAR(20) NOT NULL,
    Telefono BIGINT NOT NULL,
    Domicilio VARCHAR(50) NOT NULL,
    Sueldo DOUBLE NOT NULL
);

CREATE TABLE compra (
    id_videojuego INT,
    id_tienda INT,
    id_cliente INT,
    Cantidad INT NOT NULL,
    Total DOUBLE NOT NULL,
    Fecha DATE NOT NULL,
    FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id_videojuego) ON DELETE CASCADE,
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda) ON DELETE CASCADE,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE
);

CREATE TABLE trabaja (
    id_tienda INT,
    id_empleado INT,
    Hora_Entrada TIME NOT NULL,
    Hora_Salida TIME NOT NULL,
    Turno VARCHAR(25) NOT NULL,
    PRIMARY KEY (id_tienda, id_empleado),
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda) ON DELETE CASCADE,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado) ON DELETE CASCADE
);

CREATE TABLE proveen (
    id_videojuego INT,
    id_proveedor INT,
    id_tienda INT,
    Cantidad INT NOT NULL,
    Fecha DATE NOT NULL,
    FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id_videojuego) ON DELETE CASCADE,
    FOREIGN KEY (id_proveedor) REFERENCES proveedores(id_proveedor) ON DELETE CASCADE,
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda) ON DELETE CASCADE
);

CREATE TABLE atiende (
    id_tienda INT,
    id_cliente INT,
    id_empleado INT,
    Fecha_Atencion DATE NOT NULL,
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda) ON DELETE CASCADE,
    FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente) ON DELETE CASCADE,
    FOREIGN KEY (id_empleado) REFERENCES empleados(id_empleado) ON DELETE CASCADE
);

CREATE TABLE inventario (
    id_videojuego INT,
    id_tienda INT,
    Stock INT NOT NULL,
    PRIMARY KEY (id_videojuego, id_tienda),
    FOREIGN KEY (id_videojuego) REFERENCES videojuegos(id_videojuego) ON DELETE CASCADE,
    FOREIGN KEY (id_tienda) REFERENCES tiendas(id_tienda) ON DELETE CASCADE
);

