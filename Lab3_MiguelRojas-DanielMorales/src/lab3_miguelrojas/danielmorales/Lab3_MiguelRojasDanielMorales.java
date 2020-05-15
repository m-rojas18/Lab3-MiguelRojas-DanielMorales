package lab3_miguelrojas.danielmorales;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Lab3_MiguelRojasDanielMorales {

    static Scanner input = new Scanner(System.in);
    static ArrayList lista_usuarios = new ArrayList();
    static ArrayList lista_uids = new ArrayList();

    public static void main(String[] args) throws ParseException {

        ArrayList<Cliente> lista_clientes = new ArrayList();
        ArrayList<Empleado> lista_empleados = new ArrayList();
        ArrayList<Producto> lista_productos = new ArrayList();
        ArrayList<Tiendas> lista_tiendas = new ArrayList();

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
                    boolean userOrigCheck = false;
                    if (lista_usuarios.contains(usuario)) {
                        System.out.println("Usuario ya existente");
                        while (userOrigCheck == false) {
                            System.out.println("Ingrese el usuario: ");
                            usuario = input.next();
                            if (lista_usuarios.contains(usuario)) {

                            } else {
                                userOrigCheck = true;
                            }
                        }
                    }
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
                        break;
                    }

                    char opResp = 's';
                    while (opResp == 's' || opResp == 'S') {
                        if (authCLI) {
                            //Logica para uso del cliente.
                        } else if (authSUDO == true) {
                            boolean flag_menuAdmin = true;
                            while (flag_menuAdmin) {
                                System.out.print("-------------------"
                                        + "Menu de Administrador\n"
                                        + "[1] Manejar Locales\n"
                                        + "[2] Manejar Personas\n"
                                        + "[3] Manejar Productos\n"
                                        + "[4] Ver Factorizacion\n"
                                        + "[5] Salir\n"
                                        + "Seleccione una opcion: ");
                                int op_menu1 = input.nextInt();
                                System.out.println();
                                switch (op_menu1) {
                                    case 1:
                                        boolean flag_menuLocal = true;
                                        while (flag_menuLocal) {
                                            System.out.print("-------------------\n"
                                                    + "[1] Crear Local\n"
                                                    + "[2] Modificar Local\n"
                                                    + "[3] Eliminar Local\n"
                                                    + "[4] Salir\n"
                                                    + "Eliga una opcion: ");
                                            int op_menuLocal = input.nextInt();
                                            System.out.println();
                                            switch (op_menuLocal) {
                                                case 1:
                                                    //Menu Crear Locales
                                                    boolean flag_crearLocal = true;
                                                    while (flag_crearLocal) {
                                                        System.out.print("--------------------\n"
                                                                + "Crear Local\n"
                                                                + "[1] Tienda\n"
                                                                + "[2] Quiosco\n"
                                                                + "[3] Bar\n"
                                                                + "[4] Salir\n"
                                                                + "Eliga una opcion: ");
                                                        int op_crearLocal = input.nextInt();
                                                        System.out.println();
                                                        switch (op_crearLocal) {
                                                            case 1:
                                                                System.out.print("--------------------\n"
                                                                        + "Crear Tienda\n");
                                                                boolean flag_empleados = true;
                                                                boolean flag_productos = true;
                                                                if (lista_empleados.isEmpty()) {
                                                                    System.out.println("No hay empleados disponibles.\n"
                                                                            + "Debe Contratar empleados(Crear).\n");
                                                                } else {
                                                                    flag_empleados = false;
                                                                }

                                                                if (lista_productos.isEmpty()) {
                                                                    System.out.print("No hay productos disponibles.\n"
                                                                            + "Debe crear nuevos productos antes de crear una tienda.\n");
                                                                } else {
                                                                    flag_productos = false;
                                                                }
                                                                
                                                                
                                                                if (flag_empleados == false && flag_productos == false) {
                                                                    System.out.print("Ingrese nombre de la tienda: ");
                                                                    String nombre_tienda = input.nextLine();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    String salida_empleados = "";
                                                                    for (int i = 0; i < lista_empleados.size(); i++) {
                                                                        Empleado e = lista_empleados.get(i);
                                                                        salida_empleados += "[" + i + "] ID:" + e.getId() + "\n"
                                                                                + "Nombre: " + e.getNombre_completo() + "\n"
                                                                                + "Correo" + e.getCorreo_electronico() + "\n"
                                                                                + "Horario de Trabajo" + e.getHorario_trabajo() + "\n";
                                                                    }
                                                                    boolean add_empleados = true;
                                                                    while(add_empleados){
                                                                        System.out.println("Lista de Empleados\n"
                                                                    + salida_empleados + "\n"
                                                                    + "Eliga un empleado");
                                                                    int op_empleado = input.nextInt();
                                                                    
                                                                    input = new Scanner(System.in);
                                                                    System.out.print("Desea agregar otro empleados?\n"
                                                                             + "[1] Si\n"
                                                                             + "[2] No\n"
                                                                             + "Eliga una opcion: ");
                                                                    
 
                                                                    }
                                                                    
                                                                }
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                break;
                                                            case 4:
                                                                flag_crearLocal = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    //Menu Modificar Locales
                                                    boolean flag_modLocal = true;
                                                    while (flag_modLocal) {
                                                        System.out.print("--------------------\n"
                                                                + "Modificar Local\n"
                                                                + "[1] Tienda\n"
                                                                + "[2] Quiosco\n"
                                                                + "[3] Bar\n"
                                                                + "[4] Salir\n"
                                                                + "Eliga una opcion: ");
                                                        int op_modLocal = input.nextInt();
                                                        System.out.println();
                                                        switch (op_modLocal) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                break;
                                                            case 4:
                                                                flag_modLocal = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }
                                                    break;
                                                case 3:
                                                    //Menu Eliminar Locales
                                                    boolean flag_elimLocal = true;
                                                    while (flag_elimLocal) {
                                                        System.out.print("--------------------\n"
                                                                + "Eliminar Local\n"
                                                                + "[1] Tienda\n"
                                                                + "[2] Quiosco\n"
                                                                + "[3] Bar\n"
                                                                + "[4] Salir\n"
                                                                + "Eliga una opcion: ");
                                                        int op_elimLocal = input.nextInt();
                                                        System.out.println();
                                                        switch (op_elimLocal) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                break;
                                                            case 4:
                                                                flag_elimLocal = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    flag_menuLocal = false;
                                                    break;
                                                default:
                                                    System.out.println("Ingrese una opcion valida.\n");
                                            }
                                        }
                                        break;
                                    case 2:
                                        boolean flag_menuPersona = true;
                                        while (flag_menuPersona) {
                                            System.out.print("--------------------\n"
                                                    + "[1] Crear Persona\n"
                                                    + "[2] Modificar Persona\n"
                                                    + "[3] Eliminar Persona\n"
                                                    + "[4] Salir\n"
                                                    + "Eliga una opcion: ");
                                            int op_menuPersonas = input.nextInt();
                                            System.out.println();
                                            switch (op_menuPersonas) {
                                                case 1:
                                                    boolean flag_crearPersona = true;
                                                    while (flag_crearPersona) {
                                                        System.out.print("-------------------\n"
                                                                + "Crear Persona\n"
                                                                + "[1] Cliente\n"
                                                                + "[2] Empleado\n"
                                                                + "[3] Salir\n"
                                                                + "Eliga persona a crear: ");
                                                        int op_crearPer = input.nextInt();
                                                        System.out.println();
                                                        switch (op_crearPer) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                flag_crearPersona = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }
                                                    break;
                                                case 2:
                                                    boolean flag_modPer = true;
                                                    while (flag_modPer) {
                                                        System.out.print("-------------------\n"
                                                                + "Modificar Persona\n"
                                                                + "[1] Cliente\n"
                                                                + "[2] Empleado\n"
                                                                + "[3] Salir\n"
                                                                + "Eliga persona a modificar: ");
                                                        int op_modPer = input.nextInt();
                                                        System.out.println();
                                                        switch (op_modPer) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                flag_modPer = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }

                                                    break;
                                                case 3:
                                                    boolean flag_elimPer = true;
                                                    while (flag_elimPer) {
                                                        System.out.print("-------------------\n"
                                                                + "Eliminar Persona\n"
                                                                + "[1] Cliente\n"
                                                                + "[2] Empleado\n"
                                                                + "[3] Salir\n"
                                                                + "Eliga persona a eliminar: ");
                                                        int op_elimPer = input.nextInt();
                                                        System.out.println();
                                                        switch (op_elimPer) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                flag_elimPer = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    flag_menuPersona = false;
                                                    break;
                                                default:
                                                    System.out.println("Ingrese una opcion valida.\n");
                                            }
                                        }
                                        break;
                                    case 3:
                                        boolean flag_menuProd = true;
                                        while (flag_menuProd) {
                                            System.out.print("--------------------\n"
                                                    + "[1] Crear Producto\n"
                                                    + "[2] Modificar Producto\n"
                                                    + "[3] Eliminar Producto\n"
                                                    + "[4] Salir"
                                                    + "Eliga una opcion: ");
                                            int op_menuProd = input.nextInt();
                                            System.out.println();
                                            switch (op_menuProd) {
                                                case 1:
                                                    boolean flag_crearProd = true;
                                                    while (flag_crearProd) {
                                                        System.out.print("--------------------\n"
                                                                + "Crear Producto\n"
                                                                + "[1] Ropa\n"
                                                                + "[2] Juguete\n"
                                                                + "[3] Comida\n"
                                                                + "[4] Salir\n"
                                                                + "Eliga producto a crear: ");
                                                        int op_producto = input.nextInt();
                                                        System.out.println();
                                                        switch (op_producto) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                break;
                                                            case 4:
                                                                flag_crearProd = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }

                                                    break;
                                                case 2:
                                                    boolean flag_modProd = true;
                                                    while (flag_modProd) {
                                                        System.out.print("--------------------\n"
                                                                + "Modificar Producto\n"
                                                                + "[1] Ropa\n"
                                                                + "[2] Juguete\n"
                                                                + "[3] Comida\n"
                                                                + "[4] Salir\n"
                                                                + "Eliga producto a modificar: ");
                                                        int op_productoMod = input.nextInt();
                                                        System.out.println();
                                                        switch (op_productoMod) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                break;
                                                            case 4:
                                                                flag_modProd = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcion valida.\n");
                                                        }
                                                    }

                                                    break;
                                                case 3:
                                                    boolean flag_elimProd = true;
                                                    while (flag_elimProd) {
                                                        System.out.print("--------------------\n"
                                                                + "Eliminar Producto\n"
                                                                + "[1] Ropa\n"
                                                                + "[2] Juguete\n"
                                                                + "[3] Comida\n"
                                                                + "[4] Salir\n"
                                                                + "Eliga producto a eliminar: ");
                                                        int op_productoElim = input.nextInt();
                                                        System.out.println();
                                                        switch (op_productoElim) {
                                                            case 1:
                                                                break;
                                                            case 2:
                                                                break;
                                                            case 3:
                                                                break;
                                                            case 4:
                                                                flag_elimProd = false;
                                                                break;
                                                            default:
                                                                System.out.println("Ingrese una opcin valida.\n");
                                                        }
                                                    }
                                                    break;
                                                case 4:
                                                    flag_menuProd = false;
                                                    break;
                                                default:
                                                    System.out.println("Ingrese una opcion valida.\n");
                                            }
                                        }

                                        break;
                                    case 4:
                                        System.out.println("Factorizacion");
                                        break;
                                    case 5:
                                        flag_menuAdmin = false;
                                        break;
                                    default:
                                        System.out.println("Ingrese una opcion valida.\n");
                                }
                            }
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
}
