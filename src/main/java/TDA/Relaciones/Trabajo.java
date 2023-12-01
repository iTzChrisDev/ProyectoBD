package TDA.Relaciones;

import java.sql.Time;

public class Trabajo {

    private int id_tienda, id_empleado;
    private Time hrEntrada, hrSalida;
    private String turno;

    public Trabajo(int id_tienda, int id_empleado, Time hrEntrada, Time hrSalida, String turno) {
        this.id_tienda = id_tienda;
        this.id_empleado = id_empleado;
        this.hrEntrada = hrEntrada;
        this.hrSalida = hrSalida;
        this.turno = turno;
    }

    public Trabajo(int id_tienda, Time hrEntrada, Time hrSalida, String turno) {
        this.id_tienda = id_tienda;
        this.hrEntrada = hrEntrada;
        this.hrSalida = hrSalida;
        this.turno = turno;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Time getHrEntrada() {
        return hrEntrada;
    }

    public void setHrEntrada(Time hrEntrada) {
        this.hrEntrada = hrEntrada;
    }

    public Time getHrSalida() {
        return hrSalida;
    }

    public void setHrSalida(Time hrSalida) {
        this.hrSalida = hrSalida;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

}
