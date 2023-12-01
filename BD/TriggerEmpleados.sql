DELIMITER $
CREATE TRIGGER evitar_empleados_trabajan
BEFORE DELETE ON empleados
FOR EACH ROW
BEGIN
    IF EXISTS (SELECT 1 FROM trabaja WHERE id_empleado = OLD.id_empleado) THEN
        SET OLD = NULL; 
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'No se puede eliminar un empleado asignado a una tienda';
    END IF;
END$
DELIMITER ;
