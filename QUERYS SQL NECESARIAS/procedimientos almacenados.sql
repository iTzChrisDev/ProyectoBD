DELIMITER $
CREATE PROCEDURE insertar_empleado(
	IN p_Nombre VARCHAR(50),
    IN p_ApellidoP VARCHAR(50),
    IN p_ApellidoM VARCHAR(50),
    IN p_NSS VARCHAR(20),
    IN p_Fecha_Nacimiento DATE,
    IN p_CURP VARCHAR(20),
    IN p_Telefono INT,
    IN p_Domicilio VARCHAR(50),
    IN p_Sueldo DOUBLE,
    IN P_id_Tienda INT,
    IN P_Hr_Entrada TIME,
    IN P_Hr_Salida TIME,
    IN P_Turno VARCHAR(25))
BEGIN 
INSERT INTO empleados (Nombre, ApellidoP, ApellidoM, NSS, Fecha_Nacimiento, CURP, Telefono, Domicilio, Sueldo)
	VALUES (p_Nombre, p_ApellidoP, p_ApellidoM, p_NSS, p_Fecha_Nacimiento, p_CURP, p_Telefono, p_Domicilio, p_Sueldo);

	SET @idEmpleado = LAST_INSERT_ID();

	INSERT INTO trabaja (id_tienda, id_empleado, Hora_Entrada, Hora_Salida, Turno)
	VALUES (P_id_Tienda, @idEmpleado, P_Hr_Entrada, P_Hr_Salida, P_Turno);
END$

CREATE PROCEDURE actualizar_empleado(
    IN p_id_empleado INT,
	IN p_Nombre VARCHAR(50),
    IN p_ApellidoP VARCHAR(50),
    IN p_ApellidoM VARCHAR(50),
    IN p_NSS VARCHAR(20),
    IN p_Fecha_Nacimiento DATE,
    IN p_CURP VARCHAR(20),
    IN p_Telefono INT,
    IN p_Domicilio VARCHAR(50),
    IN p_Sueldo DOUBLE,
    IN p_id_tienda INT,
    IN p_Hr_Entrada TIME,
    IN p_Hr_Salida TIME,
    IN p_Turno VARCHAR(45)
)
BEGIN
    UPDATE empleados
    SET
        Nombre = p_Nombre,
        ApellidoP = p_ApellidoP,
        ApellidoM = p_ApellidoM,
        NSS = p_NSS,
        Fecha_Nacimiento = p_Fecha_Nacimiento,
        CURP = p_CURP,
        Telefono = p_Telefono,
        Domicilio = p_Domicilio,
        Sueldo = p_Sueldo
    WHERE id_empleado = p_id_empleado;

    UPDATE trabaja
    SET
        id_tienda = p_id_tienda,
        Hora_Entrada = p_Hr_Entrada,
        Hora_Salida = p_Hr_Salida,
        Turno = p_Turno
    WHERE id_empleado = p_id_empleado;
END$

CREATE PROCEDURE eliminar_empleado(IN p_id_empleado INT)
BEGIN
    DELETE FROM trabaja WHERE trabaja.id_empleado = p_id_empleado;
	DELETE FROM empleados WHERE empleados.id_empleado = p_id_empleado;
END$

CREATE PROCEDURE get_ingresos_lapso(IN fecha1 DATE, IN fecha2 DATE, OUT ingresos DOUBLE)
BEGIN
	SET ingresos = (SELECT SUM(compra.Total) FROM compra WHERE compra.Fecha BETWEEN fecha1 AND fecha2);
END$

CREATE PROCEDURE buscar_informacion(
    IN p_Tabla VARCHAR(255),
    IN p_ValorBusqueda VARCHAR(255)
)
BEGIN
    -- Obtener la lista de columnas de la tabla
    SELECT GROUP_CONCAT(CONCAT('`', column_name, '`') SEPARATOR ', ') INTO @columnas
    FROM information_schema.columns
    WHERE table_name = p_Tabla;

    -- Construir la consulta dinámicamente
    SET @query = CONCAT('SELECT * FROM ', p_Tabla, ' WHERE CONCAT(', @columnas, ') LIKE ?;');

    -- Preparar y ejecutar la consulta
    PREPARE stmt FROM @query;
    SET @search_value = CONCAT('%', p_ValorBusqueda, '%');
    EXECUTE stmt USING @search_value;
    DEALLOCATE PREPARE stmt;
END$

