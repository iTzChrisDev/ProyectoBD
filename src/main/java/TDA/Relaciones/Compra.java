package TDA.Relaciones;

import java.sql.Date;

public class Compra {

    private int idTienda;
    private int idCliente;
    private int idVideojuego;
    private int cantidad;
    private double total;
    private Date fechaCompra;

    public Compra(int idTienda, int idCliente, int idVideojuego, int cantidad, double total, Date fechaCompra) {
        this.idTienda = idTienda;
        this.idCliente = idCliente;
        this.idVideojuego = idVideojuego;
        this.cantidad = cantidad;
        this.total = total;
        this.fechaCompra = fechaCompra;
    }

    public Compra(int cantidad, double total, Date fechaCompra) {
        this.cantidad = cantidad;
        this.total = total;
        this.fechaCompra = fechaCompra;
    }
    
    public int getIdTienda() {
        return idTienda;
    }

    public void setIdTienda(int idTienda) {
        this.idTienda = idTienda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdVideojuego() {
        return idVideojuego;
    }

    public void setIdVideojuego(int idVideojuego) {
        this.idVideojuego = idVideojuego;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

}
