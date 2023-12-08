package GUI;

import CustomComponents.CustomComboBoxRenderer;
import CustomComponents.EstilosComponentes;
import CustomComponents.PanelVideojuego;
import CustomComponents.RoundButton;
import CustomComponents.TextPrompt;
import Funciones.Dashboard.ConsultasGenerales;
import Funciones.Entidades.CRUDClientes;
import Funciones.Entidades.CRUDVideojuegos;
import Funciones.Relaciones.CRUDAtiende;
import Funciones.Relaciones.CRUDCompras;
import Funciones.TablasListas.LlenadoInformacion;
import TDA.Entidades.AuxiliarButtons.ButtonsVenta;
import TDA.Entidades.Cliente;
import TDA.Entidades.Videojuego;
import TDA.Relaciones.Atencion;
import TDA.Relaciones.Compra;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaVentaConfirmacion extends javax.swing.JDialog {

    private ArrayList<Videojuego> carrito;
    private EstilosComponentes obE;
    private RoundButton btnConfirmar, btnVolver;
    private CRUDCompras sqlVentas;
    private LlenadoInformacion obI;
    private ConsultasGenerales obCons;
    private ArrayList<ButtonsVenta> dataBtnTxtVid;
    private JTable tbCarrito;
    private JPanel pnlVideojuegos;
    private int idTiendaTrabaja, idEmpleadoTrabajo;
    private String user;
    private JLabel lblCosto, lblSubtotal, lblIVA, lblJuegoMasVenCant, lblJuegoMenosVenCant, lblVidCont, lblTienCont, lblProvCont, lblCliCont, lblEmpCont, lblInvCont, lblCompraCont, lblCantVendida, lblJuegoMasVen, lblJuegoMenosVen, lblJuegoMasVend, lblJuegoMenosVend, lblTiendaMasVentas, lblTiendaMenosVentas, lblEmpMasAtenciones, lblEmpMejorSueldo, lblMejorCliente, lblProvMasActivo, stock1, stock2, stock3;
    private double monto;
    private double subtotal;
    private double iva;

    public VentanaVentaConfirmacion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        sqlVentas = new CRUDCompras();
        obE = new EstilosComponentes();
        obCons = new ConsultasGenerales();
        obI = new LlenadoInformacion();
        carrito = new ArrayList<>();
        dataBtnTxtVid = new ArrayList<>();
        pnlVideojuegos = new JPanel();
        setLocationRelativeTo(parent);
        initComponentsCustom();
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setTbCarrito(JTable tbCarrito) {
        this.tbCarrito = tbCarrito;
    }

    public void setLabels(JLabel lblCosto, JLabel lblSubtotal, JLabel lblIVA) {
        this.lblCosto = lblCosto;
        this.lblSubtotal = lblSubtotal;
        this.lblIVA = lblIVA;
    }

    public void initComponentsCustom() {
        btnConfirmar = obE.getStyleButtonAdd(btnConfirmar);
        btnConfirmar.setBorderColor(new Color(40, 40, 40));
        btnConfirmar.setText("Pagar");
        btnConfirmar.setIcon(new ImageIcon("./src/main/java/Resources/confirmar.png"));
        pnlButtons.add(btnConfirmar);

        btnVolver = obE.getStyleButtonBack2(btnVolver, this);
        btnVolver.setBorderColor(new Color(40, 40, 40));
        btnVolver.setText("Volver");
        pnlButtons.add(btnVolver);

        TextPrompt placeholder = new TextPrompt("$0.00...", jTextField2);
        placeholder.changeAlpha(0.50f);
        placeholder.changeStyle(Font.ITALIC);

        jComboBox2.setRenderer(new CustomComboBoxRenderer());
        jComboBox2.setFocusable(false);
        jComboBox2.getComponent(0).setBackground(new Color(140, 255, 241));

        obI.llenarComboClientes(jComboBox2);
    }

    public void mostrarSubtotal() {
        DecimalFormat df = new DecimalFormat("#.##");
        monto = 0;
        subtotal = 0;
        iva = 0;
        for (Videojuego v : carrito) {
            subtotal += v.getPrecio();
            monto += v.getPrecio() * 1.16;
            iva += (monto - subtotal);
        }
        lblCosto.setText("$" + df.format(monto));
        lblSubtotal.setText("$" + df.format(subtotal));
        lblIVA.setText("$" + df.format(iva));
    }

    public void actionListenerButtons() {
        btnConfirmar.addActionListener((e) -> {
            double total = 0;
            int idCliente = 0;

            for (Videojuego v : carrito) {
                total += v.getPrecio();
            }

            total = total * 1.16;

            CRUDClientes obC = new CRUDClientes();
            obC.selectCliente();
            for (Cliente c : obC.getData()) {
                if (String.valueOf(jComboBox2.getSelectedItem()).equals(c.getNombre() + " " + c.getApellidoP())) {
                    idCliente = c.getId();
                }
            }

            if (Double.parseDouble(jTextField2.getText().trim()) >= total) {
                for (Videojuego v : carrito) {
                    sqlVentas.insertCompra(new Compra(idTiendaTrabaja, idCliente, v.getId(), v.getStock(), v.getPrecio(), new Date(System.currentTimeMillis())));
                }
                cargarDatosGenerales();
                actualizarVideojuegos();
                subtotal = 0;
                monto = 0;
                iva = 0;
                mostrarSubtotal();
                CRUDAtiende sqlAtiende = new CRUDAtiende();
                sqlAtiende.insertAtiende(new Atencion(idTiendaTrabaja, idCliente, idEmpleadoTrabajo, new Date(System.currentTimeMillis())));
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Fondos insuficientes", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public void actualizarVideojuegos() {
        dataBtnTxtVid.clear();
        pnlVideojuegos.removeAll();
        carrito.clear();

        CRUDVideojuegos obV2 = new CRUDVideojuegos();
        obV2.selectVideojuegoVentas(idTiendaTrabaja);
        for (Videojuego v : obV2.getDataVenta()) {
            if (v.getIdTienda() == idTiendaTrabaja) {
                RoundButton btnAux = new RoundButton(new Color(187, 142, 61), new Color(231, 179, 125), new Color(239, 204, 168), new Color(40, 40, 40), 20);
                JTextField txt = new JTextField();
                dataBtnTxtVid.add(new ButtonsVenta(txt, btnAux, new Videojuego(v.getId(), v.getIdTienda(), v.getNombre(), v.getCategoria(), v.getPrecio(), 0)));
                pnlVideojuegos.add(new PanelVideojuego(v.getId(), v.getNombre(), v.getCategoria(), v.getStock(), v.getPrecio(), btnAux, txt));
            }
        }
        if (dataBtnTxtVid.size() == 1) {
            pnlVideojuegos.setLayout(new GridLayout(dataBtnTxtVid.size() + 2, 1, 10, 10));
        } else if (dataBtnTxtVid.size() == 2) {
            pnlVideojuegos.setLayout(new GridLayout(dataBtnTxtVid.size() + 1, 1, 10, 10));
        } else if (dataBtnTxtVid.size() >= 3) {
            pnlVideojuegos.setLayout(new GridLayout(dataBtnTxtVid.size(), 1, 10, 10));
        }

        obI.llenarCarrito(tbCarrito, carrito);
    }

    public void setIdTiendaTrabaja(int idTiendaTrabaja) {
        this.idTiendaTrabaja = idTiendaTrabaja;
    }

    public void setData(ArrayList<Videojuego> carrito, ArrayList<ButtonsVenta> dataBtnTxtVid, JPanel pnlVideojuegos, int idEmpleadoTrabajo) {
        this.carrito = carrito;
        this.dataBtnTxtVid = dataBtnTxtVid;
        this.pnlVideojuegos = pnlVideojuegos;
        this.idEmpleadoTrabajo = idEmpleadoTrabajo;
        actionListenerButtons();
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlHeaderVid = new CustomComponents.PanelRound();
        lblTitulo = new javax.swing.JLabel();
        pnlButtons = new CustomComponents.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 300));

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(20, 20, 20, 20));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlHeaderVid.setBackground(new java.awt.Color(25, 25, 25));
        pnlHeaderVid.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlHeaderVid.setRoundTopLeft(25);
        pnlHeaderVid.setRoundTopRight(25);
        pnlHeaderVid.setLayout(new java.awt.BorderLayout());

        lblTitulo.setFont(new java.awt.Font("Roboto", 1, 28)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(25, 200, 178));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Confirmar venta");
        pnlHeaderVid.add(lblTitulo, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlHeaderVid, java.awt.BorderLayout.PAGE_START);

        pnlButtons.setBackground(new java.awt.Color(20, 20, 20));
        pnlButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlButtons.setRoundBottomLeft(25);
        pnlButtons.setRoundBottomRight(25);
        pnlButtons.setLayout(new java.awt.GridLayout(1, 2, 10, 10));
        jPanel1.add(pnlButtons, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel29.setBackground(new java.awt.Color(20, 20, 20));
        jPanel29.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 20, 10));
        jPanel29.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(100, 100, 100));
        jLabel22.setText("Cliente");
        jLabel22.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jPanel29.add(jLabel22);

        jComboBox2.setBackground(new java.awt.Color(30, 30, 30));
        jComboBox2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(200, 200, 200));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(40, 40, 40), 2, true));
        jPanel29.add(jComboBox2);

        jPanel2.add(jPanel29, java.awt.BorderLayout.LINE_START);

        jPanel5.setBackground(new java.awt.Color(20, 20, 20));
        jPanel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 10, 20, 10));
        jPanel5.setLayout(new java.awt.GridLayout(2, 1, 0, 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(100, 100, 100));
        jLabel3.setText("Cant. de efectivo");
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
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField2KeyTyped(evt);
            }
        });
        jPanel5.add(jTextField2);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        char c = evt.getKeyChar();

        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextField2KeyTyped

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaVentaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaVentaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaVentaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaVentaConfirmacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VentanaVentaConfirmacion dialog = new VentanaVentaConfirmacion(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblTitulo;
    private CustomComponents.PanelRound pnlButtons;
    private CustomComponents.PanelRound pnlHeaderVid;
    // End of variables declaration//GEN-END:variables
}