CREATE PROCEDURE buscar_inventario(
    IN valorBuscado VARCHAR(255)
)
BEGIN
    SET @sqlQuery = CONCAT('
        SELECT v.Nombre AS NombreVideojuego, t.Nombre AS NombreTienda, i.Stock, v.id_videojuego, t.id_tienda
        FROM inventario AS i
        INNER JOIN videojuegos v ON i.id_videojuego = v.id_videojuego
        INNER JOIN tiendas t ON i.id_tienda = t.id_tienda
        WHERE CONCAT_WS("", v.Nombre, t.Nombre, i.Stock, v.id_videojuego, t.id_tienda) LIKE ?');

    SET @valorBuscado = CONCAT('%', valorBuscado, '%');

    PREPARE stmt FROM @sqlQuery;
    EXECUTE stmt USING @valorBuscado;
    DEALLOCATE PREPARE stmt;
END$

CREATE PROCEDURE buscar_empleados(
    IN valorBuscado VARCHAR(255)
)
BEGIN
    SET @sqlQuery = CONCAT('
        SELECT e.id_empleado, ti.id_tienda, e.Nombre, e.ApellidoP, e.ApellidoM, e.NSS, e.Fecha_Nacimiento, e.CURP, e.Telefono, e.Domicilio, e.Sueldo, ti.Nombre AS Tienda, t.Hora_Entrada, t.Hora_Salida, t.Turno
        FROM empleados AS e
        INNER JOIN trabaja AS t ON e.id_empleado = t.id_empleado
        INNER JOIN tiendas AS ti ON ti.id_tienda = t.id_tienda
        WHERE CONCAT_WS("", e.id_empleado, ti.id_tienda, e.Nombre, e.ApellidoP, e.ApellidoM, e.NSS, e.Fecha_Nacimiento, e.CURP, e.Telefono, e.Domicilio, e.Sueldo, ti.Nombre, t.Hora_Entrada, t.Hora_Salida, t.Turno) LIKE ? 
        ORDER BY e.id_empleado ASC');

    SET @valorBuscado = CONCAT('%', valorBuscado, '%');

    PREPARE stmt FROM @sqlQuery;
    EXECUTE stmt USING @valorBuscado;
    DEALLOCATE PREPARE stmt;
END$

CREATE PROCEDURE insertar_proveen(
    IN id_vid INT,
    IN id_t INT,
    IN id_p INT,
    IN cantidad INT,
    IN fecha DATE
)
BEGIN
    DECLARE stock_existente INT;

    SELECT Stock INTO stock_existente
    FROM inventario
    WHERE id_videojuego = id_vid AND id_tienda = id_t;

    IF stock_existente IS NOT NULL THEN
        UPDATE inventario
        SET Stock = stock_existente + cantidad
        WHERE id_videojuego = id_vid AND id_tienda = id_t;
    ELSE
        INSERT INTO inventario (id_videojuego, id_tienda, Stock) VALUES (id_vid, id_t, cantidad);
    END IF;

    INSERT INTO proveen (id_videojuego, id_proveedor, id_tienda, Cantidad, Fecha) VALUES (id_vid, id_p, id_t, cantidad, fecha);
END$

CREATE PROCEDURE actualizar_proveen(
    IN id_vid INT,
    IN id_t INT,
	IN id_p INT,
    IN nueva_cantidad INT
)
BEGIN
    -- Actualizar la cantidad en la tabla inventario
    UPDATE inventario
    SET Stock = nueva_cantidad
    WHERE id_videojuego = id_vid AND id_tienda = id_t;

    -- Actualizar la cantidad en la tabla proveen
    UPDATE proveen
    SET Cantidad = nueva_cantidad
    WHERE id_videojuego = id_vid AND id_tienda = id_t AND id_proveedor = id_p;
END$

CREATE PROCEDURE insertar_compra(
    IN p_id_videojuego INT,
    IN p_id_tienda INT,
    IN p_id_cliente INT,
    IN p_cantidad INT,
    IN p_total DECIMAL(10, 2),
    IN p_fecha DATE,
    OUT p_mensaje VARCHAR(255)
)
BEGIN
    DECLARE stock_disponible INT;

    SELECT Stock INTO stock_disponible
    FROM inventario
    WHERE id_videojuego = p_id_videojuego AND id_tienda = p_id_tienda;

    IF stock_disponible >= p_cantidad THEN
        INSERT INTO compra (id_videojuego, id_tienda, id_cliente, Cantidad, Total, Fecha)
        VALUES (p_id_videojuego, p_id_tienda, p_id_cliente, p_cantidad, p_total, p_fecha);

        UPDATE inventario
        SET Stock = Stock - p_cantidad
        WHERE id_videojuego = p_id_videojuego AND id_tienda = p_id_tienda;

        SET p_mensaje = 'Venta realizada correctamente';
    ELSE
        SET p_mensaje = 'No hay suficiente stock para realizar la venta';
    END IF;
END $

DELIMITER ;