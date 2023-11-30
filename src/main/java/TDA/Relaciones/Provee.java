package TDA.Relaciones;

import java.sql.Date;

public class Provee {

    private int id_videojuego;
    private int id_tienda;
    private int id_proveedor;
    private int cantidad;
    private Date fechaSurtido;

    public Provee(int id_videojuego, int id_tienda, int id_proveedor, int cantidad, Date fechaSurtido) {
        this.id_videojuego = id_videojuego;
        this.id_tienda = id_tienda;
        this.id_proveedor = id_proveedor;
        this.cantidad = cantidad;
        this.fechaSurtido = fechaSurtido;
    }

    public Provee(int cantidad, Date fechaSurtido) {
        this.cantidad = cantidad;
        this.fechaSurtido = fechaSurtido;
    }

    public int getId_videojuego() {
        return id_videojuego;
    }

    public void setId_videojuego(int id_videojuego) {
        this.id_videojuego = id_videojuego;
    }

    public int getId_tienda() {
        return id_tienda;
    }

    public void setId_tienda(int id_tienda) {
        this.id_tienda = id_tienda;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSurtido() {
        return fechaSurtido;
    }

    public void setFechaSurtido(Date fechaSurtido) {
        this.fechaSurtido = fechaSurtido;
    }

}
