package lab3_miguelrojas.danielmorales;

import java.util.Date;

public class Comida extends Producto{

    private String tipo;
    private Date fecha_caducidad;
    
    public Comida(){
        super();
    }

    public Comida(String tipo, Date fecha_caducidad, String descripcion, String nombre, int precio) {
        super(descripcion, nombre, precio);
        this.tipo = tipo;
        this.fecha_caducidad = fecha_caducidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }

    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }

    @Override
    public String toString() {
        return "Comida{" + "tipo=" + tipo + ", fecha_caducidad=" + fecha_caducidad + '}';
    }
    
    
}
