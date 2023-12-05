package com.mycompany.designui;

import GUI.VentanaRegistros;
import GUI.VentanaVentas;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class DesignUI {

    public static void main(String[] args) {
//        new VentanaRegistros().setVisible(true);
        VentanaVentas obV = new VentanaVentas();
        obV.setUser("user", 5);
        obV.setVisible(true);
//        Calendar c = Calendar.getInstance();
//        int day = c.get(Calendar.DATE);
//        int month = c.get(Calendar.MONTH) + 1;
//        int year = c.get(Calendar.YEAR);
//
//        c.set(year, month, day);
//        long enMillis = c.getTimeInMillis();
//
//        System.out.println(year + " | " + month + " | " + day);
//        System.out.println(enMillis);
//        CRUDVideojuegos obC = new CRUDVideojuegos();
//        obC.insertVideojuego(new Videojuego("JuegoTest", "Testing", 404));
//        obC.deleteVideojuego(35);
//        obC.updateVideojuego(34, new Videojuego("JuegoTest2", "Testing", 333));
//        obC.selectVideojuego();
    }
}
