package lab3_miguelrojas.danielmorales;

import java.util.ArrayList;
import java.util.Date;

public class Cliente extends Persona{

    private int cantidad_dinero;
    private ArrayList lista_compras = new ArrayList();
    
    public Cliente(){
        super();
    }

    public Cliente(int cantidad_dinero, String id, String usuario, String password, String correo_electronico, String nombre_completo, Date fecha_nacimiento) {
        super(id, usuario, password, correo_electronico, nombre_completo, fecha_nacimiento);
        this.cantidad_dinero = cantidad_dinero;
    }

    public int getCantidad_dinero() {
        return cantidad_dinero;
    }

    public void setCantidad_dinero(int cantidad_dinero) {
        this.cantidad_dinero = cantidad_dinero;
    }

    public ArrayList getLista_compras() {
        return lista_compras;
    }

    public void setLista_compras(ArrayList lista_compras) {
        this.lista_compras = lista_compras;
    }

    @Override
    public String toString() {
        return "Cliente{" + "cantidad_dinero=" + cantidad_dinero + ", lista_compras=" + lista_compras + '}';
    }
    
    
}
