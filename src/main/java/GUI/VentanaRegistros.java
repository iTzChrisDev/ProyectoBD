package GUI;

import CustomComponents.CustomComboBoxRenderer;
import CustomComponents.PanelRound;
import CustomComponents.RoundButton;
import Funciones.Dashboard.ConsultasGenerales;
import CustomComponents.EstilosComponentes;
import Funciones.Entidades.*;
import Funciones.Relaciones.CRUDInventario;
import Funciones.TablasListas.LlenadoInformacion;
import TDA.Entidades.*;
import TDA.Relaciones.Inventario;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VentanaRegistros extends javax.swing.JFrame {

    private final Color select = new Color(25, 200, 178);
    private final Color unselect = new Color(100, 100, 100);
    private boolean estado = true;
    private final int velAnimacion = 5, limite = 140;
    private EstilosComponentes obE;
    private CardLayout obCMenu, obCVid, obCTien, obCEmp, obCCli, obCProv, obCInv;
    private VentanaAltas alta, alta2, alta3, alta4, alta5, alta6;
    private VentanaActualizaciones actu, actu2, actu3, actu4, actu5, actu6;
    private RoundButton btnPrincipal, btnVideojuegos, btnProveedores, btnEmpleados, btnClientes, btnTiendas, btnInventario, btnSalir, btnMenu, btnPuntoVenta, btnVentas;
    private RoundButton btnBuscarVideojuegosElim, btnBuscarVideojuegosAct, btnBuscarVideojuegosMostrar, btnBuscarVideojuegosAlta, btnAgregarVideojuegos, btnEliminarVideojuegos, btnActVideojuegos, btnFiltrarVideojuegos;
    private RoundButton btnBuscarTiendasElim, btnBuscarTiendasAct, btnBuscarTiendasMostrar, btnBuscarTiendasAlta, btnAgregarTiendas, btnEliminarTiendas, btnActTiendas, btnFiltrarTiendas;
    private RoundButton btnBuscarEmpleadosElim, btnBuscarEmpleadosAct, btnBuscarEmpleadosMostrar, btnBuscarEmpleadosAlta, btnAgregarEmpleados, btnEliminarEmpleados, btnActEmpleados, btnFiltrarEmpleados;
    private RoundButton btnBuscarClientesElim, btnBuscarClientesAct, btnBuscarClientesMostrar, btnBuscarClientesAlta, btnAgregarClientes, btnEliminarClientes, btnActClientes, btnFiltrarClientes;
    private RoundButton btnBuscarProveedoresElim, btnBuscarProveedoresAct, btnBuscarProveedoresMostrar, btnBuscarProveedoresAlta, btnAgregarProveedores, btnEliminarProveedores, btnActProveedores, btnFiltrarProveedores;
    private RoundButton btnBuscarInventarioElim, btnBuscarInventarioAct, btnBuscarInventarioMostrar, btnBuscarInventarioAlta, btnAgregarInventario, btnEliminarInventario, btnActInventario;
    private ArrayList<RoundButton> crudJuegos, crudTiendas, crudEmpleados, crudClientes, crudProv, crudInv;
    private ConsultasGenerales obCons;
    private LlenadoInformacion obI;
    private CRUDVideojuegos sqlVideojuegos;
    private CRUDClientes sqlClientes;
    private CRUDEmpleados sqlEmpleados;
    private CRUDProveedores sqlProveedores;
    private CRUDTiendas sqlTiendas;
    private CRUDInventario sqlInventario;
    private String user;
    private int idTiendaTrabajo;

    public VentanaRegistros() {
        initComponents();
        setLocationRelativeTo(this);
        obE = new EstilosComponentes();
        obI = new LlenadoInformacion();
        obCons = new ConsultasGenerales();
        sqlVideojuegos = new CRUDVideojuegos();
        sqlClientes = new CRUDClientes();
        sqlEmpleados = new CRUDEmpleados();
        sqlProveedores = new CRUDProveedores();
        sqlTiendas = new CRUDTiendas();
        sqlInventario = new CRUDInventario();
        obCMenu = (CardLayout) pnlMain.getLayout();
        obCVid = (CardLayout) pnlOpcionesVideojuegos.getLayout();
        obCTien = (CardLayout) pnlOpcionesTiendas.getLayout();
        obCEmp = (CardLayout) pnlOpcionesEmpleados.getLayout();
        obCCli = (CardLayout) pnlOpcionesClientes.getLayout();
        obCProv = (CardLayout) pnlOpcionesProveedores.getLayout();
        obCInv = (CardLayout) pnlOpcionesInventario.getLayout();
        initComponentesCustom();
        initCRUD();
        actionListenerButtonsCRUD();
        initButtonsCRUD();
        actionListenerBtnActions();
        cargarDatosGenerales();
        actionListenerButtonsHeader();
    }

    public void setUser(String user, int idTiendaTrabajo) {
        this.idTiendaTrabajo = idTiendaTrabajo;
        this.user = user;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        panelRound1 = new CustomComponents.PanelRound();
        jLabel8 = new javax.swing.JLabel();
        pnlHeaderButtons = new javax.swing.JPanel();
        pnlHeaderButtons1 = new javax.swing.JPanel();
        pnlMain = new javax.swing.JPanel();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        panelRound12 = new CustomComponents.PanelRound();
        panelRound23 = new CustomComponents.PanelRound();
        panelGradient6 = new CustomComponents.PanelGradient();
        jPanel18 = new javax.swing.JPanel();
        lblProv = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        lblProvCont = new javax.swing.JLabel();
        panelRound24 = new CustomComponents.PanelRound();
        panelGradient9 = new CustomComponents.PanelGradient();
        jPanel25 = new javax.swing.JPanel();
        lblVideo = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        lblVidCont = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        panelRound29 = new CustomComponents.PanelRound();
        panelGradient11 = new CustomComponents.PanelGradient();
        jPanel30 = new javax.swing.JPanel();
        lblEmp = new javax.swing.JLabel();
        jPanel31 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        lblEmpCont = new javax.swing.JLabel();
        panelRound30 = new CustomComponents.PanelRound();
        panelGradient12 = new CustomComponents.PanelGradient();
        jPanel32 = new javax.swing.JPanel();
        lblTienda = new javax.swing.JLabel();
        jPanel36 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        lblTienCont = new javax.swing.JLabel();
        panelRound35 = new CustomComponents.PanelRound();
        panelGradient14 = new CustomComponents.PanelGradient();
        jPanel37 = new javax.swing.JPanel();
        lblClientes = new javax.swing.JLabel();
        jPanel38 = new javax.swing.JPanel();
        lblCliCont = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        panelRound36 = new CustomComponents.PanelRound();
        panelGradient15 = new CustomComponents.PanelGradient();
        jPanel39 = new javax.swing.JPanel();
        lblInv = new javax.swing.JLabel();
        jPanel43 = new javax.swing.JPanel();
        lblInvCont = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jPanel53 = new javax.swing.JPanel();
        panelRound18 = new CustomComponents.PanelRound();
        panelRound38 = new CustomComponents.PanelRound();
        panelGradient17 = new CustomComponents.PanelGradient();
        jPanel44 = new javax.swing.JPanel();
        lblVentas = new javax.swing.JLabel();
        jPanel45 = new javax.swing.JPanel();
        lblCompraCont = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        panelRound39 = new CustomComponents.PanelRound();
        panelGradient18 = new CustomComponents.PanelGradient();
        jPanel46 = new javax.swing.JPanel();
        lblIngresosVentas = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        lblCantVendida = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        panelRound40 = new CustomComponents.PanelRound();
        panelGradient19 = new CustomComponents.PanelGradient();
        jPanel48 = new javax.swing.JPanel();
        lblMasVendido = new javax.swing.JLabel();
        jPanel49 = new javax.swing.JPanel();
        lblJuegoMasVen = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lblJuegoMasVenCant = new javax.swing.JLabel();
        panelRound41 = new CustomComponents.PanelRound();
        panelGradient20 = new CustomComponents.PanelGradient();
        jPanel50 = new javax.swing.JPanel();
        lblMenosVendido = new javax.swing.JLabel();
        jPanel51 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        lblJuegoMenosVen = new javax.swing.JLabel();
        lblJuegoMenosVenCant = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        pnlVideojuegos = new javax.swing.JPanel();
        pnlOpcVideojuegos = new CustomComponents.PanelRound();
        jPanel3 = new javax.swing.JPanel();
        panelRound2 = new CustomComponents.PanelRound();
        panelRound3 = new CustomComponents.PanelRound();
        panelRound5 = new CustomComponents.PanelRound();
        panelGradient1 = new CustomComponents.PanelGradient();
        jPanel5 = new javax.swing.JPanel();
        lblCategoria = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        lblCatPopular = new javax.swing.JLabel();
        panelRound6 = new CustomComponents.PanelRound();
        panelGradient2 = new CustomComponents.PanelGradient();
        jPanel10 = new javax.swing.JPanel();
        lblMasVend = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        lblJuegoMasVend = new javax.swing.JLabel();
        panelRound7 = new CustomComponents.PanelRound();
        panelGradient3 = new CustomComponents.PanelGradient();
        jPanel12 = new javax.swing.JPanel();
        lblMenosVend = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        lblJuegoMenosVend = new javax.swing.JLabel();
        panelRound4 = new CustomComponents.PanelRound();
        pnlOpcionesVideojuegos = new javax.swing.JPanel();
        vidAlta = new javax.swing.JPanel();
        pnlButtonsVideojuegosAlta = new javax.swing.JPanel();
        txtBusquedaVideojuegos3 = new javax.swing.JTextField();
        vidElim = new javax.swing.JPanel();
        pnlButtonsVideojuegosElim = new javax.swing.JPanel();
        txtBusquedaVideojuegos = new javax.swing.JTextField();
        vidAct = new javax.swing.JPanel();
        pnlButtonsVideojuegosAct = new javax.swing.JPanel();
        txtBusquedaVideojuegos1 = new javax.swing.JTextField();
        vidMostrar = new javax.swing.JPanel();
        pnlButtonsVideojuegosMostrar = new javax.swing.JPanel();
        comboVideojuegos = new javax.swing.JComboBox<>();
        txtBusquedaVideojuegos2 = new javax.swing.JTextField();
        scrollVideojuegos = new javax.swing.JScrollPane();
        tbVideojuegos = new javax.swing.JTable();
        pnlTiendas = new javax.swing.JPanel();
        pnlOpcTiendas = new CustomComponents.PanelRound();
        jPanel6 = new javax.swing.JPanel();
        panelRound8 = new CustomComponents.PanelRound();
        panelRound9 = new CustomComponents.PanelRound();
        panelRound10 = new CustomComponents.PanelRound();
        panelGradient4 = new CustomComponents.PanelGradient();
        jPanel8 = new javax.swing.JPanel();
        lblTiendaMas = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        lblTiendaMasVentas = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        panelRound11 = new CustomComponents.PanelRound();
        panelGradient5 = new CustomComponents.PanelGradient();
        jPanel15 = new javax.swing.JPanel();
        lblTiendaMasVisitada = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        lblTiendaMenosVentas = new javax.swing.JLabel();
        panelRound13 = new CustomComponents.PanelRound();
        scrollTiendas = new javax.swing.JScrollPane();
        tbTiendas = new javax.swing.JTable();
        pnlOpcionesTiendas = new javax.swing.JPanel();
        vidAlta1 = new javax.swing.JPanel();
        pnlButtonsTiendasAlta = new javax.swing.JPanel();
        txtBusquedaVideojuegos4 = new javax.swing.JTextField();
        vidElim1 = new javax.swing.JPanel();
        pnlButtonsTiendasElim = new javax.swing.JPanel();
        txtBusquedaVideojuegos5 = new javax.swing.JTextField();
        vidAct1 = new javax.swing.JPanel();
        pnlButtonsTiendasAct = new javax.swing.JPanel();
        txtBusquedaVideojuegos6 = new javax.swing.JTextField();
        vidMostrar1 = new javax.swing.JPanel();
        pnlButtonsTiendasMostrar = new javax.swing.JPanel();
        comboTiendas = new javax.swing.JComboBox<>();
        txtBusquedaVideojuegos7 = new javax.swing.JTextField();
        pnlEmpleados = new javax.swing.JPanel();
        pnlOpcEmpleados = new CustomComponents.PanelRound();
        jPanel19 = new javax.swing.JPanel();
        panelRound14 = new CustomComponents.PanelRound();
        panelRound15 = new CustomComponents.PanelRound();
        panelRound16 = new CustomComponents.PanelRound();
        panelGradient7 = new CustomComponents.PanelGradient();
        jPanel20 = new javax.swing.JPanel();
        lblEmpleadoSueldo = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        lblEmpMejorSueldo = new javax.swing.JLabel();
        panelRound17 = new CustomComponents.PanelRound();
        panelGradient8 = new CustomComponents.PanelGradient();
        jPanel22 = new javax.swing.JPanel();
        lblEmpleadoAtento = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        lblEmpMasAtenciones = new javax.swing.JLabel();
        panelRound19 = new CustomComponents.PanelRound();
        scrollEmp = new javax.swing.JScrollPane();
        tbEmp = new javax.swing.JTable();
        pnlOpcionesEmpleados = new javax.swing.JPanel();
        vidAlta2 = new javax.swing.JPanel();
        pnlButtonsEmpleadosAlta = new javax.swing.JPanel();
        txtBusquedaVideojuegos8 = new javax.swing.JTextField();
        vidElim2 = new javax.swing.JPanel();
        pnlButtonsEmpleadosElim = new javax.swing.JPanel();
        txtBusquedaVideojuegos9 = new javax.swing.JTextField();
        vidAct2 = new javax.swing.JPanel();
        pnlButtonsEmpleadosAct = new javax.swing.JPanel();
        txtBusquedaVideojuegos10 = new javax.swing.JTextField();
        vidMostrar2 = new javax.swing.JPanel();
        pnlButtonsEmpleadosMostrar = new javax.swing.JPanel();
        comboEmpleados = new javax.swing.JComboBox<>();
        txtBusquedaVideojuegos11 = new javax.swing.JTextField();
        pnlClientes = new javax.swing.JPanel();
        pnlOpcClientes = new CustomComponents.PanelRound();
        jPanel26 = new javax.swing.JPanel();
        panelRound20 = new CustomComponents.PanelRound();
        panelRound21 = new CustomComponents.PanelRound();
        panelRound22 = new CustomComponents.PanelRound();
        panelGradient10 = new CustomComponents.PanelGradient();
        jPanel27 = new javax.swing.JPanel();
        lblClienteMejor = new javax.swing.JLabel();
        jPanel28 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        lblMejorCliente = new javax.swing.JLabel();
        panelRound25 = new CustomComponents.PanelRound();
        scrollClientes = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        pnlOpcionesClientes = new javax.swing.JPanel();
        vidAlta3 = new javax.swing.JPanel();
        pnlButtonsClientesAlta = new javax.swing.JPanel();
        txtBusquedaVideojuegos12 = new javax.swing.JTextField();
        vidElim3 = new javax.swing.JPanel();
        pnlButtonsClientesElim = new javax.swing.JPanel();
        txtBusquedaVideojuegos13 = new javax.swing.JTextField();
        vidAct3 = new javax.swing.JPanel();
        pnlButtonsClientesAct = new javax.swing.JPanel();
        txtBusquedaVideojuegos14 = new javax.swing.JTextField();
        vidMostrar3 = new javax.swing.JPanel();
        pnlButtonsClientesMostrar = new javax.swing.JPanel();
        comboClientes = new javax.swing.JComboBox<>();
        txtBusquedaVideojuegos15 = new javax.swing.JTextField();
        pnlProveedores = new javax.swing.JPanel();
        pnlOpcProveedores = new CustomComponents.PanelRound();
        jPanel33 = new javax.swing.JPanel();
        panelRound26 = new CustomComponents.PanelRound();
        panelRound27 = new CustomComponents.PanelRound();
        panelRound28 = new CustomComponents.PanelRound();
        panelGradient13 = new CustomComponents.PanelGradient();
        jPanel34 = new javax.swing.JPanel();
        lblProvActivo = new javax.swing.JLabel();
        jPanel35 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lblProvMasActivo = new javax.swing.JLabel();
        panelRound31 = new CustomComponents.PanelRound();
        scrollProv = new javax.swing.JScrollPane();
        tbProv = new javax.swing.JTable();
        pnlOpcionesProveedores = new javax.swing.JPanel();
        vidAlta4 = new javax.swing.JPanel();
        pnlButtonsProvAlta = new javax.swing.JPanel();
        txtBusquedaVideojuegos16 = new javax.swing.JTextField();
        vidElim4 = new javax.swing.JPanel();
        pnlButtonsProvElim = new javax.swing.JPanel();
        txtBusquedaVideojuegos17 = new javax.swing.JTextField();
        vidAct4 = new javax.swing.JPanel();
        pnlButtonsProvAct = new javax.swing.JPanel();
        txtBusquedaVideojuegos18 = new javax.swing.JTextField();
        vidMostrar4 = new javax.swing.JPanel();
        pnlButtonsProvMostrar = new javax.swing.JPanel();
        comboProveedores = new javax.swing.JComboBox<>();
        txtBusquedaVideojuegos19 = new javax.swing.JTextField();
        pnlInventario = new javax.swing.JPanel();
        pnlOpcInventario = new CustomComponents.PanelRound();
        jPanel40 = new javax.swing.JPanel();
        panelRound32 = new CustomComponents.PanelRound();
        panelRound33 = new CustomComponents.PanelRound();
        panelRound34 = new CustomComponents.PanelRound();
        panelGradient16 = new CustomComponents.PanelGradient();
        jPanel41 = new javax.swing.JPanel();
        lblInvStock = new javax.swing.JLabel();
        jPanel42 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        panelRound37 = new CustomComponents.PanelRound();
        scrollInv = new javax.swing.JScrollPane();
        tbInv = new javax.swing.JTable();
        pnlOpcionesInventario = new javax.swing.JPanel();
        vidAlta5 = new javax.swing.JPanel();
        pnlButtonsInvAlta = new javax.swing.JPanel();
        txtBusquedaVideojuegos20 = new javax.swing.JTextField();
        vidElim5 = new javax.swing.JPanel();
        pnlButtonsInvElim = new javax.swing.JPanel();
        txtBusquedaVideojuegos21 = new javax.swing.JTextField();
        vidAct5 = new javax.swing.JPanel();
        pnlButtonsInvAct = new javax.swing.JPanel();
        txtBusquedaVideojuegos22 = new javax.swing.JTextField();
        vidMostrar5 = new javax.swing.JPanel();
        pnlButtonsInvMostrar = new javax.swing.JPanel();
        txtBusquedaVideojuegos23 = new javax.swing.JTextField();
        pnlAside = new javax.swing.JPanel();
        pnlMenuContainer = new CustomComponents.PanelRound();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(950, 710));

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBackground(new java.awt.Color(20, 20, 20));
        pnlHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 15));
        pnlHeader.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.GridLayout(1, 1));

        panelRound1.setBackground(new java.awt.Color(10, 10, 10));
        panelRound1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semilight", 0, 30)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(245, 245, 245));
        jLabel8.setText("GameShop Software");
        panelRound1.add(jLabel8);

        jPanel2.add(panelRound1);

        pnlHeader.add(jPanel2, java.awt.BorderLayout.CENTER);

        pnlHeaderButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlHeaderButtons.setOpaque(false);
        pnlHeaderButtons.setLayout(new java.awt.GridLayout(1, 2, 5, 5));
        pnlHeader.add(pnlHeaderButtons, java.awt.BorderLayout.EAST);

        pnlHeaderButtons1.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        pnlHeaderButtons1.setOpaque(false);
        pnlHeaderButtons1.setLayout(new java.awt.GridLayout(1, 2, 5, 5));
        pnlHeader.add(pnlHeaderButtons1, java.awt.BorderLayout.WEST);

        jPanel1.add(pnlHeader, java.awt.BorderLayout.NORTH);

        pnlMain.setBackground(new java.awt.Color(20, 20, 20));
        pnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 10));
        pnlMain.setLayout(new java.awt.CardLayout());

        pnlPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        pnlPrincipal.setOpaque(false);
        pnlPrincipal.setLayout(new java.awt.GridLayout(2, 1, 0, 10));

        jPanel52.setOpaque(false);
        jPanel52.setLayout(new java.awt.BorderLayout());

        panelRound12.setBackground(new java.awt.Color(10, 10, 10));
        panelRound12.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound12.setRoundBottomLeft(20);
        panelRound12.setRoundBottomRight(20);
        panelRound12.setRoundTopLeft(20);
        panelRound12.setRoundTopRight(20);
        panelRound12.setLayout(new java.awt.GridLayout(2, 3, 10, 10));

        panelRound23.setBackground(new java.awt.Color(40, 40, 40));
        panelRound23.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound23.setRoundBottomLeft(10);
        panelRound23.setRoundBottomRight(10);
        panelRound23.setRoundTopLeft(10);
        panelRound23.setRoundTopRight(10);
        panelRound23.setLayout(new java.awt.BorderLayout());

        panelGradient6.setLayout(new java.awt.FlowLayout());
        panelRound23.add(panelGradient6, java.awt.BorderLayout.NORTH);

        jPanel18.setOpaque(false);
        jPanel18.setLayout(new java.awt.BorderLayout());

        lblProv.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel18.add(lblProv, java.awt.BorderLayout.LINE_END);

        jPanel24.setOpaque(false);
        jPanel24.setLayout(new java.awt.BorderLayout());

        jLabel19.setBackground(new java.awt.Color(100, 100, 100));
        jLabel19.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(130, 130, 130));
        jLabel19.setText("Proveedores");
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel24.add(jLabel19, java.awt.BorderLayout.NORTH);

        lblProvCont.setBackground(new java.awt.Color(25, 180, 98));
        lblProvCont.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblProvCont.setForeground(new java.awt.Color(66, 189, 159));
        lblProvCont.setText("0");
        lblProvCont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel24.add(lblProvCont, java.awt.BorderLayout.CENTER);

        jPanel18.add(jPanel24, java.awt.BorderLayout.CENTER);

        panelRound23.add(jPanel18, java.awt.BorderLayout.CENTER);

        panelRound12.add(panelRound23);

        panelRound24.setBackground(new java.awt.Color(40, 40, 40));
        panelRound24.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound24.setRoundBottomLeft(10);
        panelRound24.setRoundBottomRight(10);
        panelRound24.setRoundTopLeft(10);
        panelRound24.setRoundTopRight(10);
        panelRound24.setLayout(new java.awt.BorderLayout());

        panelGradient9.setLayout(new java.awt.FlowLayout());
        panelRound24.add(panelGradient9, java.awt.BorderLayout.NORTH);

        jPanel25.setOpaque(false);
        jPanel25.setLayout(new java.awt.BorderLayout());

        lblVideo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel25.add(lblVideo, java.awt.BorderLayout.LINE_END);

        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.BorderLayout());

        lblVidCont.setBackground(new java.awt.Color(25, 180, 98));
        lblVidCont.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblVidCont.setForeground(new java.awt.Color(66, 189, 159));
        lblVidCont.setText("0");
        lblVidCont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel29.add(lblVidCont, java.awt.BorderLayout.CENTER);

        jLabel25.setBackground(new java.awt.Color(100, 100, 100));
        jLabel25.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(130, 130, 130));
        jLabel25.setText("Videojuegos");
        jLabel25.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel29.add(jLabel25, java.awt.BorderLayout.NORTH);

        jPanel25.add(jPanel29, java.awt.BorderLayout.CENTER);

        panelRound24.add(jPanel25, java.awt.BorderLayout.CENTER);

        panelRound12.add(panelRound24);

        panelRound29.setBackground(new java.awt.Color(40, 40, 40));
        panelRound29.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound29.setRoundBottomLeft(10);
        panelRound29.setRoundBottomRight(10);
        panelRound29.setRoundTopLeft(10);
        panelRound29.setRoundTopRight(10);
        panelRound29.setLayout(new java.awt.BorderLayout());

        panelGradient11.setLayout(new java.awt.FlowLayout());
        panelRound29.add(panelGradient11, java.awt.BorderLayout.NORTH);

        jPanel30.setOpaque(false);
        jPanel30.setLayout(new java.awt.BorderLayout());

        lblEmp.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel30.add(lblEmp, java.awt.BorderLayout.LINE_END);

        jPanel31.setOpaque(false);
        jPanel31.setLayout(new java.awt.BorderLayout());

        jLabel29.setBackground(new java.awt.Color(100, 100, 100));
        jLabel29.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(130, 130, 130));
        jLabel29.setText("Empleados");
        jLabel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel31.add(jLabel29, java.awt.BorderLayout.NORTH);

        lblEmpCont.setBackground(new java.awt.Color(25, 180, 98));
        lblEmpCont.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblEmpCont.setForeground(new java.awt.Color(66, 189, 159));
        lblEmpCont.setText("0");
        lblEmpCont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel31.add(lblEmpCont, java.awt.BorderLayout.CENTER);

        jPanel30.add(jPanel31, java.awt.BorderLayout.CENTER);

        panelRound29.add(jPanel30, java.awt.BorderLayout.CENTER);

        panelRound12.add(panelRound29);

        panelRound30.setBackground(new java.awt.Color(40, 40, 40));
        panelRound30.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound30.setRoundBottomLeft(10);
        panelRound30.setRoundBottomRight(10);
        panelRound30.setRoundTopLeft(10);
        panelRound30.setRoundTopRight(10);
        panelRound30.setLayout(new java.awt.BorderLayout());

        panelGradient12.setLayout(new java.awt.FlowLayout());
        panelRound30.add(panelGradient12, java.awt.BorderLayout.NORTH);

        jPanel32.setOpaque(false);
        jPanel32.setLayout(new java.awt.BorderLayout());

        lblTienda.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel32.add(lblTienda, java.awt.BorderLayout.LINE_END);

        jPanel36.setOpaque(false);
        jPanel36.setLayout(new java.awt.BorderLayout());

        jLabel31.setBackground(new java.awt.Color(100, 100, 100));
        jLabel31.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(120, 120, 120));
        jLabel31.setText("Tiendas");
        jLabel31.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel36.add(jLabel31, java.awt.BorderLayout.NORTH);

        lblTienCont.setBackground(new java.awt.Color(25, 180, 98));
        lblTienCont.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblTienCont.setForeground(new java.awt.Color(66, 189, 159));
        lblTienCont.setText("0");
        lblTienCont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel36.add(lblTienCont, java.awt.BorderLayout.CENTER);

        jPanel32.add(jPanel36, java.awt.BorderLayout.CENTER);

        panelRound30.add(jPanel32, java.awt.BorderLayout.CENTER);

        panelRound12.add(panelRound30);

        panelRound35.setBackground(new java.awt.Color(40, 40, 40));
        panelRound35.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound35.setRoundBottomLeft(10);
        panelRound35.setRoundBottomRight(10);
        panelRound35.setRoundTopLeft(10);
        panelRound35.setRoundTopRight(10);
        panelRound35.setLayout(new java.awt.BorderLayout());

        panelGradient14.setLayout(new java.awt.FlowLayout());
        panelRound35.add(panelGradient14, java.awt.BorderLayout.NORTH);

        jPanel37.setOpaque(false);
        jPanel37.setLayout(new java.awt.BorderLayout());

        lblClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel37.add(lblClientes, java.awt.BorderLayout.LINE_END);

        jPanel38.setOpaque(false);
        jPanel38.setLayout(new java.awt.BorderLayout());

        lblCliCont.setBackground(new java.awt.Color(25, 180, 98));
        lblCliCont.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblCliCont.setForeground(new java.awt.Color(66, 189, 159));
        lblCliCont.setText("0");
        lblCliCont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel38.add(lblCliCont, java.awt.BorderLayout.CENTER);

        jLabel35.setBackground(new java.awt.Color(100, 100, 100));
        jLabel35.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(120, 120, 120));
        jLabel35.setText("Clientes");
        jLabel35.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel38.add(jLabel35, java.awt.BorderLayout.NORTH);

        jPanel37.add(jPanel38, java.awt.BorderLayout.CENTER);

        panelRound35.add(jPanel37, java.awt.BorderLayout.CENTER);

        panelRound12.add(panelRound35);

        panelRound36.setBackground(new java.awt.Color(40, 40, 40));
        panelRound36.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound36.setRoundBottomLeft(10);
        panelRound36.setRoundBottomRight(10);
        panelRound36.setRoundTopLeft(10);
        panelRound36.setRoundTopRight(10);
        panelRound36.setLayout(new java.awt.BorderLayout());

        panelGradient15.setLayout(new java.awt.FlowLayout());
        panelRound36.add(panelGradient15, java.awt.BorderLayout.NORTH);

        jPanel39.setOpaque(false);
        jPanel39.setLayout(new java.awt.BorderLayout());

        lblInv.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel39.add(lblInv, java.awt.BorderLayout.LINE_END);

        jPanel43.setOpaque(false);
        jPanel43.setLayout(new java.awt.BorderLayout());

        lblInvCont.setBackground(new java.awt.Color(25, 180, 98));
        lblInvCont.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblInvCont.setForeground(new java.awt.Color(66, 189, 159));
        lblInvCont.setText("0");
        lblInvCont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel43.add(lblInvCont, java.awt.BorderLayout.CENTER);

        jLabel37.setBackground(new java.awt.Color(100, 100, 100));
        jLabel37.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(120, 120, 120));
        jLabel37.setText("Inventario");
        jLabel37.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel43.add(jLabel37, java.awt.BorderLayout.NORTH);

        jPanel39.add(jPanel43, java.awt.BorderLayout.CENTER);

        panelRound36.add(jPanel39, java.awt.BorderLayout.CENTER);

        panelRound12.add(panelRound36);

        jPanel52.add(panelRound12, java.awt.BorderLayout.CENTER);

        jLabel53.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(245, 245, 245));
        jLabel53.setText("Resumen General");
        jLabel53.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel52.add(jLabel53, java.awt.BorderLayout.PAGE_START);

        pnlPrincipal.add(jPanel52);

        jPanel53.setOpaque(false);
        jPanel53.setLayout(new java.awt.BorderLayout());

        panelRound18.setBackground(new java.awt.Color(10, 10, 10));
        panelRound18.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound18.setRoundBottomLeft(20);
        panelRound18.setRoundBottomRight(20);
        panelRound18.setRoundTopLeft(20);
        panelRound18.setRoundTopRight(20);
        panelRound18.setLayout(new java.awt.GridLayout(2, 2, 10, 10));

        panelRound38.setBackground(new java.awt.Color(40, 40, 40));
        panelRound38.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound38.setRoundBottomLeft(10);
        panelRound38.setRoundBottomRight(10);
        panelRound38.setRoundTopLeft(10);
        panelRound38.setRoundTopRight(10);
        panelRound38.setLayout(new java.awt.BorderLayout());

        panelGradient17.setLayout(new java.awt.FlowLayout());
        panelRound38.add(panelGradient17, java.awt.BorderLayout.NORTH);

        jPanel44.setOpaque(false);
        jPanel44.setLayout(new java.awt.BorderLayout());

        lblVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel44.add(lblVentas, java.awt.BorderLayout.LINE_END);

        jPanel45.setOpaque(false);
        jPanel45.setLayout(new java.awt.BorderLayout());

        lblCompraCont.setBackground(new java.awt.Color(25, 180, 98));
        lblCompraCont.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblCompraCont.setForeground(new java.awt.Color(220, 142, 61));
        lblCompraCont.setText("0");
        lblCompraCont.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel45.add(lblCompraCont, java.awt.BorderLayout.CENTER);

        jLabel45.setBackground(new java.awt.Color(100, 100, 100));
        jLabel45.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(130, 130, 130));
        jLabel45.setText("Ventas");
        jLabel45.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel45.add(jLabel45, java.awt.BorderLayout.NORTH);

        jPanel44.add(jPanel45, java.awt.BorderLayout.CENTER);

        panelRound38.add(jPanel44, java.awt.BorderLayout.CENTER);

        panelRound18.add(panelRound38);

        panelRound39.setBackground(new java.awt.Color(40, 40, 40));
        panelRound39.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound39.setRoundBottomLeft(10);
        panelRound39.setRoundBottomRight(10);
        panelRound39.setRoundTopLeft(10);
        panelRound39.setRoundTopRight(10);
        panelRound39.setLayout(new java.awt.BorderLayout());

        panelGradient18.setLayout(new java.awt.FlowLayout());
        panelRound39.add(panelGradient18, java.awt.BorderLayout.NORTH);

        jPanel46.setOpaque(false);
        jPanel46.setLayout(new java.awt.BorderLayout());

        lblIngresosVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel46.add(lblIngresosVentas, java.awt.BorderLayout.LINE_END);

        jPanel47.setOpaque(false);
        jPanel47.setLayout(new java.awt.BorderLayout());

        lblCantVendida.setBackground(new java.awt.Color(25, 180, 98));
        lblCantVendida.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        lblCantVendida.setForeground(new java.awt.Color(246, 205, 61));
        lblCantVendida.setText("$0");
        lblCantVendida.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel47.add(lblCantVendida, java.awt.BorderLayout.CENTER);

        jLabel47.setBackground(new java.awt.Color(100, 100, 100));
        jLabel47.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(130, 130, 130));
        jLabel47.setText("Ingresos Mensuales");
        jLabel47.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel47.add(jLabel47, java.awt.BorderLayout.NORTH);

        jPanel46.add(jPanel47, java.awt.BorderLayout.CENTER);

        panelRound39.add(jPanel46, java.awt.BorderLayout.CENTER);

        panelRound18.add(panelRound39);

        panelRound40.setBackground(new java.awt.Color(40, 40, 40));
        panelRound40.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound40.setRoundBottomLeft(10);
        panelRound40.setRoundBottomRight(10);
        panelRound40.setRoundTopLeft(10);
        panelRound40.setRoundTopRight(10);
        panelRound40.setLayout(new java.awt.BorderLayout());

        panelGradient19.setLayout(new java.awt.FlowLayout());
        panelRound40.add(panelGradient19, java.awt.BorderLayout.NORTH);

        jPanel48.setOpaque(false);
        jPanel48.setLayout(new java.awt.BorderLayout());

        lblMasVendido.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel48.add(lblMasVendido, java.awt.BorderLayout.LINE_END);

        jPanel49.setOpaque(false);
        jPanel49.setLayout(new java.awt.BorderLayout());

        lblJuegoMasVen.setBackground(new java.awt.Color(25, 180, 98));
        lblJuegoMasVen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblJuegoMasVen.setForeground(new java.awt.Color(25, 180, 98));
        lblJuegoMasVen.setText("null");
        lblJuegoMasVen.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel49.add(lblJuegoMasVen, java.awt.BorderLayout.CENTER);

        jLabel49.setBackground(new java.awt.Color(100, 100, 100));
        jLabel49.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(130, 130, 130));
        jLabel49.setText("+ Vendido");
        jLabel49.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel49.add(jLabel49, java.awt.BorderLayout.NORTH);

        lblJuegoMasVenCant.setBackground(new java.awt.Color(15, 15, 15));
        lblJuegoMasVenCant.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblJuegoMasVenCant.setForeground(new java.awt.Color(200, 200, 200));
        lblJuegoMasVenCant.setText("null");
        lblJuegoMasVenCant.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel49.add(lblJuegoMasVenCant, java.awt.BorderLayout.SOUTH);

        jPanel48.add(jPanel49, java.awt.BorderLayout.CENTER);

        panelRound40.add(jPanel48, java.awt.BorderLayout.CENTER);

        panelRound18.add(panelRound40);

        panelRound41.setBackground(new java.awt.Color(40, 40, 40));
        panelRound41.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound41.setRoundBottomLeft(10);
        panelRound41.setRoundBottomRight(10);
        panelRound41.setRoundTopLeft(10);
        panelRound41.setRoundTopRight(10);
        panelRound41.setLayout(new java.awt.BorderLayout());

        panelGradient20.setLayout(new java.awt.FlowLayout());
        panelRound41.add(panelGradient20, java.awt.BorderLayout.NORTH);

        jPanel50.setOpaque(false);
        jPanel50.setLayout(new java.awt.BorderLayout());

        lblMenosVendido.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel50.add(lblMenosVendido, java.awt.BorderLayout.LINE_END);

        jPanel51.setOpaque(false);
        jPanel51.setLayout(new java.awt.BorderLayout());

        jLabel51.setBackground(new java.awt.Color(100, 100, 100));
        jLabel51.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(130, 130, 130));
        jLabel51.setText("- Vendido");
        jLabel51.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel51.add(jLabel51, java.awt.BorderLayout.NORTH);

        lblJuegoMenosVen.setBackground(new java.awt.Color(25, 180, 98));
        lblJuegoMenosVen.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblJuegoMenosVen.setForeground(new java.awt.Color(247, 81, 101));
        lblJuegoMenosVen.setText("null");
        lblJuegoMenosVen.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel51.add(lblJuegoMenosVen, java.awt.BorderLayout.CENTER);

        lblJuegoMenosVenCant.setBackground(new java.awt.Color(15, 15, 15));
        lblJuegoMenosVenCant.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lblJuegoMenosVenCant.setForeground(new java.awt.Color(200, 200, 200));
        lblJuegoMenosVenCant.setText("null");
        lblJuegoMenosVenCant.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel51.add(lblJuegoMenosVenCant, java.awt.BorderLayout.SOUTH);

        jPanel50.add(jPanel51, java.awt.BorderLayout.CENTER);

        panelRound41.add(jPanel50, java.awt.BorderLayout.CENTER);

        panelRound18.add(panelRound41);

        jPanel53.add(panelRound18, java.awt.BorderLayout.CENTER);

        jLabel54.setFont(new java.awt.Font("Segoe UI Light", 0, 28)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(245, 245, 245));
        jLabel54.setText("Datos Importantes");
        jLabel54.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel53.add(jLabel54, java.awt.BorderLayout.PAGE_START);

        pnlPrincipal.add(jPanel53);

        pnlMain.add(pnlPrincipal, "cardPrincipal");

        pnlVideojuegos.setOpaque(false);
        pnlVideojuegos.setLayout(new java.awt.BorderLayout());

        pnlOpcVideojuegos.setBackground(new java.awt.Color(20, 20, 20));
        pnlOpcVideojuegos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 0));
        pnlOpcVideojuegos.setRoundBottomLeft(15);
        pnlOpcVideojuegos.setRoundBottomRight(15);
        pnlOpcVideojuegos.setRoundTopLeft(15);
        pnlOpcVideojuegos.setRoundTopRight(15);
        pnlOpcVideojuegos.setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        pnlVideojuegos.add(pnlOpcVideojuegos, java.awt.BorderLayout.EAST);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(1, 1));

        panelRound2.setBackground(new java.awt.Color(10, 10, 10));
        panelRound2.setRoundBottomLeft(15);
        panelRound2.setRoundBottomRight(15);
        panelRound2.setRoundTopLeft(15);
        panelRound2.setRoundTopRight(15);
        panelRound2.setLayout(new java.awt.BorderLayout());

        panelRound3.setBackground(new java.awt.Color(10, 10, 10));
        panelRound3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound3.setRoundTopLeft(15);
        panelRound3.setRoundTopRight(15);
        panelRound3.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        panelRound5.setBackground(new java.awt.Color(40, 40, 40));
        panelRound5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound5.setRoundBottomLeft(10);
        panelRound5.setRoundBottomRight(10);
        panelRound5.setRoundTopLeft(10);
        panelRound5.setRoundTopRight(10);
        panelRound5.setLayout(new java.awt.BorderLayout());

        panelGradient1.setLayout(new java.awt.FlowLayout());
        panelRound5.add(panelGradient1, java.awt.BorderLayout.NORTH);

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        lblCategoria.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel5.add(lblCategoria, java.awt.BorderLayout.LINE_END);

        jPanel9.setOpaque(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel10.setBackground(new java.awt.Color(100, 100, 100));
        jLabel10.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(120, 120, 120));
        jLabel10.setText("Categoria mas popular");
        jLabel10.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel9.add(jLabel10, java.awt.BorderLayout.NORTH);

        lblCatPopular.setBackground(new java.awt.Color(25, 180, 98));
        lblCatPopular.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCatPopular.setForeground(new java.awt.Color(66, 189, 159));
        lblCatPopular.setText("Aventura");
        lblCatPopular.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel9.add(lblCatPopular, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel9, java.awt.BorderLayout.CENTER);

        panelRound5.add(jPanel5, java.awt.BorderLayout.CENTER);

        panelRound3.add(panelRound5);

        panelRound6.setBackground(new java.awt.Color(40, 40, 40));
        panelRound6.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound6.setRoundBottomLeft(10);
        panelRound6.setRoundBottomRight(10);
        panelRound6.setRoundTopLeft(10);
        panelRound6.setRoundTopRight(10);
        panelRound6.setLayout(new java.awt.BorderLayout());

        panelGradient2.setLayout(new java.awt.FlowLayout());
        panelRound6.add(panelGradient2, java.awt.BorderLayout.NORTH);

        jPanel10.setOpaque(false);
        jPanel10.setLayout(new java.awt.BorderLayout());

        lblMasVend.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel10.add(lblMasVend, java.awt.BorderLayout.LINE_END);

        jPanel11.setOpaque(false);
        jPanel11.setLayout(new java.awt.BorderLayout());

        jLabel12.setBackground(new java.awt.Color(100, 100, 100));
        jLabel12.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(120, 120, 120));
        jLabel12.setText("Videojuego + vendido");
        jLabel12.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel11.add(jLabel12, java.awt.BorderLayout.NORTH);

        lblJuegoMasVend.setBackground(new java.awt.Color(25, 180, 98));
        lblJuegoMasVend.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJuegoMasVend.setForeground(new java.awt.Color(66, 189, 159));
        lblJuegoMasVend.setText("GTA V");
        lblJuegoMasVend.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel11.add(lblJuegoMasVend, java.awt.BorderLayout.CENTER);

        jPanel10.add(jPanel11, java.awt.BorderLayout.CENTER);

        panelRound6.add(jPanel10, java.awt.BorderLayout.CENTER);

        panelRound3.add(panelRound6);

        panelRound7.setBackground(new java.awt.Color(40, 40, 40));
        panelRound7.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound7.setRoundBottomLeft(10);
        panelRound7.setRoundBottomRight(10);
        panelRound7.setRoundTopLeft(10);
        panelRound7.setRoundTopRight(10);
        panelRound7.setLayout(new java.awt.BorderLayout());

        panelGradient3.setLayout(new java.awt.FlowLayout());
        panelRound7.add(panelGradient3, java.awt.BorderLayout.NORTH);

        jPanel12.setOpaque(false);
        jPanel12.setLayout(new java.awt.BorderLayout());

        lblMenosVend.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel12.add(lblMenosVend, java.awt.BorderLayout.LINE_END);

        jPanel13.setOpaque(false);
        jPanel13.setLayout(new java.awt.BorderLayout());

        jLabel15.setBackground(new java.awt.Color(100, 100, 100));
        jLabel15.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(120, 120, 120));
        jLabel15.setText("Videojuego - vendido");
        jLabel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel13.add(jLabel15, java.awt.BorderLayout.NORTH);

        lblJuegoMenosVend.setBackground(new java.awt.Color(25, 180, 98));
        lblJuegoMenosVend.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblJuegoMenosVend.setForeground(new java.awt.Color(66, 189, 159));
        lblJuegoMenosVend.setText("RD2");
        lblJuegoMenosVend.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel13.add(lblJuegoMenosVend, java.awt.BorderLayout.CENTER);

        jPanel12.add(jPanel13, java.awt.BorderLayout.CENTER);

        panelRound7.add(jPanel12, java.awt.BorderLayout.CENTER);

        panelRound3.add(panelRound7);

        panelRound2.add(panelRound3, java.awt.BorderLayout.NORTH);

        panelRound4.setBackground(new java.awt.Color(10, 10, 10));
        panelRound4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelRound4.setRoundBottomLeft(15);
        panelRound4.setRoundBottomRight(15);
        panelRound4.setLayout(new java.awt.BorderLayout());

        pnlOpcionesVideojuegos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        pnlOpcionesVideojuegos.setOpaque(false);
        pnlOpcionesVideojuegos.setLayout(new java.awt.CardLayout());

        vidAlta.setOpaque(false);
        vidAlta.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsVideojuegosAlta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsVideojuegosAlta.setOpaque(false);
        pnlButtonsVideojuegosAlta.setLayout(new java.awt.BorderLayout(5, 5));
        vidAlta.add(pnlButtonsVideojuegosAlta, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos3.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos3.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos3.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos3.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos3.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos3.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos3.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAlta.add(txtBusquedaVideojuegos3, java.awt.BorderLayout.CENTER);

        pnlOpcionesVideojuegos.add(vidAlta, "card1");

        vidElim.setOpaque(false);
        vidElim.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsVideojuegosElim.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsVideojuegosElim.setOpaque(false);
        pnlButtonsVideojuegosElim.setLayout(new java.awt.BorderLayout(5, 5));
        vidElim.add(pnlButtonsVideojuegosElim, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidElim.add(txtBusquedaVideojuegos, java.awt.BorderLayout.CENTER);

        pnlOpcionesVideojuegos.add(vidElim, "card2");

        vidAct.setOpaque(false);
        vidAct.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsVideojuegosAct.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsVideojuegosAct.setOpaque(false);
        pnlButtonsVideojuegosAct.setLayout(new java.awt.BorderLayout(5, 5));
        vidAct.add(pnlButtonsVideojuegosAct, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos1.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos1.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos1.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos1.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos1.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos1.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAct.add(txtBusquedaVideojuegos1, java.awt.BorderLayout.CENTER);

        pnlOpcionesVideojuegos.add(vidAct, "card3");

        vidMostrar.setOpaque(false);
        vidMostrar.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsVideojuegosMostrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsVideojuegosMostrar.setOpaque(false);
        pnlButtonsVideojuegosMostrar.setLayout(new java.awt.BorderLayout(5, 5));

        comboVideojuegos.setBackground(new java.awt.Color(30, 30, 30));
        comboVideojuegos.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        comboVideojuegos.setForeground(new java.awt.Color(200, 200, 200));
        comboVideojuegos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Categoria", "Precio", "Cont. Categoria" }));
        comboVideojuegos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        pnlButtonsVideojuegosMostrar.add(comboVideojuegos, java.awt.BorderLayout.CENTER);

        vidMostrar.add(pnlButtonsVideojuegosMostrar, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos2.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos2.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos2.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos2.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos2.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos2.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidMostrar.add(txtBusquedaVideojuegos2, java.awt.BorderLayout.CENTER);

        pnlOpcionesVideojuegos.add(vidMostrar, "card4");

        panelRound4.add(pnlOpcionesVideojuegos, java.awt.BorderLayout.PAGE_START);

        tbVideojuegos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbVideojuegos.setGridColor(new java.awt.Color(40, 40, 40));
        tbVideojuegos.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbVideojuegos.setSelectionForeground(new java.awt.Color(10, 10, 10));
        tbVideojuegos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollVideojuegos.setViewportView(tbVideojuegos);

        panelRound4.add(scrollVideojuegos, java.awt.BorderLayout.CENTER);

        panelRound2.add(panelRound4, java.awt.BorderLayout.CENTER);

        jPanel3.add(panelRound2);

        pnlVideojuegos.add(jPanel3, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlVideojuegos, "cardVideojuegos");

        pnlTiendas.setOpaque(false);
        pnlTiendas.setLayout(new java.awt.BorderLayout());

        pnlOpcTiendas.setBackground(new java.awt.Color(20, 20, 20));
        pnlOpcTiendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 0));
        pnlOpcTiendas.setRoundBottomLeft(15);
        pnlOpcTiendas.setRoundBottomRight(15);
        pnlOpcTiendas.setRoundTopLeft(15);
        pnlOpcTiendas.setRoundTopRight(15);
        pnlOpcTiendas.setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        pnlTiendas.add(pnlOpcTiendas, java.awt.BorderLayout.EAST);

        jPanel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.GridLayout(1, 1));

        panelRound8.setBackground(new java.awt.Color(10, 10, 10));
        panelRound8.setRoundBottomLeft(15);
        panelRound8.setRoundBottomRight(15);
        panelRound8.setRoundTopLeft(15);
        panelRound8.setRoundTopRight(15);
        panelRound8.setLayout(new java.awt.BorderLayout());

        panelRound9.setBackground(new java.awt.Color(10, 10, 10));
        panelRound9.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound9.setRoundTopLeft(15);
        panelRound9.setRoundTopRight(15);
        panelRound9.setLayout(new java.awt.GridLayout(1, 2, 10, 0));

        panelRound10.setBackground(new java.awt.Color(40, 40, 40));
        panelRound10.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound10.setRoundBottomLeft(10);
        panelRound10.setRoundBottomRight(10);
        panelRound10.setRoundTopLeft(10);
        panelRound10.setRoundTopRight(10);
        panelRound10.setLayout(new java.awt.BorderLayout());

        panelGradient4.setLayout(new java.awt.FlowLayout());
        panelRound10.add(panelGradient4, java.awt.BorderLayout.NORTH);

        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.BorderLayout());

        lblTiendaMas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel8.add(lblTiendaMas, java.awt.BorderLayout.LINE_END);

        jPanel14.setOpaque(false);
        jPanel14.setLayout(new java.awt.BorderLayout());

        lblTiendaMasVentas.setBackground(new java.awt.Color(25, 180, 98));
        lblTiendaMasVentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTiendaMasVentas.setForeground(new java.awt.Color(66, 189, 159));
        lblTiendaMasVentas.setText("GameStore");
        lblTiendaMasVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel14.add(lblTiendaMasVentas, java.awt.BorderLayout.CENTER);

        jLabel11.setBackground(new java.awt.Color(100, 100, 100));
        jLabel11.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(120, 120, 120));
        jLabel11.setText("Tienda con + ganancias");
        jLabel11.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel14.add(jLabel11, java.awt.BorderLayout.NORTH);

        jPanel8.add(jPanel14, java.awt.BorderLayout.CENTER);

        panelRound10.add(jPanel8, java.awt.BorderLayout.CENTER);

        panelRound9.add(panelRound10);

        panelRound11.setBackground(new java.awt.Color(40, 40, 40));
        panelRound11.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound11.setRoundBottomLeft(10);
        panelRound11.setRoundBottomRight(10);
        panelRound11.setRoundTopLeft(10);
        panelRound11.setRoundTopRight(10);
        panelRound11.setLayout(new java.awt.BorderLayout());

        panelGradient5.setLayout(new java.awt.FlowLayout());
        panelRound11.add(panelGradient5, java.awt.BorderLayout.NORTH);

        jPanel15.setOpaque(false);
        jPanel15.setLayout(new java.awt.BorderLayout());

        lblTiendaMasVisitada.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel15.add(lblTiendaMasVisitada, java.awt.BorderLayout.LINE_END);

        jPanel16.setOpaque(false);
        jPanel16.setLayout(new java.awt.BorderLayout());

        jLabel17.setBackground(new java.awt.Color(100, 100, 100));
        jLabel17.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(120, 120, 120));
        jLabel17.setText("Tienda con - ganancias");
        jLabel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel16.add(jLabel17, java.awt.BorderLayout.NORTH);

        lblTiendaMenosVentas.setBackground(new java.awt.Color(25, 180, 98));
        lblTiendaMenosVentas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTiendaMenosVentas.setForeground(new java.awt.Color(66, 189, 159));
        lblTiendaMenosVentas.setText("GamePlanet");
        lblTiendaMenosVentas.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel16.add(lblTiendaMenosVentas, java.awt.BorderLayout.CENTER);

        jPanel15.add(jPanel16, java.awt.BorderLayout.CENTER);

        panelRound11.add(jPanel15, java.awt.BorderLayout.CENTER);

        panelRound9.add(panelRound11);

        panelRound8.add(panelRound9, java.awt.BorderLayout.NORTH);

        panelRound13.setBackground(new java.awt.Color(10, 10, 10));
        panelRound13.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelRound13.setRoundBottomLeft(15);
        panelRound13.setRoundBottomRight(15);
        panelRound13.setLayout(new java.awt.BorderLayout());

        tbTiendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTiendas.setGridColor(new java.awt.Color(40, 40, 40));
        tbTiendas.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbTiendas.setSelectionForeground(new java.awt.Color(10, 10, 10));
        tbTiendas.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollTiendas.setViewportView(tbTiendas);

        panelRound13.add(scrollTiendas, java.awt.BorderLayout.CENTER);

        pnlOpcionesTiendas.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        pnlOpcionesTiendas.setOpaque(false);
        pnlOpcionesTiendas.setLayout(new java.awt.CardLayout());

        vidAlta1.setOpaque(false);
        vidAlta1.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsTiendasAlta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsTiendasAlta.setOpaque(false);
        pnlButtonsTiendasAlta.setLayout(new java.awt.BorderLayout(5, 5));
        vidAlta1.add(pnlButtonsTiendasAlta, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos4.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos4.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos4.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos4.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos4.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos4.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAlta1.add(txtBusquedaVideojuegos4, java.awt.BorderLayout.CENTER);

        pnlOpcionesTiendas.add(vidAlta1, "card1");

        vidElim1.setOpaque(false);
        vidElim1.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsTiendasElim.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsTiendasElim.setOpaque(false);
        pnlButtonsTiendasElim.setLayout(new java.awt.BorderLayout(5, 5));
        vidElim1.add(pnlButtonsTiendasElim, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos5.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos5.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos5.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos5.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos5.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos5.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos5.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos5.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidElim1.add(txtBusquedaVideojuegos5, java.awt.BorderLayout.CENTER);

        pnlOpcionesTiendas.add(vidElim1, "card2");

        vidAct1.setOpaque(false);
        vidAct1.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsTiendasAct.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsTiendasAct.setOpaque(false);
        pnlButtonsTiendasAct.setLayout(new java.awt.BorderLayout(5, 5));
        vidAct1.add(pnlButtonsTiendasAct, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos6.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos6.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos6.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos6.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos6.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos6.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos6.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos6.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAct1.add(txtBusquedaVideojuegos6, java.awt.BorderLayout.CENTER);

        pnlOpcionesTiendas.add(vidAct1, "card3");

        vidMostrar1.setOpaque(false);
        vidMostrar1.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsTiendasMostrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsTiendasMostrar.setOpaque(false);
        pnlButtonsTiendasMostrar.setLayout(new java.awt.BorderLayout(5, 5));

        comboTiendas.setBackground(new java.awt.Color(30, 30, 30));
        comboTiendas.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        comboTiendas.setForeground(new java.awt.Color(200, 200, 200));
        comboTiendas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Domicilio", "Cont. Empleados", "Cont. Ventas" }));
        comboTiendas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        pnlButtonsTiendasMostrar.add(comboTiendas, java.awt.BorderLayout.CENTER);

        vidMostrar1.add(pnlButtonsTiendasMostrar, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos7.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos7.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos7.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos7.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos7.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos7.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos7.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidMostrar1.add(txtBusquedaVideojuegos7, java.awt.BorderLayout.CENTER);

        pnlOpcionesTiendas.add(vidMostrar1, "card4");

        panelRound13.add(pnlOpcionesTiendas, java.awt.BorderLayout.PAGE_START);

        panelRound8.add(panelRound13, java.awt.BorderLayout.CENTER);

        jPanel6.add(panelRound8);

        pnlTiendas.add(jPanel6, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlTiendas, "cardTiendas");

        pnlEmpleados.setOpaque(false);
        pnlEmpleados.setLayout(new java.awt.BorderLayout());

        pnlOpcEmpleados.setBackground(new java.awt.Color(20, 20, 20));
        pnlOpcEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 0));
        pnlOpcEmpleados.setRoundBottomLeft(15);
        pnlOpcEmpleados.setRoundBottomRight(15);
        pnlOpcEmpleados.setRoundTopLeft(15);
        pnlOpcEmpleados.setRoundTopRight(15);
        pnlOpcEmpleados.setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        pnlEmpleados.add(pnlOpcEmpleados, java.awt.BorderLayout.EAST);

        jPanel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel19.setOpaque(false);
        jPanel19.setLayout(new java.awt.GridLayout(1, 1));

        panelRound14.setBackground(new java.awt.Color(10, 10, 10));
        panelRound14.setRoundBottomLeft(15);
        panelRound14.setRoundBottomRight(15);
        panelRound14.setRoundTopLeft(15);
        panelRound14.setRoundTopRight(15);
        panelRound14.setLayout(new java.awt.BorderLayout());

        panelRound15.setBackground(new java.awt.Color(10, 10, 10));
        panelRound15.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound15.setRoundTopLeft(15);
        panelRound15.setRoundTopRight(15);
        panelRound15.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        panelRound16.setBackground(new java.awt.Color(40, 40, 40));
        panelRound16.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound16.setRoundBottomLeft(10);
        panelRound16.setRoundBottomRight(10);
        panelRound16.setRoundTopLeft(10);
        panelRound16.setRoundTopRight(10);
        panelRound16.setLayout(new java.awt.BorderLayout());

        panelGradient7.setLayout(new java.awt.FlowLayout());
        panelRound16.add(panelGradient7, java.awt.BorderLayout.NORTH);

        jPanel20.setOpaque(false);
        jPanel20.setLayout(new java.awt.BorderLayout());

        lblEmpleadoSueldo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel20.add(lblEmpleadoSueldo, java.awt.BorderLayout.LINE_END);

        jPanel21.setOpaque(false);
        jPanel21.setLayout(new java.awt.BorderLayout());

        jLabel21.setBackground(new java.awt.Color(100, 100, 100));
        jLabel21.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(120, 120, 120));
        jLabel21.setText("Empleado con mejor sueldo");
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel21.add(jLabel21, java.awt.BorderLayout.NORTH);

        lblEmpMejorSueldo.setBackground(new java.awt.Color(25, 180, 98));
        lblEmpMejorSueldo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmpMejorSueldo.setForeground(new java.awt.Color(66, 189, 159));
        lblEmpMejorSueldo.setText("Arturo");
        lblEmpMejorSueldo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel21.add(lblEmpMejorSueldo, java.awt.BorderLayout.CENTER);

        jPanel20.add(jPanel21, java.awt.BorderLayout.CENTER);

        panelRound16.add(jPanel20, java.awt.BorderLayout.CENTER);

        panelRound15.add(panelRound16);

        panelRound17.setBackground(new java.awt.Color(40, 40, 40));
        panelRound17.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound17.setRoundBottomLeft(10);
        panelRound17.setRoundBottomRight(10);
        panelRound17.setRoundTopLeft(10);
        panelRound17.setRoundTopRight(10);
        panelRound17.setLayout(new java.awt.BorderLayout());

        panelGradient8.setLayout(new java.awt.FlowLayout());
        panelRound17.add(panelGradient8, java.awt.BorderLayout.NORTH);

        jPanel22.setOpaque(false);
        jPanel22.setLayout(new java.awt.BorderLayout());

        lblEmpleadoAtento.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel22.add(lblEmpleadoAtento, java.awt.BorderLayout.LINE_END);

        jPanel23.setOpaque(false);
        jPanel23.setLayout(new java.awt.BorderLayout());

        jLabel23.setBackground(new java.awt.Color(100, 100, 100));
        jLabel23.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(120, 120, 120));
        jLabel23.setText("Empleado + atento");
        jLabel23.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel23.add(jLabel23, java.awt.BorderLayout.NORTH);

        lblEmpMasAtenciones.setBackground(new java.awt.Color(25, 180, 98));
        lblEmpMasAtenciones.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmpMasAtenciones.setForeground(new java.awt.Color(66, 189, 159));
        lblEmpMasAtenciones.setText("Rodrigo");
        lblEmpMasAtenciones.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel23.add(lblEmpMasAtenciones, java.awt.BorderLayout.CENTER);

        jPanel22.add(jPanel23, java.awt.BorderLayout.CENTER);

        panelRound17.add(jPanel22, java.awt.BorderLayout.CENTER);

        panelRound15.add(panelRound17);

        panelRound14.add(panelRound15, java.awt.BorderLayout.NORTH);

        panelRound19.setBackground(new java.awt.Color(10, 10, 10));
        panelRound19.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelRound19.setRoundBottomLeft(15);
        panelRound19.setRoundBottomRight(15);
        panelRound19.setLayout(new java.awt.BorderLayout());

        tbEmp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbEmp.setGridColor(new java.awt.Color(40, 40, 40));
        tbEmp.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbEmp.setSelectionForeground(new java.awt.Color(10, 10, 10));
        tbEmp.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollEmp.setViewportView(tbEmp);

        panelRound19.add(scrollEmp, java.awt.BorderLayout.CENTER);

        pnlOpcionesEmpleados.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        pnlOpcionesEmpleados.setOpaque(false);
        pnlOpcionesEmpleados.setLayout(new java.awt.CardLayout());

        vidAlta2.setOpaque(false);
        vidAlta2.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsEmpleadosAlta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsEmpleadosAlta.setOpaque(false);
        pnlButtonsEmpleadosAlta.setLayout(new java.awt.BorderLayout(5, 5));
        vidAlta2.add(pnlButtonsEmpleadosAlta, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos8.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos8.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos8.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos8.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos8.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos8.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos8.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAlta2.add(txtBusquedaVideojuegos8, java.awt.BorderLayout.CENTER);

        pnlOpcionesEmpleados.add(vidAlta2, "card1");

        vidElim2.setOpaque(false);
        vidElim2.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsEmpleadosElim.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsEmpleadosElim.setOpaque(false);
        pnlButtonsEmpleadosElim.setLayout(new java.awt.BorderLayout(5, 5));
        vidElim2.add(pnlButtonsEmpleadosElim, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos9.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos9.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos9.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos9.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos9.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos9.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos9.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos9.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidElim2.add(txtBusquedaVideojuegos9, java.awt.BorderLayout.CENTER);

        pnlOpcionesEmpleados.add(vidElim2, "card2");

        vidAct2.setOpaque(false);
        vidAct2.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsEmpleadosAct.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsEmpleadosAct.setOpaque(false);
        pnlButtonsEmpleadosAct.setLayout(new java.awt.BorderLayout(5, 5));
        vidAct2.add(pnlButtonsEmpleadosAct, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos10.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos10.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos10.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos10.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos10.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos10.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos10.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAct2.add(txtBusquedaVideojuegos10, java.awt.BorderLayout.CENTER);

        pnlOpcionesEmpleados.add(vidAct2, "card3");

        vidMostrar2.setOpaque(false);
        vidMostrar2.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsEmpleadosMostrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsEmpleadosMostrar.setOpaque(false);
        pnlButtonsEmpleadosMostrar.setLayout(new java.awt.BorderLayout(5, 5));

        comboEmpleados.setBackground(new java.awt.Color(30, 30, 30));
        comboEmpleados.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        comboEmpleados.setForeground(new java.awt.Color(200, 200, 200));
        comboEmpleados.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Clientes Atendidos" }));
        comboEmpleados.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        pnlButtonsEmpleadosMostrar.add(comboEmpleados, java.awt.BorderLayout.CENTER);

        vidMostrar2.add(pnlButtonsEmpleadosMostrar, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos11.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos11.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos11.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos11.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos11.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos11.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos11.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos11.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidMostrar2.add(txtBusquedaVideojuegos11, java.awt.BorderLayout.CENTER);

        pnlOpcionesEmpleados.add(vidMostrar2, "card4");

        panelRound19.add(pnlOpcionesEmpleados, java.awt.BorderLayout.PAGE_START);

        panelRound14.add(panelRound19, java.awt.BorderLayout.CENTER);

        jPanel19.add(panelRound14);

        pnlEmpleados.add(jPanel19, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlEmpleados, "cardEmpleados");

        pnlClientes.setOpaque(false);
        pnlClientes.setLayout(new java.awt.BorderLayout());

        pnlOpcClientes.setBackground(new java.awt.Color(20, 20, 20));
        pnlOpcClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 0));
        pnlOpcClientes.setRoundBottomLeft(15);
        pnlOpcClientes.setRoundBottomRight(15);
        pnlOpcClientes.setRoundTopLeft(15);
        pnlOpcClientes.setRoundTopRight(15);
        pnlOpcClientes.setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        pnlClientes.add(pnlOpcClientes, java.awt.BorderLayout.EAST);

        jPanel26.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel26.setOpaque(false);
        jPanel26.setLayout(new java.awt.GridLayout(1, 1));

        panelRound20.setBackground(new java.awt.Color(10, 10, 10));
        panelRound20.setRoundBottomLeft(15);
        panelRound20.setRoundBottomRight(15);
        panelRound20.setRoundTopLeft(15);
        panelRound20.setRoundTopRight(15);
        panelRound20.setLayout(new java.awt.BorderLayout());

        panelRound21.setBackground(new java.awt.Color(10, 10, 10));
        panelRound21.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound21.setRoundTopLeft(15);
        panelRound21.setRoundTopRight(15);
        panelRound21.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        panelRound22.setBackground(new java.awt.Color(40, 40, 40));
        panelRound22.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound22.setRoundBottomLeft(10);
        panelRound22.setRoundBottomRight(10);
        panelRound22.setRoundTopLeft(10);
        panelRound22.setRoundTopRight(10);
        panelRound22.setLayout(new java.awt.BorderLayout());

        panelGradient10.setLayout(new java.awt.FlowLayout());
        panelRound22.add(panelGradient10, java.awt.BorderLayout.NORTH);

        jPanel27.setOpaque(false);
        jPanel27.setLayout(new java.awt.BorderLayout());

        lblClienteMejor.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel27.add(lblClienteMejor, java.awt.BorderLayout.LINE_END);

        jPanel28.setOpaque(false);
        jPanel28.setLayout(new java.awt.BorderLayout());

        jLabel27.setBackground(new java.awt.Color(100, 100, 100));
        jLabel27.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(120, 120, 120));
        jLabel27.setText("Mejor cliente");
        jLabel27.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel28.add(jLabel27, java.awt.BorderLayout.NORTH);

        lblMejorCliente.setBackground(new java.awt.Color(25, 180, 98));
        lblMejorCliente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMejorCliente.setForeground(new java.awt.Color(66, 189, 159));
        lblMejorCliente.setText("Pedro");
        lblMejorCliente.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel28.add(lblMejorCliente, java.awt.BorderLayout.CENTER);

        jPanel27.add(jPanel28, java.awt.BorderLayout.CENTER);

        panelRound22.add(jPanel27, java.awt.BorderLayout.CENTER);

        panelRound21.add(panelRound22);

        panelRound20.add(panelRound21, java.awt.BorderLayout.NORTH);

        panelRound25.setBackground(new java.awt.Color(10, 10, 10));
        panelRound25.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelRound25.setRoundBottomLeft(15);
        panelRound25.setRoundBottomRight(15);
        panelRound25.setLayout(new java.awt.BorderLayout());

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbClientes.setGridColor(new java.awt.Color(40, 40, 40));
        tbClientes.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbClientes.setSelectionForeground(new java.awt.Color(10, 10, 10));
        tbClientes.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollClientes.setViewportView(tbClientes);

        panelRound25.add(scrollClientes, java.awt.BorderLayout.CENTER);

        pnlOpcionesClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        pnlOpcionesClientes.setOpaque(false);
        pnlOpcionesClientes.setLayout(new java.awt.CardLayout());

        vidAlta3.setOpaque(false);
        vidAlta3.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsClientesAlta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsClientesAlta.setOpaque(false);
        pnlButtonsClientesAlta.setLayout(new java.awt.BorderLayout(5, 5));
        vidAlta3.add(pnlButtonsClientesAlta, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos12.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos12.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos12.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos12.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos12.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos12.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos12.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos12.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAlta3.add(txtBusquedaVideojuegos12, java.awt.BorderLayout.CENTER);

        pnlOpcionesClientes.add(vidAlta3, "card1");

        vidElim3.setOpaque(false);
        vidElim3.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsClientesElim.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsClientesElim.setOpaque(false);
        pnlButtonsClientesElim.setLayout(new java.awt.BorderLayout(5, 5));
        vidElim3.add(pnlButtonsClientesElim, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos13.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos13.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos13.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos13.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos13.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos13.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos13.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidElim3.add(txtBusquedaVideojuegos13, java.awt.BorderLayout.CENTER);

        pnlOpcionesClientes.add(vidElim3, "card2");

        vidAct3.setOpaque(false);
        vidAct3.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsClientesAct.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsClientesAct.setOpaque(false);
        pnlButtonsClientesAct.setLayout(new java.awt.BorderLayout(5, 5));
        vidAct3.add(pnlButtonsClientesAct, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos14.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos14.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos14.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos14.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos14.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos14.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos14.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos14.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAct3.add(txtBusquedaVideojuegos14, java.awt.BorderLayout.CENTER);

        pnlOpcionesClientes.add(vidAct3, "card3");

        vidMostrar3.setOpaque(false);
        vidMostrar3.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsClientesMostrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsClientesMostrar.setOpaque(false);
        pnlButtonsClientesMostrar.setLayout(new java.awt.BorderLayout(5, 5));

        comboClientes.setBackground(new java.awt.Color(30, 30, 30));
        comboClientes.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        comboClientes.setForeground(new java.awt.Color(200, 200, 200));
        comboClientes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Ap. Paterno", "Ap. Materno", "Fecha Nac.", "Telefono", "Domicilio", "Correo", "Cont. Compras" }));
        comboClientes.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        pnlButtonsClientesMostrar.add(comboClientes, java.awt.BorderLayout.CENTER);

        vidMostrar3.add(pnlButtonsClientesMostrar, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos15.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos15.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos15.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos15.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos15.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos15.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos15.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos15.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidMostrar3.add(txtBusquedaVideojuegos15, java.awt.BorderLayout.CENTER);

        pnlOpcionesClientes.add(vidMostrar3, "card4");

        panelRound25.add(pnlOpcionesClientes, java.awt.BorderLayout.PAGE_START);

        panelRound20.add(panelRound25, java.awt.BorderLayout.CENTER);

        jPanel26.add(panelRound20);

        pnlClientes.add(jPanel26, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlClientes, "cardClientes");

        pnlProveedores.setOpaque(false);
        pnlProveedores.setLayout(new java.awt.BorderLayout());

        pnlOpcProveedores.setBackground(new java.awt.Color(20, 20, 20));
        pnlOpcProveedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 0));
        pnlOpcProveedores.setRoundBottomLeft(15);
        pnlOpcProveedores.setRoundBottomRight(15);
        pnlOpcProveedores.setRoundTopLeft(15);
        pnlOpcProveedores.setRoundTopRight(15);
        pnlOpcProveedores.setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        pnlProveedores.add(pnlOpcProveedores, java.awt.BorderLayout.EAST);

        jPanel33.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel33.setOpaque(false);
        jPanel33.setLayout(new java.awt.GridLayout(1, 1));

        panelRound26.setBackground(new java.awt.Color(10, 10, 10));
        panelRound26.setRoundBottomLeft(15);
        panelRound26.setRoundBottomRight(15);
        panelRound26.setRoundTopLeft(15);
        panelRound26.setRoundTopRight(15);
        panelRound26.setLayout(new java.awt.BorderLayout());

        panelRound27.setBackground(new java.awt.Color(10, 10, 10));
        panelRound27.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound27.setRoundTopLeft(15);
        panelRound27.setRoundTopRight(15);
        panelRound27.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        panelRound28.setBackground(new java.awt.Color(40, 40, 40));
        panelRound28.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound28.setRoundBottomLeft(10);
        panelRound28.setRoundBottomRight(10);
        panelRound28.setRoundTopLeft(10);
        panelRound28.setRoundTopRight(10);
        panelRound28.setLayout(new java.awt.BorderLayout());

        panelGradient13.setLayout(new java.awt.FlowLayout());
        panelRound28.add(panelGradient13, java.awt.BorderLayout.NORTH);

        jPanel34.setOpaque(false);
        jPanel34.setLayout(new java.awt.BorderLayout());

        lblProvActivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel34.add(lblProvActivo, java.awt.BorderLayout.LINE_END);

        jPanel35.setOpaque(false);
        jPanel35.setLayout(new java.awt.BorderLayout());

        jLabel33.setBackground(new java.awt.Color(100, 100, 100));
        jLabel33.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(120, 120, 120));
        jLabel33.setText("Proveedor mas activo");
        jLabel33.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel35.add(jLabel33, java.awt.BorderLayout.NORTH);

        lblProvMasActivo.setBackground(new java.awt.Color(25, 180, 98));
        lblProvMasActivo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblProvMasActivo.setForeground(new java.awt.Color(66, 189, 159));
        lblProvMasActivo.setText("DeliveryCarr");
        lblProvMasActivo.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 0));
        jPanel35.add(lblProvMasActivo, java.awt.BorderLayout.CENTER);

        jPanel34.add(jPanel35, java.awt.BorderLayout.CENTER);

        panelRound28.add(jPanel34, java.awt.BorderLayout.CENTER);

        panelRound27.add(panelRound28);

        panelRound26.add(panelRound27, java.awt.BorderLayout.NORTH);

        panelRound31.setBackground(new java.awt.Color(10, 10, 10));
        panelRound31.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelRound31.setRoundBottomLeft(15);
        panelRound31.setRoundBottomRight(15);
        panelRound31.setLayout(new java.awt.BorderLayout());

        tbProv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbProv.setGridColor(new java.awt.Color(40, 40, 40));
        tbProv.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbProv.setSelectionForeground(new java.awt.Color(10, 10, 10));
        tbProv.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollProv.setViewportView(tbProv);

        panelRound31.add(scrollProv, java.awt.BorderLayout.CENTER);

        pnlOpcionesProveedores.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        pnlOpcionesProveedores.setOpaque(false);
        pnlOpcionesProveedores.setLayout(new java.awt.CardLayout());

        vidAlta4.setOpaque(false);
        vidAlta4.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsProvAlta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsProvAlta.setOpaque(false);
        pnlButtonsProvAlta.setLayout(new java.awt.BorderLayout(5, 5));
        vidAlta4.add(pnlButtonsProvAlta, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos16.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos16.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos16.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos16.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos16.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos16.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos16.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos16.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAlta4.add(txtBusquedaVideojuegos16, java.awt.BorderLayout.CENTER);

        pnlOpcionesProveedores.add(vidAlta4, "card1");

        vidElim4.setOpaque(false);
        vidElim4.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsProvElim.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsProvElim.setOpaque(false);
        pnlButtonsProvElim.setLayout(new java.awt.BorderLayout(5, 5));
        vidElim4.add(pnlButtonsProvElim, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos17.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos17.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos17.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos17.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos17.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos17.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos17.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos17.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidElim4.add(txtBusquedaVideojuegos17, java.awt.BorderLayout.CENTER);

        pnlOpcionesProveedores.add(vidElim4, "card2");

        vidAct4.setOpaque(false);
        vidAct4.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsProvAct.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsProvAct.setOpaque(false);
        pnlButtonsProvAct.setLayout(new java.awt.BorderLayout(5, 5));
        vidAct4.add(pnlButtonsProvAct, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos18.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos18.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos18.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos18.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos18.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos18.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos18.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos18.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAct4.add(txtBusquedaVideojuegos18, java.awt.BorderLayout.CENTER);

        pnlOpcionesProveedores.add(vidAct4, "card3");

        vidMostrar4.setOpaque(false);
        vidMostrar4.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsProvMostrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsProvMostrar.setOpaque(false);
        pnlButtonsProvMostrar.setLayout(new java.awt.BorderLayout(5, 5));

        comboProveedores.setBackground(new java.awt.Color(30, 30, 30));
        comboProveedores.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        comboProveedores.setForeground(new java.awt.Color(200, 200, 200));
        comboProveedores.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nombre", "Telefono", "Domicilio", "Correo", "Cant. Surtida" }));
        comboProveedores.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        pnlButtonsProvMostrar.add(comboProveedores, java.awt.BorderLayout.CENTER);

        vidMostrar4.add(pnlButtonsProvMostrar, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos19.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos19.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos19.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos19.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos19.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos19.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos19.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos19.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidMostrar4.add(txtBusquedaVideojuegos19, java.awt.BorderLayout.CENTER);

        pnlOpcionesProveedores.add(vidMostrar4, "card4");

        panelRound31.add(pnlOpcionesProveedores, java.awt.BorderLayout.PAGE_START);

        panelRound26.add(panelRound31, java.awt.BorderLayout.CENTER);

        jPanel33.add(panelRound26);

        pnlProveedores.add(jPanel33, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlProveedores, "cardProveedores");

        pnlInventario.setOpaque(false);
        pnlInventario.setLayout(new java.awt.BorderLayout());

        pnlOpcInventario.setBackground(new java.awt.Color(20, 20, 20));
        pnlOpcInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 0));
        pnlOpcInventario.setRoundBottomLeft(15);
        pnlOpcInventario.setRoundBottomRight(15);
        pnlOpcInventario.setRoundTopLeft(15);
        pnlOpcInventario.setRoundTopRight(15);
        pnlOpcInventario.setLayout(new java.awt.GridLayout(4, 1, 5, 5));
        pnlInventario.add(pnlOpcInventario, java.awt.BorderLayout.EAST);

        jPanel40.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 5, 0));
        jPanel40.setOpaque(false);
        jPanel40.setLayout(new java.awt.GridLayout(1, 1));

        panelRound32.setBackground(new java.awt.Color(10, 10, 10));
        panelRound32.setRoundBottomLeft(15);
        panelRound32.setRoundBottomRight(15);
        panelRound32.setRoundTopLeft(15);
        panelRound32.setRoundTopRight(15);
        panelRound32.setLayout(new java.awt.BorderLayout());

        panelRound33.setBackground(new java.awt.Color(10, 10, 10));
        panelRound33.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound33.setRoundTopLeft(15);
        panelRound33.setRoundTopRight(15);
        panelRound33.setLayout(new java.awt.GridLayout(1, 3, 10, 0));

        panelRound34.setBackground(new java.awt.Color(40, 40, 40));
        panelRound34.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 5, 0));
        panelRound34.setRoundBottomLeft(10);
        panelRound34.setRoundBottomRight(10);
        panelRound34.setRoundTopLeft(10);
        panelRound34.setRoundTopRight(10);
        panelRound34.setLayout(new java.awt.BorderLayout());

        panelGradient16.setLayout(new java.awt.FlowLayout());
        panelRound34.add(panelGradient16, java.awt.BorderLayout.NORTH);

        jPanel41.setOpaque(false);
        jPanel41.setLayout(new java.awt.BorderLayout());

        lblInvStock.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 5, 10));
        jPanel41.add(lblInvStock, java.awt.BorderLayout.LINE_END);

        jPanel42.setOpaque(false);
        jPanel42.setLayout(new java.awt.BorderLayout());

        jLabel39.setBackground(new java.awt.Color(100, 100, 100));
        jLabel39.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(120, 120, 120));
        jLabel39.setText("Productos con stock bajo");
        jLabel39.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 0));
        jPanel42.add(jLabel39, java.awt.BorderLayout.NORTH);

        jPanel17.setOpaque(false);
        jPanel17.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        jLabel40.setBackground(new java.awt.Color(25, 180, 98));
        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(66, 189, 159));
        jLabel40.setText("Producto");
        jLabel40.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel17.add(jLabel40);

        jLabel41.setBackground(new java.awt.Color(25, 180, 98));
        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(66, 189, 159));
        jLabel41.setText("Producto");
        jLabel41.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel17.add(jLabel41);

        jLabel42.setBackground(new java.awt.Color(25, 180, 98));
        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(66, 189, 159));
        jLabel42.setText("Producto");
        jLabel42.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        jPanel17.add(jLabel42);

        jPanel42.add(jPanel17, java.awt.BorderLayout.CENTER);

        jPanel41.add(jPanel42, java.awt.BorderLayout.CENTER);

        panelRound34.add(jPanel41, java.awt.BorderLayout.CENTER);

        panelRound33.add(panelRound34);

        panelRound32.add(panelRound33, java.awt.BorderLayout.NORTH);

        panelRound37.setBackground(new java.awt.Color(10, 10, 10));
        panelRound37.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        panelRound37.setRoundBottomLeft(15);
        panelRound37.setRoundBottomRight(15);
        panelRound37.setLayout(new java.awt.BorderLayout());

        tbInv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbInv.setGridColor(new java.awt.Color(40, 40, 40));
        tbInv.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbInv.setSelectionForeground(new java.awt.Color(10, 10, 10));
        tbInv.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollInv.setViewportView(tbInv);

        panelRound37.add(scrollInv, java.awt.BorderLayout.CENTER);

        pnlOpcionesInventario.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 15, 5));
        pnlOpcionesInventario.setOpaque(false);
        pnlOpcionesInventario.setLayout(new java.awt.CardLayout());

        vidAlta5.setOpaque(false);
        vidAlta5.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsInvAlta.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsInvAlta.setOpaque(false);
        pnlButtonsInvAlta.setLayout(new java.awt.BorderLayout(5, 5));
        vidAlta5.add(pnlButtonsInvAlta, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos20.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos20.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos20.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos20.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos20.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos20.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos20.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos20.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAlta5.add(txtBusquedaVideojuegos20, java.awt.BorderLayout.CENTER);

        pnlOpcionesInventario.add(vidAlta5, "card1");

        vidElim5.setOpaque(false);
        vidElim5.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsInvElim.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsInvElim.setOpaque(false);
        pnlButtonsInvElim.setLayout(new java.awt.BorderLayout(5, 5));
        vidElim5.add(pnlButtonsInvElim, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos21.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos21.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos21.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos21.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos21.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos21.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos21.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos21.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidElim5.add(txtBusquedaVideojuegos21, java.awt.BorderLayout.CENTER);

        pnlOpcionesInventario.add(vidElim5, "card2");

        vidAct5.setOpaque(false);
        vidAct5.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsInvAct.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsInvAct.setOpaque(false);
        pnlButtonsInvAct.setLayout(new java.awt.BorderLayout(5, 5));
        vidAct5.add(pnlButtonsInvAct, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos22.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos22.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos22.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos22.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos22.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos22.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos22.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos22.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidAct5.add(txtBusquedaVideojuegos22, java.awt.BorderLayout.CENTER);

        pnlOpcionesInventario.add(vidAct5, "card3");

        vidMostrar5.setOpaque(false);
        vidMostrar5.setLayout(new java.awt.BorderLayout(5, 5));

        pnlButtonsInvMostrar.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        pnlButtonsInvMostrar.setOpaque(false);
        pnlButtonsInvMostrar.setLayout(new java.awt.BorderLayout(5, 5));
        vidMostrar5.add(pnlButtonsInvMostrar, java.awt.BorderLayout.EAST);

        txtBusquedaVideojuegos23.setBackground(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos23.setFont(new java.awt.Font("Roboto", 0, 16)); // NOI18N
        txtBusquedaVideojuegos23.setForeground(new java.awt.Color(200, 200, 200));
        txtBusquedaVideojuegos23.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(40, 40, 40)));
        txtBusquedaVideojuegos23.setCaretColor(new java.awt.Color(25, 200, 178));
        txtBusquedaVideojuegos23.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtBusquedaVideojuegos23.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        txtBusquedaVideojuegos23.setSelectionColor(new java.awt.Color(25, 200, 178));
        vidMostrar5.add(txtBusquedaVideojuegos23, java.awt.BorderLayout.CENTER);

        pnlOpcionesInventario.add(vidMostrar5, "card4");

        panelRound37.add(pnlOpcionesInventario, java.awt.BorderLayout.PAGE_START);

        panelRound32.add(panelRound37, java.awt.BorderLayout.CENTER);

        jPanel40.add(panelRound32);

        pnlInventario.add(jPanel40, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlInventario, "cardInventario");

        jPanel1.add(pnlMain, java.awt.BorderLayout.CENTER);

        pnlAside.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 5));
        pnlAside.setOpaque(false);
        pnlAside.setLayout(new java.awt.BorderLayout());

        pnlMenuContainer.setBackground(new java.awt.Color(10, 10, 10));
        pnlMenuContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 10, 5));
        pnlMenuContainer.setRoundBottomLeft(20);
        pnlMenuContainer.setRoundBottomRight(20);
        pnlMenuContainer.setRoundTopLeft(20);
        pnlMenuContainer.setRoundTopRight(20);
        pnlMenuContainer.setLayout(new java.awt.GridLayout(7, 1, 0, 5));
        pnlAside.add(pnlMenuContainer, java.awt.BorderLayout.WEST);

        jPanel1.add(pnlAside, java.awt.BorderLayout.WEST);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarDatosGenerales() {
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
        obCons.setLablesInvStock(jLabel40, jLabel41, jLabel42);
        obCons.consultarStock();

        obI.llenarTablaVideojuegos(tbVideojuegos);
        obI.llenarTablaTiendas(tbTiendas);
        obI.llenarTablaProveedores(tbProv);
        obI.llenarTablaInventario(tbInv);
        obI.llenarTablaClientes(tbClientes);
        obI.llenarTablaEmpleados(tbEmp);
    }

    public void actionListenerButtonsHeader() {
        btnPuntoVenta.addActionListener((e) -> {
            VentanaVentas obV = new VentanaVentas();
            obV.setUser(user, idTiendaTrabajo);
            obV.setVisible(true);
        });

        btnVentas.addActionListener((e) -> {
            btnVentas.setForeground(select);
            btnPrincipal.setForeground(unselect);
            btnVideojuegos.setForeground(unselect);
            btnTiendas.setForeground(unselect);
            btnProveedores.setForeground(unselect);
            btnClientes.setForeground(unselect);
            btnEmpleados.setForeground(unselect);
            btnInventario.setForeground(unselect);
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGenSel.png"));
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/unselectedMain.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
        });
    }

    public void initComponentesCustom() {
        pnlAside.setPreferredSize(new Dimension(5, pnlAside.getHeight()));
        SwingUtilities.updateComponentTreeUI(pnlAside);

        btnPuntoVenta = obE.getStyleButtonUpdate(btnPuntoVenta);
        btnPuntoVenta.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnPuntoVenta.setHorizontalTextPosition(SwingConstants.CENTER);
        btnPuntoVenta.setText("Punto de venta");
        btnPuntoVenta.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnPuntoVenta.setIcon(new ImageIcon("./src/main/java/Resources/puntoVenta.png"));
        btnPuntoVenta.setBorderColor(new Color(20, 20, 20));
        btnPuntoVenta.setIconTextGap(0);
        pnlHeaderButtons.add(btnPuntoVenta);

        btnSalir = obE.getStyleButtonExit(btnSalir);
        btnSalir.setText("");
        pnlHeaderButtons.add(btnSalir);

        btnPrincipal = obE.getStyleMenuBtn(btnPrincipal, pnlMenuContainer);

        btnPrincipal.setText("Principal");
        btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/selectedMain.png"));
        btnPrincipal.setForeground(select);
        btnPrincipal.addActionListener((e) -> {
            obCMenu.show(pnlMain, "cardPrincipal");
            btnPrincipal.setForeground(select);
            btnVideojuegos.setForeground(unselect);
            btnTiendas.setForeground(unselect);
            btnProveedores.setForeground(unselect);
            btnClientes.setForeground(unselect);
            btnEmpleados.setForeground(unselect);
            btnInventario.setForeground(unselect);
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/selectedMain.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
            btnVentas.setForeground(unselect);
        });

        btnVideojuegos = obE.getStyleMenuBtn(btnVideojuegos, pnlMenuContainer);
        btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
        btnVideojuegos.setText("Juegos");
        btnVideojuegos.addActionListener((e) -> {
            obCMenu.show(pnlMain, "cardVideojuegos");
            btnVideojuegos.setForeground(select);
            btnTiendas.setForeground(unselect);
            btnProveedores.setForeground(unselect);
            btnClientes.setForeground(unselect);
            btnEmpleados.setForeground(unselect);
            btnInventario.setForeground(unselect);
            btnPrincipal.setForeground(unselect);
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/unselectedMain.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/selectedGames.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
            btnVentas.setForeground(unselect);
        });

        btnTiendas = obE.getStyleMenuBtn(btnTiendas, pnlMenuContainer);
        btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
        btnTiendas.setText("Tiendas");
        btnTiendas.addActionListener((e) -> {
            obCMenu.show(pnlMain, "cardTiendas");
            btnVideojuegos.setForeground(unselect);
            btnTiendas.setForeground(select);
            btnProveedores.setForeground(unselect);
            btnClientes.setForeground(unselect);
            btnEmpleados.setForeground(unselect);
            btnInventario.setForeground(unselect);
            btnPrincipal.setForeground(unselect);
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/unselectedMain.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/selectedTienda.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
            btnVentas.setForeground(unselect);
        });

        btnEmpleados = obE.getStyleMenuBtn(btnEmpleados, pnlMenuContainer);
        btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
        btnEmpleados.setText("Empleados");
        btnEmpleados.addActionListener((e) -> {
            obCMenu.show(pnlMain, "cardEmpleados");
            btnVideojuegos.setForeground(unselect);
            btnTiendas.setForeground(unselect);
            btnProveedores.setForeground(unselect);
            btnClientes.setForeground(unselect);
            btnEmpleados.setForeground(select);
            btnInventario.setForeground(unselect);
            btnPrincipal.setForeground(unselect);
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/unselectedMain.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/selectedEmp.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
            btnVentas.setForeground(unselect);
        });

        btnClientes = obE.getStyleMenuBtn(btnClientes, pnlMenuContainer);
        btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
        btnClientes.setText("Clientes");
        btnClientes.addActionListener((e) -> {
            obCMenu.show(pnlMain, "cardClientes");
            btnVideojuegos.setForeground(unselect);
            btnTiendas.setForeground(unselect);
            btnProveedores.setForeground(unselect);
            btnClientes.setForeground(select);
            btnEmpleados.setForeground(unselect);
            btnInventario.setForeground(unselect);
            btnPrincipal.setForeground(unselect);
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/unselectedMain.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/selectedCliente.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
            btnVentas.setForeground(unselect);
        });

        btnProveedores = obE.getStyleMenuBtn(btnProveedores, pnlMenuContainer);
        btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
        btnProveedores.setText("Proveedores");
        btnProveedores.addActionListener((e) -> {
            obCMenu.show(pnlMain, "cardProveedores");
            btnVideojuegos.setForeground(unselect);
            btnTiendas.setForeground(unselect);
            btnProveedores.setForeground(select);
            btnClientes.setForeground(unselect);
            btnEmpleados.setForeground(unselect);
            btnInventario.setForeground(unselect);
            btnPrincipal.setForeground(unselect);
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/unselectedMain.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/selectedProv.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
            btnVentas.setForeground(unselect);
        });

        btnInventario = obE.getStyleMenuBtn(btnInventario, pnlMenuContainer);
        btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/unselectedInv.png"));
        btnInventario.setText("Inventario");
        btnInventario.addActionListener((e) -> {
            obCMenu.show(pnlMain, "cardInventario");
            btnVideojuegos.setForeground(unselect);
            btnTiendas.setForeground(unselect);
            btnProveedores.setForeground(unselect);
            btnClientes.setForeground(unselect);
            btnEmpleados.setForeground(unselect);
            btnInventario.setForeground(select);
            btnPrincipal.setForeground(unselect);
            btnPrincipal.setIcon(new ImageIcon("./src/main/java/Resources/unselectedMain.png"));
            btnInventario.setIcon(new ImageIcon("./src/main/java/Resources/selectedInv.png"));
            btnVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/unselectedGames.png"));
            btnTiendas.setIcon(new ImageIcon("./src/main/java/Resources/unselectedTienda.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            btnEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/unselectedEmp.png"));
            btnProveedores.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
            btnVentas.setForeground(unselect);
        });

        btnMenu = new RoundButton(new Color(10, 10, 10), new Color(22, 49, 39), new Color(43, 61, 49), new Color(20, 20, 20), 20);
        btnMenu.setFocusable(false);
        btnMenu.setBorder(new EmptyBorder(10, 15, 10, 15));
        btnMenu.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnMenu.setHorizontalTextPosition(SwingConstants.CENTER);
        pnlHeaderButtons1.add(btnMenu);
        btnMenu.setIcon(new ImageIcon("./src/main/java/Resources/menu.png"));
        btnMenu.addActionListener((e) -> {
            if (estado) {
                expandirCompDer(pnlAside, 1, velAnimacion, limite);
                estado = false;
                btnMenu.setIcon(new ImageIcon("./src/main/java/Resources/menuSel.png"));
            } else {
                contraerCompIzq(pnlAside, 1, velAnimacion, 5);
                estado = true;
                btnMenu.setIcon(new ImageIcon("./src/main/java/Resources/menu.png"));
            }
        });

        btnVentas = new RoundButton(new Color(10, 10, 10), new Color(22, 49, 39), new Color(43, 61, 49), new Color(20, 20, 20), 20);
        btnVentas.setFocusable(false);
        btnVentas.setBorder(new EmptyBorder(10, 15, 10, 15));
        btnVentas.setText("Ventas");
        btnVentas.setForeground(new Color(100, 100, 100));
        btnVentas.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnVentas.setFont(new Font("Roboto", Font.PLAIN, 16));
        btnVentas.setHorizontalTextPosition(SwingConstants.CENTER);
        btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventasGen.png"));
        pnlHeaderButtons1.add(btnVentas);

        obE.setStylePanel(panelGradient1);
        obE.setStylePanel(panelGradient2);
        obE.setStylePanel(panelGradient3);
        obE.setStylePanel(panelGradient4);
        obE.setStylePanel(panelGradient5);
        obE.setStylePanel(panelGradient6);
        obE.setStylePanel(panelGradient7);
        obE.setStylePanel(panelGradient8);
        obE.setStylePanel(panelGradient9);
        obE.setStylePanel(panelGradient10);
        obE.setStylePanel(panelGradient11);
        obE.setStylePanel(panelGradient12);
        obE.setStylePanel(panelGradient13);
        obE.setStylePanel(panelGradient14);
        obE.setStylePanel(panelGradient15);
        obE.setStylePanel(panelGradient16);
        obE.setStylePanelVenta(panelGradient17);
        obE.setStylePanelIngresos(panelGradient18);
        obE.setStylePanelMas(panelGradient19);
        obE.setStylePanelMenos(panelGradient20);

        obE.setStyleTableDefault(tbVideojuegos, scrollVideojuegos, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));
        obE.setStyleTableDefault(tbTiendas, scrollTiendas, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));
        obE.setStyleTableDefault(tbProv, scrollProv, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));
        obE.setStyleTableDefault(tbInv, scrollInv, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));
        obE.setStyleTableDefault(tbEmp, scrollEmp, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));
        obE.setStyleTableDefault(tbClientes, scrollClientes, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));

        lblCategoria.setIcon(new ImageIcon("./src/main/java/Resources/like.png"));
        lblMasVend.setIcon(new ImageIcon("./src/main/java/Resources/mas.png"));
        lblMenosVend.setIcon(new ImageIcon("./src/main/java/Resources/menos.png"));
        lblTiendaMas.setIcon(new ImageIcon("./src/main/java/Resources/masVenta.png"));
        lblTiendaMasVisitada.setIcon(new ImageIcon("./src/main/java/Resources/masVisita.png"));
        lblEmpleadoAtento.setIcon(new ImageIcon("./src/main/java/Resources/masAtento.png"));
        lblEmpleadoSueldo.setIcon(new ImageIcon("./src/main/java/Resources/mejorSueldo.png"));
        lblInvStock.setIcon(new ImageIcon("./src/main/java/Resources/stock.png"));
        lblProvActivo.setIcon(new ImageIcon("./src/main/java/Resources/provActivo.png"));
        lblClienteMejor.setIcon(new ImageIcon("./src/main/java/Resources/mejorCliente.png"));

        lblVideo.setIcon(new ImageIcon("./src/main/java/Resources/videojuegos.png"));
        lblProv.setIcon(new ImageIcon("./src/main/java/Resources/prov.png"));
        lblClientes.setIcon(new ImageIcon("./src/main/java/Resources/clientes.png"));
        lblEmp.setIcon(new ImageIcon("./src/main/java/Resources/empleados.png"));
        lblTienda.setIcon(new ImageIcon("./src/main/java/Resources/tiendas.png"));
        lblInv.setIcon(new ImageIcon("./src/main/java/Resources/inventario.png"));

        lblMasVendido.setIcon(new ImageIcon("./src/main/java/Resources/mejor.png"));
        lblMenosVendido.setIcon(new ImageIcon("./src/main/java/Resources/peor.png"));
        lblVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventas.png"));
        lblIngresosVentas.setIcon(new ImageIcon("./src/main/java/Resources/ingresos.png"));

        obE.setPlaceHolder(txtBusquedaVideojuegos);
        obE.setPlaceHolder(txtBusquedaVideojuegos1);
        obE.setPlaceHolder(txtBusquedaVideojuegos2);
        obE.setPlaceHolder(txtBusquedaVideojuegos3);
        obE.setPlaceHolder(txtBusquedaVideojuegos4);
        obE.setPlaceHolder(txtBusquedaVideojuegos5);
        obE.setPlaceHolder(txtBusquedaVideojuegos6);
        obE.setPlaceHolder(txtBusquedaVideojuegos7);
        obE.setPlaceHolder(txtBusquedaVideojuegos8);
        obE.setPlaceHolder(txtBusquedaVideojuegos9);
        obE.setPlaceHolder(txtBusquedaVideojuegos10);
        obE.setPlaceHolder(txtBusquedaVideojuegos11);
        obE.setPlaceHolder(txtBusquedaVideojuegos12);
        obE.setPlaceHolder(txtBusquedaVideojuegos13);
        obE.setPlaceHolder(txtBusquedaVideojuegos14);
        obE.setPlaceHolder(txtBusquedaVideojuegos15);
        obE.setPlaceHolder(txtBusquedaVideojuegos16);
        obE.setPlaceHolder(txtBusquedaVideojuegos17);
        obE.setPlaceHolder(txtBusquedaVideojuegos18);
        obE.setPlaceHolder(txtBusquedaVideojuegos19);
        obE.setPlaceHolder(txtBusquedaVideojuegos20);
        obE.setPlaceHolder(txtBusquedaVideojuegos21);
        obE.setPlaceHolder(txtBusquedaVideojuegos22);
        obE.setPlaceHolder(txtBusquedaVideojuegos23);
    }

    public void initButtonsCRUD() {
        // Videojuegos
        btnBuscarVideojuegosElim = obE.getStyleMenuSearch(btnBuscarVideojuegosElim);
        btnBuscarVideojuegosAct = obE.getStyleMenuSearch(btnBuscarVideojuegosAct);
        btnBuscarVideojuegosMostrar = obE.getStyleMenuSearch(btnBuscarVideojuegosMostrar);
        btnBuscarVideojuegosAlta = obE.getStyleMenuSearch(btnBuscarVideojuegosAlta);
        btnAgregarVideojuegos = obE.getStyleButtonAdd(btnAgregarVideojuegos);
        btnEliminarVideojuegos = obE.getStyleButtonEliminar(btnEliminarVideojuegos);
        btnActVideojuegos = obE.getStyleButtonUpdate(btnActVideojuegos);
        btnFiltrarVideojuegos = obE.getStyleBtnClear(btnFiltrarVideojuegos);
        btnFiltrarVideojuegos.setIcon(new ImageIcon("./src/main/java/Resources/filtrar.png"));
        btnFiltrarVideojuegos.setText("Filtrar");

        pnlButtonsVideojuegosElim.add(btnBuscarVideojuegosElim, BorderLayout.WEST);
        pnlButtonsVideojuegosAct.add(btnBuscarVideojuegosAct, BorderLayout.WEST);
        pnlButtonsVideojuegosMostrar.add(btnBuscarVideojuegosMostrar, BorderLayout.WEST);
        pnlButtonsVideojuegosAlta.add(btnBuscarVideojuegosAlta, BorderLayout.WEST);
        pnlButtonsVideojuegosAlta.add(btnAgregarVideojuegos, BorderLayout.CENTER);
        pnlButtonsVideojuegosElim.add(btnEliminarVideojuegos, BorderLayout.CENTER);
        pnlButtonsVideojuegosAct.add(btnActVideojuegos, BorderLayout.CENTER);
        pnlButtonsVideojuegosMostrar.add(btnFiltrarVideojuegos, BorderLayout.EAST);

        // Tiendas
        btnBuscarTiendasElim = obE.getStyleMenuSearch(btnBuscarTiendasElim);
        btnBuscarTiendasAct = obE.getStyleMenuSearch(btnBuscarTiendasAct);
        btnBuscarTiendasMostrar = obE.getStyleMenuSearch(btnBuscarTiendasMostrar);
        btnBuscarTiendasAlta = obE.getStyleMenuSearch(btnBuscarTiendasAlta);
        btnAgregarTiendas = obE.getStyleButtonAdd(btnAgregarTiendas);
        btnEliminarTiendas = obE.getStyleButtonEliminar(btnEliminarTiendas);
        btnActTiendas = obE.getStyleButtonUpdate(btnActTiendas);
        btnFiltrarTiendas = obE.getStyleBtnClear(btnFiltrarTiendas);
        btnFiltrarTiendas.setIcon(new ImageIcon("./src/main/java/Resources/filtrar.png"));
        btnFiltrarTiendas.setText("Filtrar");

        pnlButtonsTiendasElim.add(btnBuscarTiendasElim, BorderLayout.WEST);
        pnlButtonsTiendasAct.add(btnBuscarTiendasAct, BorderLayout.WEST);
        pnlButtonsTiendasMostrar.add(btnBuscarTiendasMostrar, BorderLayout.WEST);
        pnlButtonsTiendasAlta.add(btnBuscarTiendasAlta, BorderLayout.WEST);
        pnlButtonsTiendasAlta.add(btnAgregarTiendas, BorderLayout.CENTER);
        pnlButtonsTiendasElim.add(btnEliminarTiendas, BorderLayout.CENTER);
        pnlButtonsTiendasAct.add(btnActTiendas, BorderLayout.CENTER);
        pnlButtonsTiendasMostrar.add(btnFiltrarTiendas, BorderLayout.EAST);

        // Empleados
        btnBuscarEmpleadosElim = obE.getStyleMenuSearch(btnBuscarEmpleadosElim);
        btnBuscarEmpleadosAct = obE.getStyleMenuSearch(btnBuscarEmpleadosAct);
        btnBuscarEmpleadosMostrar = obE.getStyleMenuSearch(btnBuscarEmpleadosMostrar);
        btnBuscarEmpleadosAlta = obE.getStyleMenuSearch(btnBuscarEmpleadosAlta);
        btnAgregarEmpleados = obE.getStyleButtonAdd(btnAgregarEmpleados);
        btnEliminarEmpleados = obE.getStyleButtonEliminar(btnEliminarEmpleados);
        btnActEmpleados = obE.getStyleButtonUpdate(btnActEmpleados);
        btnFiltrarEmpleados = obE.getStyleBtnClear(btnFiltrarEmpleados);
        btnFiltrarEmpleados.setIcon(new ImageIcon("./src/main/java/Resources/filtrar.png"));
        btnFiltrarEmpleados.setText("Filtrar");

        pnlButtonsEmpleadosElim.add(btnBuscarEmpleadosElim, BorderLayout.WEST);
        pnlButtonsEmpleadosAct.add(btnBuscarEmpleadosAct, BorderLayout.WEST);
        pnlButtonsEmpleadosMostrar.add(btnBuscarEmpleadosMostrar, BorderLayout.WEST);
        pnlButtonsEmpleadosAlta.add(btnBuscarEmpleadosAlta, BorderLayout.WEST);
        pnlButtonsEmpleadosAlta.add(btnAgregarEmpleados, BorderLayout.CENTER);
        pnlButtonsEmpleadosElim.add(btnEliminarEmpleados, BorderLayout.CENTER);
        pnlButtonsEmpleadosAct.add(btnActEmpleados, BorderLayout.CENTER);
        pnlButtonsEmpleadosMostrar.add(btnFiltrarEmpleados, BorderLayout.EAST);

        // Clientes
        btnBuscarClientesElim = obE.getStyleMenuSearch(btnBuscarClientesElim);
        btnBuscarClientesAct = obE.getStyleMenuSearch(btnBuscarClientesAct);
        btnBuscarClientesMostrar = obE.getStyleMenuSearch(btnBuscarClientesMostrar);
        btnBuscarClientesAlta = obE.getStyleMenuSearch(btnBuscarClientesAlta);
        btnAgregarClientes = obE.getStyleButtonAdd(btnAgregarClientes);
        btnEliminarClientes = obE.getStyleButtonEliminar(btnEliminarClientes);
        btnActClientes = obE.getStyleButtonUpdate(btnActClientes);
        btnFiltrarClientes = obE.getStyleBtnClear(btnFiltrarClientes);
        btnFiltrarClientes.setIcon(new ImageIcon("./src/main/java/Resources/filtrar.png"));
        btnFiltrarClientes.setText("Filtrar");

        pnlButtonsClientesElim.add(btnBuscarClientesElim, BorderLayout.WEST);
        pnlButtonsClientesAct.add(btnBuscarClientesAct, BorderLayout.WEST);
        pnlButtonsClientesMostrar.add(btnBuscarClientesMostrar, BorderLayout.WEST);
        pnlButtonsClientesAlta.add(btnBuscarClientesAlta, BorderLayout.WEST);
        pnlButtonsClientesAlta.add(btnAgregarClientes, BorderLayout.CENTER);
        pnlButtonsClientesElim.add(btnEliminarClientes, BorderLayout.CENTER);
        pnlButtonsClientesAct.add(btnActClientes, BorderLayout.CENTER);
        pnlButtonsClientesMostrar.add(btnFiltrarClientes, BorderLayout.EAST);

        // Proveedores
        btnBuscarProveedoresElim = obE.getStyleMenuSearch(btnBuscarProveedoresElim);
        btnBuscarProveedoresAct = obE.getStyleMenuSearch(btnBuscarProveedoresAct);
        btnBuscarProveedoresMostrar = obE.getStyleMenuSearch(btnBuscarProveedoresMostrar);
        btnBuscarProveedoresAlta = obE.getStyleMenuSearch(btnBuscarProveedoresAlta);
        btnAgregarProveedores = obE.getStyleButtonAdd(btnAgregarProveedores);
        btnEliminarProveedores = obE.getStyleButtonEliminar(btnEliminarProveedores);
        btnActProveedores = obE.getStyleButtonUpdate(btnActProveedores);
        btnFiltrarProveedores = obE.getStyleBtnClear(btnFiltrarProveedores);
        btnFiltrarProveedores.setIcon(new ImageIcon("./src/main/java/Resources/filtrar.png"));
        btnFiltrarProveedores.setText("Filtrar");

        pnlButtonsProvElim.add(btnBuscarProveedoresElim, BorderLayout.WEST);
        pnlButtonsProvAct.add(btnBuscarProveedoresAct, BorderLayout.WEST);
        pnlButtonsProvMostrar.add(btnBuscarProveedoresMostrar, BorderLayout.WEST);
        pnlButtonsProvAlta.add(btnBuscarProveedoresAlta, BorderLayout.WEST);
        pnlButtonsProvAlta.add(btnAgregarProveedores, BorderLayout.CENTER);
        pnlButtonsProvElim.add(btnEliminarProveedores, BorderLayout.CENTER);
        pnlButtonsProvAct.add(btnActProveedores, BorderLayout.CENTER);
        pnlButtonsProvMostrar.add(btnFiltrarProveedores, BorderLayout.EAST);

        // Inventario
        btnBuscarInventarioElim = obE.getStyleMenuSearch(btnBuscarInventarioElim);
        btnBuscarInventarioAct = obE.getStyleMenuSearch(btnBuscarInventarioAct);
        btnBuscarInventarioMostrar = obE.getStyleMenuSearch(btnBuscarInventarioMostrar);
        btnBuscarInventarioAlta = obE.getStyleMenuSearch(btnBuscarInventarioAlta);
        btnAgregarInventario = obE.getStyleButtonAdd(btnAgregarInventario);
        btnEliminarInventario = obE.getStyleButtonEliminar(btnEliminarInventario);
        btnActInventario = obE.getStyleButtonUpdate(btnActInventario);

        pnlButtonsInvElim.add(btnBuscarInventarioElim, BorderLayout.WEST);
        pnlButtonsInvAct.add(btnBuscarInventarioAct, BorderLayout.WEST);
        pnlButtonsInvMostrar.add(btnBuscarInventarioMostrar, BorderLayout.WEST);
        pnlButtonsInvAlta.add(btnBuscarInventarioAlta, BorderLayout.WEST);
        pnlButtonsInvAlta.add(btnAgregarInventario, BorderLayout.CENTER);
        pnlButtonsInvElim.add(btnEliminarInventario, BorderLayout.CENTER);
        pnlButtonsInvAct.add(btnActInventario, BorderLayout.CENTER);

        // Combo Box
        comboProveedores.setRenderer(new CustomComboBoxRenderer());
        comboProveedores.setFocusable(false);
        comboProveedores.getComponent(0).setBackground(new Color(66, 189, 159));
        comboProveedores.setBorder(new LineBorder(new Color(10, 10, 10)));
        comboClientes.setRenderer(new CustomComboBoxRenderer());
        comboClientes.setFocusable(false);
        comboClientes.getComponent(0).setBackground(new Color(66, 189, 159));
        comboClientes.setBorder(new LineBorder(new Color(10, 10, 10)));
        comboEmpleados.setRenderer(new CustomComboBoxRenderer());
        comboEmpleados.setFocusable(false);
        comboEmpleados.getComponent(0).setBackground(new Color(66, 189, 159));
        comboEmpleados.setBorder(new LineBorder(new Color(10, 10, 10)));
        comboTiendas.setRenderer(new CustomComboBoxRenderer());
        comboTiendas.setFocusable(false);
        comboTiendas.getComponent(0).setBackground(new Color(66, 189, 159));
        comboTiendas.setBorder(new LineBorder(new Color(10, 10, 10)));
        comboVideojuegos.setRenderer(new CustomComboBoxRenderer());
        comboVideojuegos.setFocusable(false);
        comboVideojuegos.getComponent(0).setBackground(new Color(66, 189, 159));
        comboVideojuegos.setBorder(new LineBorder(new Color(10, 10, 10)));

    }

    public void actionListenerBtnActions() {
        // Registrar / Alta
        btnAgregarVideojuegos.addActionListener((e) -> {
            alta = new VentanaAltas();
            alta.setStr("altaVideojuegos", "Videojuegos", "./src/main/java/Resources/selectedGames.png");
            alta.setTitle("Agregar videojuego");
            alta.setTbVideojuegos(tbVideojuegos);
            alta.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
            alta.setVisible(true);
            alta.setUser(user);
        });

        btnAgregarTiendas.addActionListener((e) -> {
            alta2 = new VentanaAltas();
            alta2.setStr("altaTiendas", "Tiendas", "./src/main/java/Resources/selectedTienda.png");
            alta2.setTitle("Agregar tienda");
            alta2.setTbTiendas(tbTiendas);
            alta2.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
            alta2.setVisible(true);
            alta2.setUser(user);
        });

        btnAgregarEmpleados.addActionListener((e) -> {
            alta3 = new VentanaAltas();
            alta3.setStr("altaEmpleados", "Empleados", "./src/main/java/Resources/selectedEmp.png");
            alta3.setTitle("Agregar empleado");
            alta3.setTbEmpleados(tbEmp);
            alta3.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
            alta3.setVisible(true);
            alta3.setUser(user);
        });

        btnAgregarClientes.addActionListener((e) -> {
            alta4 = new VentanaAltas();
            alta4.setStr("altaClientes", "Clientes", "./src/main/java/Resources/selectedCliente.png");
            alta4.setTitle("Agregar cliente");
            alta4.setTbClientes(tbClientes);
            alta4.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
            alta4.setVisible(true);
            alta4.setUser(user);
        });

        btnAgregarProveedores.addActionListener((e) -> {
            alta5 = new VentanaAltas();
            alta5.setStr("altaProveedores", "Proveedores", "./src/main/java/Resources/selectedProv.png");
            alta5.setTitle("Agregar proveedor");
            alta5.setTbProveedores(tbProv);
            alta5.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
            alta5.setVisible(true);
            alta5.setUser(user);
        });

        btnAgregarInventario.addActionListener((e) -> {
            alta6 = new VentanaAltas();
            alta6.setStr("altaInventario", "Inventario", "./src/main/java/Resources/selectedInv.png");
            alta6.setTitle("Agregar videojuegos al inventario");
            alta6.setTbInventario(tbInv);
            alta6.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
            alta6.setVisible(true);
            alta6.setUser(user);
        });

        // Eliminar
        btnEliminarVideojuegos.addActionListener((e) -> {
            int selectedRowIndex = tbVideojuegos.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbVideojuegos.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));

                sqlVideojuegos.deleteVideojuego(id);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminarTiendas.addActionListener((e) -> {
            int selectedRowIndex = tbTiendas.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbTiendas.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));

                sqlTiendas.deleteTienda(id);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminarProveedores.addActionListener((e) -> {
            int selectedRowIndex = tbProv.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbProv.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));

                sqlProveedores.deleteProveedor(id);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminarEmpleados.addActionListener((e) -> {
            int selectedRowIndex = tbEmp.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbEmp.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));

                sqlEmpleados.deleteEmpleado(id);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminarClientes.addActionListener((e) -> {
            int selectedRowIndex = tbClientes.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbClientes.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));

                sqlClientes.deleteCliente(id);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnEliminarInventario.addActionListener((e) -> {
            int selectedRowIndex = tbInv.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbInv.getModel().getValueAt(selectedRowIndex, 0);
                int idVideojuego = Integer.parseInt(String.valueOf(aux));
                sqlInventario.selectInventarioTable();
                int idTienda = 0;
                for (String s[] : sqlInventario.getDataTable()) {
                    if (idVideojuego == Integer.parseInt(s[3])) {
                        idTienda = Integer.parseInt(s[4]);
                        System.out.println(idVideojuego + " | " + idTienda);
                        break;
                    }
                }
                sqlInventario.deleteInventario(idVideojuego, idTienda);
                cargarDatosGenerales();
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Actualizar
        btnActVideojuegos.addActionListener((e) -> {
            int selectedRowIndex = tbVideojuegos.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbVideojuegos.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));
                actu = new VentanaActualizaciones();
                actu.setTitle("Actualizar videojuego");
                actu.setTbVideojuegos(tbVideojuegos);

                sqlVideojuegos.selectVideojuego();
                for (Videojuego v : sqlVideojuegos.getData()) {
                    if (v.getId() == id) {
                        actu.setVideojuego(v, id);
                        break;
                    }
                }
                actu.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
                actu.setStr("altaVideojuegos", "Videojuegos", "./src/main/java/Resources/selectedGames.png");
                actu.setVisible(true);
                actu.setUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnActTiendas.addActionListener((e) -> {
            int selectedRowIndex = tbTiendas.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbTiendas.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));
                actu2 = new VentanaActualizaciones();
                actu2.setTitle("Actualizar tienda");
                actu2.setTbTiendas(tbTiendas);

                sqlTiendas.selectTienda();
                for (Tienda t : sqlTiendas.getData()) {
                    if (t.getId() == id) {
                        actu2.setTienda(t, id);
                        break;
                    }
                }
                actu2.setStr("altaTiendas", "Tiendas", "./src/main/java/Resources/selectedTienda.png");
                actu2.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
                actu2.setVisible(true);
                actu2.setUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        });

        btnActProveedores.addActionListener((e) -> {
            int selectedRowIndex = tbProv.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbProv.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));
                actu3 = new VentanaActualizaciones();
                actu3.setTitle("Actualizar proveedor");
                actu3.setTbProveedores(tbProv);

                sqlProveedores.selectProveedor();
                for (Proveedor p : sqlProveedores.getData()) {
                    if (p.getId() == id) {
                        actu3.setProveedor(p, id);
                        break;
                    }
                }

                actu3.setStr("altaProveedores", "Proveedores", "./src/main/java/Resources/selectedProv.png");
                actu3.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
                actu3.setVisible(true);
                actu3.setUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnActInventario.addActionListener((e) -> {
            int selectedRowIndex = tbInv.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbInv.getModel().getValueAt(selectedRowIndex, 0);
                Object aux2 = tbInv.getModel().getValueAt(selectedRowIndex, 2);
                int idVideojuego = Integer.parseInt(String.valueOf(aux));
                int idTienda = Integer.parseInt(String.valueOf(aux2));

                actu4 = new VentanaActualizaciones();
                actu4.setTitle("Actualizar inventario");
                actu4.setTbInventario(tbInv);

                sqlInventario.selectInventarioTable();
                for (String s[] : sqlInventario.getDataTable()) {
                    if (idVideojuego == Integer.parseInt(s[3]) && idTienda == Integer.parseInt(s[4])) {
                        actu4.setInventario(new Inventario(idVideojuego, idTienda, Integer.parseInt(s[2])));
                        break;
                    }
                }
                actu4.setStr("altaInventario", "Inventario", "./src/main/java/Resources/selectedInv.png");
                actu4.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
                actu4.setVisible(true);
                actu4.setUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnActEmpleados.addActionListener((e) -> {
            int selectedRowIndex = tbEmp.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbEmp.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));
                actu5 = new VentanaActualizaciones();
                actu5.setTitle("Actualizar empleado");
                actu5.setTbEmpleados(tbEmp);

                sqlEmpleados.selectEmpleado();
                for (Empleado em : sqlEmpleados.getDataEmpleado()) {
                    if (em.getId() == id) {
                        actu5.setEmpleado(em, id);
                        break;
                    }
                }

                actu5.setStr("altaEmpleados", "Empleados", "./src/main/java/Resources/selectedEmp.png");
                actu5.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
                actu5.setVisible(true);
                actu5.setUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnActClientes.addActionListener((e) -> {
            int selectedRowIndex = tbClientes.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbClientes.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));
                actu6 = new VentanaActualizaciones();
                actu6.setTitle("Actualizar cliente");
                actu6.setTbClientes(tbClientes);

                sqlClientes.selectCliente();
                for (Cliente c : sqlClientes.getData()) {
                    if (c.getId() == id) {
                        actu6.setCliente(c, id);
                        break;
                    }
                }

                actu6.setStr("altaClientes", "Clientes", "./src/main/java/Resources/selectedCliente.png");
                actu6.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, jLabel40, jLabel41, jLabel42);
                actu6.setVisible(true);
                actu6.setUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Buscar
        btnBuscarVideojuegosAlta.addActionListener((e) -> {
            if (txtBusquedaVideojuegos3.getText().trim().length() == 0) {
                obI.llenarTablaVideojuegos(tbVideojuegos);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("videojuegos", txtBusquedaVideojuegos3.getText().trim(), 1);
                obCons.llenarTablaVideojuegosBus(tbVideojuegos);
            }
            txtBusquedaVideojuegos.setText(txtBusquedaVideojuegos3.getText().trim());
            txtBusquedaVideojuegos2.setText(txtBusquedaVideojuegos3.getText().trim());
            txtBusquedaVideojuegos1.setText(txtBusquedaVideojuegos3.getText().trim());

        });
        btnBuscarVideojuegosElim.addActionListener((e) -> {
            if (txtBusquedaVideojuegos.getText().trim().length() == 0) {
                obI.llenarTablaVideojuegos(tbVideojuegos);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("videojuegos", txtBusquedaVideojuegos.getText().trim(), 1);
                obCons.llenarTablaVideojuegosBus(tbVideojuegos);
            }
            txtBusquedaVideojuegos3.setText(txtBusquedaVideojuegos.getText().trim());
            txtBusquedaVideojuegos2.setText(txtBusquedaVideojuegos.getText().trim());
            txtBusquedaVideojuegos1.setText(txtBusquedaVideojuegos.getText().trim());
        });
        btnBuscarVideojuegosAct.addActionListener((e) -> {
            if (txtBusquedaVideojuegos1.getText().trim().length() == 0) {
                obI.llenarTablaVideojuegos(tbVideojuegos);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("videojuegos", txtBusquedaVideojuegos1.getText().trim(), 1);
                obCons.llenarTablaVideojuegosBus(tbVideojuegos);
            }
            txtBusquedaVideojuegos.setText(txtBusquedaVideojuegos1.getText().trim());
            txtBusquedaVideojuegos2.setText(txtBusquedaVideojuegos1.getText().trim());
            txtBusquedaVideojuegos3.setText(txtBusquedaVideojuegos1.getText().trim());
        });
        btnBuscarVideojuegosMostrar.addActionListener((e) -> {
            if (txtBusquedaVideojuegos2.getText().trim().length() == 0) {
                obI.llenarTablaVideojuegos(tbVideojuegos);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("videojuegos", txtBusquedaVideojuegos2.getText().trim(), 1);
                obCons.llenarTablaVideojuegosBus(tbVideojuegos);
            }
            txtBusquedaVideojuegos.setText(txtBusquedaVideojuegos2.getText().trim());
            txtBusquedaVideojuegos3.setText(txtBusquedaVideojuegos2.getText().trim());
            txtBusquedaVideojuegos1.setText(txtBusquedaVideojuegos2.getText().trim());
        });

        btnBuscarTiendasAlta.addActionListener((e) -> {
            if (txtBusquedaVideojuegos4.getText().trim().length() == 0) {
                obI.llenarTablaTiendas(tbTiendas);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("tiendas", txtBusquedaVideojuegos4.getText().trim(), 2);
                obCons.llenarTablaTiendasBus(tbTiendas);
            }
            txtBusquedaVideojuegos5.setText(txtBusquedaVideojuegos4.getText().trim());
            txtBusquedaVideojuegos6.setText(txtBusquedaVideojuegos4.getText().trim());
            txtBusquedaVideojuegos7.setText(txtBusquedaVideojuegos4.getText().trim());
        });
        btnBuscarTiendasElim.addActionListener((e) -> {
            if (txtBusquedaVideojuegos5.getText().trim().length() == 0) {
                obI.llenarTablaTiendas(tbTiendas);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("tiendas", txtBusquedaVideojuegos5.getText().trim(), 2);
                obCons.llenarTablaTiendasBus(tbTiendas);
            }
            txtBusquedaVideojuegos4.setText(txtBusquedaVideojuegos5.getText().trim());
            txtBusquedaVideojuegos6.setText(txtBusquedaVideojuegos5.getText().trim());
            txtBusquedaVideojuegos7.setText(txtBusquedaVideojuegos5.getText().trim());
        });
        btnBuscarTiendasAct.addActionListener((e) -> {
            if (txtBusquedaVideojuegos6.getText().trim().length() == 0) {
                obI.llenarTablaTiendas(tbTiendas);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("tiendas", txtBusquedaVideojuegos6.getText().trim(), 2);
                obCons.llenarTablaTiendasBus(tbTiendas);
            }
            txtBusquedaVideojuegos5.setText(txtBusquedaVideojuegos6.getText().trim());
            txtBusquedaVideojuegos4.setText(txtBusquedaVideojuegos6.getText().trim());
            txtBusquedaVideojuegos7.setText(txtBusquedaVideojuegos6.getText().trim());
        });
        btnBuscarTiendasMostrar.addActionListener((e) -> {
            if (txtBusquedaVideojuegos7.getText().trim().length() == 0) {
                obI.llenarTablaTiendas(tbTiendas);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("tiendas", txtBusquedaVideojuegos7.getText().trim(), 2);
                obCons.llenarTablaTiendasBus(tbTiendas);
            }
            txtBusquedaVideojuegos5.setText(txtBusquedaVideojuegos7.getText().trim());
            txtBusquedaVideojuegos6.setText(txtBusquedaVideojuegos7.getText().trim());
            txtBusquedaVideojuegos4.setText(txtBusquedaVideojuegos7.getText().trim());
        });

        btnBuscarEmpleadosAlta.addActionListener((e) -> {
            if (txtBusquedaVideojuegos8.getText().trim().length() == 0) {
                obI.llenarTablaEmpleados(tbEmp);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionEmpleados(txtBusquedaVideojuegos8.getText().trim());
                obCons.llenarTablaEmpleadosBus(tbEmp);
            }
            txtBusquedaVideojuegos9.setText(txtBusquedaVideojuegos8.getText().trim());
            txtBusquedaVideojuegos10.setText(txtBusquedaVideojuegos8.getText().trim());
            txtBusquedaVideojuegos11.setText(txtBusquedaVideojuegos8.getText().trim());
        });
        btnBuscarEmpleadosElim.addActionListener((e) -> {
            if (txtBusquedaVideojuegos9.getText().trim().length() == 0) {
                obI.llenarTablaEmpleados(tbEmp);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionEmpleados(txtBusquedaVideojuegos9.getText().trim());
                obCons.llenarTablaEmpleadosBus(tbEmp);
            }
            txtBusquedaVideojuegos8.setText(txtBusquedaVideojuegos9.getText().trim());
            txtBusquedaVideojuegos10.setText(txtBusquedaVideojuegos9.getText().trim());
            txtBusquedaVideojuegos11.setText(txtBusquedaVideojuegos9.getText().trim());
        });
        btnBuscarEmpleadosAct.addActionListener((e) -> {
            if (txtBusquedaVideojuegos10.getText().trim().length() == 0) {
                obI.llenarTablaEmpleados(tbEmp);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionEmpleados(txtBusquedaVideojuegos10.getText().trim());
                obCons.llenarTablaEmpleadosBus(tbEmp);
            }
            txtBusquedaVideojuegos9.setText(txtBusquedaVideojuegos10.getText().trim());
            txtBusquedaVideojuegos8.setText(txtBusquedaVideojuegos10.getText().trim());
            txtBusquedaVideojuegos11.setText(txtBusquedaVideojuegos10.getText().trim());
        });
        btnBuscarEmpleadosMostrar.addActionListener((e) -> {
            if (txtBusquedaVideojuegos11.getText().trim().length() == 0) {
                obI.llenarTablaEmpleados(tbEmp);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionEmpleados(txtBusquedaVideojuegos11.getText().trim());
                obCons.llenarTablaEmpleadosBus(tbEmp);
            }
            txtBusquedaVideojuegos9.setText(txtBusquedaVideojuegos11.getText().trim());
            txtBusquedaVideojuegos10.setText(txtBusquedaVideojuegos11.getText().trim());
            txtBusquedaVideojuegos8.setText(txtBusquedaVideojuegos11.getText().trim());
        });

        btnBuscarClientesAlta.addActionListener((e) -> {
            if (txtBusquedaVideojuegos12.getText().trim().length() == 0) {
                obI.llenarTablaClientes(tbClientes);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("clientes", txtBusquedaVideojuegos12.getText().trim(), 4);
                obCons.llenarTablaClientesBus(tbClientes);
            }
            txtBusquedaVideojuegos13.setText(txtBusquedaVideojuegos12.getText().trim());
            txtBusquedaVideojuegos14.setText(txtBusquedaVideojuegos12.getText().trim());
            txtBusquedaVideojuegos15.setText(txtBusquedaVideojuegos12.getText().trim());
        });
        btnBuscarClientesElim.addActionListener((e) -> {
            if (txtBusquedaVideojuegos13.getText().trim().length() == 0) {
                obI.llenarTablaClientes(tbClientes);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("clientes", txtBusquedaVideojuegos13.getText().trim(), 4);
                obCons.llenarTablaClientesBus(tbClientes);
            }
            txtBusquedaVideojuegos12.setText(txtBusquedaVideojuegos13.getText().trim());
            txtBusquedaVideojuegos14.setText(txtBusquedaVideojuegos13.getText().trim());
            txtBusquedaVideojuegos15.setText(txtBusquedaVideojuegos13.getText().trim());
        });
        btnBuscarClientesAct.addActionListener((e) -> {
            if (txtBusquedaVideojuegos14.getText().trim().length() == 0) {
                obI.llenarTablaClientes(tbClientes);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("clientes", txtBusquedaVideojuegos14.getText().trim(), 4);
                obCons.llenarTablaClientesBus(tbClientes);
            }
            txtBusquedaVideojuegos13.setText(txtBusquedaVideojuegos14.getText().trim());
            txtBusquedaVideojuegos12.setText(txtBusquedaVideojuegos14.getText().trim());
            txtBusquedaVideojuegos15.setText(txtBusquedaVideojuegos14.getText().trim());
        });
        btnBuscarClientesMostrar.addActionListener((e) -> {
            if (txtBusquedaVideojuegos15.getText().trim().length() == 0) {
                obI.llenarTablaClientes(tbClientes);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("clientes", txtBusquedaVideojuegos15.getText().trim(), 4);
                obCons.llenarTablaClientesBus(tbClientes);
            }
            txtBusquedaVideojuegos13.setText(txtBusquedaVideojuegos15.getText().trim());
            txtBusquedaVideojuegos14.setText(txtBusquedaVideojuegos15.getText().trim());
            txtBusquedaVideojuegos12.setText(txtBusquedaVideojuegos15.getText().trim());
        });

        btnBuscarProveedoresAlta.addActionListener((e) -> {
            if (txtBusquedaVideojuegos16.getText().trim().length() == 0) {
                obI.llenarTablaProveedores(tbProv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("proveedores", txtBusquedaVideojuegos16.getText().trim(), 3);
                obCons.llenarTablaProveedoresBus(tbProv);
            }
            txtBusquedaVideojuegos17.setText(txtBusquedaVideojuegos16.getText().trim());
            txtBusquedaVideojuegos18.setText(txtBusquedaVideojuegos16.getText().trim());
            txtBusquedaVideojuegos19.setText(txtBusquedaVideojuegos16.getText().trim());
        });
        btnBuscarProveedoresElim.addActionListener((e) -> {
            if (txtBusquedaVideojuegos17.getText().trim().length() == 0) {
                obI.llenarTablaProveedores(tbProv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("proveedores", txtBusquedaVideojuegos17.getText().trim(), 3);
                obCons.llenarTablaProveedoresBus(tbProv);
            }
            txtBusquedaVideojuegos16.setText(txtBusquedaVideojuegos17.getText().trim());
            txtBusquedaVideojuegos18.setText(txtBusquedaVideojuegos17.getText().trim());
            txtBusquedaVideojuegos19.setText(txtBusquedaVideojuegos17.getText().trim());
        });
        btnBuscarProveedoresAct.addActionListener((e) -> {
            if (txtBusquedaVideojuegos18.getText().trim().length() == 0) {
                obI.llenarTablaProveedores(tbProv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("proveedores", txtBusquedaVideojuegos18.getText().trim(), 3);
                obCons.llenarTablaProveedoresBus(tbProv);
            }
            txtBusquedaVideojuegos17.setText(txtBusquedaVideojuegos18.getText().trim());
            txtBusquedaVideojuegos16.setText(txtBusquedaVideojuegos18.getText().trim());
            txtBusquedaVideojuegos19.setText(txtBusquedaVideojuegos18.getText().trim());
        });
        btnBuscarProveedoresMostrar.addActionListener((e) -> {
            if (txtBusquedaVideojuegos19.getText().trim().length() == 0) {
                obI.llenarTablaProveedores(tbProv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacion("proveedores", txtBusquedaVideojuegos19.getText().trim(), 3);
                obCons.llenarTablaProveedoresBus(tbProv);
            }
            txtBusquedaVideojuegos17.setText(txtBusquedaVideojuegos19.getText().trim());
            txtBusquedaVideojuegos18.setText(txtBusquedaVideojuegos19.getText().trim());
            txtBusquedaVideojuegos16.setText(txtBusquedaVideojuegos19.getText().trim());
        });

        btnBuscarInventarioAlta.addActionListener((e) -> {
            if (txtBusquedaVideojuegos20.getText().trim().length() == 0) {
                obI.llenarTablaInventario(tbInv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionInventario(txtBusquedaVideojuegos20.getText().trim());
                obCons.llenarTablaInventario(tbInv);
            }
            txtBusquedaVideojuegos21.setText(txtBusquedaVideojuegos20.getText().trim());
            txtBusquedaVideojuegos22.setText(txtBusquedaVideojuegos20.getText().trim());
            txtBusquedaVideojuegos23.setText(txtBusquedaVideojuegos20.getText().trim());
        });
        btnBuscarInventarioElim.addActionListener((e) -> {
            if (txtBusquedaVideojuegos21.getText().trim().length() == 0) {
                obI.llenarTablaInventario(tbInv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionInventario(txtBusquedaVideojuegos21.getText().trim());
                obCons.llenarTablaInventario(tbInv);
            }
            txtBusquedaVideojuegos20.setText(txtBusquedaVideojuegos21.getText().trim());
            txtBusquedaVideojuegos22.setText(txtBusquedaVideojuegos21.getText().trim());
            txtBusquedaVideojuegos23.setText(txtBusquedaVideojuegos21.getText().trim());
        });
        btnBuscarInventarioAct.addActionListener((e) -> {
            if (txtBusquedaVideojuegos22.getText().trim().length() == 0) {
                obI.llenarTablaInventario(tbInv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionInventario(txtBusquedaVideojuegos22.getText().trim());
                obCons.llenarTablaInventario(tbInv);
            }
            txtBusquedaVideojuegos21.setText(txtBusquedaVideojuegos22.getText().trim());
            txtBusquedaVideojuegos20.setText(txtBusquedaVideojuegos22.getText().trim());
            txtBusquedaVideojuegos23.setText(txtBusquedaVideojuegos22.getText().trim());
        });
        btnBuscarInventarioMostrar.addActionListener((e) -> {
            if (txtBusquedaVideojuegos23.getText().trim().length() == 0) {
                obI.llenarTablaInventario(tbInv);
            } else {
                ConsultasGenerales obCons = new ConsultasGenerales();
                obCons.buscarInformacionInventario(txtBusquedaVideojuegos23.getText().trim());
                obCons.llenarTablaInventario(tbInv);
            }
            txtBusquedaVideojuegos21.setText(txtBusquedaVideojuegos23.getText().trim());
            txtBusquedaVideojuegos22.setText(txtBusquedaVideojuegos23.getText().trim());
            txtBusquedaVideojuegos20.setText(txtBusquedaVideojuegos23.getText().trim());
        });

        // Filtros de busqueda
        btnFiltrarVideojuegos.addActionListener((e) -> {
            String aux = String.valueOf(comboVideojuegos.getSelectedItem());
            switch (aux) {
                case "ID":
                    obI.llenarTablaVideojuegosCampo(tbVideojuegos, "id_videojuego");
                    break;
                case "Nombre":
                    obI.llenarTablaVideojuegosCampo(tbVideojuegos, "Nombre");
                    break;
                case "Categoria":
                    obI.llenarTablaVideojuegosCampo(tbVideojuegos, "Categoria");
                    break;
                case "Precio":
                    obI.llenarTablaVideojuegosCampo(tbVideojuegos, "Precio");
                    break;
                case "Cont. Categoria":
                    obI.llenarTablaVideojuegosCategoria(tbVideojuegos);
                    break;
            }
        });

        btnFiltrarTiendas.addActionListener((e) -> {
            String aux = String.valueOf(comboTiendas.getSelectedItem());
            switch (aux) {
                case "ID":
                    obI.llenarTablaTiendasCampo(tbTiendas, "id_tienda");
                    break;
                case "Nombre":
                    obI.llenarTablaTiendasCampo(tbTiendas, "Nombre");
                    break;
                case "Domicilio":
                    obI.llenarTablaTiendasCampo(tbTiendas, "Domicilio");
                    break;
                case "Cont. Ventas":
                    obI.llenarTablaTiendasVentas(tbTiendas);
                    break;
                case "Cont. Empleados":
                    obI.llenarTablaTiendasEmpleados(tbTiendas);
                    break;
            }
        });
        btnFiltrarProveedores.addActionListener((e) -> {
            String aux = String.valueOf(comboProveedores.getSelectedItem());
            switch (aux) {
                case "ID":
                    obI.llenarTablaProveedoresCampo(tbProv, "id_proveedor");
                    break;
                case "Nombre":
                    obI.llenarTablaProveedoresCampo(tbProv, "Nombre");
                    break;
                case "Domicilio":
                    obI.llenarTablaProveedoresCampo(tbProv, "Domicilio");
                    break;
                case "Telefono":
                    obI.llenarTablaProveedoresCampo(tbProv, "Telefono");
                    break;
                case "Correo":
                    obI.llenarTablaProveedoresCampo(tbProv, "Correo");
                    break;
                case "Cant. Surtida":
                    obI.llenarTablaProveedoresCantSurtida(tbProv);
                    break;
            }
        });
        btnFiltrarEmpleados.addActionListener((e) -> {
            String aux = String.valueOf(comboEmpleados.getSelectedItem());
            if (aux.equals("Clientes Atendidos")) {
                obI.llenarTablaEmpleadosAtenciones(tbEmp);
            }
        });

        btnFiltrarClientes.addActionListener((e) -> {
            String aux = String.valueOf(comboClientes.getSelectedItem());
            switch (aux) {
                case "ID":
                    obI.llenarTablaClientesCampo(tbClientes, "id_cliente");
                    break;
                case "Nombre":
                    obI.llenarTablaClientesCampo(tbClientes, "Nombre");
                    break;
                case "Ap. Paterno":
                    obI.llenarTablaClientesCampo(tbClientes, "ApellidoP");
                    break;
                case "Ap. Materno":
                    obI.llenarTablaClientesCampo(tbClientes, "ApellidoM");
                    break;
                case "Fecha Nac.":
                    obI.llenarTablaClientesCampo(tbClientes, "Fecha_Nacimiento");
                    break;
                case "Domicilio":
                    obI.llenarTablaClientesCampo(tbClientes, "Domicilio");
                    break;
                case "Telefono":
                    obI.llenarTablaClientesCampo(tbClientes, "Telefono");
                    break;
                case "Correo":
                    obI.llenarTablaClientesCampo(tbClientes, "Correo");
                    break;
                case "Cont. Compras":
                    obI.llenarTablaClientesCompra(tbClientes);
                    break;
            }
        });
    }

    public void actionListenerButtonsCRUD() {
        // Videojuegos
        crudJuegos.get(0).addActionListener((e) -> {
            obCVid.show(pnlOpcionesVideojuegos, "card1");
        });
        crudJuegos.get(1).addActionListener((e) -> {
            obCVid.show(pnlOpcionesVideojuegos, "card2");
        });
        crudJuegos.get(2).addActionListener((e) -> {
            obCVid.show(pnlOpcionesVideojuegos, "card3");
        });
        crudJuegos.get(3).addActionListener((e) -> {
            obCVid.show(pnlOpcionesVideojuegos, "card4");
        });

        // Tiendas
        crudTiendas.get(0).addActionListener((e) -> {
            obCTien.show(pnlOpcionesTiendas, "card1");
        });
        crudTiendas.get(1).addActionListener((e) -> {
            obCTien.show(pnlOpcionesTiendas, "card2");
        });
        crudTiendas.get(2).addActionListener((e) -> {
            obCTien.show(pnlOpcionesTiendas, "card3");
        });
        crudTiendas.get(3).addActionListener((e) -> {
            obCTien.show(pnlOpcionesTiendas, "card4");
        });

        // Empleados
        crudEmpleados.get(0).addActionListener((e) -> {
            obCEmp.show(pnlOpcionesEmpleados, "card1");
        });
        crudEmpleados.get(1).addActionListener((e) -> {
            obCEmp.show(pnlOpcionesEmpleados, "card2");
        });
        crudEmpleados.get(2).addActionListener((e) -> {
            obCEmp.show(pnlOpcionesEmpleados, "card3");
        });
        crudEmpleados.get(3).addActionListener((e) -> {
            obCEmp.show(pnlOpcionesEmpleados, "card4");
        });

        // Clientes
        crudClientes.get(0).addActionListener((e) -> {
            obCCli.show(pnlOpcionesClientes, "card1");
        });
        crudClientes.get(1).addActionListener((e) -> {
            obCCli.show(pnlOpcionesClientes, "card2");
        });
        crudClientes.get(2).addActionListener((e) -> {
            obCCli.show(pnlOpcionesClientes, "card3");
        });
        crudClientes.get(3).addActionListener((e) -> {
            obCCli.show(pnlOpcionesClientes, "card4");
        });

        // Proveedores
        crudProv.get(0).addActionListener((e) -> {
            obCProv.show(pnlOpcionesProveedores, "card1");
        });
        crudProv.get(1).addActionListener((e) -> {
            obCProv.show(pnlOpcionesProveedores, "card2");
        });
        crudProv.get(2).addActionListener((e) -> {
            obCProv.show(pnlOpcionesProveedores, "card3");
        });
        crudProv.get(3).addActionListener((e) -> {
            obCProv.show(pnlOpcionesProveedores, "card4");
        });

        // Inventario
        crudInv.get(0).addActionListener((e) -> {
            obCInv.show(pnlOpcionesInventario, "card1");
        });
        crudInv.get(1).addActionListener((e) -> {
            obCInv.show(pnlOpcionesInventario, "card2");
        });
        crudInv.get(2).addActionListener((e) -> {
            obCInv.show(pnlOpcionesInventario, "card3");
        });
        crudInv.get(3).addActionListener((e) -> {
            obCInv.show(pnlOpcionesInventario, "card4");
        });
    }

    public void initCRUD() {
        crudJuegos = new ArrayList<>();
        crudClientes = new ArrayList<>();
        crudEmpleados = new ArrayList<>();
        crudProv = new ArrayList<>();
        crudTiendas = new ArrayList<>();
        crudInv = new ArrayList<>();
        initButtonsCRUD(pnlOpcVideojuegos, crudJuegos);
        initButtonsCRUD(pnlOpcTiendas, crudTiendas);
        initButtonsCRUD(pnlOpcEmpleados, crudEmpleados);
        initButtonsCRUD(pnlOpcClientes, crudClientes);
        initButtonsCRUD(pnlOpcProveedores, crudProv);
        initButtonsCRUD(pnlOpcInventario, crudInv);
    }

    public void initButtonsCRUD(PanelRound pnl, ArrayList<RoundButton> buttons) {
        RoundButton btnAlta = null, btnBaja = null, btnActualizar = null, btnMostrar = null;

        btnAlta = obE.getStyleMenuBtn(btnAlta, pnl);
        btnAlta.setText("Añadir");
        btnAlta.setIcon(new ImageIcon("./src/main/java/Resources/alta.png"));
        btnAlta.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnAlta.setBorderColor(new Color(20, 20, 20));

        btnBaja = obE.getStyleMenuBtn(btnBaja, pnl);
        btnBaja.setText("Eliminar");
        btnBaja.setIcon(new ImageIcon("./src/main/java/Resources/baja.png"));
        btnBaja.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnBaja.setBorderColor(new Color(20, 20, 20));

        btnActualizar = obE.getStyleMenuBtn(btnActualizar, pnl);
        btnActualizar.setText("Actualizar");
        btnActualizar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnActualizar.setIcon(new ImageIcon("./src/main/java/Resources/actualizar.png"));
        btnActualizar.setBorderColor(new Color(20, 20, 20));

        btnMostrar = obE.getStyleMenuBtn(btnMostrar, pnl);
        btnMostrar.setText("Mostrar");
        btnMostrar.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnMostrar.setIcon(new ImageIcon("./src/main/java/Resources/consulta.png"));
        btnMostrar.setBorderColor(new Color(20, 20, 20));

        buttons.add(btnAlta);
        buttons.add(btnBaja);
        buttons.add(btnActualizar);
        buttons.add(btnMostrar);
    }

    public static void contraerCompIzq(JComponent componente, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = componente.getWidth(); i >= parar; i -= saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        componente.setPreferredSize(new Dimension(i, componente.getHeight()));
                        SwingUtilities.updateComponentTreeUI(componente);
                    } catch (InterruptedException e) {
                        System.out.println("Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }

    public static void expandirCompDer(JComponent componente, int milisegundos, int saltos, int parar) {
        (new Thread() {
            @Override
            public void run() {
                for (int i = componente.getWidth(); i <= parar; i += saltos) {
                    try {
                        Thread.sleep(milisegundos);
                        componente.setPreferredSize(new Dimension(i, componente.getHeight()));
                        SwingUtilities.updateComponentTreeUI(componente);
                    } catch (InterruptedException e) {
                        System.out.println("Thread Interrumpido: " + e);
                    }
                }
            }
        }).start();
    }

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
            java.util.logging.Logger.getLogger(VentanaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRegistros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRegistros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboClientes;
    private javax.swing.JComboBox<String> comboEmpleados;
    private javax.swing.JComboBox<String> comboProveedores;
    private javax.swing.JComboBox<String> comboTiendas;
    private javax.swing.JComboBox<String> comboVideojuegos;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblCantVendida;
    private javax.swing.JLabel lblCatPopular;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblCliCont;
    private javax.swing.JLabel lblClienteMejor;
    private javax.swing.JLabel lblClientes;
    private javax.swing.JLabel lblCompraCont;
    private javax.swing.JLabel lblEmp;
    private javax.swing.JLabel lblEmpCont;
    private javax.swing.JLabel lblEmpMasAtenciones;
    private javax.swing.JLabel lblEmpMejorSueldo;
    private javax.swing.JLabel lblEmpleadoAtento;
    private javax.swing.JLabel lblEmpleadoSueldo;
    private javax.swing.JLabel lblIngresosVentas;
    private javax.swing.JLabel lblInv;
    private javax.swing.JLabel lblInvCont;
    private javax.swing.JLabel lblInvStock;
    private javax.swing.JLabel lblJuegoMasVen;
    private javax.swing.JLabel lblJuegoMasVenCant;
    private javax.swing.JLabel lblJuegoMasVend;
    private javax.swing.JLabel lblJuegoMenosVen;
    private javax.swing.JLabel lblJuegoMenosVenCant;
    private javax.swing.JLabel lblJuegoMenosVend;
    private javax.swing.JLabel lblMasVend;
    private javax.swing.JLabel lblMasVendido;
    private javax.swing.JLabel lblMejorCliente;
    private javax.swing.JLabel lblMenosVend;
    private javax.swing.JLabel lblMenosVendido;
    private javax.swing.JLabel lblProv;
    private javax.swing.JLabel lblProvActivo;
    private javax.swing.JLabel lblProvCont;
    private javax.swing.JLabel lblProvMasActivo;
    private javax.swing.JLabel lblTienCont;
    private javax.swing.JLabel lblTienda;
    private javax.swing.JLabel lblTiendaMas;
    private javax.swing.JLabel lblTiendaMasVentas;
    private javax.swing.JLabel lblTiendaMasVisitada;
    private javax.swing.JLabel lblTiendaMenosVentas;
    private javax.swing.JLabel lblVentas;
    private javax.swing.JLabel lblVidCont;
    private javax.swing.JLabel lblVideo;
    private CustomComponents.PanelGradient panelGradient1;
    private CustomComponents.PanelGradient panelGradient10;
    private CustomComponents.PanelGradient panelGradient11;
    private CustomComponents.PanelGradient panelGradient12;
    private CustomComponents.PanelGradient panelGradient13;
    private CustomComponents.PanelGradient panelGradient14;
    private CustomComponents.PanelGradient panelGradient15;
    private CustomComponents.PanelGradient panelGradient16;
    private CustomComponents.PanelGradient panelGradient17;
    private CustomComponents.PanelGradient panelGradient18;
    private CustomComponents.PanelGradient panelGradient19;
    private CustomComponents.PanelGradient panelGradient2;
    private CustomComponents.PanelGradient panelGradient20;
    private CustomComponents.PanelGradient panelGradient3;
    private CustomComponents.PanelGradient panelGradient4;
    private CustomComponents.PanelGradient panelGradient5;
    private CustomComponents.PanelGradient panelGradient6;
    private CustomComponents.PanelGradient panelGradient7;
    private CustomComponents.PanelGradient panelGradient8;
    private CustomComponents.PanelGradient panelGradient9;
    private CustomComponents.PanelRound panelRound1;
    private CustomComponents.PanelRound panelRound10;
    private CustomComponents.PanelRound panelRound11;
    private CustomComponents.PanelRound panelRound12;
    private CustomComponents.PanelRound panelRound13;
    private CustomComponents.PanelRound panelRound14;
    private CustomComponents.PanelRound panelRound15;
    private CustomComponents.PanelRound panelRound16;
    private CustomComponents.PanelRound panelRound17;
    private CustomComponents.PanelRound panelRound18;
    private CustomComponents.PanelRound panelRound19;
    private CustomComponents.PanelRound panelRound2;
    private CustomComponents.PanelRound panelRound20;
    private CustomComponents.PanelRound panelRound21;
    private CustomComponents.PanelRound panelRound22;
    private CustomComponents.PanelRound panelRound23;
    private CustomComponents.PanelRound panelRound24;
    private CustomComponents.PanelRound panelRound25;
    private CustomComponents.PanelRound panelRound26;
    private CustomComponents.PanelRound panelRound27;
    private CustomComponents.PanelRound panelRound28;
    private CustomComponents.PanelRound panelRound29;
    private CustomComponents.PanelRound panelRound3;
    private CustomComponents.PanelRound panelRound30;
    private CustomComponents.PanelRound panelRound31;
    private CustomComponents.PanelRound panelRound32;
    private CustomComponents.PanelRound panelRound33;
    private CustomComponents.PanelRound panelRound34;
    private CustomComponents.PanelRound panelRound35;
    private CustomComponents.PanelRound panelRound36;
    private CustomComponents.PanelRound panelRound37;
    private CustomComponents.PanelRound panelRound38;
    private CustomComponents.PanelRound panelRound39;
    private CustomComponents.PanelRound panelRound4;
    private CustomComponents.PanelRound panelRound40;
    private CustomComponents.PanelRound panelRound41;
    private CustomComponents.PanelRound panelRound5;
    private CustomComponents.PanelRound panelRound6;
    private CustomComponents.PanelRound panelRound7;
    private CustomComponents.PanelRound panelRound8;
    private CustomComponents.PanelRound panelRound9;
    private javax.swing.JPanel pnlAside;
    private javax.swing.JPanel pnlButtonsClientesAct;
    private javax.swing.JPanel pnlButtonsClientesAlta;
    private javax.swing.JPanel pnlButtonsClientesElim;
    private javax.swing.JPanel pnlButtonsClientesMostrar;
    private javax.swing.JPanel pnlButtonsEmpleadosAct;
    private javax.swing.JPanel pnlButtonsEmpleadosAlta;
    private javax.swing.JPanel pnlButtonsEmpleadosElim;
    private javax.swing.JPanel pnlButtonsEmpleadosMostrar;
    private javax.swing.JPanel pnlButtonsInvAct;
    private javax.swing.JPanel pnlButtonsInvAlta;
    private javax.swing.JPanel pnlButtonsInvElim;
    private javax.swing.JPanel pnlButtonsInvMostrar;
    private javax.swing.JPanel pnlButtonsProvAct;
    private javax.swing.JPanel pnlButtonsProvAlta;
    private javax.swing.JPanel pnlButtonsProvElim;
    private javax.swing.JPanel pnlButtonsProvMostrar;
    private javax.swing.JPanel pnlButtonsTiendasAct;
    private javax.swing.JPanel pnlButtonsTiendasAlta;
    private javax.swing.JPanel pnlButtonsTiendasElim;
    private javax.swing.JPanel pnlButtonsTiendasMostrar;
    private javax.swing.JPanel pnlButtonsVideojuegosAct;
    private javax.swing.JPanel pnlButtonsVideojuegosAlta;
    private javax.swing.JPanel pnlButtonsVideojuegosElim;
    private javax.swing.JPanel pnlButtonsVideojuegosMostrar;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlEmpleados;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlHeaderButtons;
    private javax.swing.JPanel pnlHeaderButtons1;
    private javax.swing.JPanel pnlInventario;
    private javax.swing.JPanel pnlMain;
    private CustomComponents.PanelRound pnlMenuContainer;
    private CustomComponents.PanelRound pnlOpcClientes;
    private CustomComponents.PanelRound pnlOpcEmpleados;
    private CustomComponents.PanelRound pnlOpcInventario;
    private CustomComponents.PanelRound pnlOpcProveedores;
    private CustomComponents.PanelRound pnlOpcTiendas;
    private CustomComponents.PanelRound pnlOpcVideojuegos;
    private javax.swing.JPanel pnlOpcionesClientes;
    private javax.swing.JPanel pnlOpcionesEmpleados;
    private javax.swing.JPanel pnlOpcionesInventario;
    private javax.swing.JPanel pnlOpcionesProveedores;
    private javax.swing.JPanel pnlOpcionesTiendas;
    private javax.swing.JPanel pnlOpcionesVideojuegos;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlProveedores;
    private javax.swing.JPanel pnlTiendas;
    private javax.swing.JPanel pnlVideojuegos;
    private javax.swing.JScrollPane scrollClientes;
    private javax.swing.JScrollPane scrollEmp;
    private javax.swing.JScrollPane scrollInv;
    private javax.swing.JScrollPane scrollProv;
    private javax.swing.JScrollPane scrollTiendas;
    private javax.swing.JScrollPane scrollVideojuegos;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTable tbEmp;
    private javax.swing.JTable tbInv;
    private javax.swing.JTable tbProv;
    private javax.swing.JTable tbTiendas;
    private javax.swing.JTable tbVideojuegos;
    private javax.swing.JTextField txtBusquedaVideojuegos;
    private javax.swing.JTextField txtBusquedaVideojuegos1;
    private javax.swing.JTextField txtBusquedaVideojuegos10;
    private javax.swing.JTextField txtBusquedaVideojuegos11;
    private javax.swing.JTextField txtBusquedaVideojuegos12;
    private javax.swing.JTextField txtBusquedaVideojuegos13;
    private javax.swing.JTextField txtBusquedaVideojuegos14;
    private javax.swing.JTextField txtBusquedaVideojuegos15;
    private javax.swing.JTextField txtBusquedaVideojuegos16;
    private javax.swing.JTextField txtBusquedaVideojuegos17;
    private javax.swing.JTextField txtBusquedaVideojuegos18;
    private javax.swing.JTextField txtBusquedaVideojuegos19;
    private javax.swing.JTextField txtBusquedaVideojuegos2;
    private javax.swing.JTextField txtBusquedaVideojuegos20;
    private javax.swing.JTextField txtBusquedaVideojuegos21;
    private javax.swing.JTextField txtBusquedaVideojuegos22;
    private javax.swing.JTextField txtBusquedaVideojuegos23;
    private javax.swing.JTextField txtBusquedaVideojuegos3;
    private javax.swing.JTextField txtBusquedaVideojuegos4;
    private javax.swing.JTextField txtBusquedaVideojuegos5;
    private javax.swing.JTextField txtBusquedaVideojuegos6;
    private javax.swing.JTextField txtBusquedaVideojuegos7;
    private javax.swing.JTextField txtBusquedaVideojuegos8;
    private javax.swing.JTextField txtBusquedaVideojuegos9;
    private javax.swing.JPanel vidAct;
    private javax.swing.JPanel vidAct1;
    private javax.swing.JPanel vidAct2;
    private javax.swing.JPanel vidAct3;
    private javax.swing.JPanel vidAct4;
    private javax.swing.JPanel vidAct5;
    private javax.swing.JPanel vidAlta;
    private javax.swing.JPanel vidAlta1;
    private javax.swing.JPanel vidAlta2;
    private javax.swing.JPanel vidAlta3;
    private javax.swing.JPanel vidAlta4;
    private javax.swing.JPanel vidAlta5;
    private javax.swing.JPanel vidElim;
    private javax.swing.JPanel vidElim1;
    private javax.swing.JPanel vidElim2;
    private javax.swing.JPanel vidElim3;
    private javax.swing.JPanel vidElim4;
    private javax.swing.JPanel vidElim5;
    private javax.swing.JPanel vidMostrar;
    private javax.swing.JPanel vidMostrar1;
    private javax.swing.JPanel vidMostrar2;
    private javax.swing.JPanel vidMostrar3;
    private javax.swing.JPanel vidMostrar4;
    private javax.swing.JPanel vidMostrar5;
    // End of variables declaration//GEN-END:variables
}
