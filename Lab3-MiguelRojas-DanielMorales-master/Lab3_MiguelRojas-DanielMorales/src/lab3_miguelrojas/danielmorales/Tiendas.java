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
public class Tiendas {

    private ArrayList productos;
    
    public Tiendas(ArrayList productos) {
        this.productos = productos;
    }

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Tiendas{" + "productos=" + productos + '}';
    }
    
    
    
}
