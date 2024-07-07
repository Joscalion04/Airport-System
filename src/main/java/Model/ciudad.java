package Model;

public class ciudad {
    private String nombre;
    private String id;
    private int gmt;

    public ciudad(String nombre, String id, int gmt) {
        this.nombre = nombre;
        this.id = id;
        this.gmt = gmt;
    }

    public ciudad() {
        this.nombre = "";
        this.id = "";
        this.gmt = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getGmt() {
        return gmt;
    }

    public void setGmt(int gmt) {
        this.gmt = gmt;
    }    

    @Override
    public String toString() {
        return "ciudad{" + "nombre=" + nombre + ", id=" + id + ", gmt=" + gmt + '}';
    }

    
    
}
