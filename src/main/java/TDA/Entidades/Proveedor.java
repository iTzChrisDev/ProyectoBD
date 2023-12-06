package TDA.Entidades;

public class Proveedor {

    private int id;
    private String nombre;
    private int telefono;
    private String domicilio;
    private String correo;
    private int cantSurtida;

    public Proveedor(int id, String nombre, int telefono, String domicilio, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    public Proveedor(String nombre, int telefono, String domicilio, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.domicilio = domicilio;
        this.correo = correo;
    }

    public Proveedor(String nombre, int cantSurtida) {
        this.nombre = nombre;
        this.cantSurtida = cantSurtida;
    }

    public int getCantSurtida() {
        return cantSurtida;
    }

    public void setCantSurtida(int cantSurtida) {
        this.cantSurtida = cantSurtida;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

}
