package GUI;

import CustomComponents.CustomComboBoxRenderer;
import CustomComponents.RoundButton;
import CustomComponents.EstilosComponentes;
import Funciones.Dashboard.ConsultasGenerales;
import Funciones.Entidades.*;
import Funciones.Relaciones.CRUDInventario;
import Funciones.TablasListas.LlenadoInformacion;
import TDA.Entidades.Cliente;
import TDA.Entidades.Empleado;
import TDA.Entidades.Proveedor;
import TDA.Entidades.Tienda;
import TDA.Entidades.Videojuego;
import TDA.Relaciones.Inventario;
import TDA.Relaciones.Trabajo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.sql.Date;
import java.sql.Time;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class VentanaActualizaciones extends javax.swing.JFrame {

    private LlenadoInformacion obI;
    private EstilosComponentes obE;
    private RoundButton btnSalir, btnGuardarVid, btnGuardarTiendas, btnGuardarEmp, btnGuardarClientes, btnGuardarProv, btnGuardarInv;
    private CardLayout obC;
    private String str;
    private CRUDVideojuegos sqlVideojuegos;
    private CRUDClientes sqlClientes;
    private CRUDEmpleados sqlEmpleados;
    private CRUDProveedores sqlProveedores;
    private CRUDTiendas sqlTiendas;
    private CRUDInventario sqlInventario;
    private JTable tbVideojuegos, tbClientes, tbEmpleados, tbProveedores, tbTiendas, tbInventario;
    private JLabel lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, stock1, stock2, stock3;
    private ConsultasGenerales obCons;
    private Videojuego videojuego;
    private Tienda tienda;
    private Proveedor proveedor;
    private Empleado empleado;
    private Cliente cliente;
    private Inventario inventario;
    private int idVideojuego, idTienda, idProveedor, idEmpleado, idCliente;

    public VentanaActualizaciones() {
        initComponents();
        initComponentsCustom();
        setLocationRelativeTo(this);
        obCons = new ConsultasGenerales();
        obC = (CardLayout) pnlMain.getLayout();
        sqlVideojuegos = new CRUDVideojuegos();
        sqlClientes = new CRUDClientes();
        sqlEmpleados = new CRUDEmpleados();
        sqlProveedores = new CRUDProveedores();
        sqlTiendas = new CRUDTiendas();
        sqlInventario = new CRUDInventario();
        actionListenerButtons();
    }

    public void verificar() {
        if (str == "altaVideojuegos") {
            jTextField2.setText(videojuego.getNombre());
            jTextField3.setText(videojuego.getCategoria());
            jTextField4.setText(String.valueOf(videojuego.getPrecio()));
        }
        switch (str) {
            case "altaVideojuegos":
                jTextField2.setText(videojuego.getNombre());
                jTextField3.setText(videojuego.getCategoria());
                jTextField4.setText(String.valueOf(videojuego.getPrecio()));
                break;
            case "altaTiendas":
                jTextField13.setText(tienda.getNombre());
                jTextField14.setText(tienda.getDomicilio());
                break;
            case "altaEmpleados":
                jTextField22.setText(empleado.getApellidoM());
                jTextField21.setText(empleado.getCURP());
                jTextField24.setText(String.valueOf(empleado.getTelefono()));
                jTextField43.setText(String.valueOf(empleado.getHrSalida().getHours()));
                jTextField38.setText(empleado.getFechaNacimiento().toString());
                jTextField40.setText(String.valueOf(empleado.getHrEntrada().getHours()));
                jTextField16.setText(empleado.getApellidoP());
                jTextField15.setText(empleado.getNSS());
                jTextField41.setText(String.valueOf(empleado.getHrEntrada().getMinutes()));
                jTextField7.setText(empleado.getNombre());
                jTextField44.setText(String.valueOf(empleado.getHrSalida().getMinutes()));
                jTextField6.setText(empleado.getDomicilio());
                jTextField39.setText(String.valueOf(empleado.getSueldo()));

                sqlEmpleados.selectEmpleado();
                for (Empleado emp : sqlEmpleados.getDataEmpleado()) {
                    if (emp.getNombreTienda().equals(empleado.getNombreTienda())) {
                        jComboBox3.setSelectedItem(emp.getNombreTienda());
                    }
                    if (emp.getTurno().equals(empleado.getTurno())) {
                        jComboBox4.setSelectedItem(emp.getTurno());
                    }
                }
                break;
            case "altaClientes":
                jTextField11.setText(cliente.getDomicilio());
                jTextField28.setText(cliente.getFechaNacimiento().toString());
                jTextField12.setText(cliente.getApellidoP());
                jTextField27.setText(cliente.getTelefono());
                jTextField25.setText(cliente.getApellidoM());
                jTextField9.setText(cliente.getNombre());
                jTextField29.setText(cliente.getCorreo());
                break;
            case "altaProveedores":
                jTextField30.setText(proveedor.getNombre());
                jTextField31.setText(proveedor.getDomicilio());
                jTextField32.setText(String.valueOf(proveedor.getTelefono()));
                jTextField33.setText(proveedor.getCorreo());
                break;
            case "altaInventario":
                //1 video 2 tienda
                sqlInventario.selectInventarioTable();
                for (String s[] : sqlInventario.getDataTable()) {
                    if (Integer.parseInt(s[3]) == inventario.getId_videojuego()) {
                        jComboBox1.setSelectedItem(s[0]);
                    }
                    if (Integer.parseInt(s[4]) == inventario.getId_tienda()) {
                        jComboBox2.setSelectedItem(s[1]);
                    }
                }
                jTextField17.setText(String.valueOf(inventario.getStock()));
                break;

        }
    }

    public void setValuesGen(JLabel lblJuegoMasVenCant, JLabel lblJuegoMenosVenCant, JLabel lblVidCont, JLabel lblTienCont, JLabel lblProvCont, JLabel lblCliCont, JLabel lblEmpCont, JLabel lblInvCont, JLabel lblCompraCont, JLabel lblCantVendida, JLabel lblJuegoMasVen, JLabel lblJuegoMenosVen, JLabel lblJuegoMasVend, JLabel lblJuegoMenosVend, JLabel lblTiendaMasVentas, JLabel lblTiendaMenosVentas, JLabel lblEmpMasAtenciones, JLabel lblEmpMejorSueldo, JLabel lblMejorCliente, JLabel lblProvMasActivo, JLabel stock1, JLabel stock2, JLabel stock3) {
        this.lblVidCont = lblVidCont;
        this.lblTienCont = lblTienCont;
        this.lblProvCont = lblProvCont;
        this.lblCliCont = lblCliCont;
        this.lblEmpCont = lblEmpCont;
        this.lblInvCont = lblInvCont;
        this.lblCompraCont = lblCompraCont;
        this.lblCantVendida = lblCantVendida;
        this.lblJuegoMasVen = lblJuegoMasVen;
        this.lblJuegoMenosVen = lblJuegoMenosVen;
        this.lblJuegoMasVend = lblJuegoMasVend;
        this.lblJuegoMenosVend = lblJuegoMenosVend;
        this.lblTiendaMasVentas = lblTiendaMasVentas;
        this.lblTiendaMenosVentas = lblTiendaMenosVentas;
        this.lblEmpMasAtenciones = lblEmpMasAtenciones;
        this.lblEmpMejorSueldo = lblEmpMejorSueldo;
        this.lblMejorCliente = lblMejorCliente;
        this.lblProvMasActivo = lblProvMasActivo;
        this.lblJuegoMasVenCant = lblJuegoMasVenCant;
        this.lblJuegoMenosVenCant = lblJuegoMenosVenCant;
        this.stock1 = stock1;
        this.stock2 = stock2;
        this.stock3 = stock3;
    }

    public void initComponentsCustom() {
        obE = new EstilosComponentes();
        btnSalir = obE.getStyleButtonBack(btnSalir, this);
        pnlHeaderVid.add(btnSalir, BorderLayout.EAST);

        btnGuardarVid = obE.getStyleBtnSave(btnGuardarVid);
        btnGuardarTiendas = obE.getStyleBtnSave(btnGuardarTiendas);
        btnGuardarEmp = obE.getStyleBtnSave(btnGuardarEmp);
        btnGuardarClientes = obE.getStyleBtnSave(btnGuardarClientes);
        btnGuardarProv = obE.getStyleBtnSave(btnGuardarProv);
        btnGuardarInv = obE.getStyleBtnSave(btnGuardarInv);
        pnlBtnVideojuegos.add(btnGuardarVid);
        pnlBtnTiendas.add(btnGuardarTiendas);
        pnlBtnEmp.add(btnGuardarEmp);
        pnlBtnClientes.add(btnGuardarClientes);
        pnlBtnProv.add(btnGuardarProv);
        pnlBtnInventario.add(btnGuardarInv);

        jComboBox1.setRenderer(new CustomComboBoxRenderer());
        jComboBox1.setFocusable(false);
        jComboBox1.getComponent(0).setBackground(new Color(140, 255, 241));

        jComboBox2.setRenderer(new CustomComboBoxRenderer());
        jComboBox2.setFocusable(false);
        jComboBox2.getComponent(0).setBackground(new Color(140, 255, 241));

        jComboBox3.setRenderer(new CustomComboBoxRenderer());
        jComboBox3.setFocusable(false);
        jComboBox3.getComponent(0).setBackground(new Color(140, 255, 241));

        jComboBox4.setRenderer(new CustomComboBoxRenderer());
        jComboBox4.setFocusable(false);
        jComboBox4.getComponent(0).setBackground(new Color(140, 255, 241));

        obI = new LlenadoInformacion();
        obI.llenarComboTiendas(jComboBox2);
        obI.llenarComboVideojuegos(jComboBox1);
        obI.llenarComboTiendas(jComboBox3);
    }

    public void cargarDatosGenerales() {
        obCons.consultarDatoGeneral("videojuegos", lblVidCont, null);
        obCons.consultarDatoGeneral("tiendas", lblTienCont, null);
        obCons.consultarDatoGeneral("proveedores", lblProvCont, null);
        obCons.consultarDatoGeneral("clientes", lblCliCont, null);
        obCons.consultarDatoGeneral("empleados", lblEmpCont, null);
        obCons.consultarDatoGeneral("inventario", lblInvCont, null);
        obCons.consultarDatoGeneral("compra", lblCompraCont, null);
        obCons.consultarDatoGeneral("ventas", lblCantVendida, null);
        obCons.consultarDatoGeneral("mas vendido", lblJuegoMasVen, lblJuegoMasVenCant);
        obCons.consultarDatoGeneral("menos vendido", lblJuegoMenosVen, lblJuegoMenosVenCant);
        obCons.consultarDatoGeneral("mas vendido1", lblJuegoMasVend, null);
        obCons.consultarDatoGeneral("menos vendido1", lblJuegoMenosVend, null);
        obCons.consultarDatoGeneral("mas ventas", lblTiendaMasVentas, null);
        obCons.consultarDatoGeneral("menos ventas", lblTiendaMenosVentas, null);
        obCons.consultarDatoGeneral("mas atento", lblEmpMasAtenciones, null);
        obCons.consultarDatoGeneral("mejor sueldo", lblEmpMejorSueldo, null);
        obCons.consultarDatoGeneral("mejor cliente", lblMejorCliente, null);
        obCons.consultarDatoGeneral("mas activo", lblProvMasActivo, null);
        obCons.setLablesInvStock(stock1, stock2, stock3);
        obCons.consultarDatoGeneral("stock", null, null);
    }

    public void actionListenerButtons() {
        btnGuardarVid.addActionListener((e) -> {
            try {
                String nombre = jTextField2.getText(), categoria = jTextField3.getText();
                double precio = Double.parseDouble(jTextField4.getText());

                sqlVideojuegos.updateVideojuego(idVideojuego, new Videojuego(nombre, categoria, precio));
                sqlVideojuegos.selectVideojuego();
                obI.llenarTablaVideojuegos(tbVideojuegos, sqlVideojuegos.getData());
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualización exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarTiendas.addActionListener((e) -> {
            try {
                String nombre = jTextField13.getText(), domicilio = jTextField14.getText();

                sqlTiendas.updateTienda(idTienda, new Tienda(nombre, domicilio));
                sqlTiendas.selectTienda();
                obI.llenarTablaTiendas(tbTiendas, sqlTiendas.getData());
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualización exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarProv.addActionListener((e) -> {
            try {
                String nombre = jTextField30.getText(),
                        domicilio = jTextField31.getText(),
                        correo = jTextField33.getText();
                int telefono = Integer.parseInt(jTextField32.getText());

                sqlProveedores.updateProveedor(idProveedor, new Proveedor(nombre, telefono, domicilio, correo));
                sqlProveedores.selectProveedor();
                obI.llenarTablaProveedores(tbProveedores, sqlProveedores.getData());
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarInv.addActionListener((e) -> {
            try {
                int idVideojuego = 0, idTienda = 0, stock = Integer.parseInt(jTextField17.getText());
                CRUDVideojuegos obV = new CRUDVideojuegos();
                CRUDTiendas obT = new CRUDTiendas();
                obV.selectVideojuego();
                obT.selectTienda();

                for (Videojuego v : obV.getData()) {
                    if (String.valueOf(jComboBox1.getSelectedItem()).equals(v.getNombre())) {
                        idVideojuego = v.getId();
                    }
                }

                for (Tienda t : obT.getData()) {
                    if (String.valueOf(jComboBox2.getSelectedItem()).equals(t.getNombre())) {
                        idTienda = t.getId();
                    }
                }

                sqlInventario.updateInventario(idVideojuego, idTienda, stock);
                sqlInventario.selectInventarioTable();
                obI.llenarTablaInventario(tbInventario, sqlInventario.getDataTable());
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarEmp.addActionListener((e) -> {
            try {
                String nombre = jTextField7.getText();
                String ApellidoP = jTextField16.getText();
                String ApellidoM = jTextField22.getText();
                String NSS = jTextField15.getText();
                String CURP = jTextField21.getText();
                Date fechaNacimiento = null;//jTextField38.getText();
                int telefono = Integer.parseInt(jTextField24.getText());
                String domicilio = jTextField6.getText();
                int sueldo = Integer.parseInt(jTextField39.getText());
                int id_tienda = 0;
                Time hrEntrada = new Time(Integer.parseInt(jTextField40.getText()), Integer.parseInt(jTextField41.getText()), 0),
                        hrSalida = new Time(Integer.parseInt(jTextField43.getText()), Integer.parseInt(jTextField44.getText()), 0);
                String turno = String.valueOf(jComboBox4.getSelectedItem());

                CRUDTiendas obT = new CRUDTiendas();
                obT.selectTienda();
                for (Tienda t : obT.getData()) {
                    if (String.valueOf(jComboBox3.getSelectedItem()).equals(t.getNombre())) {
                        id_tienda = t.getId();
                    }
                }

                sqlEmpleados.updateEmpleado(idEmpleado, new Empleado(nombre, ApellidoP, ApellidoM, NSS, CURP, fechaNacimiento, telefono, domicilio, sueldo), new Trabajo(id_tienda, hrEntrada, hrSalida, turno));
                sqlEmpleados.selectEmpleado();
                obI.llenarTablaEmpleados(tbEmpleados, sqlEmpleados.getDataEmpleado());
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualización exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException xe) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarClientes.addActionListener((e) -> {
            try {
                String nombre = jTextField9.getText(),
                        app = jTextField11.getText(),
                        apm = jTextField25.getText(),
                        domicilio = jTextField11.getText(),
                        correo = jTextField29.getText();
                int telefono = Integer.parseInt(jTextField27.getText());
                Date fechaNac = null;//jTextField28.getText();
                sqlClientes.updateCliente(idCliente, new Cliente(nombre, app, apm, fechaNac, telefono, domicilio, correo));
                sqlClientes.selectCliente();
                obI.llenarTablaClientes(tbClientes, sqlClientes.getData());
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualización exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        });
    }

    public void setTbVideojuegos(JTable tbVideojuegos) {
        this.tbVideojuegos = tbVideojuegos;
    }

    public void setTbClientes(JTable tbClientes) {
        this.tbClientes = tbClientes;
    }

    public void setTbEmpleados(JTable tbEmpleados) {
        this.tbEmpleados = tbEmpleados;
    }

    public void setTbProveedores(JTable tbProveedores) {
        this.tbProveedores = tbProveedores;
    }

    public void setTbTiendas(JTable tbTiendas) {
        this.tbTiendas = tbTiendas;
    }

    public void setTbInventario(JTable tbInventario) {
        this.tbInventario = tbInventario;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str, String title, String rutaImg) {
        this.str = str;
        obC.show(pnlMain, str);
        lblTitulo.setText("Actualizar " + title);
        lblTitulo.setIcon(new ImageIcon(rutaImg));
        lblTitulo.setIconTextGap(10);
        verificar();
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego, int id) {
        this.videojuego = videojuego;
        this.idVideojuego = id;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda, int id) {
        this.tienda = tienda;
        this.idTienda = id;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor, int id) {
        this.proveedor = proveedor;
        this.idProveedor = id;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado, int id) {
        this.empleado = empleado;
        this.idEmpleado = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente, int id) {
        this.cliente = cliente;
        this.idCliente = id;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlHeaderVid = new CustomComponents.PanelRound();
        lblTitulo = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();
        pnlAltaVideojuegos = new CustomComponents.PanelRound();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        pnlBtnVideojuegos = new javax.swing.JPanel();
        pnlAltaTiendas = new CustomComponents.PanelRound();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        pnlBtnTiendas = new javax.swing.JPanel();
        pnlAltaEmpleados = new CustomComponents.PanelRound();
        jPanel13 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jPanel21 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel32 = new javax.swing.JPanel();
        jTextField40 = new javax.swing.JTextField();
        jTextField41 = new javax.swing.JTextField();
        jPanel33 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel38 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel22 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel48 = new javax.swing.JPanel();
        jTextField43 = new javax.swing.JTextField();
        jTextField44 = new javax.swing.JTextField();
        jPanel35 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jPanel34 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField24 = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jPanel17 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jPanel37 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jPanel36 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        pnlBtnEmp = new javax.swing.JPanel();
        pnlAltaClientes = new CustomComponents.PanelRound();
        jPanel18 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jPanel41 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jPanel42 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jPanel44 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jTextField27 = new javax.swing.JTextField();
        jPanel43 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jTextField25 = new javax.swing.JTextField();
        jPanel46 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jPanel45 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jPanel40 = new javax.swing.JPanel();
        pnlBtnClientes = new javax.swing.JPanel();
        pnlAltaProveedores = new CustomComponents.PanelRound();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jTextField30 = new javax.swing.JTextField();
        jPanel26 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jPanel27 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jTextField32 = new javax.swing.JTextField();
        jPanel47 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jTextField33 = new javax.swing.JTextField();
        jPanel24 = new javax.swing.JPanel();
        pnlBtnProv = new javax.swing.JPanel();
        pnlAltaInventario = new CustomComponents.PanelRound();
        jPanel28 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jPanel30 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel29 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel31 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        pnlBtnInventario = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlHeaderVid.setBackground(new java.awt.Color(25, 25, 25));
        pnlHeaderVid.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlHeaderVid.setRoundTopLeft(25);
        pnlHeaderVid.setRoundTopRight(25);
        pnlHeaderVid.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 26)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(25, 200, 178));
        lblTitulo.setText("Actualizar");
        pnlHeaderVid.add(lblTitulo, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlHeaderVid, java.awt.BorderLayout.PAGE_START);

        pnlMain.setOpaque(false);
        pnlMain.setLayout(new java.awt.CardLayout());

        pnlAltaVideojuegos.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaVideojuegos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaVideojuegos.setRoundBottomLeft(25);
        pnlAltaVideojuegos.setRoundBottomRight(25);
        pnlAltaVideojuegos.setLayout(new java.awt.BorderLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 20, 5));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 100, 100));
        jLabel3.setText("Nombre");
        jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel5.add(jLabel3);

        jTextField2.setBackground(new java.awt.Color(30, 30, 30));
        jTextField2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(200, 200, 200));
        jTextField2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField2.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField2.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel5.add(jTextField2);

        jPanel3.add(jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(100, 100, 100));
        jLabel4.setText("Categoria");
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel6.add(jLabel4);

        jTextField3.setBackground(new java.awt.Color(30, 30, 30));
        jTextField3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(200, 200, 200));
        jTextField3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField3.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField3.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField3.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel6.add(jTextField3);

        jPanel3.add(jPanel6);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(100, 100, 100));
        jLabel5.setText("Precio");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel7.add(jLabel5);

        jTextField4.setBackground(new java.awt.Color(30, 30, 30));
        jTextField4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(200, 200, 200));
        jTextField4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField4.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField4.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField4.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel7.add(jTextField4);

        jPanel3.add(jPanel7);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        jPanel3.add(jPanel4);

        pnlAltaVideojuegos.add(jPanel3, java.awt.BorderLayout.CENTER);

        pnlBtnVideojuegos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnVideojuegos.setOpaque(false);
        pnlBtnVideojuegos.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaVideojuegos.add(pnlBtnVideojuegos, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaVideojuegos, "altaVideojuegos");

        pnlAltaTiendas.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaTiendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaTiendas.setRoundBottomLeft(25);
        pnlAltaTiendas.setRoundBottomRight(25);
        pnlAltaTiendas.setLayout(new java.awt.BorderLayout());

        jPanel8.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(100, 100, 100));
        jLabel7.setText("Nombre");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel10.add(jLabel7);

        jTextField13.setBackground(new java.awt.Color(30, 30, 30));
        jTextField13.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(200, 200, 200));
        jTextField13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField13.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField13.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField13.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel10.add(jTextField13);

        jPanel8.add(jPanel10);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(100, 100, 100));
        jLabel8.setText("Domicilio");
        jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel11.add(jLabel8);

        jTextField14.setBackground(new java.awt.Color(30, 30, 30));
        jTextField14.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(200, 200, 200));
        jTextField14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField14.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField14.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField14.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel11.add(jTextField14);

        jPanel8.add(jPanel11);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        jPanel8.add(jPanel12);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        jPanel8.add(jPanel9);

        pnlAltaTiendas.add(jPanel8, java.awt.BorderLayout.CENTER);

        pnlBtnTiendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnTiendas.setOpaque(false);
        pnlBtnTiendas.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaTiendas.add(pnlBtnTiendas, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaTiendas, "altaTiendas");

        pnlAltaEmpleados.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaEmpleados.setRoundBottomLeft(25);
        pnlAltaEmpleados.setRoundBottomRight(25);
        pnlAltaEmpleados.setLayout(new java.awt.BorderLayout());

        jPanel13.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 20, 5));
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.GridLayout(5, 3, 10, 5));

        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(100, 100, 100));
        jLabel12.setText("Nombre");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel16.add(jLabel12);

        jTextField7.setBackground(new java.awt.Color(30, 30, 30));
        jTextField7.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(200, 200, 200));
        jTextField7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField7.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField7.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField7.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel16.add(jTextField7);

        jPanel13.add(jPanel16);

        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(100, 100, 100));
        jLabel11.setText("NSS");
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel15.add(jLabel11);

        jTextField15.setBackground(new java.awt.Color(30, 30, 30));
        jTextField15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(200, 200, 200));
        jTextField15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField15.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField15.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField15.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField15.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel15.add(jTextField15);

        jPanel13.add(jPanel15);

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(100, 100, 100));
        jLabel16.setText("Hr. Entrada");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel21.add(jLabel16);

        jPanel32.setOpaque(false);
        jPanel32.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jTextField40.setBackground(new java.awt.Color(30, 30, 30));
        jTextField40.setColumns(2);
        jTextField40.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField40.setForeground(new java.awt.Color(200, 200, 200));
        jTextField40.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField40.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField40.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField40.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField40.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel32.add(jTextField40);

        jTextField41.setBackground(new java.awt.Color(30, 30, 30));
        jTextField41.setColumns(2);
        jTextField41.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField41.setForeground(new java.awt.Color(200, 200, 200));
        jTextField41.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField41.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField41.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField41.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField41.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel32.add(jTextField41);

        jPanel21.add(jPanel32);

        jPanel13.add(jPanel21);

        jPanel33.setOpaque(false);
        jPanel33.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel26.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(100, 100, 100));
        jLabel26.setText("Apellido Paterno");
        jLabel26.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel33.add(jLabel26);

        jTextField16.setBackground(new java.awt.Color(30, 30, 30));
        jTextField16.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(200, 200, 200));
        jTextField16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField16.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField16.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField16.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel33.add(jTextField16);

        jPanel13.add(jPanel33);

        jPanel38.setOpaque(false);
        jPanel38.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(100, 100, 100));
        jLabel31.setText("Domicilio");
        jLabel31.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel38.add(jLabel31);

        jTextField6.setBackground(new java.awt.Color(30, 30, 30));
        jTextField6.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(200, 200, 200));
        jTextField6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField6.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField6.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField6.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel38.add(jTextField6);

        jPanel13.add(jPanel38);

        jPanel22.setOpaque(false);
        jPanel22.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(100, 100, 100));
        jLabel17.setText("Hr. Salida");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel22.add(jLabel17);

        jPanel48.setOpaque(false);
        jPanel48.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jTextField43.setBackground(new java.awt.Color(30, 30, 30));
        jTextField43.setColumns(2);
        jTextField43.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField43.setForeground(new java.awt.Color(200, 200, 200));
        jTextField43.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField43.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField43.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField43.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField43.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel48.add(jTextField43);

        jTextField44.setBackground(new java.awt.Color(30, 30, 30));
        jTextField44.setColumns(2);
        jTextField44.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField44.setForeground(new java.awt.Color(200, 200, 200));
        jTextField44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField44.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField44.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField44.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField44.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel48.add(jTextField44);

        jPanel22.add(jPanel48);

        jPanel13.add(jPanel22);

        jPanel35.setOpaque(false);
        jPanel35.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(100, 100, 100));
        jLabel28.setText("Apellido Materno");
        jLabel28.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel35.add(jLabel28);

        jTextField22.setBackground(new java.awt.Color(30, 30, 30));
        jTextField22.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(200, 200, 200));
        jTextField22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField22.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField22.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField22.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel35.add(jTextField22);

        jPanel13.add(jPanel35);

        jPanel34.setOpaque(false);
        jPanel34.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(100, 100, 100));
        jLabel27.setText("Telefono");
        jLabel27.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel34.add(jLabel27);

        jTextField24.setBackground(new java.awt.Color(30, 30, 30));
        jTextField24.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField24.setForeground(new java.awt.Color(200, 200, 200));
        jTextField24.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField24.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField24.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField24.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField24.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel34.add(jTextField24);

        jPanel13.add(jPanel34);

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(100, 100, 100));
        jLabel14.setText("Tienda");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel14.add(jLabel14);

        jComboBox3.setBackground(new java.awt.Color(30, 30, 30));
        jComboBox3.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(200, 200, 200));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jPanel14.add(jComboBox3);

        jPanel13.add(jPanel14);

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(100, 100, 100));
        jLabel13.setText("CURP");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel17.add(jLabel13);

        jTextField21.setBackground(new java.awt.Color(30, 30, 30));
        jTextField21.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(200, 200, 200));
        jTextField21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField21.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField21.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField21.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel17.add(jTextField21);

        jPanel13.add(jPanel17);

        jPanel37.setOpaque(false);
        jPanel37.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(100, 100, 100));
        jLabel30.setText("Sueldo");
        jLabel30.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel37.add(jLabel30);

        jTextField39.setBackground(new java.awt.Color(30, 30, 30));
        jTextField39.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField39.setForeground(new java.awt.Color(200, 200, 200));
        jTextField39.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField39.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField39.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField39.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField39.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel37.add(jTextField39);

        jPanel13.add(jPanel37);

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(100, 100, 100));
        jLabel15.setText("Turno");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel20.add(jLabel15);

        jComboBox4.setBackground(new java.awt.Color(30, 30, 30));
        jComboBox4.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jComboBox4.setForeground(new java.awt.Color(200, 200, 200));
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino" }));
        jComboBox4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jPanel20.add(jComboBox4);

        jPanel13.add(jPanel20);

        jPanel36.setOpaque(false);
        jPanel36.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(100, 100, 100));
        jLabel29.setText("Fecha de nacimiento");
        jLabel29.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel36.add(jLabel29);

        jTextField38.setBackground(new java.awt.Color(30, 30, 30));
        jTextField38.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField38.setForeground(new java.awt.Color(200, 200, 200));
        jTextField38.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField38.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField38.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField38.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField38.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel36.add(jTextField38);

        jPanel13.add(jPanel36);

        pnlAltaEmpleados.add(jPanel13, java.awt.BorderLayout.CENTER);

        pnlBtnEmp.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnEmp.setOpaque(false);
        pnlBtnEmp.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaEmpleados.add(pnlBtnEmp, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaEmpleados, "altaEmpleados");

        pnlAltaClientes.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaClientes.setRoundBottomLeft(25);
        pnlAltaClientes.setRoundBottomRight(25);
        pnlAltaClientes.setLayout(new java.awt.BorderLayout());

        jPanel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 20, 5));
        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.GridLayout(4, 2, 10, 5));

        jPanel39.setOpaque(false);
        jPanel39.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(100, 100, 100));
        jLabel32.setText("Nombre");
        jLabel32.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel39.add(jLabel32);

        jTextField9.setBackground(new java.awt.Color(30, 30, 30));
        jTextField9.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(200, 200, 200));
        jTextField9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField9.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField9.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField9.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel39.add(jTextField9);

        jPanel18.add(jPanel39);

        jPanel41.setOpaque(false);
        jPanel41.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(100, 100, 100));
        jLabel34.setText("Domicilio");
        jLabel34.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel41.add(jLabel34);

        jTextField11.setBackground(new java.awt.Color(30, 30, 30));
        jTextField11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(200, 200, 200));
        jTextField11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField11.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField11.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField11.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel41.add(jTextField11);

        jPanel18.add(jPanel41);

        jPanel42.setOpaque(false);
        jPanel42.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(100, 100, 100));
        jLabel35.setText("Apellido Paterno");
        jLabel35.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel42.add(jLabel35);

        jTextField12.setBackground(new java.awt.Color(30, 30, 30));
        jTextField12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(200, 200, 200));
        jTextField12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField12.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField12.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField12.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel42.add(jTextField12);

        jPanel18.add(jPanel42);

        jPanel44.setOpaque(false);
        jPanel44.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(100, 100, 100));
        jLabel37.setText("Telefono");
        jLabel37.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel44.add(jLabel37);

        jTextField27.setBackground(new java.awt.Color(30, 30, 30));
        jTextField27.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField27.setForeground(new java.awt.Color(200, 200, 200));
        jTextField27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField27.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField27.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField27.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField27.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel44.add(jTextField27);

        jPanel18.add(jPanel44);

        jPanel43.setOpaque(false);
        jPanel43.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(100, 100, 100));
        jLabel36.setText("Apellido Materno");
        jLabel36.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel43.add(jLabel36);

        jTextField25.setBackground(new java.awt.Color(30, 30, 30));
        jTextField25.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField25.setForeground(new java.awt.Color(200, 200, 200));
        jTextField25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField25.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField25.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField25.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField25.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel43.add(jTextField25);

        jPanel18.add(jPanel43);

        jPanel46.setOpaque(false);
        jPanel46.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(100, 100, 100));
        jLabel39.setText("Correo electronico");
        jLabel39.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel46.add(jLabel39);

        jTextField29.setBackground(new java.awt.Color(30, 30, 30));
        jTextField29.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField29.setForeground(new java.awt.Color(200, 200, 200));
        jTextField29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField29.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField29.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField29.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField29.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel46.add(jTextField29);

        jPanel18.add(jPanel46);

        jPanel45.setOpaque(false);
        jPanel45.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(100, 100, 100));
        jLabel38.setText("Fecha de nacimiento");
        jLabel38.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel45.add(jLabel38);

        jTextField28.setBackground(new java.awt.Color(30, 30, 30));
        jTextField28.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(200, 200, 200));
        jTextField28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField28.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField28.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField28.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField28.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel45.add(jTextField28);

        jPanel18.add(jPanel45);

        jPanel40.setOpaque(false);
        jPanel40.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        jPanel18.add(jPanel40);

        pnlAltaClientes.add(jPanel18, java.awt.BorderLayout.CENTER);

        pnlBtnClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnClientes.setOpaque(false);
        pnlBtnClientes.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaClientes.add(pnlBtnClientes, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaClientes, "altaClientes");

        pnlAltaProveedores.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaProveedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaProveedores.setRoundBottomLeft(25);
        pnlAltaProveedores.setRoundBottomRight(25);
        pnlAltaProveedores.setLayout(new java.awt.BorderLayout());

        jPanel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 20, 5));
        jPanel23.setOpaque(false);
        jPanel23.setLayout(new java.awt.GridLayout(5, 1, 0, 5));

        jPanel25.setOpaque(false);
        jPanel25.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(100, 100, 100));
        jLabel19.setText("Nombre");
        jLabel19.setToolTipText("");
        jLabel19.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel25.add(jLabel19);

        jTextField30.setBackground(new java.awt.Color(30, 30, 30));
        jTextField30.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField30.setForeground(new java.awt.Color(200, 200, 200));
        jTextField30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField30.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField30.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField30.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField30.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel25.add(jTextField30);

        jPanel23.add(jPanel25);

        jPanel26.setOpaque(false);
        jPanel26.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(100, 100, 100));
        jLabel20.setText("Domicilio");
        jLabel20.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel26.add(jLabel20);

        jTextField31.setBackground(new java.awt.Color(30, 30, 30));
        jTextField31.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField31.setForeground(new java.awt.Color(200, 200, 200));
        jTextField31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField31.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField31.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField31.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField31.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel26.add(jTextField31);

        jPanel23.add(jPanel26);

        jPanel27.setOpaque(false);
        jPanel27.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(100, 100, 100));
        jLabel21.setText("Telefono");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel27.add(jLabel21);

        jTextField32.setBackground(new java.awt.Color(30, 30, 30));
        jTextField32.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField32.setForeground(new java.awt.Color(200, 200, 200));
        jTextField32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField32.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField32.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField32.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField32.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel27.add(jTextField32);

        jPanel23.add(jPanel27);

        jPanel47.setOpaque(false);
        jPanel47.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(100, 100, 100));
        jLabel40.setText("Correo electronico");
        jLabel40.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel47.add(jLabel40);

        jTextField33.setBackground(new java.awt.Color(30, 30, 30));
        jTextField33.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField33.setForeground(new java.awt.Color(200, 200, 200));
        jTextField33.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField33.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField33.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField33.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField33.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel47.add(jTextField33);

        jPanel23.add(jPanel47);

        jPanel24.setOpaque(false);
        jPanel24.setLayout(new java.awt.GridLayout(2, 1, 0, 5));
        jPanel23.add(jPanel24);

        pnlAltaProveedores.add(jPanel23, java.awt.BorderLayout.CENTER);

        pnlBtnProv.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnProv.setOpaque(false);
        pnlBtnProv.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaProveedores.add(pnlBtnProv, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaProveedores, "altaProveedores");

        pnlAltaInventario.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaInventario.setRoundBottomLeft(25);
        pnlAltaInventario.setRoundBottomRight(25);
        pnlAltaInventario.setLayout(new java.awt.BorderLayout());

        jPanel28.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        jPanel28.setOpaque(false);
        jPanel28.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jPanel30.setOpaque(false);
        jPanel30.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(100, 100, 100));
        jLabel23.setText("Videojuego");
        jLabel23.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel30.add(jLabel23);

        jComboBox1.setBackground(new java.awt.Color(30, 30, 30));
        jComboBox1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(200, 200, 200));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jPanel30.add(jComboBox1);

        jPanel19.add(jPanel30);

        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(100, 100, 100));
        jLabel22.setText("Tienda");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel29.add(jLabel22);

        jComboBox2.setBackground(new java.awt.Color(30, 30, 30));
        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(200, 200, 200));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jPanel29.add(jComboBox2);

        jPanel19.add(jPanel29);

        jPanel28.add(jPanel19);

        jPanel31.setOpaque(false);
        jPanel31.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel24.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(100, 100, 100));
        jLabel24.setText("Cantidad (Stock)");
        jLabel24.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel31.add(jLabel24);

        jTextField17.setBackground(new java.awt.Color(30, 30, 30));
        jTextField17.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(200, 200, 200));
        jTextField17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField17.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField17.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField17.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel31.add(jTextField17);

        jPanel28.add(jPanel31);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 117, Short.MAX_VALUE)
        );

        jPanel28.add(jPanel2);

        pnlAltaInventario.add(jPanel28, java.awt.BorderLayout.CENTER);

        pnlBtnInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnInventario.setOpaque(false);
        pnlBtnInventario.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaInventario.add(pnlBtnInventario, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaInventario, "altaInventario");

        jPanel1.add(pnlMain, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaActualizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaActualizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaActualizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaActualizaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaActualizaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField40;
    private javax.swing.JTextField jTextField41;
    private javax.swing.JTextField jTextField43;
    private javax.swing.JTextField jTextField44;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JLabel lblTitulo;
    private CustomComponents.PanelRound pnlAltaClientes;
    private CustomComponents.PanelRound pnlAltaEmpleados;
    private CustomComponents.PanelRound pnlAltaInventario;
    private CustomComponents.PanelRound pnlAltaProveedores;
    private CustomComponents.PanelRound pnlAltaTiendas;
    private CustomComponents.PanelRound pnlAltaVideojuegos;
    private javax.swing.JPanel pnlBtnClientes;
    private javax.swing.JPanel pnlBtnEmp;
    private javax.swing.JPanel pnlBtnInventario;
    private javax.swing.JPanel pnlBtnProv;
    private javax.swing.JPanel pnlBtnTiendas;
    private javax.swing.JPanel pnlBtnVideojuegos;
    private CustomComponents.PanelRound pnlHeaderVid;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
