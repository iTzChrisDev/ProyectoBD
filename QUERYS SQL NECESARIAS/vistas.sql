-- Vista de toda la informacion de los videojuegos
CREATE VIEW videojuegosall AS SELECT * FROM videojuegos;

-- Vista de las categorias y la cantidad de juegos que tienen
CREATE VIEW vjcategorias AS SELECT Categoria, COUNT(categoria) AS Cantidad FROM videojuegosall GROUP BY categoria ORDER BY categoria ASC;

-- Vista de toda la informacion de los proveedores
CREATE VIEW proveedoresall AS SELECT * FROM proveedores;

-- Vista de los proveedores y cuanto han surtido
CREATE VIEW provsurtido AS SELECT Nombre AS Proveedor, SUM(cantidad) AS Cantidad_Surtida FROM proveen JOIN proveedores ON proveen.id_proveedor = proveedores.id_proveedor GROUP BY Nombre ORDER BY cantidad_surtida DESC;

-- Vista de toda la información de las tiendas
CREATE VIEW tiendasall AS SELECT * FROM tiendas;

-- Vista de la cantidad de ventas que tiene cada tienda
CREATE VIEW tventas AS SELECT tiendas.Nombre AS Tienda, SUM(compra.Cantidad) AS Ventas FROM tiendas INNER JOIN compra ON tiendas.id_tienda = compra.id_tienda GROUP BY tiendas.id_tienda ORDER BY Ventas DESC;

-- Vista de la cantidad de empleados que tiene cada tienda
CREATE VIEW templeados AS SELECT tiendas.Nombre AS Tienda, COUNT(trabaja.id_empleado) AS Empleados FROM tiendas INNER JOIN trabaja ON tiendas.id_tienda = trabaja.id_tienda GROUP BY tiendas.id_tienda ORDER BY empleados DESC;

-- Vista de toda la informacion de los clientes
CREATE VIEW clientesall AS SELECT * FROM clientes;

-- Vista de los clientes que mas han comprado
CREATE VIEW ccompra AS SELECT clientes.Nombre, clientes.ApellidoP AS Apellido_Paterno, SUM(compra.Cantidad) as Comprado FROM clientes INNER JOIN compra ON clientes.id_cliente = compra.id_cliente GROUP BY clientes.id_cliente ORDER BY Comprado DESC;

-- Vista de toda la información de los empleados
CREATE VIEW empleadosall AS SELECT empleados.*, tiendas.nombre AS Tienda FROM empleados INNER JOIN (trabaja INNER JOIN tiendas ON trabaja.id_tienda = tiendas.id_tienda) ON trabaja.id_empleado = empleados.id_empleado;

-- Vista de la cantidad de atenciones que ha realizado un empeado
CREATE VIEW eatenciones AS SELECT empleados.id_empleado AS id, empleados.Nombre AS Empleado, empleados.ApellidoP AS Apellido_Paterno, COUNT(atiende.id_empleado) AS Atendidos FROM empleados INNER JOIN atiende ON empleados.id_empleado = atiende.id_empleado GROUP BY empleados.id_empleado ORDER BY Atendidos DESC;