package CustomComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class PanelVideojuego extends PanelRound {

    private int id;
    private String nombre;
    private String categoria;
    private int stock;
    private double precio;

    public PanelVideojuego(int id, String nombre, String categoria, int stock, double precio, RoundButton btn, JTextField txtCant) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.stock = stock;
        this.precio = precio;

        this.setBackground(new Color(40, 40, 40));
        this.setRoundBottomLeft(10);
        this.setRoundBottomRight(10);
        this.setRoundTopLeft(10);
        this.setRoundTopRight(10);
        this.setLayout(new BorderLayout());
        Font fuente = new Font("Segoe UI", Font.PLAIN, 16);
        Font fuenteT = new Font("Segoe UI", Font.BOLD, 20);
        Color fontColor = new Color(210, 210, 210);

        btn.setText("Añadir");
        btn.setForeground(Color.white);
        btn.setIcon(new ImageIcon("./src/main/java/Resources/agregarCarrito.png"));
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 10, 10, 15));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));

        JLabel lblNombre = new JLabel(" - " + nombre);
        lblNombre.setFont(fuenteT);
        lblNombre.setForeground(new Color(30, 30, 30));

        JLabel lblCategoria = new JLabel("<html><b style=\"color: #19C8B2;font-size:15px;\">Categoria: </b><br>" + categoria + "<html>");
        lblCategoria.setFont(fuente);
        lblCategoria.setForeground(fontColor);

        JLabel lblStock = new JLabel("<html><b style=\"color: #19C8B2;font-size:15px;\">Cantidad disponible: </b><br>" + String.valueOf(stock) + "</html>");
        lblStock.setFont(fuente);
        lblStock.setForeground(fontColor);

        JLabel lblID = new JLabel("ID" + String.valueOf(id));
        lblID.setFont(fuenteT);
        lblID.setForeground(new Color(30, 30, 30));

        JLabel lblPrecio = new JLabel("$" + String.valueOf(precio));
        lblPrecio.setFont(new Font("Roboto", Font.BOLD, 28));
        lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrecio.setVerticalAlignment(SwingConstants.CENTER);
        lblPrecio.setForeground(fontColor);

        RoundButton btnMas = new RoundButton(new Color(16, 120, 65), new Color(25, 140, 98), new Color(65, 181, 125), new Color(40, 40, 40), 10);
        btnMas.setForeground(Color.white);
        btnMas.setText("+");
        btnMas.setFocusable(false);
        btnMas.setFont(new Font("Segoe UI", Font.BOLD, 28));
        btnMas.setBorder(new EmptyBorder(0, 10, 5, 10));
        btnMas.setHorizontalAlignment(SwingConstants.CENTER);
        btnMas.setVerticalAlignment(SwingConstants.CENTER);
        btnMas.addActionListener((e) -> {
            txtCant.setText(String.valueOf(Integer.parseInt(txtCant.getText()) + 1));
        });

        RoundButton btnMenos = new RoundButton(new Color(247, 81, 101), new Color(255, 125, 141), new Color(255, 168, 179), new Color(40, 40, 40), 10);
        btnMenos.setForeground(Color.white);
        btnMenos.setText("-");
        btnMenos.setFocusable(false);
        btnMenos.setFont(new Font("Segoe UI", Font.BOLD, 28));
        btnMenos.setBorder(new EmptyBorder(0, 10, 5, 10));
        btnMenos.setHorizontalAlignment(SwingConstants.CENTER);
        btnMenos.setVerticalAlignment(SwingConstants.CENTER);
        btnMenos.addActionListener((e) -> {
            if (Integer.parseInt(txtCant.getText()) > 1) {
                txtCant.setText(String.valueOf(Integer.parseInt(txtCant.getText()) - 1));
            }
        });

        txtCant.setEditable(false);
        txtCant.setText("1");
        txtCant.setBorder(new LineBorder(new Color(40, 40, 40), 2, false));
        txtCant.setFont(fuenteT);
        txtCant.setBackground(new Color(30, 30, 30));
        txtCant.setHorizontalAlignment(SwingConstants.CENTER);
        txtCant.setForeground(Color.white);

        JPanel pnlCant = new JPanel(new GridLayout(1, 3, 3, 3));
        pnlCant.setOpaque(false);
        pnlCant.add(btnMenos);
        pnlCant.add(txtCant);
        pnlCant.add(btnMas);

        JPanel pnlData = new JPanel(new GridLayout(2, 1, 5, 5));
        pnlData.setBorder(new EmptyBorder(0, 5, 5, 5));
        pnlData.setOpaque(false);
        pnlData.add(lblCategoria);
        pnlData.add(lblStock);

        PanelRound pnlTitle = new PanelRound();
        pnlTitle.setLayout(new BorderLayout(5, 5));
        pnlTitle.setRoundTopLeft(10);
        pnlTitle.setRoundTopRight(10);
        pnlTitle.setBorder(new EmptyBorder(0, 5, 2, 5));
        pnlTitle.setBackground(new Color(25, 200, 178));
        pnlTitle.add(lblID, BorderLayout.WEST);
        pnlTitle.add(lblNombre, BorderLayout.CENTER);

        JPanel pnlButtons = new JPanel(new BorderLayout());
        pnlButtons.setOpaque(false);
        pnlButtons.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnlButtons.add(lblPrecio, BorderLayout.CENTER);
        pnlButtons.add(btn, BorderLayout.SOUTH);
        pnlButtons.add(pnlCant, BorderLayout.NORTH);

        this.add(pnlTitle, BorderLayout.NORTH);
        this.add(pnlData, BorderLayout.CENTER);
        this.add(pnlButtons, BorderLayout.EAST);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
