package lab3_miguelrojas.danielmorales;

public class Juguetes extends Producto{


    private String descripcion_2;
    
    public Juguetes(){
        super();
    }

    public Juguetes(String descripcion_2, String descripcion, String nombre, int precio) {
        super(descripcion, nombre, precio);
        this.descripcion_2 = descripcion_2;
    }

    public String getDescripcion_2() {
        return descripcion_2;
    }

    public void setDescripcion_2(String descripcion_2) {
        this.descripcion_2 = descripcion_2;
    }

    @Override
    public String toString() {
        return "Juguetes{" + "descripcion_2=" + descripcion_2 + '}';
    }
    
    
    
    
}
