package GUI;

import CustomComponents.CustomComboBoxRenderer;
import CustomComponents.RoundButton;
import CustomComponents.EstilosComponentes;
import CustomComponents.PanelVideojuego;
import CustomComponents.TextPrompt;
import Funciones.Dashboard.ConsultasGenerales;
import Funciones.Entidades.*;
import Funciones.Relaciones.CRUDCompras;
import Funciones.Relaciones.CRUDInventario;
import Funciones.Relaciones.CRUDProveen;
import Funciones.TablasListas.LlenadoInformacion;
import TDA.Entidades.AuxiliarButtons.ButtonsVenta;
import TDA.Entidades.Cliente;
import TDA.Entidades.Empleado;
import TDA.Entidades.Proveedor;
import TDA.Entidades.Tienda;
import TDA.Entidades.Videojuego;
import TDA.Relaciones.Compra;
import TDA.Relaciones.Inventario;
import TDA.Relaciones.Provee;
import TDA.Relaciones.Trabajo;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class VentanaActualizaciones extends javax.swing.JFrame {

    private LlenadoInformacion obI;
    private EstilosComponentes obE;
    private RoundButton btnGuardarProveen, btnSalir, btnGuardarVid, btnGuardarTiendas, btnGuardarEmp, btnGuardarClientes, btnGuardarProv, btnGuardarInv, btnGuardarVenta;
    private CardLayout obC;
    private String str;
    private CRUDVideojuegos sqlVideojuegos;
    private CRUDClientes sqlClientes;
    private CRUDEmpleados sqlEmpleados;
    private CRUDProveedores sqlProveedores;
    private CRUDTiendas sqlTiendas;
    private CRUDInventario sqlInventario;
    private CRUDProveen sqlProveen;
    private CRUDCompras sqlVentas;
    private JTable tbVideojuegos, tbClientes, tbEmpleados, tbProveedores, tbTiendas, tbInventario, tbProveen, tbVentas;
    private JLabel lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, stock1, stock2, stock3;
    private ConsultasGenerales obCons;
    private Videojuego videojuego;
    private Tienda tienda;
    private Proveedor proveedor;
    private Empleado empleado;
    private Cliente cliente;
    private Inventario inventario;
    private Provee proveer;
    private Compra venta;
    private int idVideojuego, idTienda, idProveedor, idEmpleado, idCliente, idVidP, idProP, idTienP;
    private String user;
    private int idTiendaTrabajo;
    private ArrayList<ButtonsVenta> buttonsVideojuegos;
    private JPanel pnlVideojuegos;

    public VentanaActualizaciones() {
        initComponents();
        initComponentsCustom();
        setLocationRelativeTo(this);
        buttonsVideojuegos = new ArrayList<>();
        obCons = new ConsultasGenerales();
        obC = (CardLayout) pnlMain.getLayout();
        sqlVentas = new CRUDCompras();
        sqlVideojuegos = new CRUDVideojuegos();
        sqlClientes = new CRUDClientes();
        sqlEmpleados = new CRUDEmpleados();
        sqlProveedores = new CRUDProveedores();
        sqlTiendas = new CRUDTiendas();
        sqlInventario = new CRUDInventario();
        sqlProveen = new CRUDProveen();
    }

    public void setUser(String user) {
        this.user = user;
        actionListenerButtons();
    }

    public void verificar() {
        switch (str) {
            case "altaVideojuegos":
                sqlVideojuegos.selectVideojuego();
                for (Videojuego v : sqlVideojuegos.getData()) {
                    jTextField2.setText(v.getNombre());
                    jTextField3.setText(v.getCategoria());
                    jTextField4.setText(String.valueOf(v.getPrecio()));
                    break;
                }
                break;
            case "altaTiendas":
                sqlTiendas.selectTienda();
                for (Tienda t : sqlTiendas.getData()) {
                    jTextField13.setText(t.getNombre());
                    jTextField14.setText(t.getDomicilio());
                    break;
                }
                break;
            case "altaEmpleados":
                sqlEmpleados.selectEmpleado();
                for (Empleado emp : sqlEmpleados.getDataEmpleado()) {
                    if (idEmpleado == emp.getId()) {
                        jTextField22.setText(emp.getApellidoM());
                        jTextField21.setText(emp.getCURP());
                        jTextField24.setText(String.valueOf(emp.getTelefono()));
                        jTextField43.setText(String.valueOf(emp.getHrSalida().getHours()));
                        dateSelector.setDate(emp.getFechaNacimiento());
                        jTextField40.setText(String.valueOf(emp.getHrEntrada().getHours()));
                        jTextField16.setText(emp.getApellidoP());
                        jTextField15.setText(emp.getNSS());
                        jTextField41.setText(String.valueOf(emp.getHrEntrada().getMinutes()));
                        jTextField7.setText(emp.getNombre());
                        jTextField44.setText(String.valueOf(emp.getHrSalida().getMinutes()));
                        jTextField6.setText(emp.getDomicilio());
                        jTextField39.setText(String.valueOf(emp.getSueldo()));
                        jComboBox3.setSelectedItem(emp.getNombreTienda());
                        jComboBox4.setSelectedItem(emp.getTurno());
                    }
                }
                break;
            case "altaClientes":
                sqlClientes.selectCliente();
                for (Cliente c : sqlClientes.getData()) {
                    if (idCliente == c.getId()) {
                        jTextField11.setText(c.getDomicilio());
                        dateSelector1.setDate(c.getFechaNacimiento());
                        jTextField12.setText(c.getApellidoP());
                        jTextField27.setText(c.getTelefono());
                        jTextField25.setText(c.getApellidoM());
                        jTextField9.setText(c.getNombre());
                        jTextField29.setText(c.getCorreo());
                        break;
                    }
                }
                break;
            case "altaProveedores":
                sqlProveedores.selectProveedor();
                for (Proveedor p : sqlProveedores.getData()) {
                    if (p.getId() == idProveedor) {
                        jTextField30.setText(p.getNombre());
                        jTextField31.setText(p.getDomicilio());
                        jTextField32.setText(String.valueOf(p.getTelefono()));
                        jTextField33.setText(p.getCorreo());
                        break;
                    }
                }
                break;
            case "altaInventario":
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
            case "altaProveen":
                sqlProveen.selectProveen();
                for (Provee p : sqlProveen.getData()) {
                    if (p.getId_proveedor() == idProP && p.getId_tienda() == idTienP && p.getId_videojuego() == idVidP) {
                        jTextField28.setText(String.valueOf(p.getProveedor()));
                        jTextField23.setText(String.valueOf(p.getTienda()));
                        jTextField26.setText(String.valueOf(p.getVideojuego()));
                        jTextField19.setText(String.valueOf(p.getFechaSurtido()));
                        jTextField20.setText(String.valueOf(p.getCantidad()));
                        break;
                    }
                }
                break;
            case "altaVenta":
                jTextField34.setText(String.valueOf(venta.getVideojuego()));
                jTextField35.setText(String.valueOf(venta.getCliente()));
                jTextField37.setText(String.valueOf(venta.getTienda()));
                jTextField36.setText(String.valueOf(venta.getFechaCompra()));
                jTextField38.setText(String.valueOf(venta.getCantidad()));
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
        btnGuardarProveen = obE.getStyleBtnSave(btnGuardarProveen);
        btnGuardarVenta = obE.getStyleBtnSave(btnGuardarVenta);
        pnlBtnVideojuegos.add(btnGuardarVid);
        pnlBtnTiendas.add(btnGuardarTiendas);
        pnlBtnEmp.add(btnGuardarEmp);
        pnlBtnClientes.add(btnGuardarClientes);
        pnlBtnProv.add(btnGuardarProv);
        pnlBtnInventario.add(btnGuardarInv);
        pnlBtnInventario1.add(btnGuardarProveen);
        pnlBtnInventario2.add(btnGuardarVenta);

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

        dateSelector.getDateEditor().getUiComponent().setBackground(new Color(30, 30, 30));
        dateSelector.getDateEditor().getUiComponent().setBorder(new LineBorder(new Color(40, 40, 40), 2, true));
        dateSelector.getDateEditor().getUiComponent().setForeground(new Color(200, 200, 200));
        dateSelector.getCalendarButton().setBackground(new Color(30, 30, 30));
        dateSelector.setForeground(new Color(200, 200, 200));

        dateSelector1.getDateEditor().getUiComponent().setBackground(new Color(30, 30, 30));
        dateSelector1.getDateEditor().getUiComponent().setBorder(new LineBorder(new Color(40, 40, 40), 2, true));
        dateSelector1.getDateEditor().getUiComponent().setForeground(new Color(200, 200, 200));
        dateSelector1.getCalendarButton().setBackground(new Color(30, 30, 30));
        dateSelector1.setForeground(new Color(200, 200, 200));

        // VIDEOJUEGOS
        TextPrompt placeholder = new TextPrompt("Ingrese el nombre del videojuego...", jTextField2);
        placeholder.changeAlpha(0.50f);
        placeholder.changeStyle(Font.ITALIC);

        TextPrompt placeholder2 = new TextPrompt("Ej. Acción, Aventura, etc...", jTextField3);
        placeholder2.changeAlpha(0.50f);
        placeholder2.changeStyle(Font.ITALIC);

        TextPrompt placeholder3 = new TextPrompt("Ingrese el valor númerico del precio", jTextField4);
        placeholder3.changeAlpha(0.50f);
        placeholder3.changeStyle(Font.ITALIC);

        // TIENDAS
        TextPrompt placeholder4 = new TextPrompt("Ingrese el nombre de la tienda...", jTextField13);
        placeholder4.changeAlpha(0.50f);
        placeholder4.changeStyle(Font.ITALIC);

        TextPrompt placeholder5 = new TextPrompt("Ej. Calle Gardenias #123...", jTextField14);
        placeholder5.changeAlpha(0.50f);
        placeholder5.changeStyle(Font.ITALIC);

        // EMPLEADOS
        TextPrompt placeholder6 = new TextPrompt("Ingrese el nombre del empleado...", jTextField7);
        placeholder6.changeAlpha(0.50f);
        placeholder6.changeStyle(Font.ITALIC);

        TextPrompt placeholder7 = new TextPrompt("Ingrese el ap. paterno del empleado...", jTextField16);
        placeholder7.changeAlpha(0.50f);
        placeholder7.changeStyle(Font.ITALIC);

        TextPrompt placeholder8 = new TextPrompt("Ingrese el ap. materno del empleado...", jTextField22);
        placeholder8.changeAlpha(0.50f);
        placeholder8.changeStyle(Font.ITALIC);

        TextPrompt placeholder9 = new TextPrompt("Max. 18 caracteres", jTextField21);
        placeholder9.changeAlpha(0.50f);
        placeholder9.changeStyle(Font.ITALIC);

        TextPrompt placeholder10 = new TextPrompt("Max. 11 caracteres númericos", jTextField15);
        placeholder10.changeAlpha(0.50f);
        placeholder10.changeStyle(Font.ITALIC);

        TextPrompt placeholder11 = new TextPrompt("Ej. Calle Gardenias #123...", jTextField6);
        placeholder11.changeAlpha(0.50f);
        placeholder11.changeStyle(Font.ITALIC);

        TextPrompt placeholder12 = new TextPrompt("Max. 10 caracteres númericos", jTextField24);
        placeholder12.changeAlpha(0.50f);
        placeholder12.changeStyle(Font.ITALIC);

        TextPrompt placeholder13 = new TextPrompt("Ingrese el sueldo del empleado...", jTextField39);
        placeholder13.changeAlpha(0.50f);
        placeholder13.changeStyle(Font.ITALIC);

        TextPrompt placeholder14 = new TextPrompt("Hr. (0 a 23)", jTextField40);
        placeholder14.changeAlpha(0.50f);
        placeholder14.changeStyle(Font.ITALIC);

        TextPrompt placeholder15 = new TextPrompt("Min. (0 a 59)", jTextField41);
        placeholder15.changeAlpha(0.50f);
        placeholder15.changeStyle(Font.ITALIC);

        TextPrompt placeholder16 = new TextPrompt("Hr. (0 a 23)", jTextField43);
        placeholder16.changeAlpha(0.50f);
        placeholder16.changeStyle(Font.ITALIC);

        TextPrompt placeholder17 = new TextPrompt("Min. (0 a 59)", jTextField44);
        placeholder17.changeAlpha(0.50f);
        placeholder17.changeStyle(Font.ITALIC);

        // CLIENTES
        TextPrompt placeholder18 = new TextPrompt("Ingrese el nombre del cliente...", jTextField9);
        placeholder18.changeAlpha(0.50f);
        placeholder18.changeStyle(Font.ITALIC);

        TextPrompt placeholder19 = new TextPrompt("Ingrese el ap. paterno del cliente...", jTextField12);
        placeholder19.changeAlpha(0.50f);
        placeholder19.changeStyle(Font.ITALIC);

        TextPrompt placeholder20 = new TextPrompt("Ingrese el ap. materno del cliente...", jTextField25);
        placeholder20.changeAlpha(0.50f);
        placeholder20.changeStyle(Font.ITALIC);

        TextPrompt placeholder21 = new TextPrompt("Ej. Calle Gardenias #123...", jTextField11);
        placeholder21.changeAlpha(0.50f);
        placeholder21.changeStyle(Font.ITALIC);

        TextPrompt placeholder22 = new TextPrompt("Max. 10 caracteres númericos", jTextField27);
        placeholder22.changeAlpha(0.50f);
        placeholder22.changeStyle(Font.ITALIC);

        TextPrompt placeholder23 = new TextPrompt("Ej. correo123@gmail.com", jTextField29);
        placeholder23.changeAlpha(0.50f);
        placeholder23.changeStyle(Font.ITALIC);

        // PROVEEDORES
        TextPrompt placeholder24 = new TextPrompt("Ingrese el nombre del proveedor...", jTextField30);
        placeholder24.changeAlpha(0.50f);
        placeholder24.changeStyle(Font.ITALIC);

        TextPrompt placeholder25 = new TextPrompt("Ej. Calle Gardenias #123...", jTextField31);
        placeholder25.changeAlpha(0.50f);
        placeholder25.changeStyle(Font.ITALIC);

        TextPrompt placeholder26 = new TextPrompt("Max. 10 caracteres númericos", jTextField32);
        placeholder26.changeAlpha(0.50f);
        placeholder26.changeStyle(Font.ITALIC);

        TextPrompt placeholder27 = new TextPrompt("Ej. correo123@gmail.com", jTextField33);
        placeholder27.changeAlpha(0.50f);
        placeholder27.changeStyle(Font.ITALIC);

        // INVENTARIO
        TextPrompt placeholder28 = new TextPrompt("Ingrese el valor númerico entero correspondiente...", jTextField17);
        placeholder28.changeAlpha(0.50f);
        placeholder28.changeStyle(Font.ITALIC);
    }

    public void cargarDatosGenerales() {
        if (user.equals("admin")) {
            obCons.consultarDatoGeneral("videojuegos", lblVidCont);
            obCons.consultarDatoGeneral("tiendas", lblTienCont);
            obCons.consultarDatoGeneral("proveedores", lblProvCont);
            obCons.consultarDatoGeneral("clientes", lblCliCont);
            obCons.consultarDatoGeneral("empleados", lblEmpCont);
            obCons.consultarDatoGeneral("inventario", lblInvCont);
            obCons.consultarDatoGeneral("compra", lblCompraCont);
            obCons.consultarDatoGeneral("ventas", lblCantVendida);
            obCons.consultarDatoGeneralVentas("mas vendido", lblJuegoMasVen, lblJuegoMasVenCant);
            obCons.consultarDatoGeneralVentas("menos vendido", lblJuegoMenosVen, lblJuegoMenosVenCant);
            obCons.consultarDatoGeneral("mas vendido1", lblJuegoMasVend);
            obCons.consultarDatoGeneral("menos vendido1", lblJuegoMenosVend);
            obCons.consultarDatoGeneral("mas ventas", lblTiendaMasVentas);
            obCons.consultarDatoGeneral("menos ventas", lblTiendaMenosVentas);
            obCons.consultarDatoGeneral("mas atento", lblEmpMasAtenciones);
            obCons.consultarDatoGeneral("mejor sueldo", lblEmpMejorSueldo);
            obCons.consultarDatoGeneral("mejor cliente", lblMejorCliente);
            obCons.consultarDatoGeneral("mas activo", lblProvMasActivo);
            obCons.setLablesInvStock(stock1, stock2, stock3);
            obCons.consultarStock();
        }
    }

    public void actionListenerButtons() {
        btnGuardarVid.addActionListener((e) -> {
            try {
                String nombre = jTextField2.getText(), categoria = jTextField3.getText();
                double precio = Double.parseDouble(jTextField4.getText());

                sqlVideojuegos.updateVideojuego(idVideojuego, new Videojuego(nombre, categoria, precio));

                obI.llenarTablaVideojuegos(tbVideojuegos);
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

                obI.llenarTablaTiendas(tbTiendas);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualización exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarProv.addActionListener((e) -> {
            try {
                int cont = 0;
                String nombre = jTextField30.getText(),
                        domicilio = jTextField31.getText(),
                        correo = jTextField33.getText();
                int telefono = Integer.parseInt(jTextField32.getText());

                sqlProveedores.updateProveedor(idProveedor, new Proveedor(nombre, telefono, domicilio, correo));

                if (correo.contains("@") && correo.contains(".")) {
                    cont++;
                } else {
                    JOptionPane.showMessageDialog(null, "El correo ingresado no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (cont != 0) {
                    obI.llenarTablaProveedores(tbProveedores);
                    cargarDatosGenerales();
                    JOptionPane.showMessageDialog(null, "Guardado Correctamente", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Valores ingresados no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
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

                obI.llenarTablaInventario(tbInventario);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarEmp.addActionListener((e) -> {
            try {
                int cont = 0;
                String nombre = jTextField7.getText();
                String ApellidoP = jTextField16.getText();
                String ApellidoM = jTextField22.getText();
                String NSS = jTextField15.getText();
                String CURP = jTextField21.getText();
                int telefono = Integer.parseInt(jTextField24.getText());
                String domicilio = jTextField6.getText();
                Date fechaNacimiento;
                double sueldo = Double.parseDouble(jTextField39.getText());
                int id_tienda = 0;
                Time hrEntrada = null, hrSalida = null;
                if (Integer.parseInt(jTextField40.getText().trim()) < 24 && Integer.parseInt(jTextField41.getText().trim()) < 60) {
                    hrEntrada = new Time(Integer.parseInt(jTextField40.getText()), Integer.parseInt(jTextField41.getText()), 0);
                    cont++;
                } else {
                    JOptionPane.showMessageDialog(null, "Hora de entrada no valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
                if (Integer.parseInt(jTextField43.getText().trim()) < 24 && Integer.parseInt(jTextField44.getText().trim()) < 60) {
                    hrSalida = new Time(Integer.parseInt(jTextField43.getText()), Integer.parseInt(jTextField44.getText()), 0);
                    cont++;
                } else {
                    JOptionPane.showMessageDialog(null, "Hora de salida no valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                String turno = String.valueOf(jComboBox4.getSelectedItem());

                try {
                    fechaNacimiento = new Date(dateSelector.getDate().getTime());
                } catch (NullPointerException ex) {
                    fechaNacimiento = null;
                }

                if (fechaNacimiento == null) {
                    JOptionPane.showMessageDialog(null, "Fecha no valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    cont++;
                }

                if (hrEntrada.compareTo(hrSalida) < 0) {
                    cont++;
                } else if (hrEntrada.compareTo(hrSalida) > 0) {
                    JOptionPane.showMessageDialog(null, "Hora de salida menor que la hora de entrada!", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Hora de entrada y salida iguales!", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                CRUDTiendas obT = new CRUDTiendas();
                obT.selectTienda();
                for (Tienda t : obT.getData()) {
                    if (String.valueOf(jComboBox3.getSelectedItem()).equals(t.getNombre())) {
                        id_tienda = t.getId();
                    }
                }

                if (cont == 4) {
                    sqlEmpleados.updateEmpleado(idEmpleado, new Empleado(nombre, ApellidoP, ApellidoM, NSS, CURP, fechaNacimiento, telefono, domicilio, sueldo), new Trabajo(id_tienda, hrEntrada, hrSalida, turno));

                    obI.llenarTablaEmpleados(tbEmpleados);
                    cargarDatosGenerales();
                    JOptionPane.showMessageDialog(null, "Actualización exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Valores ingresados no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException xe) {
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarClientes.addActionListener((e) -> {
            try {
                int cont = 0;
                String nombre = jTextField9.getText().trim(),
                        app = jTextField12.getText().trim(),
                        apm = jTextField25.getText().trim(),
                        domicilio = jTextField11.getText().trim(),
                        correo = jTextField29.getText().trim();
                int telefono = Integer.parseInt(jTextField27.getText().trim());
                Date fechaNac;

                try {
                    fechaNac = new Date(dateSelector1.getDate().getTime());
                } catch (NullPointerException ex) {
                    fechaNac = null;
                }

                if (fechaNac == null) {
                    JOptionPane.showMessageDialog(null, "Fecha no valida", "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {
                    cont++;
                }

                if (correo.contains("@") && correo.contains(".")) {
                    cont++;
                } else {
                    JOptionPane.showMessageDialog(null, "El correo ingresado no es valido", "ERROR", JOptionPane.ERROR_MESSAGE);
                }

                if (cont == 2) {
                    sqlClientes.updateCliente(idCliente, new Cliente(nombre, app, apm, fechaNac, telefono, domicilio, correo));
                    obI.llenarTablaClientes(tbClientes);
                    cargarDatosGenerales();
                    JOptionPane.showMessageDialog(null, "Actualización exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Valores ingresados no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        });

        btnGuardarProveen.addActionListener((e) -> {
            try {
                int idVid = 0, idTien = 0, idPro = 0;
                CRUDVideojuegos obV = new CRUDVideojuegos();
                CRUDTiendas obT = new CRUDTiendas();
                CRUDProveedores obP = new CRUDProveedores();
                obV.selectVideojuego();
                obT.selectTienda();
                obP.selectProveedor();
                int cantidad = Integer.parseInt(jTextField20.getText().trim());

                for (Videojuego v : obV.getData()) {
                    if (jTextField26.getText().trim().equals(v.getNombre())) {
                        idVid = v.getId();
                        break;
                    }
                }

                for (Tienda t : obT.getData()) {
                    if (jTextField23.getText().trim().equals(t.getNombre())) {
                        idTien = t.getId();
                        break;
                    }
                }

                for (Proveedor p : obP.getData()) {
                    if (jTextField28.getText().trim().equals(p.getNombre())) {
                        idPro = p.getId();
                        break;
                    }
                }

                sqlProveen.updateProveen(idVid, idPro, idTien, cantidad);
                obI.llenarTablaProveen(tbProveen, idTiendaTrabajo);
                cargarDatosGenerales();
                actualizarVideojuegos();
                setActionButtonsVideojuegos();
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGuardarVenta.addActionListener((e) -> {
            try {
                int idVid = 0, idTien = 0, idClien = 0;
                CRUDVideojuegos obV = new CRUDVideojuegos();
                CRUDTiendas obT = new CRUDTiendas();
                CRUDClientes obC = new CRUDClientes();
                obV.selectVideojuego();
                obT.selectTienda();
                obC.selectCliente();
                int cantidad = Integer.parseInt(jTextField38.getText().trim());
                double total = 0, auxPrecio = 0;
                Date fechaCompra = null;

                for (Videojuego v : obV.getData()) {
                    if (jTextField34.getText().trim().equals(v.getNombre())) {
                        idVid = v.getId();
                        auxPrecio = v.getPrecio();
                        break;
                    }
                }

                for (Tienda t : obT.getData()) {
                    if (jTextField37.getText().trim().equals(t.getNombre())) {
                        idTien = t.getId();
                        break;
                    }
                }

                for (Cliente p : obC.getData()) {
                    if (jTextField35.getText().trim().equals(p.getNombre())) {
                        idClien = p.getId();
                        break;
                    }
                }

                sqlVentas.selectCompra();
                for (Compra c : sqlVentas.getData()) {
                    if (c.getIdVideojuego() == idVid && c.getIdTienda() == idTien && c.getIdCliente() == idClien) {
                        fechaCompra = c.getFechaCompra();
                    }
                }

                total = auxPrecio * cantidad;

                sqlVentas.updateCompra(idVid, idTien, idClien, new Compra(cantidad, total, fechaCompra));
                obI.llenarTablaVentas(tbVentas);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Actualizacion exitosa", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Campos no validos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void setInfoVideojuegos(ArrayList<ButtonsVenta> btns, JPanel pnl) {
        buttonsVideojuegos = btns;
        pnlVideojuegos = pnl;
    }

    public void setActionButtonsVideojuegos() {
        for (ButtonsVenta bv : buttonsVideojuegos) {
            bv.getButton().addActionListener((e) -> {
                bv.getVideojuego().setStock(Integer.parseInt(bv.getTxt().getText().trim()));
                System.out.println(bv.getVideojuego().getNombre() + " | Cant:" + bv.getVideojuego().getStock());
            });
        }
    }

    public void actualizarVideojuegos() {
        buttonsVideojuegos.clear();
        pnlVideojuegos.removeAll();

        CRUDVideojuegos obV2 = new CRUDVideojuegos();
        obV2.selectVideojuegoVentas(idTiendaTrabajo);
        for (Videojuego v : obV2.getDataVenta()) {
            if (v.getIdTienda() == idTiendaTrabajo) {
                RoundButton btnAux = new RoundButton(new Color(187, 142, 61), new Color(231, 179, 125), new Color(239, 204, 168), new Color(40, 40, 40), 20);
                JTextField txt = new JTextField();
                buttonsVideojuegos.add(new ButtonsVenta(txt, btnAux, new Videojuego(v.getId(), v.getIdTienda(), v.getNombre(), v.getCategoria(), v.getPrecio(), 0)));
                pnlVideojuegos.add(new PanelVideojuego(v.getId(), v.getNombre(), v.getCategoria(), v.getStock(), v.getPrecio(), btnAux, txt));
            }
        }
        System.out.println(buttonsVideojuegos.size());
        if (buttonsVideojuegos.size() == 1) {
            pnlVideojuegos.setLayout(new GridLayout(buttonsVideojuegos.size() + 2, 1, 10, 10));
        } else if (buttonsVideojuegos.size() == 2) {
            pnlVideojuegos.setLayout(new GridLayout(buttonsVideojuegos.size() + 1, 1, 10, 10));
        } else if (buttonsVideojuegos.size() >= 3) {
            pnlVideojuegos.setLayout(new GridLayout(buttonsVideojuegos.size(), 1, 10, 10));
        }
    }

    public void setTbVentas(JTable tbVentas) {
        this.tbVentas = tbVentas;
    }

    public void setIdTiendaTrabajo(int idTiendaTrabajo) {
        this.idTiendaTrabajo = idTiendaTrabajo;
    }

    public void setVenta(Compra venta, int idVideojuego, int idTienda, int idCliente) {
        this.venta = venta;
        this.idVideojuego = idVideojuego;
        this.idTienda = idTienda;
        this.idCliente = idCliente;
    }

    public void setTbProveen(JTable tbProveen) {
        this.tbProveen = tbProveen;
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

    public Provee getProveer() {
        return proveer;
    }

    public void setProveer(Provee proveer, int idVid, int idTie, int idProv) {
        this.proveer = proveer;
        this.idVidP = idVid;
        this.idProP = idProv;
        this.idTienP = idTie;
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
        dateSelector = new com.toedter.calendar.JDateChooser();
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
        dateSelector1 = new com.toedter.calendar.JDateChooser();
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
        pnlAltaProveen = new CustomComponents.PanelRound();
        jPanel49 = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jPanel51 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jTextField26 = new javax.swing.JTextField();
        jPanel52 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jTextField28 = new javax.swing.JTextField();
        jPanel54 = new javax.swing.JPanel();
        jPanel55 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jTextField19 = new javax.swing.JTextField();
        jPanel53 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jTextField23 = new javax.swing.JTextField();
        jPanel56 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        pnlBtnInventario1 = new javax.swing.JPanel();
        pnlAltaVenta = new CustomComponents.PanelRound();
        jPanel57 = new javax.swing.JPanel();
        jPanel58 = new javax.swing.JPanel();
        jPanel59 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jPanel60 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jTextField35 = new javax.swing.JTextField();
        jPanel61 = new javax.swing.JPanel();
        jPanel62 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jTextField36 = new javax.swing.JTextField();
        jPanel63 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        jTextField37 = new javax.swing.JTextField();
        jPanel64 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        pnlBtnInventario2 = new javax.swing.JPanel();

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
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
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
        jTextField15.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField15KeyTyped(evt);
            }
        });
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
        jTextField40.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField40KeyTyped(evt);
            }
        });
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
        jTextField41.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField41KeyTyped(evt);
            }
        });
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
        jTextField43.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField43KeyTyped(evt);
            }
        });
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
        jTextField44.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField44KeyTyped(evt);
            }
        });
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
        jTextField24.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField24KeyTyped(evt);
            }
        });
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
        jTextField21.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField21KeyTyped(evt);
            }
        });
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
        jTextField39.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField39KeyTyped(evt);
            }
        });
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

        dateSelector.setBackground(new java.awt.Color(30, 30, 30));
        dateSelector.setForeground(new java.awt.Color(200, 200, 200));
        dateSelector.setDateFormatString("yyyy-MM-dd");
        jPanel36.add(dateSelector);

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
        jTextField27.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField27KeyTyped(evt);
            }
        });
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

        dateSelector1.setBackground(new java.awt.Color(30, 30, 30));
        dateSelector1.setForeground(new java.awt.Color(200, 200, 200));
        dateSelector1.setDateFormatString("yyyy-MM-dd");
        jPanel45.add(dateSelector1);

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
        jTextField32.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField32KeyTyped(evt);
            }
        });
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
        jTextField17.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField17KeyTyped(evt);
            }
        });
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

        pnlAltaProveen.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaProveen.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaProveen.setRoundBottomLeft(25);
        pnlAltaProveen.setRoundBottomRight(25);
        pnlAltaProveen.setLayout(new java.awt.BorderLayout());

        jPanel49.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        jPanel49.setOpaque(false);
        jPanel49.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel50.setOpaque(false);
        jPanel50.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jPanel51.setOpaque(false);
        jPanel51.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(100, 100, 100));
        jLabel25.setText("Videojuego");
        jLabel25.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel51.add(jLabel25);

        jTextField26.setBackground(new java.awt.Color(20, 20, 20));
        jTextField26.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField26.setForeground(new java.awt.Color(200, 200, 200));
        jTextField26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField26.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField26.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField26.setEnabled(false);
        jTextField26.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField26.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel51.add(jTextField26);

        jPanel50.add(jPanel51);

        jPanel52.setOpaque(false);
        jPanel52.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(100, 100, 100));
        jLabel33.setText("Proveedor");
        jLabel33.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel52.add(jLabel33);

        jTextField28.setBackground(new java.awt.Color(20, 20, 20));
        jTextField28.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField28.setForeground(new java.awt.Color(200, 200, 200));
        jTextField28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField28.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField28.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField28.setEnabled(false);
        jTextField28.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField28.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel52.add(jTextField28);

        jPanel50.add(jPanel52);

        jPanel49.add(jPanel50);

        jPanel54.setOpaque(false);
        jPanel54.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jPanel55.setOpaque(false);
        jPanel55.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(100, 100, 100));
        jLabel42.setText("Fecha surtido");
        jLabel42.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel55.add(jLabel42);

        jTextField19.setBackground(new java.awt.Color(20, 20, 20));
        jTextField19.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(200, 200, 200));
        jTextField19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField19.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField19.setEnabled(false);
        jTextField19.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField19.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel55.add(jTextField19);

        jPanel54.add(jPanel55);

        jPanel53.setOpaque(false);
        jPanel53.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(100, 100, 100));
        jLabel41.setText("Tienda");
        jLabel41.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel53.add(jLabel41);

        jTextField23.setBackground(new java.awt.Color(20, 20, 20));
        jTextField23.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField23.setForeground(new java.awt.Color(200, 200, 200));
        jTextField23.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField23.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField23.setEnabled(false);
        jTextField23.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField23.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel53.add(jTextField23);

        jPanel54.add(jPanel53);

        jPanel49.add(jPanel54);

        jPanel56.setOpaque(false);
        jPanel56.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(100, 100, 100));
        jLabel43.setText("Cantidad surtida");
        jLabel43.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel56.add(jLabel43);

        jTextField20.setBackground(new java.awt.Color(30, 30, 30));
        jTextField20.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(200, 200, 200));
        jTextField20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField20.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField20.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField20.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField20.setSelectionColor(new java.awt.Color(25, 200, 178));
        jTextField20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField20KeyTyped(evt);
            }
        });
        jPanel56.add(jTextField20);

        jPanel49.add(jPanel56);

        pnlAltaProveen.add(jPanel49, java.awt.BorderLayout.CENTER);

        pnlBtnInventario1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnInventario1.setOpaque(false);
        pnlBtnInventario1.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaProveen.add(pnlBtnInventario1, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaProveen, "altaProveen");

        pnlAltaVenta.setBackground(new java.awt.Color(20, 20, 20));
        pnlAltaVenta.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlAltaVenta.setRoundBottomLeft(25);
        pnlAltaVenta.setRoundBottomRight(25);
        pnlAltaVenta.setLayout(new java.awt.BorderLayout());

        jPanel57.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        jPanel57.setOpaque(false);
        jPanel57.setLayout(new java.awt.GridLayout(4, 1, 0, 5));

        jPanel58.setOpaque(false);
        jPanel58.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jPanel59.setOpaque(false);
        jPanel59.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(100, 100, 100));
        jLabel44.setText("Videojuego");
        jLabel44.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel59.add(jLabel44);

        jTextField34.setBackground(new java.awt.Color(20, 20, 20));
        jTextField34.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField34.setForeground(new java.awt.Color(200, 200, 200));
        jTextField34.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField34.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField34.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField34.setEnabled(false);
        jTextField34.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField34.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel59.add(jTextField34);

        jPanel58.add(jPanel59);

        jPanel60.setOpaque(false);
        jPanel60.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(100, 100, 100));
        jLabel45.setText("Cliente");
        jLabel45.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel60.add(jLabel45);

        jTextField35.setBackground(new java.awt.Color(20, 20, 20));
        jTextField35.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField35.setForeground(new java.awt.Color(200, 200, 200));
        jTextField35.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField35.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField35.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField35.setEnabled(false);
        jTextField35.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField35.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel60.add(jTextField35);

        jPanel58.add(jPanel60);

        jPanel57.add(jPanel58);

        jPanel61.setOpaque(false);
        jPanel61.setLayout(new java.awt.GridLayout(1, 2, 5, 0));

        jPanel62.setOpaque(false);
        jPanel62.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(100, 100, 100));
        jLabel46.setText("Fecha de venta");
        jLabel46.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel62.add(jLabel46);

        jTextField36.setBackground(new java.awt.Color(20, 20, 20));
        jTextField36.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField36.setForeground(new java.awt.Color(200, 200, 200));
        jTextField36.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField36.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField36.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField36.setEnabled(false);
        jTextField36.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField36.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel62.add(jTextField36);

        jPanel61.add(jPanel62);

        jPanel63.setOpaque(false);
        jPanel63.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(100, 100, 100));
        jLabel47.setText("Tienda");
        jLabel47.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel63.add(jLabel47);

        jTextField37.setBackground(new java.awt.Color(20, 20, 20));
        jTextField37.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField37.setForeground(new java.awt.Color(200, 200, 200));
        jTextField37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField37.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField37.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField37.setEnabled(false);
        jTextField37.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField37.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel63.add(jTextField37);

        jPanel61.add(jPanel63);

        jPanel57.add(jPanel61);

        jPanel64.setOpaque(false);
        jPanel64.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(100, 100, 100));
        jLabel48.setText("Cantidad vendida");
        jLabel48.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel64.add(jLabel48);

        jTextField38.setBackground(new java.awt.Color(30, 30, 30));
        jTextField38.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField38.setForeground(new java.awt.Color(200, 200, 200));
        jTextField38.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jTextField38.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField38.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField38.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField38.setSelectionColor(new java.awt.Color(25, 200, 178));
        jTextField38.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField38KeyTyped(evt);
            }
        });
        jPanel64.add(jTextField38);

        jPanel57.add(jPanel64);

        pnlAltaVenta.add(jPanel57, java.awt.BorderLayout.CENTER);

        pnlBtnInventario2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlBtnInventario2.setOpaque(false);
        pnlBtnInventario2.setLayout(new java.awt.GridLayout(1, 1, 0, 10));
        pnlAltaVenta.add(pnlBtnInventario2, java.awt.BorderLayout.SOUTH);

        pnlMain.add(pnlAltaVenta, "altaVenta");

        jPanel1.add(pnlMain, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == '.')) {
            evt.consume();
        }

        if (c == '.' && jTextField4.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField21KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField21KeyTyped
        if (jTextField21.getText().length() >= 18) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField21KeyTyped

    private void jTextField15KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField15KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField15.getText().length() >= 11) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField15KeyTyped

    private void jTextField24KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField24KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField24.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField24KeyTyped

    private void jTextField39KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField39KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE || c == '.')) {
            evt.consume();
        }

        if (c == '.' && jTextField39.getText().contains(".")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField39KeyTyped

    private void jTextField40KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField40KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField40.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField40KeyTyped

    private void jTextField43KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField43KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField43.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField43KeyTyped

    private void jTextField41KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField41KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField41.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField41KeyTyped

    private void jTextField44KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField44KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField44.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField44KeyTyped

    private void jTextField27KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField27KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField27.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField27KeyTyped

    private void jTextField32KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField32KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }

        if (jTextField32.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField32KeyTyped

    private void jTextField17KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField17KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField17KeyTyped

    private void jTextField20KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField20KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField20KeyTyped

    private void jTextField38KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField38KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField38KeyTyped
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
    private com.toedter.calendar.JDateChooser dateSelector;
    private com.toedter.calendar.JDateChooser dateSelector1;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
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
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel57;
    private javax.swing.JPanel jPanel58;
    private javax.swing.JPanel jPanel59;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel60;
    private javax.swing.JPanel jPanel61;
    private javax.swing.JPanel jPanel62;
    private javax.swing.JPanel jPanel63;
    private javax.swing.JPanel jPanel64;
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
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField24;
    private javax.swing.JTextField jTextField25;
    private javax.swing.JTextField jTextField26;
    private javax.swing.JTextField jTextField27;
    private javax.swing.JTextField jTextField28;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField30;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField32;
    private javax.swing.JTextField jTextField33;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField jTextField35;
    private javax.swing.JTextField jTextField36;
    private javax.swing.JTextField jTextField37;
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
    private CustomComponents.PanelRound pnlAltaProveen;
    private CustomComponents.PanelRound pnlAltaTiendas;
    private CustomComponents.PanelRound pnlAltaVenta;
    private CustomComponents.PanelRound pnlAltaVideojuegos;
    private javax.swing.JPanel pnlBtnClientes;
    private javax.swing.JPanel pnlBtnEmp;
    private javax.swing.JPanel pnlBtnInventario;
    private javax.swing.JPanel pnlBtnInventario1;
    private javax.swing.JPanel pnlBtnInventario2;
    private javax.swing.JPanel pnlBtnProv;
    private javax.swing.JPanel pnlBtnTiendas;
    private javax.swing.JPanel pnlBtnVideojuegos;
    private CustomComponents.PanelRound pnlHeaderVid;
    private javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
