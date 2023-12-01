-- Resumen general
SELECT COUNT(*) FROM proveedores;

SELECT COUNT(*) FROM videojuegos;

SELECT COUNT(*) FROM empleados;

SELECT COUNT(*) FROM tiendas;

SELECT COUNT(*) FROM clientes;

SELECT COUNT(*) FROM inventario;

-- Datos importantes

SELECT COUNT(*) FROM compra;

	-- INGRESOS MENSUALES
DELIMITER $
CREATE PROCEDURE get_ingresos_lapso(IN fecha1 DATE, IN fecha2 DATE, OUT ingresos DOUBLE)
BEGIN
	SET ingresos = (SELECT SUM(compra.Total) FROM compra WHERE compra.Fecha BETWEEN fecha1 AND fecha2);
END$
CALL get_ingresos_lapso("01-10-2021","01-10-2021",@ingresos);
SELECT @ingresos AS ingresos_obtenidos;

	-- MAS VENDIDO
SELECT v.Nombre, SUM(c.Cantidad) AS cant 
FROM videojuegos AS v
INNER JOIN compra AS c ON v.id_videojuego = c.id_videojuego
GROUP BY c.id_videojuego
ORDER BY cant DESC LIMIT 1;

	-- MENOS VENDIDO
SELECT v.Nombre, SUM(c.Cantidad) AS cant 
FROM videojuegos AS v
INNER JOIN compra AS c ON v.id_videojuego = c.id_videojuego
GROUP BY c.id_videojuego
ORDER BY cant ASC LIMIT 1;

-- Tiendas
	-- MAS VENTAS
SELECT t.Nombre, SUM(c.Total) AS venta 
FROM tiendas AS t
INNER JOIN compra AS c ON t.id_tiendas = c.id_tienda
GROUP BY c.id_tienda
ORDER BY venta DESC LIMIT 1;
	-- MENOS VENTAS
SELECT t.Nombre, SUM(c.Total) AS venta 
FROM tiendas AS t
INNER JOIN compra AS c ON t.id_tiendas = c.id_tienda
GROUP BY c.id_tienda
ORDER BY venta ASC LIMIT 1;

-- Empleados
	-- MEJOR SUELDO
SELECT e.Nombre, e.Sueldo
FROM empleados AS e
ORDER BY e.Sueldo DESC LIMIT 1;

	-- MAS ATENTO
SELECT e.Nombre, COUNT(a.id_empleado) AS atenciones
FROM empleados AS e
INNER JOIN atiende AS a ON e.id_empleado = a.id_empleado
GROUP BY e.id_empleado
ORDER BY atenciones DESC;

-- Clientes
SELECT c.Nombre, SUM(v.Total) AS compra 
FROM clientes AS c
INNER JOIN compra AS v ON c.id_clientes = v.id_clientes
GROUP BY v.id_clientes
ORDER BY compra DESC LIMIT 1;

-- Proveedores
SELECT p.Nombre, COUNT(pr.id_proveedores) AS participacion
FROM proveedores AS p
INNER JOIN proveen pr ON p.id_proveedores = pr.id_proveedores
GROUP BY pr.id_proveedores
ORDER BY participacion DESC LIMIT 1;

-- Inventario
SELECT v.Nombre, SUM(i.Stock) AS cantidad
FROM videojuegos AS v
INNER JOIN inventario AS i ON v.id_videojuego = i.id_videojuego
GROUP BY i.id_videojuego
ORDER BY cantidad ASC LIMIT 3;
