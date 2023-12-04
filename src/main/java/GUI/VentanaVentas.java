package GUI;

import CustomComponents.EstilosComponentes;
import CustomComponents.PanelVideojuego;
import CustomComponents.RoundButton;
import CustomComponents.ScrollBarCustom;
import Funciones.Dashboard.ConsultasGenerales;
import Funciones.Entidades.CRUDClientes;
import Funciones.Entidades.CRUDVideojuegos;
import Funciones.TablasListas.LlenadoInformacion;
import TDA.Entidades.Cliente;
import TDA.Entidades.Videojuego;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VentanaVentas extends javax.swing.JFrame {

    private RoundButton btnVentas, btnProv, btnClientes, btnSalir, btnAgregarClientes, btnEliminarClientes, btnActClientes;
    private VentanaAltas alta;
    private VentanaActualizaciones actualizar;
    private CRUDClientes sqlClientes;
    private ConsultasGenerales obCons;
    private EstilosComponentes obE;
    private LlenadoInformacion obI;
    private CardLayout obC;
    private ArrayList<JTextField> txtsVideojuegos;
    private ArrayList<RoundButton> buttonsVideojuegos;
    private ArrayList<Videojuego> dataVideojuegos;
    private int idTiendaTrabajo; //Esta id se ingresará desde el LOGIN
    private JLabel lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, stock1, stock2, stock3;
    private String user;

    public VentanaVentas() {
        initComponents();
        buttonsVideojuegos = new ArrayList<>();
        dataVideojuegos = new ArrayList<>();
        txtsVideojuegos = new ArrayList<>();
        obCons = new ConsultasGenerales();
        obI = new LlenadoInformacion();
        sqlClientes = new CRUDClientes();
        obC = (CardLayout) pnlMain.getLayout();
        obE = new EstilosComponentes();
        setLocationRelativeTo(this);
        initComponentsCustom();
    }

    public void setTiendaTrabajo(int idTiendaTrabajo) {
        this.idTiendaTrabajo = idTiendaTrabajo;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void initButtonsCliente() {
        btnAgregarClientes = obE.getStyleButtonAdd(btnAgregarClientes);
        btnEliminarClientes = obE.getStyleButtonEliminar(btnEliminarClientes);
        btnActClientes = obE.getStyleButtonUpdate(btnActClientes);

        btnAgregarClientes.addActionListener((e) -> {
            alta = new VentanaAltas();
            alta.setStr("altaClientes", "Clientes", "./src/main/java/Resources/selectedCliente.png");
            alta.setTitle("Agregar cliente");
            alta.setTbClientes(tbClientes1);
            alta.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, stock1, stock2, stock3);
            alta.setVisible(true);
            alta.setUser(user);
        });

        btnEliminarClientes.addActionListener((e) -> {
            int selectedRowIndex = tbClientes1.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbClientes1.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));

                sqlClientes.deleteCliente(id);
                cargarDatosGenerales();
                obI.llenarTablaClientes(tbClientes1);
                JOptionPane.showMessageDialog(null, "Se ha eliminado el registro", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnActClientes.addActionListener((e) -> {
            int selectedRowIndex = tbClientes1.getSelectedRow();
            if (selectedRowIndex != -1) {
                Object aux = tbClientes1.getModel().getValueAt(selectedRowIndex, 0);
                int id = Integer.parseInt(String.valueOf(aux));
                actualizar = new VentanaActualizaciones();
                actualizar.setTitle("Actualizar cliente");
                actualizar.setTbClientes(tbClientes1);

                sqlClientes.selectCliente();
                for (Cliente c : sqlClientes.getData()) {
                    if (c.getId() == id) {
                        actualizar.setCliente(c, id);
                        break;
                    }
                }

                actualizar.setStr("altaClientes", "Clientes", "./src/main/java/Resources/selectedCliente.png");
                actualizar.setValuesGen(lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, stock1, stock2, stock3);
                actualizar.setVisible(true);
                actualizar.setUser(user);
            } else {
                JOptionPane.showMessageDialog(null, "Ningun elemento seleccionado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void initComponentsCustom() {
        obI.llenarTablaClientes(tbClientes1);

        btnVentas = obE.getStyleMenuBtn(btnVentas, pnlMenuData);
        btnVentas.setVerticalTextPosition(SwingConstants.CENTER);
        btnVentas.setHorizontalTextPosition(SwingConstants.TRAILING);
        btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventaSelected.png"));
        btnVentas.setForeground(new Color(25, 200, 178));
        btnVentas.setText("Punto de venta");
        btnVentas.setIconTextGap(15);
        btnVentas.addActionListener((e) -> {
            btnVentas.setForeground(new Color(25, 200, 178));
            btnProv.setForeground(new Color(100, 100, 100));
            btnClientes.setForeground(new Color(100, 100, 100));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/ventaSelected.png"));
            btnProv.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            obC.show(pnlMain, "card1");
        });

        btnProv = obE.getStyleMenuBtn(btnProv, pnlMenuData);
        btnProv.setVerticalTextPosition(SwingConstants.CENTER);
        btnProv.setHorizontalTextPosition(SwingConstants.TRAILING);
        btnProv.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
        btnProv.setText("Registrar ingresos");
        btnProv.setIconTextGap(15);
        btnProv.addActionListener((e) -> {
            btnProv.setForeground(new Color(25, 200, 178));
            btnVentas.setForeground(new Color(100, 100, 100));
            btnClientes.setForeground(new Color(100, 100, 100));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/venta.png"));
            btnProv.setIcon(new ImageIcon("./src/main/java/Resources/selectedProvV.png"));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
            obC.show(pnlMain, "card2");
        });

        btnClientes = obE.getStyleMenuBtn(btnClientes, pnlMenuData);
        btnClientes.setVerticalTextPosition(SwingConstants.CENTER);
        btnClientes.setHorizontalTextPosition(SwingConstants.TRAILING);
        btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/unselectedCliente.png"));
        btnClientes.setText("Gestionar clientes");
        btnClientes.setIconTextGap(15);
        btnClientes.addActionListener((e) -> {
            btnClientes.setForeground(new Color(25, 200, 178));
            btnVentas.setForeground(new Color(100, 100, 100));
            btnProv.setForeground(new Color(100, 100, 100));
            btnClientes.setIcon(new ImageIcon("./src/main/java/Resources/selectedClienteV.png"));
            btnVentas.setIcon(new ImageIcon("./src/main/java/Resources/venta.png"));
            btnProv.setIcon(new ImageIcon("./src/main/java/Resources/unselectedProv.png"));
            obC.show(pnlMain, "card3");
        });

        btnSalir = new RoundButton(new Color(247, 81, 101), new Color(255, 125, 141), new Color(255, 168, 179), new Color(20, 20, 20), 20);
        btnSalir.setForeground(Color.white);
        btnSalir.setText("Salir");
        btnSalir.setIcon(new ImageIcon("./src/main/java/Resources/salir2.png"));
        btnSalir.setFocusable(false);
        btnSalir.setBorder(new EmptyBorder(10, 10, 10, 15));
        btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnSalir.setIconTextGap(10);
        btnSalir.addActionListener((e) -> {
            System.exit(0);
        });
        pnlHeader.add(btnSalir, BorderLayout.EAST);

        jLabel14.setIcon(new ImageIcon("./src/main/java/Resources/carrito.png"));
        obE.setStyleTableDefault(tbCarrito, scrollCarrito, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));

        scrollVideojuegos.setVerticalScrollBar(new ScrollBarCustom(new Color(10, 10, 10), new Color(100, 100, 100)));
        scrollVideojuegos.getViewport().setBackground(new Color(30, 30, 30));
        JPanel corner = new JPanel();
        corner.setBackground(new Color(40, 40, 40));
        scrollVideojuegos.setCorner(JScrollPane.UPPER_RIGHT_CORNER, corner);
        scrollVideojuegos.setBorder(new LineBorder(new Color(10, 10, 10), 5, true));
        scrollVideojuegos.setBorder(new EmptyBorder(5, 5, 10, 5));
        scrollVideojuegos.setOpaque(false);

        obE.setStyleTableDefault(tbClientes1, scrollClientes1, new Color(40, 40, 40), new Color(30, 30, 30), new Color(100, 100, 100), new Color(30, 30, 30), new Color(66, 189, 159));
        initButtonsCliente();
        pnlOpcClientes.add(btnAgregarClientes);
        pnlOpcClientes.add(btnEliminarClientes);
        pnlOpcClientes.add(btnActClientes);

        initButtonsVideojuegos();
        System.out.println(buttonsVideojuegos.size());
        if (buttonsVideojuegos.size() == 1) {
            pnlVideojuegos.setLayout(new GridLayout(buttonsVideojuegos.size() + 2, 1, 10, 10));
        } else if (buttonsVideojuegos.size() == 2) {
            pnlVideojuegos.setLayout(new GridLayout(buttonsVideojuegos.size() + 1, 1, 10, 10));
        } else if (buttonsVideojuegos.size() >= 3) {
            pnlVideojuegos.setLayout(new GridLayout(buttonsVideojuegos.size(), 1, 10, 10));
        }
    }

    public void initButtonsVideojuegos() {
        CRUDVideojuegos obV = new CRUDVideojuegos();
        obV.selectVideojuegoVentas(dataVideojuegos);

        idTiendaTrabajo = 5;

        for (Videojuego v : dataVideojuegos) {
            if (v.getIdTienda() == idTiendaTrabajo) {
                System.out.println(v.getNombre() + " - " + v.getStock());
                RoundButton btnAux = new RoundButton(new Color(187, 142, 61), new Color(231, 179, 125), new Color(239, 204, 168), new Color(40, 40, 40), 20);
                buttonsVideojuegos.add(btnAux);
                JTextField txt = new JTextField();
                txtsVideojuegos.add(txt);
                pnlVideojuegos.add(new PanelVideojuego(v.getId(), v.getNombre(), v.getCategoria(), v.getStock(), v.getPrecio(), btnAux, txt));
            }
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

    public ArrayList<Videojuego> getDataVideojuegos() {
        return dataVideojuegos;
    }

    public void setDataVideojuegos(ArrayList<Videojuego> dataVideojuegos) {
        this.dataVideojuegos = dataVideojuegos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        ComboBoxTienda = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ComboBoxCliente = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlHeader = new javax.swing.JPanel();
        pnlMenuData = new CustomComponents.PanelRound();
        pnlMain = new javax.swing.JPanel();
        pnlVentas = new javax.swing.JPanel();
        pnlAside = new javax.swing.JPanel();
        pnlMenuContainer = new CustomComponents.PanelRound();
        jLabel14 = new javax.swing.JLabel();
        scrollCarrito = new javax.swing.JScrollPane();
        tbCarrito = new javax.swing.JTable();
        panelRound1 = new CustomComponents.PanelRound();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        pnlSelectorVideojuegos = new javax.swing.JPanel();
        panelRound2 = new CustomComponents.PanelRound();
        scrollVideojuegos = new javax.swing.JScrollPane();
        pnlVideojuegos = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        pnlProveedores = new javax.swing.JPanel();
        pnlClientes = new javax.swing.JPanel();
        pnlOpcClientes = new CustomComponents.PanelRound();
        jPanel29 = new javax.swing.JPanel();
        panelRound23 = new CustomComponents.PanelRound();
        panelRound27 = new CustomComponents.PanelRound();
        scrollClientes1 = new javax.swing.JScrollPane();
        tbClientes1 = new javax.swing.JTable();

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        ComboBoxTienda.setBackground(new java.awt.Color(30, 30, 30));
        ComboBoxTienda.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ComboBoxTienda.setForeground(new java.awt.Color(200, 200, 200));
        ComboBoxTienda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxTienda.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jPanel2.add(ComboBoxTienda, java.awt.BorderLayout.CENTER);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(100, 100, 100));
        jLabel12.setText("Tienda");
        jLabel12.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel2.add(jLabel12, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 5));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        ComboBoxCliente.setBackground(new java.awt.Color(30, 30, 30));
        ComboBoxCliente.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        ComboBoxCliente.setForeground(new java.awt.Color(200, 200, 200));
        ComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxCliente.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jPanel3.add(ComboBoxCliente, java.awt.BorderLayout.CENTER);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(100, 100, 100));
        jLabel13.setText("Cliente");
        jLabel13.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel3.add(jLabel13, java.awt.BorderLayout.NORTH);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlHeader.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 10, 10, 10));
        pnlHeader.setOpaque(false);
        pnlHeader.setLayout(new java.awt.BorderLayout(5, 5));

        pnlMenuData.setBackground(new java.awt.Color(10, 10, 10));
        pnlMenuData.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlMenuData.setRoundBottomLeft(20);
        pnlMenuData.setRoundBottomRight(20);
        pnlMenuData.setRoundTopLeft(20);
        pnlMenuData.setRoundTopRight(20);
        pnlMenuData.setLayout(new java.awt.GridLayout(1, 3, 5, 5));
        pnlHeader.add(pnlMenuData, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlHeader, java.awt.BorderLayout.PAGE_START);

        pnlMain.setOpaque(false);
        pnlMain.setLayout(new java.awt.CardLayout());

        pnlVentas.setOpaque(false);
        pnlVentas.setLayout(new java.awt.BorderLayout());

        pnlAside.setBackground(new java.awt.Color(63, 63, 63));
        pnlAside.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 5, 5));
        pnlAside.setOpaque(false);
        pnlAside.setLayout(new java.awt.GridLayout(1, 0));

        pnlMenuContainer.setBackground(new java.awt.Color(10, 10, 10));
        pnlMenuContainer.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlMenuContainer.setRoundBottomLeft(20);
        pnlMenuContainer.setRoundBottomRight(20);
        pnlMenuContainer.setRoundTopLeft(20);
        pnlMenuContainer.setRoundTopRight(20);
        pnlMenuContainer.setLayout(new java.awt.BorderLayout(0, 10));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(25, 200, 178));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Carrito");
        jLabel14.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel14.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 0, 5));
        pnlMenuContainer.add(jLabel14, java.awt.BorderLayout.PAGE_START);

        scrollCarrito.setPreferredSize(new java.awt.Dimension(250, 402));

        tbCarrito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Juego", "Cantidad", "Total"
            }
        ));
        tbCarrito.setGridColor(new java.awt.Color(40, 40, 40));
        tbCarrito.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbCarrito.setSelectionForeground(new java.awt.Color(10, 10, 10));
        scrollCarrito.setViewportView(tbCarrito);

        pnlMenuContainer.add(scrollCarrito, java.awt.BorderLayout.CENTER);

        panelRound1.setBackground(new java.awt.Color(40, 40, 40));
        panelRound1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setLayout(new java.awt.BorderLayout());

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.GridLayout(2, 2));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Subtotal");
        jLabel15.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel15.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel5.add(jLabel15);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(130, 130, 130));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("$0.00");
        jLabel16.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel16.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel5.add(jLabel16);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("IVA");
        jLabel17.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel17.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel5.add(jLabel17);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(130, 130, 130));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("$0.00");
        jLabel18.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel18.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel5.add(jLabel18);

        panelRound1.add(jPanel5, java.awt.BorderLayout.WEST);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Total");
        jLabel19.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel19.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel6.add(jLabel19, java.awt.BorderLayout.PAGE_START);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(25, 200, 178));
        jLabel20.setText("$0.00");
        jLabel20.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel6.add(jLabel20, java.awt.BorderLayout.CENTER);

        panelRound1.add(jPanel6, java.awt.BorderLayout.CENTER);

        pnlMenuContainer.add(panelRound1, java.awt.BorderLayout.SOUTH);

        pnlAside.add(pnlMenuContainer);

        pnlVentas.add(pnlAside, java.awt.BorderLayout.WEST);

        pnlSelectorVideojuegos.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 5, 10));
        pnlSelectorVideojuegos.setOpaque(false);
        pnlSelectorVideojuegos.setLayout(new java.awt.BorderLayout());

        panelRound2.setBackground(new java.awt.Color(10, 10, 10));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.BorderLayout(0, 5));

        scrollVideojuegos.setBackground(new java.awt.Color(30, 30, 30));
        scrollVideojuegos.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlVideojuegos.setBackground(new java.awt.Color(10, 10, 10));
        pnlVideojuegos.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        javax.swing.GroupLayout pnlVideojuegosLayout = new javax.swing.GroupLayout(pnlVideojuegos);
        pnlVideojuegos.setLayout(pnlVideojuegosLayout);
        pnlVideojuegosLayout.setHorizontalGroup(
            pnlVideojuegosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );
        pnlVideojuegosLayout.setVerticalGroup(
            pnlVideojuegosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 663, Short.MAX_VALUE)
        );

        scrollVideojuegos.setViewportView(pnlVideojuegos);

        panelRound2.add(scrollVideojuegos, java.awt.BorderLayout.CENTER);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(25, 200, 178));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Seleccione los videojuegos");
        jLabel21.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel21.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panelRound2.add(jLabel21, java.awt.BorderLayout.PAGE_START);

        pnlSelectorVideojuegos.add(panelRound2, java.awt.BorderLayout.CENTER);

        pnlVentas.add(pnlSelectorVideojuegos, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlVentas, "card1");

        pnlProveedores.setOpaque(false);

        javax.swing.GroupLayout pnlProveedoresLayout = new javax.swing.GroupLayout(pnlProveedores);
        pnlProveedores.setLayout(pnlProveedoresLayout);
        pnlProveedoresLayout.setHorizontalGroup(
            pnlProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        pnlProveedoresLayout.setVerticalGroup(
            pnlProveedoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 675, Short.MAX_VALUE)
        );

        pnlMain.add(pnlProveedores, "card2");

        pnlClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 0, 10));
        pnlClientes.setOpaque(false);
        pnlClientes.setLayout(new java.awt.BorderLayout(0, 10));

        pnlOpcClientes.setBackground(new java.awt.Color(10, 10, 10));
        pnlOpcClientes.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlOpcClientes.setRoundBottomLeft(15);
        pnlOpcClientes.setRoundBottomRight(15);
        pnlOpcClientes.setRoundTopLeft(15);
        pnlOpcClientes.setRoundTopRight(15);
        pnlOpcClientes.setLayout(new java.awt.GridLayout(1, 3, 5, 5));
        pnlClientes.add(pnlOpcClientes, java.awt.BorderLayout.NORTH);

        jPanel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 10, 0));
        jPanel29.setOpaque(false);
        jPanel29.setLayout(new java.awt.GridLayout(1, 1));

        panelRound23.setBackground(new java.awt.Color(10, 10, 10));
        panelRound23.setRoundBottomLeft(20);
        panelRound23.setRoundBottomRight(20);
        panelRound23.setRoundTopLeft(20);
        panelRound23.setRoundTopRight(20);
        panelRound23.setLayout(new java.awt.BorderLayout());

        panelRound27.setBackground(new java.awt.Color(10, 10, 10));
        panelRound27.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound27.setRoundBottomLeft(20);
        panelRound27.setRoundBottomRight(20);
        panelRound27.setRoundTopLeft(20);
        panelRound27.setRoundTopRight(20);
        panelRound27.setLayout(new java.awt.BorderLayout());

        tbClientes1.setModel(new javax.swing.table.DefaultTableModel(
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
        tbClientes1.setGridColor(new java.awt.Color(40, 40, 40));
        tbClientes1.setSelectionBackground(new java.awt.Color(66, 189, 159));
        tbClientes1.setSelectionForeground(new java.awt.Color(10, 10, 10));
        tbClientes1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        scrollClientes1.setViewportView(tbClientes1);

        panelRound27.add(scrollClientes1, java.awt.BorderLayout.CENTER);

        panelRound23.add(panelRound27, java.awt.BorderLayout.CENTER);

        jPanel29.add(panelRound23);

        pnlClientes.add(jPanel29, java.awt.BorderLayout.CENTER);

        pnlMain.add(pnlClientes, "card3");

        jPanel1.add(pnlMain, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaVentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCliente;
    private javax.swing.JComboBox<String> ComboBoxTienda;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private CustomComponents.PanelRound panelRound1;
    private CustomComponents.PanelRound panelRound2;
    private CustomComponents.PanelRound panelRound23;
    private CustomComponents.PanelRound panelRound27;
    private javax.swing.JPanel pnlAside;
    private javax.swing.JPanel pnlClientes;
    private javax.swing.JPanel pnlHeader;
    private javax.swing.JPanel pnlMain;
    private CustomComponents.PanelRound pnlMenuContainer;
    private CustomComponents.PanelRound pnlMenuData;
    private CustomComponents.PanelRound pnlOpcClientes;
    private javax.swing.JPanel pnlProveedores;
    private javax.swing.JPanel pnlSelectorVideojuegos;
    private javax.swing.JPanel pnlVentas;
    private javax.swing.JPanel pnlVideojuegos;
    private javax.swing.JScrollPane scrollCarrito;
    private javax.swing.JScrollPane scrollClientes1;
    private javax.swing.JScrollPane scrollVideojuegos;
    private javax.swing.JTable tbCarrito;
    private javax.swing.JTable tbClientes1;
    // End of variables declaration//GEN-END:variables
}
