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
    static ArrayList<Ropa> lista_ropa = new ArrayList();

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
                    boolean idOrigCheck = false;
                    if (lista_uids.contains(id)) {
                        System.out.println("ID ya existente.");
                        while (idOrigCheck == false) {
                            System.out.println("Ingrese su id:");
                            id = input.next();
                            if (lista_uids.contains(id)) {
                                System.out.println("ID ya existente");
                            } else {
                                idOrigCheck = true;
                            }
                        }
                    }
                    //Usuario
                    System.out.print("Ingrese un usuario: ");
                    String usuario = input.nextLine();
                    input = new Scanner(System.in);
                    System.out.println();
                    boolean userOrigCheck = false;
                    if (lista_usuarios.contains(usuario)) {
                        System.out.println("Usuario ya existente");
                        while (userOrigCheck == false) {
                            System.out.println("Ingrese un usuario: ");
                            usuario = input.next();
                            if (lista_usuarios.contains(usuario)) {
                                System.out.println("Usuario ya existente");
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
                    lista_uids.add(id);
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
                                                                    while (add_empleados) {
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
                                                                System.out.println("Ingrese el ID: ");
                                                                String id = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                boolean idOrigCheck = false;
                                                                if (lista_uids.contains(id)) {
                                                                    System.out.println("ID ya existente.");
                                                                    while (idOrigCheck == false) {
                                                                        System.out.println("Ingrese su id:");
                                                                        id = input.next();
                                                                        if (lista_uids.contains(id)) {
                                                                            System.out.println("ID ya existente");
                                                                        } else {
                                                                            idOrigCheck = true;
                                                                        }
                                                                    }
                                                                }
                                                                //Usuario
                                                                System.out.print("Ingrese un usuario: ");
                                                                String usuario = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                boolean userOrigCheck = false;
                                                                if (lista_usuarios.contains(usuario)) {
                                                                    System.out.println("Usuario ya existente");
                                                                    while (userOrigCheck == false) {
                                                                        System.out.println("Ingrese un usuario: ");
                                                                        usuario = input.next();
                                                                        if (lista_usuarios.contains(usuario)) {
                                                                            System.out.println("Usuario ya existente");
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
                                                                System.out.println("Ingrese el horario de trabajo: ");
                                                                String horarioTrabajo = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese el numero de productos que vendio: ");
                                                                int numProdVend = input.nextInt();
                                                                Empleado e = new Empleado(horarioTrabajo, numProdVend, id, usuario, password, correo, nombre_completo, fecha_nacimiento);
                                                                lista_empleados.add(e);
                                                                break;
                                                            case 2:
                                                                System.out.println("Que persona quiere modificar? ");
                                                                int opPersona = input.nextInt();
                                                                Empleado mod_e = lista_empleados.get(opPersona);
                                                                boolean opModE = true;
                                                                while (opModE) {
                                                                    System.out.println("Ingrese que desea modificar del empleado: \n"
                                                                            + "1. ID\n"
                                                                            + "2. Usuario\n"
                                                                            + "3. Password\n"
                                                                            + "4. Correo\n"
                                                                            + "5. Nombre\n"
                                                                            + "6. Fecha de Nacimiento\n"
                                                                            + "7. Horario\n"
                                                                            + "8. Numero de productos \n"
                                                                            + "9. Salida");
                                                                    int opModEmpleado = input.nextInt();
                                                                    switch (opModEmpleado) {
                                                                        case 1:
                                                                            System.out.println("Ingrese el nuevo ID: ");
                                                                            String id_e = input.next();
                                                                            mod_e.setId(id_e);
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Ingrese el nuevo usuario: ");
                                                                            String usuario_e = input.next();
                                                                            boolean userOrigCheck_e = false;
                                                                            if (lista_usuarios.contains(usuario_e)) {
                                                                                System.out.println("Usuario ya existente");
                                                                                while (userOrigCheck_e == false) {
                                                                                    System.out.println("Ingrese un usuario: ");
                                                                                    usuario_e = input.next();
                                                                                    if (lista_usuarios.contains(usuario_e)) {
                                                                                        System.out.println("Usuario ya existente");
                                                                                    } else {
                                                                                        userOrigCheck = true;
                                                                                    }
                                                                                }
                                                                            }
                                                                            mod_e.setUsuario(usuario_e);
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Ingrese la nueva password: ");
                                                                            String pass_e = input.next();
                                                                            mod_e.setPassword(pass_e);
                                                                            break;
                                                                        case 4:
                                                                            System.out.println("Ingrese el nuevo correo: ");
                                                                            String correo_e = input.nextLine();
                                                                            input = new Scanner(System.in);
                                                                            mod_e.setCorreo_electronico(correo_e);
                                                                            break;
                                                                        case 5:
                                                                            System.out.println("Ingrese el nuevo nombre: ");
                                                                            String nombre_e = input.nextLine();
                                                                            input = new Scanner(System.in);
                                                                            mod_e.setNombre_completo(nombre_e);
                                                                            break;
                                                                        case 6:
                                                                            System.out.println("Ingrese la nueva fecha de nacimiento: (dd/MM/yyyy) ");
                                                                            String fecha_eRAW = input.next();
                                                                            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                                                                            Date fecha_e = df.parse(fecha_eRAW);
                                                                            mod_e.setFecha_nacimiento(fecha_e);
                                                                            break;
                                                                        case 7:
                                                                            System.out.println("Ingrese el nuevo horario: ");
                                                                            String horario_e = input.nextLine();
                                                                            input = new Scanner(System.in);
                                                                            mod_e.setHorario_trabajo(horario_e);
                                                                            break;
                                                                        case 8:
                                                                            System.out.println("Ingrese el nuevo num de productos: ");
                                                                            int prod_e = input.nextInt();
                                                                            mod_e.setNumero_productos(prod_e);
                                                                            break;
                                                                        case 9:
                                                                            opModE = false;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese una opcion valida");
                                                                    }
                                                                }
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
                                                                System.out.println("Ingrese el nombre: ");
                                                                String nombreRopa = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese una descripcion de la prenda: ");
                                                                String descripRopa = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese el precio de la prenda: ");
                                                                int precioRopa = input.nextInt();
                                                                System.out.println("Ingrese si es de hombre o mujer: 1. Hombre 2. Mujer");
                                                                int ropaSexoResp = input.nextInt();
                                                                String sexo = "";
                                                                switch (ropaSexoResp) {
                                                                    case 1:
                                                                        sexo = "Hombre";
                                                                        break;
                                                                    case 2:
                                                                        sexo = "Mujer";
                                                                        break;
                                                                }
                                                                System.out.println("Ingrese la talla: 1. S 2. M 3. L 4. XL");
                                                                int ropaTallaResp = input.nextInt();
                                                                String talla = "";
                                                                switch (ropaTallaResp) {
                                                                    case 1:
                                                                        talla = "S";
                                                                        break;
                                                                    case 2:
                                                                        talla = "M";
                                                                        break;
                                                                    case 3:
                                                                        talla = "L";
                                                                        break;
                                                                    case 4:
                                                                        talla = "XL";
                                                                        break;

                                                                }
                                                                Ropa r = new Ropa(sexo, talla, descripRopa, nombreRopa, precioRopa);
                                                                lista_productos.add(r);
                                                                lista_ropa.add(r);
                                                                break;
                                                            case 2:
                                                                System.out.println("Ingrese el nombre del juguete: ");
                                                                String nombreJuguete = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese una descripcion del juguete: ");
                                                                String descripJuguete = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese el precio del juguete: ");
                                                                int precioJuguete = input.nextInt();
                                                                Juguetes j = new Juguetes(descripJuguete, nombreJuguete, precioJuguete);
                                                                lista_productos.add(j);
                                                                break;
                                                            case 3:
                                                                System.out.println("Ingrese el nombre: ");
                                                                String nombreComida = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese la descripcion: ");
                                                                String descComida = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese el precio: ");
                                                                int precioComida = input.nextInt();
                                                                System.out.println("Ingrese que tipo de comida desea crear: 1. Bebida 2. Comida");
                                                                int comidaOp = input.nextInt();
                                                                String comidaTipo = "";
                                                                switch (comidaOp) {
                                                                    case 1:
                                                                        comidaTipo = "Bebida";
                                                                        break;
                                                                    case 2:
                                                                        comidaTipo = "Comida";
                                                                        break;
                                                                }
                                                                System.out.println("Ingrese la fecha de caducidad de la comida o bebida: (dd/MM/yyyy)");
                                                                String fechaCaducidadRAW = input.next();
                                                                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                                                                Date fechaCaducidad = sd.parse(fechaCaducidadRAW);

                                                                Comida c = new Comida(comidaTipo, fechaCaducidad, descComida, nombreComida, precioComida);
                                                                lista_productos.add(c);
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
                                                                System.out.println("Que ropa desea modificar: ");
                                                                //muestra
                                                                String salida_ropa = "";
                                                                for (int i = 0; i < lista_ropa.size(); i++) {
                                                                    Ropa r = lista_ropa.get(i);
                                                                    salida_ropa += "[" + i + "] " + "Nombre: " + r.getNombre() + "\n"
                                                                            + "Descripcion: " + r.getDescripcion() + "\n"
                                                                            + "Precio: " + r.getPrecio() + "lps.\n"
                                                                            + "Sexo: " + r.getSexo() + "\n"
                                                                            + "Talla: " + r.getTalla() + "\n"
                                                                            + "---------------------\n";
                                                                }
                                                                System.out.println("Lista de Ropa\n"
                                                                        + salida_ropa + "\n"
                                                                        + "Eliga opcion a modificar: ");
                                                                int op_modRopa = input.nextInt();
                                                                input = new Scanner(System.in);
                                                                //Instanciar objeto de Ropa
                                                                Ropa mod_r = lista_ropa.get(op_modRopa);
                                                                boolean flag_opMod = true;
                                                                while (flag_opMod) {
                                                                    System.out.print("Opciones Modificacion\n"
                                                                            + "[1] Descripcion\n"
                                                                            + "[2] Nombre\n"
                                                                            + "[3] Precio\n"
                                                                            + "[4] Sexo\n"
                                                                            + "[5] Talla\n"
                                                                            + "[6] Salir\n"
                                                                            + "Eliga una opcion: ");
                                                                    int op_modificion = input.nextInt();
                                                                    System.out.println();
                                                                    switch (op_modificion) {
                                                                        case 1:
                                                                            System.out.print("Ingrese nueva descripcion: ");
                                                                            String mod_descripcion = input.nextLine();
                                                                            mod_descripcion = input.nextLine();
                                                                            mod_r.setDescripcion(mod_descripcion);
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 2:
                                                                            System.out.print("Ingrese nuevo nombre de ropa: ");
                                                                            String mod_nombre = input.next();
                                                                            mod_r.setNombre(mod_nombre);
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 3:
                                                                            System.out.print("Ingrese nuevo precio de ropa: ");
                                                                            int mod_precio = input.nextInt();
                                                                            mod_r.setPrecio(mod_precio);
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 4:
                                                                            System.out.println("Sexo\n"
                                                                                    + "[1] Hombre\n"
                                                                                    + "[2] Mujer\n"
                                                                                    + "Eliga una opcion: ");
                                                                            int op_modSexo = input.nextInt();
                                                                            System.out.println();
                                                                            if (op_modSexo == 1) {
                                                                                mod_r.setSexo("Hombre");
                                                                            } else {
                                                                                mod_r.setSexo("Mujer");
                                                                            }
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 5:
                                                                            System.out.println("Modificar Tallas\n"
                                                                                    + "[1] S\n"
                                                                                    + "[2] M\n"
                                                                                    + "[3] L\n"
                                                                                    + "[4] XL\n"
                                                                                    + "Eliga una opcion: ");
                                                                            int op_modTalla = input.nextInt();
                                                                            System.out.println();
                                                                            if (op_modTalla == 1) {
                                                                                mod_r.setTalla("S");
                                                                            }
                                                                            if (op_modTalla == 2) {
                                                                                mod_r.setTalla("M");
                                                                            }
                                                                            if (op_modTalla == 3) {
                                                                                mod_r.setTalla("L");
                                                                            }
                                                                            if (op_modTalla == 4) {
                                                                                mod_r.setTalla("XL");
                                                                            }
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 6:
                                                                            flag_opMod = false;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese una opcion valida.");
                                                                    }

                                                                }
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
