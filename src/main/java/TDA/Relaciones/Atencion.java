package TDA.Relaciones;

import java.sql.Date;

public class Atencion {

    private int idTienda;
    private int idCliente;
    private int idEmpleado;
    private Date fechaAtencion;

    public Atencion(int idTienda, int idCliente, int idEmpleado, Date fechaAtencion) {
        this.idTienda = idTienda;
        this.idCliente = idCliente;
        this.idEmpleado = idEmpleado;
        this.fechaAtencion = fechaAtencion;
    }

    public Atencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
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

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaAtencion() {
        return fechaAtencion;
    }

    public void setFechaAtencion(Date fechaAtencion) {
        this.fechaAtencion = fechaAtencion;
    }

}
