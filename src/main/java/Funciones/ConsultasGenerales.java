package Funciones;

import ConexionBD.Conexion;
import com.mysql.cj.jdbc.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import javax.swing.JLabel;

public class ConsultasGenerales {

    private Conexion obC;
    private String sql;
    private PreparedStatement query;
    private ResultSet result;
    private JLabel lblR1, lblR2, lblR3;

    public ConsultasGenerales() {
        obC = new Conexion();
    }

    public void consultarDatoGeneral(String tabla, JLabel lblResult) {
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
            }
            break;
            case "ventas":
                try {
                sql = "CALL get_ingresos_lapso(?, ?, ?);";
                CallableStatement stat = (CallableStatement) obC.setConnection().prepareCall(sql);
                stat.setDate(1, Date.valueOf(LocalDate.now().with(TemporalAdjusters.firstDayOfMonth())));
                stat.setDate(2, Date.valueOf(LocalDate.now().with(TemporalAdjusters.lastDayOfMonth())));
                stat.registerOutParameter(3, Types.DOUBLE);

                stat.execute();

                lblResult.setText(String.valueOf(stat.getDouble(3)));
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                    lblResult.setText(result.getString(1) + " | " + result.getString(2) + " vendidos");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                    lblResult.setText(result.getString(1) + " | " + result.getString(2) + " vendidos");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
            }
            break;
            case "menos ventas":
                try {
                sql = "SELECT t.Nombre, SUM(c.Total) AS venta \n"
                        + "FROM tiendas AS t\n"
                        + "INNER JOIN compra AS c ON t.id_tiendas = c.id_tienda\n"
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
            }
            break;
            case "mas ventas":
                try {
                sql = "SELECT t.Nombre, SUM(c.Total) AS venta \n"
                        + "FROM tiendas AS t\n"
                        + "INNER JOIN compra AS c ON t.id_tiendas = c.id_tienda\n"
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
            }
            break;
            case "mejor cliente":
                try {
                sql = "SELECT c.Nombre, SUM(v.Total) AS compra \n"
                        + "FROM clientes AS c\n"
                        + "INNER JOIN compra AS v ON c.id_clientes = v.id_clientes\n"
                        + "GROUP BY v.id_clientes\n"
                        + "ORDER BY compra DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
            }
            break;
            case "mas activo":
                try {
                sql = "SELECT p.Nombre, COUNT(pr.id_proveedores) AS participacion\n"
                        + "FROM proveedores AS p\n"
                        + "INNER JOIN proveen pr ON p.id_proveedores = pr.id_proveedores\n"
                        + "GROUP BY pr.id_proveedores\n"
                        + "ORDER BY participacion DESC LIMIT 1;";
                query = obC.setConnection().prepareStatement(sql);
                result = query.executeQuery();
                while (result.next()) {
                    lblResult.setText(result.getString(1));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
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
                            lblR1.setText(result.getString(1)+ "   |");
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
                obC.closeConnection();
                System.out.println("Fin conexion " + tabla);
            }
            break;
        }
    }

    public void setLablesInvStock(JLabel lblR1, JLabel lblR2, JLabel lblR3) {
        this.lblR1 = lblR1;
        this.lblR2 = lblR2;
        this.lblR3 = lblR3;
    }

}
