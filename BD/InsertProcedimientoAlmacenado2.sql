DELIMITER $
CREATE PROCEDURE insertar_empleado(
	IN p_Nombre VARCHAR(255),
    IN p_ApellidoP VARCHAR(45),
    IN p_ApellidoM VARCHAR(45),
    IN p_NSS VARCHAR(45),
    IN p_Fecha_Nacimiento VARCHAR(45),
    IN p_CURP VARCHAR(45),
    IN p_Telefono VARCHAR(45),
    IN p_Domicilio VARCHAR(45),
    IN p_Sueldo INT,
    IN P_id_Tienda INT,
    IN P_Hr_Entrada TIME,
    IN P_Hr_Salida TIME,
    IN P_Turno VARCHAR(45))
BEGIN 
INSERT INTO empleados (Nombre, ApellidoP, ApellidoM, NSS, Fecha_Nacimiento, CURP, Telefono, Domicilio, Sueldo)
	VALUES (p_Nombre, p_ApellidoP, p_ApellidoM, p_NSS, p_Fecha_Nacimiento, p_CURP, p_Telefono, p_Domicilio, p_Sueldo);

	SET @idEmpleado = LAST_INSERT_ID();

	INSERT INTO trabaja (id_tiendas, id_empleado, Hora_Entrada, Hora_Salida, Turno)
	VALUES (P_id_Tienda, @idEmpleado, P_Hr_Entrada, P_Hr_Salida, P_Turno);
END$

DELIMITER $

CREATE PROCEDURE actualizar_empleado(
    IN p_id_empleado INT,
    IN p_Nombre VARCHAR(255),
    IN p_ApellidoP VARCHAR(45),
    IN p_ApellidoM VARCHAR(45),
    IN p_NSS VARCHAR(45),
    IN p_Fecha_Nacimiento VARCHAR(45),
    IN p_CURP VARCHAR(45),
    IN p_Telefono VARCHAR(45),
    IN p_Domicilio VARCHAR(45),
    IN p_Sueldo INT,
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
        id_tiendas = p_id_tienda,
        Hora_Entrada = p_Hr_Entrada,
        Hora_Salida = p_Hr_Salida,
        Turno = p_Turno
    WHERE id_empleado = p_id_empleado;
END$


DELIMITER $

CREATE PROCEDURE eliminar_empleado(IN p_id_empleado INT)
BEGIN
    DELETE FROM trabaja WHERE trabaja.id_empleado = p_id_empleado;
	DELETE FROM empleados WHERE empleados.id_empleado = p_id_empleado;
END$