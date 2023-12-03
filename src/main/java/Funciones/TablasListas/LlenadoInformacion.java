package Funciones.TablasListas;

import Funciones.Entidades.CRUDClientes;
import Funciones.Entidades.CRUDEmpleados;
import Funciones.Entidades.CRUDProveedores;
import Funciones.Entidades.CRUDTiendas;
import Funciones.Entidades.CRUDVideojuegos;
import Funciones.Relaciones.CRUDInventario;
import TDA.Entidades.*;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class LlenadoInformacion {

    private DefaultTableCellRenderer tcr;

    public LlenadoInformacion() {
        tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        tcr.setBorder(new LineBorder(Color.BLACK));
    }

    public void llenarComboVideojuegos(JComboBox combo) {
        combo.removeAllItems();

        CRUDVideojuegos obV = new CRUDVideojuegos();
        obV.selectVideojuego();
        for (Videojuego v : obV.getData()) {
            combo.addItem(v.getNombre());
        }
    }

    public void llenarComboTiendas(JComboBox combo) {
        combo.removeAllItems();

        CRUDTiendas obT = new CRUDTiendas();
        obT.selectTienda();
        for (Tienda t : obT.getData()) {
            combo.addItem(t.getNombre());
        }
    }

    public void llenarTablaVideojuegos(JTable tabla) {
        DefaultTableModel tbModelVideojuegos = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelVideojuegos.setRowCount(0);
        CRUDVideojuegos obV = new CRUDVideojuegos();
        obV.selectVideojuego();

        tbModelVideojuegos.addColumn("ID");
        tbModelVideojuegos.addColumn("Nombre");
        tbModelVideojuegos.addColumn("Categoria");
        tbModelVideojuegos.addColumn("Precio");

        Object[] row = new Object[4];
        for (Videojuego v : obV.getData()) {
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

    public void llenarTablaTiendas(JTable tabla) {
        DefaultTableModel tbModelTiendas = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelTiendas.setRowCount(0);
        CRUDTiendas obT = new CRUDTiendas();
        obT.selectTienda();

        tbModelTiendas.addColumn("ID");
        tbModelTiendas.addColumn("Nombre");
        tbModelTiendas.addColumn("Domicilio");

        Object[] row = new Object[3];
        for (Tienda t : obT.getData()) {
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

    public void llenarTablaProveedores(JTable tabla) {
        DefaultTableModel tbModelProv = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelProv.setRowCount(0);
        CRUDProveedores obP = new CRUDProveedores();
        obP.selectProveedor();

        tbModelProv.addColumn("ID");
        tbModelProv.addColumn("Nombre");
        tbModelProv.addColumn("Telefono");
        tbModelProv.addColumn("Domicilio");
        tbModelProv.addColumn("Correo");

        Object[] row = new Object[5];
        for (Proveedor p : obP.getData()) {
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

    public void llenarTablaEmpleados(JTable tabla) {
        DefaultTableModel tbModelEmp = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelEmp.setRowCount(0);
        CRUDEmpleados obE = new CRUDEmpleados();
        obE.selectEmpleado();

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
        for (Empleado e : obE.getDataEmpleado()) {
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

    public void llenarTablaClientes(JTable tabla) {
        DefaultTableModel tbModelClientes = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelClientes.setRowCount(0);
        CRUDClientes obC = new CRUDClientes();
        obC.selectCliente();

        tbModelClientes.addColumn("ID");
        tbModelClientes.addColumn("Nombre");
        tbModelClientes.addColumn("ApellidoP");
        tbModelClientes.addColumn("ApellidoM");
        tbModelClientes.addColumn("Fecha Nacimiento");
        tbModelClientes.addColumn("Telefono");
        tbModelClientes.addColumn("Domicilio");
        tbModelClientes.addColumn("Correo");

        Object[] row = new Object[8];
        for (Cliente c : obC.getData()) {
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

    public void llenarTablaInventario(JTable tabla) {
        DefaultTableModel tbModelInv = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tbModelInv.setRowCount(0);
        CRUDInventario obI = new CRUDInventario();
        obI.selectInventarioTable();
        
        tbModelInv.addColumn("ID_Videojuego");
        tbModelInv.addColumn("Videojuego");
        tbModelInv.addColumn("ID_Tienda");
        tbModelInv.addColumn("Tienda");
        tbModelInv.addColumn("Stock");

        Object[] row = new Object[5];
        for (int i = 0; i < obI.getDataTable().size(); i++) {
            row[0] = obI.getDataTable().get(i)[3];
            row[1] = obI.getDataTable().get(i)[0];
            row[2] = obI.getDataTable().get(i)[4];
            row[3] = obI.getDataTable().get(i)[1];
            row[4] = obI.getDataTable().get(i)[2];

            tbModelInv.addRow(row);
        }
        tabla.setModel(tbModelInv);
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
        tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    }

}
