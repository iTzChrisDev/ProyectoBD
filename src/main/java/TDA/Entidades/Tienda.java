package TDA.Entidades;

public class Tienda {

    private int id;
    private String nombre;
    private String domicilio;

    public Tienda(int id, String nombre, String domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
    }    

    public Tienda(String nombre, String domicilio) {
        this.nombre = nombre;
        this.domicilio = domicilio;
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

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}
