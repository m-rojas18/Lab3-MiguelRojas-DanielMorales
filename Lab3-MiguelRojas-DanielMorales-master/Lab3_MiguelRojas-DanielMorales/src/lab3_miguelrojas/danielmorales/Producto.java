package lab3_miguelrojas.danielmorales;

public class Producto {

    private String descripcion;
    private String nombre;
    private int precio;
    
    public Producto(){
        
    }

    public Producto(String descripcion, String nombre, int precio) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" + "descripcion=" + descripcion + ", nombre=" + nombre + ", precio=" + precio + '}';
    }
    
    
}
