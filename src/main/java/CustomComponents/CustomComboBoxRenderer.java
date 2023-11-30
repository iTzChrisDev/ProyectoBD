package CustomComponents;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class CustomComboBoxRenderer extends BasicComboBoxRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        setFont(new Font("Roboto", Font.PLAIN, 14));
        if (isSelected) {
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setBackground(new Color(140, 255, 241));
            setForeground(new Color(10, 10, 10));
        } else {
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setBackground(new Color(30, 30, 30));
            setForeground(new Color(200, 200, 200));
        }

        return this;
    }

}
