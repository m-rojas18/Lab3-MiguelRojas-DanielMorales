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
public class Bares {

    private ArrayList empleados;
    private ArrayList productos;
    public Bares(ArrayList empleados, ArrayList productos) {
        this.empleados  = empleados;
        this.productos = productos;
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

    @Override
    public String toString() {
        return "Bares{" + "empleados=" + empleados + ", productos=" + productos + '}';
    }
    
    
}
