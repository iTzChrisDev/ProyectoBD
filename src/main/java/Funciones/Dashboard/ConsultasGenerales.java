package Funciones.Dashboard;

import ConexionBD.Conexion;
import TDA.Entidades.*;
import TDA.Relaciones.Inventario;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import javax.swing.JLabel;

public class ConsultasGenerales {

    private Conexion obC;
    private String sql;
    private PreparedStatement query;
    private ResultSet result;
    private JLabel lblR1, lblR2, lblR3;
    private ArrayList<Videojuego> dataVideojuego;
    private ArrayList<Empleado> dataEmpleado;
    private ArrayList<Cliente> dataCliente;
    private ArrayList<Proveedor> dataProveedor;
    private ArrayList<Tienda> dataTienda;
    private ArrayList<Inventario> dataInventario;

    public ConsultasGenerales() {
        obC = new Conexion();
        dataVideojuego = new ArrayList<>();
        dataTienda = new ArrayList<>();
        dataProveedor = new ArrayList<>();
        dataInventario = new ArrayList<>();
        dataEmpleado = new ArrayList<>();
        dataCliente = new ArrayList<>();
    }

    /* 1 - Videojuegos
       2 - Tiendas
       3 - Proveedores
       4 - Empleados
       5 - Clientes
       6 - Inventario*/
    public void buscarInformacion(String nombreTabla, String parametroBusqueda, int value) {
        CallableStatement stat = null;
        try {
            sql = "CALL buscar_informacion(?, ?);";
            stat = (CallableStatement) obC.setConnection().prepareCall(sql);
            stat.setString(1, nombreTabla);
            stat.setString(2, parametroBusqueda);

            result = stat.executeQuery();

            switch (value) {
                case 1 -> {
                    while (result.next()) {
                        dataVideojuego.add(new Videojuego(result.getInt("id_videojuego"), result.getString("Nombre"), result.getString("Categoria"), result.getDouble("Precio")));
                    }
                }
                case 2 -> {
                    while (result.next()) {
                        dataTienda.add(new Tienda(result.getInt("id_tiendas"), result.getString("Nombre"), result.getString("Domicilio")));
                    }
                }
                case 3 -> {
                    while (result.next()) {
                        dataProveedor.add(new Proveedor(result.getInt("id_proveedores"), result.getString("Nombre"), result.getInt("Telefono"), result.getString("Domicilio"), result.getString("Correo")));
                    }
                }
                case 4 -> {
                    while (result.next()) {
                        dataEmpleado.add(new Empleado(result.getInt("id_empleado"), result.getString("Nombre"), result.getString("ApellidoP"), result.getString("ApellidoM"), result.getString("NSS"), result.getString("CURP"), result.getDate("Fecha_Nacimiento"), result.getInt("Telefono"), result.getString("Domicilio"), result.getInt("Sueldo")));
                    }
                }
                case 5 -> {
                    while (result.next()) {
                        dataCliente.add(new Cliente(result.getInt("id_clientes"), result.getString("Nombre"), result.getString("ApellidoP"), result.getString("ApellidoM"), result.getDate("Fecha_Nacimiento"), result.getInt("Telefono"), result.getString("Domicilio"), result.getString("Correo")));
                    }
                }
                case 6 -> {
                    while (result.next()) {
                        dataInventario.add(new Inventario(result.getInt("id_videojuego"), result.getInt("id_tiendas"), result.getInt("Stock")));
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException ex) {
                }
            }
            obC.closeConnection();
        }
    }

    public void consultarDatoGeneral(String tabla, JLabel lblResult, JLabel lblResultCant) {
        switch (tabla) {
            case "videojuegos":
                try {
                sql = "SELECT COUNT(*) FROM videojuegos;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "tiendas":
                try {
                sql = "SELECT COUNT(*) FROM tiendas;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "clientes":
                try {
                sql = "SELECT COUNT(*) FROM clientes;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "empleados":
                try {
                sql = "SELECT COUNT(*) FROM empleados;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "proveedores":
                try {
                sql = "SELECT COUNT(*) FROM proveedores;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "inventario":
                try {
                sql = "SELECT COUNT(*) FROM inventario;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "compra":
                try {
                sql = "SELECT COUNT(*) FROM compra;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "ventas":
                CallableStatement stat = null;
                try {
                    sql = "CALL get_ingresos_lapso(?, ?, ?);";
                    stat = (CallableStatement) obC.setConnection().prepareCall(sql);
                    stat.setDate(1, Date.valueOf(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth())));
                    stat.setDate(2, Date.valueOf(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth())));
                    stat.registerOutParameter(3, Types.DOUBLE);
                    stat.execute();

                    lblResult.setText("$" + String.valueOf(stat.getDouble(3)));
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    if (stat != null) {
                        try {
                            stat.close();
                        } catch (SQLException ex) {
                        }
                    }
                    obC.closeConnection();
                }
                break;
            case "mas vendido":
                try {
                sql = "SELECT v.Nombre, SUM(c.Cantidad) AS cant"
                        + " FROM videojuegos AS v"
                        + " INNER JOIN compra AS c ON v.id_videojuego = c.id_videojuego"
                        + " GROUP BY c.id_videojuego"
                        + " ORDER BY cant DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                    lblResultCant.setText(result.getString(2) + " vendidos");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "menos vendido":
                try {
                sql = "SELECT v.Nombre, SUM(c.Cantidad) AS cant"
                        + " FROM videojuegos AS v"
                        + " INNER JOIN compra AS c ON v.id_videojuego = c.id_videojuego"
                        + " GROUP BY c.id_videojuego"
                        + " ORDER BY cant ASC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                    lblResultCant.setText(result.getString(2) + " vendidos");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "mas vendido1":
                try {
                sql = "SELECT v.Nombre, SUM(c.Cantidad) AS cant"
                        + " FROM videojuegos AS v"
                        + " INNER JOIN compra AS c ON v.id_videojuego = c.id_videojuego"
                        + " GROUP BY c.id_videojuego"
                        + " ORDER BY cant DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "menos vendido1":
                try {
                sql = "SELECT v.Nombre, SUM(c.Cantidad) AS cant"
                        + " FROM videojuegos AS v"
                        + " INNER JOIN compra AS c ON v.id_videojuego = c.id_videojuego"
                        + " GROUP BY c.id_videojuego"
                        + " ORDER BY cant ASC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "menos ventas":
                try {
                sql = "SELECT t.Nombre, SUM(c.Total) AS venta \n"
                        + "FROM tiendas AS t\n"
                        + "INNER JOIN compra AS c ON t.id_tienda = c.id_tienda\n"
                        + "GROUP BY c.id_tienda\n"
                        + "ORDER BY venta ASC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "mas ventas":
                try {
                sql = "SELECT t.Nombre, SUM(c.Total) AS venta \n"
                        + "FROM tiendas AS t\n"
                        + "INNER JOIN compra AS c ON t.id_tienda = c.id_tienda\n"
                        + "GROUP BY c.id_tienda\n"
                        + "ORDER BY venta DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "mejor sueldo":
                try {
                sql = "SELECT e.Nombre, e.Sueldo\n"
                        + "FROM empleados AS e\n"
                        + "ORDER BY e.Sueldo DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "mas atento":
                try {
                sql = "SELECT e.Nombre, COUNT(a.id_empleado) AS atenciones\n"
                        + "FROM empleados AS e\n"
                        + "INNER JOIN atiende AS a ON e.id_empleado = a.id_empleado\n"
                        + "GROUP BY e.id_empleado\n"
                        + "ORDER BY atenciones DESC;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "mejor cliente":
                try {
                sql = "SELECT c.Nombre, SUM(v.Total) AS compra \n"
                        + "FROM clientes AS c\n"
                        + "INNER JOIN compra AS v ON c.id_cliente = v.id_cliente\n"
                        + "GROUP BY v.id_cliente\n"
                        + "ORDER BY compra DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "mas activo":
                try {
                sql = "SELECT p.Nombre, COUNT(pr.id_proveedor) AS participacion\n"
                        + "FROM proveedores AS p\n"
                        + "INNER JOIN proveen pr ON p.id_proveedor = pr.id_proveedor\n"
                        + "GROUP BY pr.id_proveedor\n"
                        + "ORDER BY participacion DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
            case "stock":
                try {
                sql = "SELECT v.Nombre, SUM(i.Stock) AS cantidad\n"
                        + "FROM videojuegos AS v\n"
                        + "INNER JOIN inventario AS i ON v.id_videojuego = i.id_videojuego\n"
                        + "GROUP BY i.id_videojuego\n"
                        + "ORDER BY cantidad ASC LIMIT 3;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                int cont = 1;
                while (result.next()) {
                    switch (cont) {
                        case 1:
                            lblR1.setText(result.getString(1) + "   |");
                            break;
                        case 2:
                            lblR2.setText(result.getString(1) + "   |");
                            break;
                        case 3:
                            lblR3.setText(result.getString(1));
                            break;
                    }
                    cont++;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (query != null) {
                    try {
                        query.close();
                    } catch (SQLException ex) {
                    }
                }
                obC.closeConnection();
            }
            break;
        }
    }

    public void setLablesInvStock(JLabel lblR1, JLabel lblR2, JLabel lblR3) {
        this.lblR1 = lblR1;
        this.lblR2 = lblR2;
        this.lblR3 = lblR3;
    }

    public ArrayList<Videojuego> getDataVideojuego() {
        return dataVideojuego;
    }

    public ArrayList<Empleado> getDataEmpleado() {
        return dataEmpleado;
    }

    public ArrayList<Cliente> getDataCliente() {
        return dataCliente;
    }

    public ArrayList<Proveedor> getDataProveedor() {
        return dataProveedor;
    }

    public ArrayList<Tienda> getDataTienda() {
        return dataTienda;
    }

    public ArrayList<Inventario> getDataInventario() {
        return dataInventario;
    }
}
