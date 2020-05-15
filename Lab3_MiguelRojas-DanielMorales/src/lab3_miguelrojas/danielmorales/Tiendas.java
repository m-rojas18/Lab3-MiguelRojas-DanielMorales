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
public class Tiendas extends Locales{
    
    private ArrayList<Ropa> lista_ropa = new ArrayList();
    private ArrayList<Juguetes> lista_juguetes = new ArrayList();

    public Tiendas(String nombre, ArrayList empleados, ArrayList productos, String gerente) {
        super(nombre, empleados, productos, gerente);
    }

    public ArrayList<Ropa> getLista_ropa() {
        return lista_ropa;
    }

    public void setLista_ropa(ArrayList<Ropa> lista_ropa) {
        this.lista_ropa = lista_ropa;
    }

    public ArrayList<Juguetes> getLista_juguetes() {
        return lista_juguetes;
    }

    public void setLista_juguetes(ArrayList<Juguetes> lista_juguetes) {
        this.lista_juguetes = lista_juguetes;
    }

    @Override
    public String toString() {
        return "Tiendas{" + "lista_ropa=" + lista_ropa + ", lista_juguetes=" + lista_juguetes + '}';
    }


    
    
    
}
