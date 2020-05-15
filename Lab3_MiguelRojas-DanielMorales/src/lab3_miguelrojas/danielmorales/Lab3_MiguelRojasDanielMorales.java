/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_miguelrojas.danielmorales;

import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class Lab3_MiguelRojasDanielMorales {

    /**
     * @param args the command line arguments
     */
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        char resp = 's';
        while (resp == 's' || resp == 'S') {
            System.out.println("Bienvenido al Shopping Mall de muy muy lejos.");
            System.out.println("1. Sign in");
            System.out.println("2. Log in");
            System.out.println("3. Salir");
            int op = input.nextInt();
            switch (op) {
                case 1:
                    
                    break;
                case 2:
                    break;
                default:
                    System.exit(0);
            }
        }
    }
    
    public static void login(){
        boolean authSUDO = false;
        System.out.println("Ingrese el usuario: ");
        String userRecibido = input.next();
        System.out.println("Ingrese la password: ");
        String passRecibida = input.next();
        if (userRecibido.equalsIgnoreCase("SUDO")) {
            if (passRecibida.equalsIgnoreCase("sudo")) {
                authSUDO = true;
                System.out.println("Usuario autenticado. ");
            } else {
                System.out.println("Password incorrecta. ");
            }
        } else {
            System.out.println("Usuario incorrecto. ");
        } 
    }

}
