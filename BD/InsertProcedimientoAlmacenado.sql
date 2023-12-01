DELIMITER $
CREATE PROCEDURE set_videojuego(IN nombre VARCHAR(20), IN precio INT, IN categoria VARCHAR(45))
BEGIN
	INSERT INTO videojuegos (videojuegos.Nombre, videojuegos.Precio, videojuegos.Categoria)
    VALUES (nombre, precio, categoria);
END$

CREATE PROCEDURE set_trabaja(IN id_tienda INT,IN id_empleado INT, IN hr_entrada TIME, IN hr_salida TIME, IN turno VARCHAR(45))
BEGIN
	INSERT INTO trabaja (trabaja.id_tiendas, trabaja.id_empleado, trabaja.Hora_Entrada, trabaja.Hora_Salida)
    VALUES (id_tienda, id_empleado, hr_entrada, hr_salida, turno);
END$

CREATE PROCEDURE set_tienda(IN nombre VARCHAR(45), IN domicilio VARCHAR(45))
BEGIN
	INSERT INTO tiendas (tiendas.Nombre, tiendas.Domicilio)
    VALUES (nombre, domicilio);
END$

CREATE PROCEDURE set_proveen(IN id_videojuego INT, IN id_proveedores INT, IN id_tiendas INT, IN cantidad INT, IN fecha DATE)
BEGIN
	INSERT INTO proveen (proveen.id_videojuego, proveen.id_proveedores, proveen.id_tiendas, proveen.Cantidad, proveen.Fecha)
    VALUES (id_videojuego, id_proveedores, id_tiendas, cantidad, fecha);
END$

CREATE PROCEDURE set_proveedores(IN nombre VARCHAR(30), IN domicilio VARCHAR(45), IN telefono INT, IN correo VARCHAR(60))
BEGIN
	INSERT INTO proveedores (proveedores.Nombre, proveedores.Telefono, proveedores.Domicilio, proveedores.Correo)
    VALUES (nombre, telefono, domicilio, correo);
END$

CREATE PROCEDURE set_inventario(IN id_videojuego VARCHAR(20), IN id_tienda VARCHAR(45), IN stock INT)
BEGIN
    INSERT INTO inventario (inventario.id_videojuego, inventario.id_tiendas, inventario.Stock)
    VALUES (id_videojuego, id_tienda, stock);
END$

CREATE PROCEDURE set_empleado(IN nombre VARCHAR(45), IN app VARCHAR(45), IN apm VARCHAR(45), IN nss VARCHAR(45), IN fecha VARCHAR(45), IN curp VARCHAR(45), IN telefono INT, IN domicilio VARCHAR(45), IN sueldo INT)
BEGIN
	INSERT INTO empleados (empleados.Nombre, empleados.ApellidoP, empleados.ApellidoM, empleados.NSS, empleados.Fecha_Nacimiento, empleados.CURP, empleados.Telefono, empleados.Domicilio, empleados.Sueldo) 
    VALUES (nombre, app, apm, nss, fecha, curp, telefono, domicilio, sueldo);
END$

CREATE PROCEDURE set_compra(IN id_videojuego INT, IN id_tienda INT, IN id_cliente INT, IN cantidad INT, IN total DOUBLE, IN fecha DATE)
BEGIN
	INSERT INTO compra (compra.id_videojuego, compra.id_tienda, compra.id_clientes, compra.Cantidad, compra.Total, compra.Fecha) 
    VALUES (id_videojuego, id_tienda, id_cliente, cantidad, total, fecha);
END$

CREATE PROCEDURE set_cliente(IN nombre VARCHAR(45), IN app VARCHAR(45), IN apm VARCHAR(45), IN fecha VARCHAR(45), IN telefono INT, IN domicilio VARCHAR(45), IN correo VARCHAR(45))
BEGIN
	INSERT INTO clientes (clientes.Nombre, clientes.ApellidoP, clientes.ApellidoM, clientes.Fecha_Nacimiento, clientes.Telefono, clientes.Domicilio, clientes.Correo) 
    VALUES (nombre, app, apm, fecha, telefono, domicilio, correo);
END$

CREATE PROCEDURE set_atiende(IN id_tienda INT, IN id_cliente INT, IN id_empleado INT, IN fecha DATE)
BEGIN
	INSERT INTO atiende (atiende.id_tiendas,atiende.id_clientes, atiende.id_empleado, atiende.Fecha_Atencion) 
    VALUES (id_tienda, id_cliente, id_empleado, fecha);
END$