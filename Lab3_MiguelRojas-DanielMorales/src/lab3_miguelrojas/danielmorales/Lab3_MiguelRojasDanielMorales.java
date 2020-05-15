package lab3_miguelrojas.danielmorales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lab3_MiguelRojasDanielMorales {

    static Scanner input = new Scanner(System.in);
    static ArrayList lista_usuarios = new ArrayList();

    public static void main(String[] args) throws ParseException {

        ArrayList<Cliente> lista_clientes = new ArrayList();

        char resp = 's';
        while (resp == 's' || resp == 'S') {
            System.out.println("Bienvenido al Shopping Mall de muy muy lejos.");
            System.out.println("1. Sign in");
            System.out.println("2. Log in");
            System.out.println("3. Salir");
            int op = input.nextInt();
            input = new Scanner(System.in);
            System.out.println();
            switch (op) {
                case 1: {
                    System.out.print("--------------------\n"
                            + "Crear Usuario\n"
                            + "Ingrese su id: ");
                    //Id
                    String id = input.next();
                    input = new Scanner(System.in);
                    System.out.println();
                    //Usuario
                    System.out.print("Ingrese un usuario: ");
                    String usuario = input.nextLine();
                    input = new Scanner(System.in);
                    System.out.println();
                    //Contraseña: 
                    System.out.print("Ingrese una contraseña: ");
                    String password = input.next();
                    input = new Scanner(System.in);
                    System.out.println();
                    //Correo
                    System.out.print("Ingrese su correo electronico: ");
                    String correo = input.next();
                    input = new Scanner(System.in);
                    System.out.println();
                    //Nombre Completo
                    System.out.print("Ingrese su nombre completo: ");
                    String nombre_completo = input.nextLine();
                    input = new Scanner(System.in);
                    System.out.println();
                    //Fecha de Nacimiento
                    System.out.print("Ingrese su fecha de nacimiento(dd/mm/yyyy): ");
                    String fecha = input.next();
                    input = new Scanner(System.in);
                    System.out.println();
                    //Formatear fecha
                    SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                    Date fecha_nacimiento = sd.parse(fecha);
                    //Cantidad de Dinero
                    System.out.print("Ingrese cantidad de dinero: ");
                    int cantidad_dinero = input.nextInt();
                    input = new Scanner(System.in);
                    System.out.println();
                    //Agregar a lista de clientes
                    lista_clientes.add(new Cliente(cantidad_dinero, id, usuario, password, correo, nombre_completo, fecha_nacimiento));
                    lista_usuarios.add(usuario);
                    System.out.println("Se creo la cuenta exitosamente!!\n");
                    break;

                }
                case 2: {
                    boolean authSUDO = false;
                    boolean authCLI = false;
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
                    } else if (lista_usuarios.contains(userRecibido)) {
                        int indUserRecibido = 0;
                        for (int i = 0; i < lista_clientes.size(); i++) {
                            if (((Cliente) lista_clientes.get(i)).getUsuario().equals(userRecibido)) {
                                indUserRecibido = i;
                            }
                        }
                        if (((Cliente) lista_clientes.get(indUserRecibido)).getPassword().equals(passRecibida)) {
                            System.out.println("Usuario autenticado.");
                            authCLI = true;
                        }
                    } else {
                        System.out.println("Usuario incorrecto. ");
                    }

                    char opResp = 's';
                    while (opResp == 's' || opResp == 'S') {
                        if (authCLI) {
                            //Logica para uso del cliente.
                        } else if (authSUDO) {
                            //Logica para uso del administrador.
                        }
                    }
                }
                break;
                case 3:
                    resp = 'n';
                    break;
                default:
                    System.out.println("Ingrese una opcion valida.\n");
            }
        }
    }

    public static void login() {

    }

}
