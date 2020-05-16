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
public class Quiosco {

    private String nombre;
    private ArrayList productos;

    public Quiosco(String nombre, ArrayList productos) {
        this.nombre = nombre;
        this.productos = productos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Quiosco{" + "nombre=" + nombre + ", productos=" + productos + '}';
    }

    
}
