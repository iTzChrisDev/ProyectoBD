package GUI;

import CustomComponents.CustomComboBoxRenderer;
import CustomComponents.RoundButton;
import CustomComponents.TextPrompt;
import Funciones.Entidades.CRUDEmpleados;
import Funciones.Entidades.CRUDTiendas;
import TDA.Entidades.Empleado;
import TDA.Entidades.Tienda;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class VentanaLogin extends javax.swing.JFrame {

    private RoundButton btnLogin;
    private CRUDTiendas sqlTiendas;
    private CRUDEmpleados sqlEmpleados;

    public VentanaLogin() {
        initComponents();
        sqlTiendas = new CRUDTiendas();
        sqlEmpleados = new CRUDEmpleados();
        initComponentsCustom();
        setLocationRelativeTo(this);
    }

    public void initComponentsCustom() {
        btnLogin = new RoundButton(new Color(25, 200, 178), new Color(16, 133, 118), new Color(101, 218, 203), new Color(20, 20, 20), 10);
        btnLogin.setBorder(new EmptyBorder(10, 15, 10, 15));
        btnLogin.setText("Entrar");
        btnLogin.setForeground(new Color(30, 30, 30));
        btnLogin.setFocusable(false);
        btnLogin.setFont(new Font("Roboto", Font.PLAIN, 18));
        jPanel4.add(btnLogin);
        btnLogin.addActionListener((e) -> {
            String password = new String(jPasswordField1.getPassword());
            if (jTextField2.getText().trim().equals("admin") && password.equals("pass")) {
                VentanaRegistros obV = new VentanaRegistros();
                obV.setVisible(true);
                obV.setUser("admin");
            } else if (jTextField2.getText().trim().equals("user") && password.equals("pass")) {
                sqlEmpleados.selectEmpleado();
                String empleados[] = new String[sqlEmpleados.getDataEmpleado().size()];
                for (int i = 0; i < empleados.length; i++) {
                    empleados[i] = sqlEmpleados.getDataEmpleado().get(i).getId() + " - " + sqlEmpleados.getDataEmpleado().get(i).getNombre();
                }

                JComboBox<String> comboBox = new JComboBox<>(empleados);
                comboBox.setRenderer(new CustomComboBoxRenderer());
                comboBox.setFocusable(false);
                comboBox.getComponent(0).setBackground(new Color(66, 189, 159));
                comboBox.setBorder(new LineBorder(new Color(10, 10, 10)));

                JPanel panel = new JPanel();
                panel.add(comboBox);

                int opcionElegida = JOptionPane.showOptionDialog(null, panel, "Selecciona una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                int idTienda = 0, idEmpleado = 0;
                String aux = null;
                if (opcionElegida == JOptionPane.OK_OPTION) {
                    String opcionSeleccionada = String.valueOf(comboBox.getSelectedItem());
                    sqlEmpleados.selectEmpleado();
                    for (Empleado emp : sqlEmpleados.getDataEmpleado()) {
                        if (opcionSeleccionada.equals(emp.getId() + " - " + emp.getNombre())) {
                            idEmpleado = emp.getId();
                            aux = emp.getNombreTienda();
                            break;
                        }
                    }

                    sqlTiendas.selectTienda();
                    for (Tienda t : sqlTiendas.getData()) {
                        if (t.getNombre().equals(aux)) {
                            idTienda = t.getId();
                        }
                    }

                    VentanaVentas obV = new VentanaVentas();
                    obV.setUser("user", idTienda, idEmpleado);
                    obV.setVisible(true);
                }
                this.dispose();
            } else {
                jTextField2.setText("");
                jPasswordField1.setText("");
                JOptionPane.showMessageDialog(null, "Usuario no registrado", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        });

        TextPrompt placeholder = new TextPrompt("Usuario", jTextField2);
        placeholder.changeAlpha(0.50f);
        placeholder.changeStyle(Font.ITALIC);

        TextPrompt placeholder2 = new TextPrompt("Contraseña", jPasswordField1);
        placeholder2.changeAlpha(0.50f);
        placeholder2.changeStyle(Font.ITALIC);

        jLabel1.setIcon(new ImageIcon("./src/main/java/Resources/logo.png"));
        jLabel2.setIcon(new ImageIcon("./src/main/java/Resources/user.png"));
        jLabel3.setIcon(new ImageIcon("./src/main/java/Resources/pass.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelRound1 = new CustomComponents.PanelRound();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(350, 400));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(10, 10, 10));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        panelRound1.setBackground(new java.awt.Color(20, 20, 20));
        panelRound1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.setRoundTopLeft(20);
        panelRound1.setRoundTopRight(20);
        panelRound1.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 10, 0));
        jPanel2.setOpaque(false);
        jPanel2.add(jLabel1);

        panelRound1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 20, 30));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.GridLayout(2, 1, 0, 30));

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTextField2.setBackground(new java.awt.Color(20, 20, 20));
        jTextField2.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(200, 200, 200));
        jTextField2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(30, 30, 30)));
        jTextField2.setCaretColor(new java.awt.Color(25, 200, 178));
        jTextField2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTextField2.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jTextField2.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel5.add(jTextField2, java.awt.BorderLayout.CENTER);

        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(30, 30, 30)));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new java.awt.GridLayout());

        jLabel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 2, 10));
        jPanel8.add(jLabel2);

        jPanel5.add(jPanel8, java.awt.BorderLayout.WEST);

        jPanel3.add(jPanel5);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new java.awt.BorderLayout());

        jPasswordField1.setBackground(new java.awt.Color(20, 20, 20));
        jPasswordField1.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        jPasswordField1.setForeground(new java.awt.Color(200, 200, 200));
        jPasswordField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(30, 30, 30)));
        jPasswordField1.setCaretColor(new java.awt.Color(25, 200, 178));
        jPasswordField1.setSelectedTextColor(new java.awt.Color(10, 10, 10));
        jPasswordField1.setSelectionColor(new java.awt.Color(25, 200, 178));
        jPanel6.add(jPasswordField1, java.awt.BorderLayout.CENTER);

        jPanel7.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(30, 30, 30)));
        jPanel7.setOpaque(false);
        jPanel7.setLayout(new java.awt.GridLayout());

        jLabel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 2, 10));
        jPanel7.add(jLabel3);

        jPanel6.add(jPanel7, java.awt.BorderLayout.WEST);

        jPanel3.add(jPanel6);

        panelRound1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jPanel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 30, 0, 30));
        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.GridLayout(1, 0));
        panelRound1.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel1.add(panelRound1);

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
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField2;
    private CustomComponents.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
