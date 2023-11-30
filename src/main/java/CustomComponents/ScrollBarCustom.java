package CustomComponents;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollBar;

public class ScrollBarCustom extends JScrollBar {

    public ScrollBarCustom(Color bgColor, Color scrollColor) {
        setUI(new ModernScrollBarUI(bgColor, scrollColor));
        setPreferredSize(new Dimension(10, 10));
        setBackground(bgColor);
    }
}
