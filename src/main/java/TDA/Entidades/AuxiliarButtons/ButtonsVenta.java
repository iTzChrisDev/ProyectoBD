package TDA.Entidades.AuxiliarButtons;

import CustomComponents.RoundButton;
import TDA.Entidades.Videojuego;
import javax.swing.JTextField;

public class ButtonsVenta 
{
    private JTextField txt;
    private RoundButton button;
    private Videojuego videojuego;

    public ButtonsVenta(JTextField txt, RoundButton button, Videojuego videojuego) {
        this.txt = txt;
        this.button = button;
        this.videojuego = videojuego;
    }

    public JTextField getTxt() {
        return txt;
    }

    public void setTxt(JTextField txt) {
        this.txt = txt;
    }

    public RoundButton getButton() {
        return button;
    }

    public void setButton(RoundButton button) {
        this.button = button;
    }

    public Videojuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(Videojuego videojuego) {
        this.videojuego = videojuego;
    }
    
}
