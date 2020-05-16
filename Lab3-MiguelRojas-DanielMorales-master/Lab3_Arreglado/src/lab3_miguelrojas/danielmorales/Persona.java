package lab3_miguelrojas.danielmorales;

import java.util.Date;

public class Persona {


    private String id;
    private String usuario;
    private String password;
    private String correo_electronico;
    private String nombre_completo;
    private Date fecha_nacimiento;

    public Persona() {
    }

    public Persona(String id, String usuario, String password, String correo_electronico, String nombre_completo, Date fecha_nacimiento) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.correo_electronico = correo_electronico;
        this.nombre_completo = nombre_completo;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", usuario=" + usuario + ", password=" + password + ", correo_electronico=" + correo_electronico + ", nombre_completo=" + nombre_completo + ", fecha_nacimiento=" + fecha_nacimiento + '}';
    }
    
    
    
}
