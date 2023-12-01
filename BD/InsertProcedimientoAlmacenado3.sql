DELIMITER $

CREATE PROCEDURE buscar_informacion(
    IN p_Tabla VARCHAR(255),
    IN p_ValorBusqueda VARCHAR(255)
)
BEGIN
    -- Obtener la lista de columnas de la tabla
    SELECT GROUP_CONCAT(column_name SEPARATOR ', ') INTO @columnas
    FROM information_schema.columns
    WHERE table_name = p_Tabla;

    -- Construir la consulta dinámicamente
    SET @query = CONCAT('SELECT * FROM ', p_Tabla, ' WHERE CONCAT(', @columnas, ') LIKE ?', ';');

    -- Preparar y ejecutar la consulta
    PREPARE stmt FROM @query;
    SET @search_value = CONCAT('%', p_ValorBusqueda, '%');
    EXECUTE stmt USING @search_value;
    DEALLOCATE PREPARE stmt;
END$

DELIMITER ;
