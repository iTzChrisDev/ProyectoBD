package CustomComponents;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class EstilosComponentes {

    public final Color verdeOscuro = new Color(22, 49, 39);
    public final Color verdeMedio = new Color(43, 61, 49);
    public final Color one = new Color(66, 189, 159);
    public final Color two = new Color(25, 200, 178);
    public final Color three = new Color(54, 149, 192);
    public final Color grisUnselect = new Color(100, 100, 100);
    public final Color grisSecond = new Color(20, 20, 20);
    public final Color grisPrimary = new Color(10, 10, 10);
    public final Color egg = new Color(245, 245, 245);

    public RoundButton getStyleMenuBtn(RoundButton btn, JPanel pnlAdd) {
        btn = new RoundButton(grisPrimary, verdeOscuro, verdeMedio, grisPrimary, 10);
        btn.setForeground(grisUnselect);
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setIconTextGap(1);
        btn.setFont(new Font("Roboto", Font.PLAIN, 15));
        btn.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);
        pnlAdd.add(btn);
        return btn;
    }

    public void setStylePanel(PanelGradient pnl) {
        pnl.addColor(new ModelColor(one, 0.1f), new ModelColor(two, 0.5f), new ModelColor(three, 1.0f));
        pnl.setDirection(pnl.getWidth(), 0);
    }

    public void setStylePanelVenta(PanelGradient pnl) {
        pnl.addColor(new ModelColor(new Color(239, 204, 168), 0.1f), new ModelColor(new Color(231, 179, 125), 0.5f), new ModelColor(new Color(220, 142, 61), 1.0f));
        pnl.setDirection(pnl.getWidth(), 0);
    }

    public void setStylePanelMas(PanelGradient pnl) {
        pnl.addColor(new ModelColor(new Color(148, 195, 170), 0.1f), new ModelColor(new Color(95, 165, 128), 0.5f), new ModelColor(new Color(25, 180, 98), 1.0f));
        pnl.setDirection(pnl.getWidth(), 0);
    }

    public void setStylePanelMenos(PanelGradient pnl) {
        pnl.addColor(new ModelColor(new Color(252, 197, 203), 0.1f), new ModelColor(new Color(249, 139, 152), 0.5f), new ModelColor(new Color(247, 81, 101), 1.0f));
        pnl.setDirection(pnl.getWidth(), 0);
    }

    public void setStylePanelIngresos(PanelGradient pnl) {
        pnl.addColor(new ModelColor(new Color(239, 204, 168), 0.1f), new ModelColor(new Color(240, 204, 142), 0.5f), new ModelColor(new Color(246, 205, 61), 1.0f));
        pnl.setDirection(pnl.getWidth(), 0);
    }

    public RoundButton getStyleButtonExit(RoundButton btn) {
        btn = new RoundButton(new Color(247, 81, 101), new Color(255, 125, 141), new Color(255, 168, 179), new Color(20, 20, 20), 20);
        btn.setForeground(Color.white);
        btn.setText("Salir");
        btn.setIcon(new ImageIcon("./src/main/java/Resources/salir.png"));
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setIconTextGap(10);
        btn.addActionListener((e) -> {
            System.exit(0);
        });
        return btn;
    }

    public RoundButton getStyleButtonBack(RoundButton btn, JFrame frame) {
        btn = new RoundButton(new Color(247, 81, 101), new Color(255, 125, 141), new Color(255, 168, 179), new Color(20, 20, 20), 20);
        btn.setForeground(Color.white);
        btn.setText("Volver");
        btn.setIcon(new ImageIcon("./src/main/java/Resources/salir2.png"));
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setIconTextGap(10);
        btn.addActionListener((e) -> {
            frame.dispose();
        });
        return btn;
    }

    public RoundButton getStyleBtnSave(RoundButton btn) {
        btn = new RoundButton(new Color(16, 120, 65), new Color(25, 140, 98), new Color(65, 181, 125), new Color(20, 20, 20), 20);
        btn.setForeground(Color.white);
        btn.setText("Guardar");
        btn.setIcon(new ImageIcon("./src/main/java/Resources/guardar.png"));
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setIconTextGap(10);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return btn;
    }

    public RoundButton getStyleBtnClear(RoundButton btn) {
        btn = new RoundButton(grisUnselect, new Color(120, 120, 120), new Color(140, 140, 140), new Color(20, 20, 20), 20);
        btn.setForeground(Color.white);
        btn.setText("Limpiar");
        btn.setIcon(new ImageIcon("./src/main/java/Resources/limpiar.png"));
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setIconTextGap(10);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return btn;
    }

    public RoundButton getStyleMenuSearch(RoundButton btn) {
        btn = new RoundButton(new Color(30, 30, 30), new Color(40, 40, 40), new Color(50, 50, 50), grisPrimary, 20);
        btn.setForeground(grisUnselect);
        btn.setFocusable(false);
        btn.setIcon(new ImageIcon("./src/main/java/Resources/buscar.png"));
        btn.setText("");
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setIconTextGap(10);
        btn.setFont(new Font("Roboto", Font.PLAIN, 16));
        return btn;
    }

    public RoundButton getStyleButtonAdd(RoundButton btn) {
        btn = new RoundButton(new Color(16, 120, 65), new Color(25, 140, 98), new Color(65, 181, 125), new Color(20, 20, 20), 20);
        btn.setForeground(Color.white);
        btn.setIcon(new ImageIcon("./src/main/java/Resources/agregar.png"));
        btn.setText("Agregar");
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setIconTextGap(10);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        return btn;
    }

    public RoundButton getStyleButtonEliminar(RoundButton btn) {
        btn = new RoundButton(new Color(247, 81, 101), new Color(255, 125, 141), new Color(255, 168, 179), new Color(20, 20, 20), 20);
        btn.setForeground(egg);
        btn.setIcon(new ImageIcon("./src/main/java/Resources/borrar.png"));
        btn.setText("Eliminar");
        btn.setFocusable(false);
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setIconTextGap(10);
        return btn;
    }

    public RoundButton getStyleButtonUpdate(RoundButton btn) {
        btn = new RoundButton(new Color(187, 142, 61), new Color(231, 179, 125), new Color(239, 204, 168), new Color(20, 20, 20), 20);
        btn.setFocusable(false);
        btn.setForeground(egg);
        btn.setIcon(new ImageIcon("./src/main/java/Resources/actu.png"));
        btn.setText("Actualizar");
        btn.setBorder(new EmptyBorder(10, 15, 10, 15));
        btn.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btn.setIconTextGap(10);
        return btn;
    }

    public void setStyleTableDefault(JTable tb, JScrollPane scroll, Color headerColor, Color viewportBackground, Color scrollColor, Color tbBackground, Color fontColor) {
        tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 16));
        tb.getTableHeader().setForeground(egg);
        tb.getTableHeader().setBackground(headerColor);
        tb.getTableHeader().setBorder(new LineBorder(headerColor, 1, false));
        tb.setBackground(tbBackground);
        tb.setFont(new Font("Roboto", Font.PLAIN, 12));
        tb.setForeground(fontColor);
        tb.getTableHeader().setReorderingAllowed(false);
        tb.setRowHeight(30);
        scroll.setVerticalScrollBar(new ScrollBarCustom(tbBackground, scrollColor));
        scroll.getViewport().setBackground(viewportBackground);
        JPanel corner = new JPanel();
        corner.setBackground(headerColor);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, corner);
        scroll.setBorder(new LineBorder(headerColor, 2, true));
        scroll.setOpaque(false);
    }
    
    public void setPlaceHolder(JTextField txt)
    {
        TextPrompt placeholder = new TextPrompt("Ingrese cualquier valor a buscar...", txt);
        placeholder.changeAlpha(0.50f);
        placeholder.changeStyle(Font.ITALIC);
    }
}
