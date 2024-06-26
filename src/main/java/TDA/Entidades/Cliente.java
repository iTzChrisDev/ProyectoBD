package TDA.Entidades;

import java.sql.Date;

public class Cliente {
    private int id;
    private String nombre;
    private String ApellidoP;
    private String ApellidoM;
    private Date fechaNacimiento;
    private long telefono;
    private String domicilio;
    private String correo;
    private int cantComprada;

    public Cliente(int id, String nombre, String ApellidoP, String ApellidoM, Date fechaNacimiento, long telefono, String domicilio, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    public Cliente(String nombre, String ApellidoP, String ApellidoM, Date fechaNacimiento, long telefono, String domicilio, String correo) {
        this.nombre = nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    public Cliente(String nombre, String ApellidoP, int cantComprada) {
        this.nombre = nombre;
        this.ApellidoP = ApellidoP;
        this.cantComprada = cantComprada;
    }

    public int getCantComprada() {
        return cantComprada;
    }

    public void setCantComprada(int cantComprada) {
        this.cantComprada = cantComprada;
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

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String ApellidoP) {
        this.ApellidoP = ApellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String ApellidoM) {
        this.ApellidoM = ApellidoM;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return String.valueOf(telefono);
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}
