package lab3_miguelrojas.danielmorales;

public class Ropa extends Producto{

    private String sexo;
    private String talla;
    
    public Ropa(){
        super();
    }

    public Ropa(String sexo, String talla, String descripcion, String nombre, int precio) {
        super(descripcion, nombre, precio);
        this.sexo = sexo;
        this.talla = talla;
    }
    
    

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Ropa{" + "sexo=" + sexo + ", talla=" + talla + '}';
    }
    
    
    
}
