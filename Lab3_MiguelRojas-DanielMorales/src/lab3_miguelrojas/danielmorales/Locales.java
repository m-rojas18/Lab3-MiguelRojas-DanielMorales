/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_miguelrojas.danielmorales;
import java.util.ArrayList;

/**
 *
 * @author danie
 */
public class Locales {
    
    private String nombre;
    private ArrayList <Empleado>empleados = new ArrayList();
    private ArrayList <Producto>productos = new ArrayList();
    private String gerente;
    

    public Locales(String nombre, ArrayList empleados, ArrayList productos, String gerente ) {
        this.nombre = nombre;
        this.empleados = empleados;
        this.productos = productos;
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Locales{" + "nombre=" + nombre + ", empleados=" + empleados + ", productos=" + productos + ", gerente=" + gerente + '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList empleados) {
        this.empleados = empleados;
    }

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }

    public String getGerente() {
        return gerente;
    }

    public void setGerente(String gerente) {
        this.gerente = gerente;
    }
    
}
