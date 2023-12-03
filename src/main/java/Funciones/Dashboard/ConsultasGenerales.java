package Funciones.Dashboard;

import ConexionBD.Conexion;
import Funciones.Entidades.CRUDClientes;
import Funciones.Entidades.CRUDEmpleados;
import Funciones.Entidades.CRUDProveedores;
import Funciones.Entidades.CRUDTiendas;
import Funciones.Entidades.CRUDVideojuegos;
import Funciones.Relaciones.CRUDInventario;
import TDA.Entidades.*;
import TDA.Relaciones.Inventario;
import com.mysql.cj.jdbc.CallableStatement;
import java.awt.Color;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

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
    //private ArrayList<String[]> dataInventario;
    private DefaultTableCellRenderer tcr;

    public ConsultasGenerales() {
        obC = new Conexion();
        dataVideojuego = new ArrayList<>();
        dataTienda = new ArrayList<>();
        dataProveedor = new ArrayList<>();
        //dataInventario = new ArrayList<>();
        dataEmpleado = new ArrayList<>();
        dataCliente = new ArrayList<>();
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr.setBorder(new LineBorder(Color.BLACK));
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
                        dataTienda.add(new Tienda(result.getInt("id_tienda"), result.getString("Nombre"), result.getString("Domicilio")));
                    }
                }
                case 3 -> {
                    while (result.next()) {
                        dataProveedor.add(new Proveedor(result.getInt("id_proveedor"), result.getString("Nombre"), result.getInt("Telefono"), result.getString("Domicilio"), result.getString("Correo")));
                    }
                }
                case 4 -> {
                    while (result.next()) {
                        dataEmpleado.add(new Empleado(result.getInt("id_empleado"), result.getString("Nombre"), result.getString("ApellidoP"), result.getString("ApellidoM"), result.getString("NSS"), result.getString("CURP"), result.getDate("Fecha_Nacimiento"), result.getInt("Telefono"), result.getString("Domicilio"), result.getInt("Sueldo")));
                    }
                }
                case 5 -> {
                    while (result.next()) {
                        dataCliente.add(new Cliente(result.getInt("id_cliente"), result.getString("Nombre"), result.getString("ApellidoP"), result.getString("ApellidoM"), result.getDate("Fecha_Nacimiento"), result.getInt("Telefono"), result.getString("Domicilio"), result.getString("Correo")));
                    }
                }
                case 6 -> {
                    while (result.next()) {
                        //dataInventario.add(new Inventario(result.getInt("id_videojuego"), result.getInt("id_tienda"), result.getInt("Stock")));
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

    public void llenarTablaVideojuegosBus(JTable tabla) {
        DefaultTableModel tbModelVideojuegos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelVideojuegos.setRowCount(0);

        tbModelVideojuegos.addColumn("ID");
        tbModelVideojuegos.addColumn("Nombre");
        tbModelVideojuegos.addColumn("Categoria");
        tbModelVideojuegos.addColumn("Precio");

        Object[] row = new Object[4];
        for (Videojuego v : dataVideojuego) {
            row[0] = v.getId();
            row[1] = v.getNombre();
            row[2] = v.getCategoria();
            row[3] = v.getPrecio();

            tbModelVideojuegos.addRow(row);
        }
        tabla.setModel(tbModelVideojuegos);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void llenarTablaTiendasBus(JTable tabla) {
        DefaultTableModel tbModelTiendas = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelTiendas.setRowCount(0);

        tbModelTiendas.addColumn("ID");
        tbModelTiendas.addColumn("Nombre");
        tbModelTiendas.addColumn("Domicilio");

        Object[] row = new Object[3];
        for (Tienda t : dataTienda) {
            row[0] = t.getId();
            row[1] = t.getNombre();
            row[2] = t.getDomicilio();

            tbModelTiendas.addRow(row);
        }
        tabla.setModel(tbModelTiendas);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void llenarTablaProveedoresBus(JTable tabla) {
        DefaultTableModel tbModelProv = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelProv.setRowCount(0);

        tbModelProv.addColumn("ID");
        tbModelProv.addColumn("Nombre");
        tbModelProv.addColumn("Telefono");
        tbModelProv.addColumn("Domicilio");
        tbModelProv.addColumn("Correo");

        Object[] row = new Object[5];
        for (Proveedor p : dataProveedor) {
            row[0] = p.getId();
            row[1] = p.getNombre();
            row[2] = p.getTelefono();
            row[3] = p.getDomicilio();
            row[4] = p.getCorreo();

            tbModelProv.addRow(row);
        }
        tabla.setModel(tbModelProv);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void llenarTablaEmpleadosBus(JTable tabla) {
        DefaultTableModel tbModelEmp = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelEmp.setRowCount(0);

        tbModelEmp.addColumn("ID");
        tbModelEmp.addColumn("Nombre");
        tbModelEmp.addColumn("ApellidoP");
        tbModelEmp.addColumn("ApellidoM");
        tbModelEmp.addColumn("NSS");
        tbModelEmp.addColumn("Fecha Nacimiento");
        tbModelEmp.addColumn("CURP");
        tbModelEmp.addColumn("Telefono");
        tbModelEmp.addColumn("Domicilio");
        tbModelEmp.addColumn("Sueldo");
        tbModelEmp.addColumn("Tienda");
        tbModelEmp.addColumn("Hr.Entrada");
        tbModelEmp.addColumn("Hr.Salida");
        tbModelEmp.addColumn("Turno");

        Object[] row = new Object[14];
        for (Empleado e : dataEmpleado) {
            row[0] = e.getId();
            row[1] = e.getNombre();
            row[2] = e.getApellidoP();
            row[3] = e.getApellidoM();
            row[4] = e.getNSS();
            row[5] = e.getFechaNacimiento();
            row[6] = e.getCURP();
            row[7] = e.getTelefono();
            row[8] = e.getDomicilio();
            row[9] = e.getSueldo();
            row[10] = e.getNombreTienda();
            row[11] = e.getHrEntrada();
            row[12] = e.getHrSalida();
            row[13] = e.getTurno();

            tbModelEmp.addRow(row);
        }
        tabla.setModel(tbModelEmp);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

    public void llenarTablaClientesBus(JTable tabla) {
        DefaultTableModel tbModelClientes = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelClientes.setRowCount(0);

        tbModelClientes.addColumn("ID");
        tbModelClientes.addColumn("Nombre");
        tbModelClientes.addColumn("ApellidoP");
        tbModelClientes.addColumn("ApellidoM");
        tbModelClientes.addColumn("Fecha Nacimiento");
        tbModelClientes.addColumn("Telefono");
        tbModelClientes.addColumn("Domicilio");
        tbModelClientes.addColumn("Correo");

        Object[] row = new Object[8];
        for (Cliente c : dataCliente) {
            row[0] = c.getId();
            row[1] = c.getNombre();
            row[2] = c.getApellidoP();
            row[3] = c.getApellidoM();
            row[4] = c.getFechaNacimiento();
            row[5] = c.getTelefono();
            row[6] = c.getDomicilio();
            row[7] = c.getCorreo();

            tbModelClientes.addRow(row);
        }
        tabla.setModel(tbModelClientes);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
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

//    public ArrayList<Inventario> getDataInventario() {
//        return dataInventario;
//    }
}
