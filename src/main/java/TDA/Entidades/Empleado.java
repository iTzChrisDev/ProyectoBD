package TDA.Entidades;

import java.sql.Time;

public class Empleado {

    private int id;
    private String nombre;
    private String ApellidoP;
    private String ApellidoM;
    private String NSS;
    private String CURP;
    private String fechaNacimiento;
    private int telefono;
    private String domicilio;
    private int sueldo;
    private String nombreTienda;
    private Time hrEntrada, hrSalida;
    private String turno;
    
    public Empleado(int id, String nombre, String ApellidoP, String ApellidoM, String NSS, String CURP, String fechaNacimiento, int telefono, String domicilio, int sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.NSS = NSS;
        this.CURP = CURP;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.sueldo = sueldo;
    }

    public Empleado(String nombre, String ApellidoP, String ApellidoM, String NSS, String CURP, String fechaNacimiento, int telefono, String domicilio, int sueldo) {
        this.nombre = nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.NSS = NSS;
        this.CURP = CURP;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.sueldo = sueldo;
    }

    public Empleado(int id, String nombre, String ApellidoP, String ApellidoM, String NSS, String CURP, String fechaNacimiento, int telefono, String domicilio, int sueldo, String nombreTienda, Time hrEntrada, Time hrSalida, String turno) {
        this.id = id;
        this.nombre = nombre;
        this.ApellidoP = ApellidoP;
        this.ApellidoM = ApellidoM;
        this.NSS = NSS;
        this.CURP = CURP;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.sueldo = sueldo;
        this.nombreTienda = nombreTienda;
        this.hrEntrada = hrEntrada;
        this.hrSalida = hrSalida;
        this.turno = turno;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
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

    public String getNSS() {
        return NSS;
    }

    public void setNSS(String NSS) {
        this.NSS = NSS;
    }

    public String getCURP() {
        return CURP;
    }

    public void setCURP(String CURP) {
        this.CURP = CURP;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

}
