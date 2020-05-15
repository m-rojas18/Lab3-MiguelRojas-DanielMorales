package lab3_miguelrojas.danielmorales;

import java.util.Date;

public class Empleado extends Persona{

    private int horario_trabajo;
    private int numero_productos;
    
    
    public Empleado(){
        super();
    }

    public Empleado(int horario_trabajo, int numero_productos, String id, String usuario, String password, String correo_electronico, String nombre_completo, Date fecha_nacimiento) {
        super(id, usuario, password, correo_electronico, nombre_completo, fecha_nacimiento);
        this.horario_trabajo = horario_trabajo;
        this.numero_productos = numero_productos;
    }

    public int getHorario_trabajo() {
        return horario_trabajo;
    }

    public void setHorario_trabajo(int horario_trabajo) {
        this.horario_trabajo = horario_trabajo;
    }

    public int getNumero_productos() {
        return numero_productos;
    }

    public void setNumero_productos(int numero_productos) {
        this.numero_productos = numero_productos;
    }

    @Override
    public String toString() {
        return "Empleado{" + "horario_trabajo=" + horario_trabajo + ", numero_productos=" + numero_productos + '}';
    }
    
    
}
