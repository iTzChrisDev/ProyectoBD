DELIMITER $
CREATE TRIGGER precio_videojuegos
BEFORE INSERT ON videojuegos
FOR EACH ROW
BEGIN
    IF NEW.Precio <= 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'El precio del videojuego debe ser mayor que cero';
    END IF;
END$

