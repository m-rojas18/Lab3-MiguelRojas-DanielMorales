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
    static ArrayList<Comida> lista_comidas = new ArrayList();
    static ArrayList<Juguetes> lista_juguetes = new ArrayList();
    static ArrayList<Quiosco> lista_quioscos = new ArrayList();
    static ArrayList<Bares> lista_bares = new ArrayList();
    static int indUserRecibido = 0;

    public static void main(String[] args) throws ParseException {

        ArrayList<Cliente> lista_clientes = new ArrayList();
        ArrayList<Empleado> lista_empleados = new ArrayList();
        ArrayList<Producto> lista_productos = new ArrayList();
        ArrayList<Tiendas> lista_tiendas = new ArrayList();

        char resp = 's';
        while (resp == 's' || resp == 'S') {
            System.out.println("Usuario : SUDO y Contraseña: sudo");
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
                            System.out.println("Bienvenido al Shopping mall de muy muy lejos");
                            System.out.println("A que establecimiento desea ir: \n"
                                    + "1. Tienda\n"
                                    + "2. Quiosco\n"
                                    + "3. Bar\n");
                            int opCli = input.nextInt();
                            switch (opCli) {
                                case 1:
                                    if (lista_tiendas.isEmpty()) {
                                        System.out.print("No existe ninguna tienda.\n");
                                    } else {
                                        for (int i = 0; i < lista_tiendas.size(); i++) {
                                            Tiendas getTie = lista_tiendas.get(i);
                                            System.out.println("[" + i + "]" + "Nombre: " + getTie.getNombre());
                                        }
                                    }
                                    System.out.println("A que tienda desea ir? : ");
                                    int opTieSele = input.nextInt();
                                    Tiendas t = lista_tiendas.get(opTieSele);
                                    System.out.println("Productos de la tienda: ");
                                    for (int i = 0; i < t.getProductos().size(); i++) {
                                        System.out.println("[" + i + "]" + t.getProductos().get(i) + "\n");
                                    }
                                    System.out.println("Desea comprar o irse? 1. comprar 2. salir ");
                                    int inputCompraTie = input.nextInt();
                                    switch (inputCompraTie) {
                                        case 1:
                                            System.out.println("Productos de la tienda: ");
                                            for (int i = 0; i < t.getProductos().size(); i++) {
                                                System.out.println("[" + i + "]" + t.getProductos().get(i) + "\n");
                                            }
                                            System.out.println("Ingrese el indice del producto que desea comprar: ");
                                            int opCompTie = input.nextInt();
                                            int precio = ((Producto) lista_productos.get(opCompTie)).getPrecio();
                                            int dineroDisp = ((Cliente) lista_clientes.get(indUserRecibido)).getCantidad_dinero();
                                            int diferencia = dineroDisp - precio;
                                            if (dineroDisp > precio) {
                                                System.out.println("Comprado exitosamente. ");
                                                ((Cliente) lista_clientes.get(indUserRecibido)).setCantidad_dinero(diferencia);
                                                lista_productos.remove(opCompTie);
                                            }
                                            break;
                                        case 2:
                                            opResp = 'n';
                                        default:
                                            System.out.println("Ingrese una opcion valida");
                                    }

                                    break;

                                case 2:
                                    if (lista_quioscos.isEmpty()) {
                                        System.out.print("No existe ningun quiosco.\n");
                                    } else {
                                        for (int i = 0; i < lista_quioscos.size(); i++) {
                                            Quiosco getQui = lista_quioscos.get(i);
                                            System.out.println("[" + i + "]" + "Nombre: " + getQui.getNombre());
                                        }
                                    }
                                    System.out.println("A que quiosco desea ir? : ");
                                    int opQuiSel = input.nextInt();
                                    Quiosco q = lista_quioscos.get(opQuiSel);
                                    System.out.println("Productos del quiosco: ");
                                    for (int i = 0; i < q.getProductos().size(); i++) {
                                        System.out.println("[" + i + "]" + q.getProductos().get(i));
                                    }

                                    System.out.println("Desea comprar o irse? 1. comprar 2. salir ");
                                    int inputCompraQui = input.nextInt();
                                    switch (inputCompraQui) {
                                        case 1:
                                            System.out.println("Productos del quiosco: ");
                                            for (int i = 0; i < q.getProductos().size(); i++) {
                                                System.out.println("[" + i + "]" + q.getProductos().get(i) + "\n");
                                            }
                                            System.out.println("Ingrese el indice del producto que desea comprar: ");
                                            int opCompQui = input.nextInt();
                                            int precio = ((Producto) lista_productos.get(opCompQui)).getPrecio() / 2;
                                            int dineroDisp = ((Cliente) lista_clientes.get(indUserRecibido)).getCantidad_dinero();
                                            int diferencia = dineroDisp - precio;
                                            if (dineroDisp > precio) {
                                                System.out.println("Comprado exitosamente. ");
                                                ((Cliente) lista_clientes.get(indUserRecibido)).setCantidad_dinero(diferencia);
                                                lista_productos.remove(opCompQui);
                                            }
                                            break;
                                        case 2:
                                            opResp = 'n';
                                        default:
                                            System.out.println("Ingrese una opcion valida");
                                    }
                                    break;
                                case 3:
                                    if (lista_bares.isEmpty()) {
                                        System.out.print("No existe ningun bar.\n");
                                    } else {
                                        for (int i = 0; i < lista_bares.size(); i++) {
                                            Bares getQui = lista_bares.get(i);
                                            System.out.println("[" + i + "]" + "Nombre: " + getQui.getNombre());
                                        }
                                    }
                                    System.out.println("A que bar desea ir? : ");
                                    int opBarSel = input.nextInt();
                                    Bares b = lista_bares.get(opBarSel);
                                    System.out.println("Productos del bar: ");
                                    for (int i = 0; i < b.getProductos().size(); i++) {
                                        System.out.println("[" + i + "]" + b.getProductos().get(i));
                                    }
                                    System.out.println("Desea comprar o irse? 1. comprar 2. salir ");
                                    int inputCompraBar = input.nextInt();
                                    switch (inputCompraBar) {
                                        case 1:
                                            System.out.println("Productos del bar: ");
                                            for (int i = 0; i < b.getProductos().size(); i++) {
                                                System.out.println("[" + i + "]" + b.getProductos().get(i) + "\n");
                                            }
                                            System.out.println("Ingrese el indice del producto que desea comprar: ");
                                            int opCompBar = input.nextInt();
                                            int precio = ((Producto) lista_productos.get(opCompBar)).getPrecio();
                                            int dineroDisp = ((Cliente) lista_clientes.get(indUserRecibido)).getCantidad_dinero();
                                            int diferencia = dineroDisp - precio;
                                            if (dineroDisp > precio) {
                                                System.out.println("Comprado exitosamente. ");
                                                ((Cliente) lista_clientes.get(indUserRecibido)).setCantidad_dinero(diferencia);
                                                lista_productos.remove(opCompBar);
                                            }
                                            break;
                                        case 2:
                                            opResp = 'n';
                                        default:
                                            System.out.println("Ingrese una opcion valida");
                                    }
                                    break;
                                case 4:
                                    opResp = 'n';
                                    break;
                                default:
                                    throw new AssertionError();
                            }
                        } else if (authSUDO == true) {
                            boolean flag_menuAdmin = true;
                            while (flag_menuAdmin) {
                                System.out.print("-------------------\n"
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
                                                                    nombre_tienda = input.nextLine();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();

                                                                    //Creacion de Objeto
                                                                    Tiendas tienda = new Tiendas(nombre_tienda, new ArrayList(), new ArrayList(), "");
                                                                    String salida_empleados = "";
                                                                    for (int i = 0; i < lista_empleados.size(); i++) {
                                                                        Empleado e = lista_empleados.get(i);
                                                                        salida_empleados += "[" + i + "] ID:" + e.getId() + "\n"
                                                                                + "Nombre: " + e.getNombre_completo() + "\n"
                                                                                + "Correo" + e.getCorreo_electronico() + "\n"
                                                                                + "Horario de Trabajo" + e.getHorario_trabajo() + "\n";
                                                                    }
                                                                    boolean add_empleados = true;
                                                                    boolean add_object = true;
                                                                    while (add_empleados) {
                                                                        System.out.println("Lista de Empleados\n"
                                                                                + salida_empleados + "\n"
                                                                                + "Eliga un empleado");
                                                                        int op_empleado = input.nextInt();
                                                                        input = new Scanner(System.in);

                                                                        for (int i = 0; i < tienda.getEmpleados().size(); i++) {
                                                                            if (!tienda.getEmpleados().contains(lista_empleados.get(op_empleado))) {
                                                                                add_object = true;
                                                                            } else {
                                                                                add_object = false;
                                                                            }
                                                                        }

                                                                        if (add_object == false) {
                                                                            System.out.println("No se puede agregar el mismo empleado.\n");
                                                                        } else {
                                                                            tienda.getEmpleados().add(lista_empleados.get(op_empleado));
                                                                            System.out.println("Se agrego el empleado exitosamente!!\n\n");
                                                                        }

                                                                        System.out.print("Desea agregar otro empleados?\n"
                                                                                + "[1] Si\n"
                                                                                + "[2] No\n"
                                                                                + "Eliga una opcion: ");
                                                                        int seguir = input.nextInt();
                                                                        if (seguir == 1) {
                                                                            //do nothing
                                                                        } else {
                                                                            add_empleados = false;
                                                                        }
                                                                    }

                                                                    //Productos
                                                                    System.out.print("Productos\n"
                                                                            + "[1] Ropa\n"
                                                                            + "[2] Juguetes\n"
                                                                            + "Eliga una opcion: ");
                                                                    int op_addProd = input.nextInt();
                                                                    if (op_addProd == 1) {
                                                                        boolean flag_addProd = true;

                                                                        while (flag_addProd) {
                                                                            String salida_ropaAdd = "";
                                                                            for (int i = 0; i < lista_ropa.size(); i++) {
                                                                                Ropa r6 = lista_ropa.get(i);
                                                                                salida_ropaAdd += "[" + i + "] " + "Nombre: " + r6.getNombre() + "\n"
                                                                                        + "Descripcion: " + r6.getDescripcion() + "\n"
                                                                                        + "Precio: " + r6.getPrecio() + "lps.\n"
                                                                                        + "Sexo: " + r6.getSexo() + "\n"
                                                                                        + "Talla: " + r6.getTalla() + "\n"
                                                                                        + "---------------------\n";
                                                                            }

                                                                            System.out.print("Lista de Ropas\n"
                                                                                    + salida_ropaAdd + "\n"
                                                                                    + "Eliga prenda a agregar: ");
                                                                            int op_addPrenda = input.nextInt();
                                                                            tienda.getProductos().add(lista_productos.get(op_addPrenda));
                                                                            System.out.println("Se agrego el producto exitosamente!!\n\n");
                                                                            System.out.print("Desea agregar otra prenda?\n"
                                                                                    + "[1] Si\n"
                                                                                    + "[2] No\n"
                                                                                    + "Eliga una opcion: ");
                                                                            int seguir1 = input.nextInt();
                                                                            if (seguir1 == 1) {
                                                                                //do nothing
                                                                            } else {
                                                                                flag_addProd = false;
                                                                            }

                                                                        }

                                                                    } else {
                                                                        String salida_juguetesAdd = "";
                                                                        for (int i = 0; i < lista_juguetes.size(); i++) {
                                                                            Juguetes j = lista_juguetes.get(i);
                                                                            salida_juguetesAdd += "[" + i + "] Nombre: " + j.getNombre() + "\n"
                                                                                    + "Descripcion: " + j.getDescripcion() + "\n"
                                                                                    + "Precio: " + j.getPrecio() + "\n"
                                                                                    + "---------------------\n";
                                                                        }

                                                                        boolean seguir_AddProd = true;
                                                                        while (seguir_AddProd) {
                                                                            System.out.println("Lista de Juguetes\n"
                                                                                    + salida_juguetesAdd + "\n"
                                                                                    + "Eliga juguete a agregar: ");
                                                                            int op_addJuguetes = input.nextInt();
                                                                            tienda.getProductos().add(lista_juguetes.get(op_addJuguetes));
                                                                            System.out.println("Se agrego el producto exitosamente!!\n\n");
                                                                            System.out.print("Desea agregar otra prenda?\n"
                                                                                    + "[1] Si\n"
                                                                                    + "[2] No\n"
                                                                                    + "Eliga una opcion: ");
                                                                            int seguir2 = input.nextInt();
                                                                            if (seguir2 == 1) {
                                                                                //do nothing
                                                                            } else {
                                                                                seguir_AddProd = false;
                                                                            }

                                                                        }

                                                                    }

                                                                    String salida_empleados2 = "";
                                                                    for (int i = 0; i < tienda.getEmpleados().size(); i++) {
                                                                        Empleado e = (Empleado) tienda.getEmpleados().get(i);
                                                                        salida_empleados2 += "[" + i + "] ID:" + e.getId() + "\n"
                                                                                + "Nombre: " + e.getNombre_completo() + "\n"
                                                                                + "Correo" + e.getCorreo_electronico() + "\n"
                                                                                + "Horario de Trabajo" + e.getHorario_trabajo() + "\n";
                                                                    }

                                                                    System.out.println("Lista de Empleados Contratados\n"
                                                                            + salida_empleados2 + "\n"
                                                                            + "Eliga empleado a se gerente: ");
                                                                    int op_gerente = input.nextInt();
                                                                    tienda.setGerente(((Empleado) tienda.getEmpleados().get(op_gerente)).getNombre_completo());

                                                                    lista_tiendas.add(tienda);
                                                                    System.out.println("Se agrego exitosamente la tienda!!\n");
                                                                }
                                                                break;
                                                            case 2:
                                                                System.out.print("--------------------\n"
                                                                        + "Crear Quiosco\n");
                                                                boolean flag_empleados2 = true;
                                                                boolean flag_productos2 = true;
                                                                boolean flag_productos3 = true;
                                                                if (lista_empleados.isEmpty()) {
                                                                    System.out.println("No hay empleados disponibles.\n"
                                                                            + "Debe Contratar empleados(Crear).\n");
                                                                } else {
                                                                    flag_empleados2 = false;
                                                                }

                                                                if (lista_productos.isEmpty()) {
                                                                    System.out.print("No hay productos disponibles.\n"
                                                                            + "Debe crear nuevos productos antes de crear una tienda.\n");
                                                                } else {
                                                                    flag_productos2 = false;
                                                                }

                                                                if (lista_tiendas.isEmpty()) {
                                                                    System.out.println("Debe existir alguna tienda para crear Quiosco/\n");
                                                                } else {
                                                                    flag_productos3 = false;
                                                                }

                                                                if (flag_empleados2 == false && flag_productos2 == false && flag_productos3 == false) {
                                                                    String salida_nombresTienda = "";
                                                                    for (int i = 0; i < lista_tiendas.size(); i++) {
                                                                        salida_nombresTienda += "[" + i + "] Nombre: " + lista_tiendas.get(i).getNombre() + "\n";
                                                                    }

                                                                    System.out.print("Lista de Tiendas\n"
                                                                            + salida_nombresTienda + "\n"
                                                                            + "Eliga un nombre para el quiosco: ");
                                                                    int op_nombre = input.nextInt();
                                                                    System.out.println();
                                                                    Quiosco q = new Quiosco(lista_tiendas.get(op_nombre).getNombre(), new ArrayList(),
                                                                            new ArrayList(), "");

                                                                    boolean add_empleados = true;
                                                                    boolean add_object = true;
                                                                    String salida_empleados = "";
                                                                    while (add_empleados) {
                                                                        if (q.getEmpleados().size() < 4) {
                                                                            System.out.println("Lista de Empleados\n"
                                                                                    + salida_empleados + "\n"
                                                                                    + "Eliga un empleado");
                                                                            int op_empleado = input.nextInt();
                                                                            input = new Scanner(System.in);

                                                                            for (int i = 0; i < q.getEmpleados().size(); i++) {
                                                                                if (!q.getEmpleados().contains(lista_empleados.get(op_empleado))) {
                                                                                    add_object = true;
                                                                                } else {
                                                                                    add_object = false;
                                                                                }
                                                                            }

                                                                            if (add_object == false) {
                                                                                System.out.println("No se puede agregar el mismo empleado.\n");
                                                                            } else {
                                                                                q.getEmpleados().add(lista_empleados.get(op_empleado));
                                                                                System.out.println("Se agrego el empleado exitosamente!!\n\n");
                                                                            }

                                                                            System.out.print("Desea agregar otro empleados?\n"
                                                                                    + "[1] Si\n"
                                                                                    + "[2] No\n"
                                                                                    + "Eliga una opcion: ");
                                                                            int seguir = input.nextInt();
                                                                            System.out.println();
                                                                            if (seguir == 1) {
                                                                                //do nothing
                                                                            } else {
                                                                                add_empleados = false;
                                                                            }
                                                                        } else {
                                                                            add_empleados = false;
                                                                            System.out.println("Ya no puede agregar mas empleados");
                                                                        }

                                                                    }
                                                                    //Agregar Ropa
                                                                    boolean flag_addProd = true;

                                                                    while (flag_addProd) {
                                                                        String salida_ropaAdd = "";
                                                                        for (int i = 0; i < lista_ropa.size(); i++) {
                                                                            Ropa r6 = lista_ropa.get(i);
                                                                            salida_ropaAdd += "[" + i + "] " + "Nombre: " + r6.getNombre() + "\n"
                                                                                    + "Descripcion: " + r6.getDescripcion() + "\n"
                                                                                    + "Precio: " + r6.getPrecio() + "lps.\n"
                                                                                    + "Sexo: " + r6.getSexo() + "\n"
                                                                                    + "Talla: " + r6.getTalla() + "\n"
                                                                                    + "---------------------\n";
                                                                        }

                                                                        System.out.print("Lista de Ropas\n"
                                                                                + salida_ropaAdd + "\n"
                                                                                + "Eliga prenda a agregar: ");
                                                                        int op_addPrenda = input.nextInt();
                                                                        q.getProductos().add(lista_productos.get(op_addPrenda));
                                                                        System.out.println("Se agrego el producto exitosamente!!\n\n");
                                                                        System.out.print("Desea agregar otra prenda?\n"
                                                                                + "[1] Si\n"
                                                                                + "[2] No\n"
                                                                                + "Eliga una opcion: ");
                                                                        int seguir1 = input.nextInt();
                                                                        if (seguir1 == 1) {
                                                                            //do nothing
                                                                        } else {
                                                                            flag_addProd = false;
                                                                        }

                                                                    }
                                                                    //Producto Comida
                                                                    String salida_comidas = "";
                                                                    boolean flag_addComida = true;
                                                                    while (flag_addComida) {
                                                                        for (int i = 0; i < lista_comidas.size(); i++) {
                                                                            Comida c0 = lista_comidas.get(i);
                                                                            salida_comidas += "[" + i + "] Nombre: " + c0.getNombre() + "\n"
                                                                                    + "Descripcion: " + c0.getDescripcion() + "\n"
                                                                                    + "Precio: " + c0.getPrecio() + "\n"
                                                                                    + "Tipo: " + c0.getTipo() + "\n"
                                                                                    + "Fecha de Caducidad" + c0.getFecha_caducidad() + "\n"
                                                                                    + "---------------------\n";
                                                                        }

                                                                        System.out.print("Lista de Comidas\n"
                                                                                + salida_comidas + "\n"
                                                                                + "Eliga comida a agregar: ");
                                                                        int op_AddComida = input.nextInt();
                                                                        System.out.println();
                                                                        q.getProductos().add(op_AddComida);

                                                                        System.out.println("Se agego el producto exitosamente!!\n");
                                                                        System.out.print("Desea agregar otra comida?\n"
                                                                                + "[1] Si\n"
                                                                                + "[2] No\n"
                                                                                + "Eliga una opcion: ");
                                                                        int seguir3 = input.nextInt();
                                                                        if (seguir3 == 1) {
                                                                            //do nothing
                                                                        } else {
                                                                            flag_addComida = false;
                                                                        }

                                                                    }
                                                                    //Agregar Juguete
                                                                    String salida_juguetesAdd = "";
                                                                    for (int i = 0; i < lista_juguetes.size(); i++) {
                                                                        Juguetes j = lista_juguetes.get(i);
                                                                        salida_juguetesAdd += "[" + i + "] Nombre: " + j.getNombre() + "\n"
                                                                                + "Descripcion: " + j.getDescripcion() + "\n"
                                                                                + "Precio: " + j.getPrecio() + "\n"
                                                                                + "---------------------\n";
                                                                    }

                                                                    boolean seguir_AddProd = true;
                                                                    while (seguir_AddProd) {
                                                                        System.out.println("Lista de Juguetes\n"
                                                                                + salida_juguetesAdd + "\n"
                                                                                + "Eliga juguete a agregar: ");
                                                                        int op_addJuguetes = input.nextInt();
                                                                        q.getProductos().add(lista_juguetes.get(op_addJuguetes));
                                                                        System.out.println("Se agrego el producto exitosamente!!\n\n");
                                                                        System.out.print("Desea agregar otra prenda?\n"
                                                                                + "[1] Si\n"
                                                                                + "[2] No\n"
                                                                                + "Eliga una opcion: ");
                                                                        int seguir2 = input.nextInt();
                                                                        if (seguir2 == 1) {
                                                                            //do nothing
                                                                        } else {
                                                                            seguir_AddProd = false;
                                                                        }

                                                                    }

                                                                    //Gerente
                                                                    String salida_empleados2 = "";
                                                                    for (int i = 0; i < q.getEmpleados().size(); i++) {
                                                                        Empleado e = (Empleado) q.getEmpleados().get(i);
                                                                        salida_empleados2 += "[" + i + "] ID:" + e.getId() + "\n"
                                                                                + "Nombre: " + e.getNombre_completo() + "\n"
                                                                                + "Correo" + e.getCorreo_electronico() + "\n"
                                                                                + "Horario de Trabajo" + e.getHorario_trabajo() + "\n";
                                                                    }

                                                                    System.out.println("Lista de Empleados Contratados\n"
                                                                            + salida_empleados2 + "\n"
                                                                            + "Eliga empleado a se gerente: ");
                                                                    int op_gerente = input.nextInt();
                                                                    q.setGerente(((Empleado) q.getEmpleados().get(op_gerente)).getNombre_completo());

                                                                    lista_quioscos.add(q);
                                                                    System.out.println("Se agrego exitosamente el quiosco!!\n");

                                                                }
                                                                break;
                                                            case 3:
                                                                System.out.print("--------------------\n"
                                                                        + "Crear Bar\n");
                                                                boolean flag_empleados3 = true;
                                                                boolean flag_productos4 = true;

                                                                if (flag_empleados3 == false && flag_productos4 == false) {
                                                                    System.out.print("Ingrese nombre del bar: ");
                                                                    String nombre_tienda = input.nextLine();
                                                                    nombre_tienda = input.nextLine();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();

                                                                    //Creacion de Objeto
                                                                    Bares bar = new Bares(nombre_tienda, new ArrayList(), new ArrayList(), "");
                                                                    String salida_empleados = "";
                                                                    for (int i = 0; i < lista_empleados.size(); i++) {
                                                                        Empleado e = lista_empleados.get(i);
                                                                        salida_empleados += "[" + i + "] ID:" + e.getId() + "\n"
                                                                                + "Nombre: " + e.getNombre_completo() + "\n"
                                                                                + "Correo" + e.getCorreo_electronico() + "\n"
                                                                                + "Horario de Trabajo" + e.getHorario_trabajo() + "\n";
                                                                    }
                                                                    boolean add_empleados = true;
                                                                    boolean add_object = true;
                                                                    while (add_empleados) {
                                                                        if (bar.getEmpleados().size() < 4) {
                                                                            System.out.println("Lista de Empleados\n"
                                                                                    + salida_empleados + "\n"
                                                                                    + "Eliga un empleado");
                                                                            int op_empleado = input.nextInt();
                                                                            input = new Scanner(System.in);

                                                                            for (int i = 0; i < bar.getEmpleados().size(); i++) {
                                                                                if (!bar.getEmpleados().contains(lista_empleados.get(op_empleado))) {
                                                                                    add_object = true;
                                                                                } else {
                                                                                    add_object = false;
                                                                                }
                                                                            }

                                                                            if (add_object == false) {
                                                                                System.out.println("No se puede agregar el mismo empleado.\n");
                                                                            } else {
                                                                                bar.getEmpleados().add(lista_empleados.get(op_empleado));
                                                                                System.out.println("Se agrego el empleado exitosamente!!\n\n");
                                                                            }

                                                                            System.out.print("Desea agregar otro empleados?\n"
                                                                                    + "[1] Si\n"
                                                                                    + "[2] No\n"
                                                                                    + "Eliga una opcion: ");
                                                                            int seguir = input.nextInt();
                                                                            System.out.println();
                                                                            if (seguir == 1) {
                                                                                //do nothing
                                                                            } else {
                                                                                add_empleados = false;
                                                                            }
                                                                        } else {
                                                                            add_empleados = false;
                                                                            System.out.println("Ya no puede agregar mas empleados");
                                                                        }

                                                                    }

                                                                    //Productos
                                                                    String salida_comidas = "";
                                                                    boolean flag_addComida = true;
                                                                    while (flag_addComida) {
                                                                        for (int i = 0; i < lista_comidas.size(); i++) {
                                                                            Comida c0 = lista_comidas.get(i);
                                                                            salida_comidas += "[" + i + "] Nombre: " + c0.getNombre() + "\n"
                                                                                    + "Descripcion: " + c0.getDescripcion() + "\n"
                                                                                    + "Precio: " + c0.getPrecio() + "\n"
                                                                                    + "Tipo: " + c0.getTipo() + "\n"
                                                                                    + "Fecha de Caducidad" + c0.getFecha_caducidad() + "\n"
                                                                                    + "---------------------\n";
                                                                        }

                                                                        System.out.print("Lista de Comidas\n"
                                                                                + salida_comidas + "\n"
                                                                                + "Eliga comida a agregar: ");
                                                                        int op_AddComida = input.nextInt();
                                                                        System.out.println();
                                                                        bar.getProductos().add(op_AddComida);

                                                                        System.out.println("Se agego el producto exitosamente!!\n");
                                                                        System.out.print("Desea agregar otra comida?\n"
                                                                                + "[1] Si\n"
                                                                                + "[2] No\n"
                                                                                + "Eliga una opcion: ");
                                                                        int seguir3 = input.nextInt();
                                                                        if (seguir3 == 1) {
                                                                            //do nothing
                                                                        } else {
                                                                            flag_addComida = false;
                                                                        }

                                                                    }

                                                                    String salida_empleados2 = "";
                                                                    for (int i = 0; i < bar.getEmpleados().size(); i++) {
                                                                        Empleado e = (Empleado) bar.getEmpleados().get(i);
                                                                        salida_empleados2 += "[" + i + "] ID:" + e.getId() + "\n"
                                                                                + "Nombre: " + e.getNombre_completo() + "\n"
                                                                                + "Correo" + e.getCorreo_electronico() + "\n"
                                                                                + "Horario de Trabajo" + e.getHorario_trabajo() + "\n";
                                                                    }
                                                                    System.out.println("Lista de Empleados Contratados\n"
                                                                            + salida_empleados2 + "\n"
                                                                            + "Eliga empleado a ser gerente: ");
                                                                    int op_gerente = input.nextInt();
                                                                    bar.setGerente(((Empleado) bar.getEmpleados().get(op_gerente)).getNombre_completo());
                                                                    lista_bares.add(bar);
                                                                    System.out.println("Se agrego exitosamente el bar!\n");

                                                                }
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
                                                                System.out.println("No nos dio tiempo. :(\n");
                                                                break;
                                                            case 2:
                                                                System.out.println("No nos dio tiempo. :(\n");
                                                                break;
                                                            case 3:
                                                                System.out.println("No nos dio tiempo. :(\n");
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
                                                                if (lista_tiendas.isEmpty()) {
                                                                    System.out.println("No existe ninguna tienda.\n");
                                                                } else {

                                                                    String salida_elimTienda = "";
                                                                    for (int i = 0; i < lista_tiendas.size(); i++) {
                                                                        Tiendas ts = lista_tiendas.get(i);
                                                                        salida_elimTienda += "[" + i + "] Nombre: " + ts.getNombre() + "\n";
                                                                    }

                                                                    System.out.print("Lista de Tiendas\n"
                                                                            + salida_elimTienda + "\n"
                                                                            + "Eliga tienda a eliminar: ");
                                                                    int elim_tienda = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_tiendas.remove(elim_tienda);
                                                                    System.out.println("Se elimino el local exitosamente!!\n");
                                                                }
                                                                break;
                                                            case 2:
                                                                if (lista_quioscos.isEmpty()) {
                                                                    System.out.println("No existe ningun quiosco.\n");
                                                                } else {
                                                                    String salida_elimquioscos = "";
                                                                    for (int i = 0; i < lista_quioscos.size(); i++) {
                                                                        Quiosco q = lista_quioscos.get(i);
                                                                        salida_elimquioscos += "[" + i + "] Nombre: " + q.getNombre() + "\n";
                                                                    }

                                                                    System.out.print("Lista de Quioscos\n"
                                                                            + salida_elimquioscos + "\n"
                                                                            + "Eliga quiosco a eliminar: ");
                                                                    int elim_quiosco = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_quioscos.remove(elim_quiosco);

                                                                    System.out.println("Se elimino el local exitosamente!!\n");
                                                                }
                                                                break;
                                                            case 3:
                                                                if (lista_bares.isEmpty()) {
                                                                    System.out.println("No existe ningun bar.\n");
                                                                } else {

                                                                    String salida_elimBar = "";
                                                                    for (int i = 0; i < lista_bares.size(); i++) {
                                                                        Bares b = lista_bares.get(i);
                                                                        salida_elimBar += "[" + i + "] Nombre: " + b.getNombre() + "\n";
                                                                    }

                                                                    System.out.print("Lista de Bares\n"
                                                                            + salida_elimBar + "\n"
                                                                            + "Eliga quiosco a eliminar: ");
                                                                    int elim_bar = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_bares.remove(elim_bar);
                                                                    System.out.println("Se elimino el local exitosamente!!\n");
                                                                }
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
                                                                String idc = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                boolean idcOrigCheck = false;
                                                                if (lista_uids.contains(idc)) {
                                                                    System.out.println("ID ya existente.");
                                                                    while (idcOrigCheck == false) {
                                                                        System.out.println("Ingrese su id:");
                                                                        idc = input.next();
                                                                        if (lista_uids.contains(idc)) {
                                                                            System.out.println("ID ya existente");
                                                                        } else {
                                                                            idcOrigCheck = true;
                                                                        }
                                                                    }
                                                                }
                                                                //Usuario
                                                                System.out.print("Ingrese un usuario: ");
                                                                String usuarioc = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                boolean userOrigCheckc = false;
                                                                if (lista_usuarios.contains(usuarioc)) {
                                                                    System.out.println("Usuario ya existente");
                                                                    while (userOrigCheckc == false) {
                                                                        System.out.println("Ingrese un usuario: ");
                                                                        usuarioc = input.next();
                                                                        if (lista_usuarios.contains(usuarioc)) {
                                                                            System.out.println("Usuario ya existente");
                                                                        } else {
                                                                            userOrigCheckc = true;
                                                                        }
                                                                    }
                                                                }
                                                                //Contraseña: 
                                                                System.out.print("Ingrese una contraseña: ");
                                                                String passwordc = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Correo
                                                                System.out.print("Ingrese su correo electronico: ");
                                                                String correoc = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Nombre Completo
                                                                System.out.print("Ingrese su nombre completo: ");
                                                                String nombre_completoc = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Fecha de Nacimiento
                                                                System.out.print("Ingrese su fecha de nacimiento(dd/mm/yyyy): ");
                                                                String fecha = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Formatear fecha
                                                                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                                                                Date fecha_nacimientoc = sd.parse(fecha);
                                                                //Cantidad de Dinero
                                                                System.out.print("Ingrese cantidad de dinero: ");
                                                                int cantidad_dineroc = input.nextInt();
                                                                input = new Scanner(System.in);
                                                                Cliente c = new Cliente(cantidad_dineroc, idc, usuarioc, passwordc, correoc, nombre_completoc, fecha_nacimientoc);
                                                                lista_clientes.add(c);
                                                                lista_usuarios.add(usuarioc);
                                                                break;
                                                            case 2:
                                                                System.out.println("Ingrese el ID: ");
                                                                String ide = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                boolean idOrigChecke = false;
                                                                if (lista_uids.contains(ide)) {
                                                                    System.out.println("ID ya existente.");
                                                                    while (idOrigChecke == false) {
                                                                        System.out.println("Ingrese su id:");
                                                                        ide = input.next();
                                                                        if (lista_uids.contains(ide)) {
                                                                            System.out.println("ID ya existente");
                                                                        } else {
                                                                            idOrigChecke = true;
                                                                        }
                                                                    }
                                                                }
                                                                //Usuario
                                                                System.out.print("Ingrese un usuario: ");
                                                                String usuarioe = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                boolean userOrigCheck = false;
                                                                if (lista_usuarios.contains(usuarioe)) {
                                                                    System.out.println("Usuario ya existente");
                                                                    while (userOrigCheck == false) {
                                                                        System.out.println("Ingrese un usuario: ");
                                                                        usuarioe = input.next();
                                                                        if (lista_usuarios.contains(usuarioe)) {
                                                                            System.out.println("Usuario ya existente");
                                                                        } else {
                                                                            userOrigCheck = true;
                                                                        }
                                                                    }
                                                                }
                                                                //Contraseña: 
                                                                System.out.print("Ingrese una contraseña: ");
                                                                String passworde = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Correo
                                                                System.out.print("Ingrese su correo electronico: ");
                                                                String correoe = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Nombre Completo
                                                                System.out.print("Ingrese su nombre completo: ");
                                                                String nombre_completoe = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Fecha de Nacimiento
                                                                System.out.print("Ingrese su fecha de nacimiento(dd/mm/yyyy): ");
                                                                String fechae = input.next();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                //Formatear fecha
                                                                SimpleDateFormat sde = new SimpleDateFormat("dd/MM/yyyy");
                                                                Date fecha_nacimientoe = sde.parse(fechae);
                                                                System.out.println("Ingrese el horario de trabajo: ");
                                                                String horarioTrabajoe = input.nextLine();
                                                                input = new Scanner(System.in);
                                                                System.out.println("Ingrese el numero de productos que vendio: ");
                                                                int numProdVende = input.nextInt();
                                                                Empleado e = new Empleado(horarioTrabajoe, numProdVende, ide, usuarioe, passworde, correoe, nombre_completoe, fecha_nacimientoe);
                                                                lista_empleados.add(e);

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
                                                                //muestra
                                                                System.out.println("Que cliente desea modificar? ");
                                                                String salida_ModCliente = "";
                                                                for (int i = 0; i < lista_clientes.size(); i++) {
                                                                    Cliente modCLi2 = lista_clientes.get(i);
                                                                    salida_ModCliente +=  "[" + i + "] " + "ID: " + modCLi2.getId() + "\n"
                                                                                + "Usuario: " + modCLi2.getUsuario() + "\n"
                                                                                + "Password: " + modCLi2.getPassword() + "\n"
                                                                                + "Correo: " + modCLi2.getCorreo_electronico() + "\n"
                                                                                + "Nombre: " + modCLi2.getNombre_completo() + "\n"
                                                                                + "Fecha: " + modCLi2.getFecha_nacimiento() + "\n"
                                                                                + "Cantidad de dinero: " + modCLi2.getCantidad_dinero() + "LPS \n"
                                                                                + "---------------------\n";
                                                                }
                                                                
                                                                System.out.println("Lista de Clientes\n"
                                                                        + salida_ModCliente + "\n"
                                                                        + "Eliga cliente: ");
                                                                int opCliente = input.nextInt();
                                                                Cliente mod_c = lista_clientes.get(opCliente);
                                                                boolean opModC = true;
                                                                while (opModC) {
                                                                    
                                                                    System.out.println("Cliente Modificando: \n"
                                                                            + "ID: " + mod_c.getId() + "\n"
                                                                                + "Usuario: " + mod_c.getUsuario() + "\n"
                                                                                + "Password: " + mod_c.getPassword() + "\n"
                                                                                + "Correo: " + mod_c.getCorreo_electronico() + "\n"
                                                                                + "Nombre: " + mod_c.getNombre_completo() + "\n"
                                                                                + "Fecha: " + mod_c.getFecha_nacimiento() + "\n"
                                                                                + "Cantidad de dinero: " + mod_c.getCantidad_dinero() + "LPS \n"
                                                                                + "---------------------\n");
                                                                    System.out.println("Ingrese que desea modificar del cliente: \n"
                                                                            + "1. ID\n"
                                                                            + "2. Usuario\n"
                                                                            + "3. Password\n"
                                                                            + "4. Correo\n"
                                                                            + "5. Nombre\n"
                                                                            + "6. Fecha de Nacimiento\n"
                                                                            + "7. Cantidad de dinero\n"
                                                                            + "9. Salida");
                                                                    int opModEmpleado = input.nextInt();
                                                                    switch (opModEmpleado) {
                                                                        case 1:
                                                                            System.out.println("Ingrese el nuevo ID: ");
                                                                            String id_c = input.next();
                                                                            mod_c.setId(id_c);
                                                                            break;
                                                                        case 2:
                                                                            System.out.println("Ingrese el nuevo usuario: ");
                                                                            String usuario_c = input.next();
                                                                            boolean userOrigCheck_c = false;
                                                                            if (lista_usuarios.contains(usuario_c)) {
                                                                                System.out.println("Usuario ya existente");
                                                                                while (userOrigCheck_c == false) {
                                                                                    System.out.println("Ingrese un usuario: ");
                                                                                    usuario_c = input.next();
                                                                                    if (lista_usuarios.contains(usuario_c)) {
                                                                                        System.out.println("Usuario ya existente");
                                                                                    } else {
                                                                                        userOrigCheck_c = true;
                                                                                    }
                                                                                }
                                                                            }
                                                                            mod_c.setUsuario(usuario_c);
                                                                            break;
                                                                        case 3:
                                                                            System.out.println("Ingrese la nueva password: ");
                                                                            String pass_c = input.next();
                                                                            mod_c.setPassword(pass_c);
                                                                            break;
                                                                        case 4:
                                                                            System.out.println("Ingrese el nuevo correo: ");
                                                                            String correo_c = input.nextLine();
                                                                            input = new Scanner(System.in);
                                                                            mod_c.setCorreo_electronico(correo_c);
                                                                            break;
                                                                        case 5:
                                                                            System.out.println("Ingrese el nuevo nombre: ");
                                                                            String nombre_c = input.nextLine();
                                                                            input = new Scanner(System.in);
                                                                            mod_c.setNombre_completo(nombre_c);
                                                                            break;
                                                                        case 6:
                                                                            System.out.println("Ingrese la nueva fecha de nacimiento: (dd/MM/yyyy) ");
                                                                            String fecha_cRAW = input.next();
                                                                            SimpleDateFormat dfc = new SimpleDateFormat("dd/MM/yyyy");
                                                                            Date fecha_c = dfc.parse(fecha_cRAW);
                                                                            mod_c.setFecha_nacimiento(fecha_c);
                                                                            break;
                                                                        case 7:
                                                                            System.out.println("Ingrese la nueva cantidad de dinero: ");
                                                                            int cantDineroC = input.nextInt();
                                                                            mod_c.setCantidad_dinero(cantDineroC);
                                                                            break;
                                                                        case 8:
                                                                            opModC = false;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese una opcion valida");
                                                                    }
                                                                }
                                                                break;
                                                            case 2:
                                                                //mostrar
                                                                System.out.println("Que empleado quiere modificar? ");
                                                                String salida_ModEmpleado = "";
                                                                for (int i = 0; i < lista_empleados.size(); i++) {
                                                                    Empleado modEMP = lista_empleados.get(i);
                                                                    salida_ModEmpleado +=  "[" + i + "] " + "ID: " + modEMP.getId() + "\n"
                                                                                + "Usuario: " + modEMP.getUsuario() + "\n"
                                                                                + "Password: " + modEMP.getPassword() + "\n"
                                                                                + "Correo: " + modEMP.getCorreo_electronico() + "\n"
                                                                                + "Nombre: " + modEMP.getNombre_completo() + "\n"
                                                                                + "Fecha: " + modEMP.getFecha_nacimiento() + "\n"
                                                                                + "Horario de Trabajo: " + modEMP.getHorario_trabajo() + "LPS \n"
                                                                                + "---------------------\n";
                                                                }
                                                                
                                                                System.out.println("Lista de Empleados\n"
                                                                        + salida_ModEmpleado + "\n"
                                                                        + "Eliga un empleado: ");
                                                                int opEmpleados = input.nextInt();
                                                                Empleado mod_e = lista_empleados.get(opEmpleados);
                                                                boolean opModE = true;
                                                                while (opModE) {
                                                                    
                                                                    System.out.println("Empleado Modificando: \n"
                                                                            + "ID: " + mod_e.getId() + "\n"
                                                                                + "Usuario: " + mod_e.getUsuario() + "\n"
                                                                                + "Password: " + mod_e.getPassword() + "\n"
                                                                                + "Correo: " + mod_e.getCorreo_electronico() + "\n"
                                                                                + "Nombre: " + mod_e.getNombre_completo() + "\n"
                                                                                + "Fecha: " + mod_e.getFecha_nacimiento() + "\n"
                                                                                + "Horario de Trabajo: " + mod_e.getHorario_trabajo() + "LPS \n"
                                                                                + "---------------------\n\n");
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
                                                                                        userOrigCheck_e = true;
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
                                                            case 1: {
                                                                if (lista_clientes.isEmpty()) {
                                                                    System.out.print("No existe ningun cliente.\n");
                                                                } else {
                                                                    String salida_elimC = "";
                                                                    for (int i = 0; i < lista_ropa.size(); i++) {
                                                                        Cliente modCli = lista_clientes.get(i);
                                                                        salida_elimC += "[" + i + "] " + "ID: " + modCli.getId() + "\n"
                                                                                + "Usuario: " + modCli.getUsuario() + "\n"
                                                                                + "Password: " + modCli.getPassword() + "\n"
                                                                                + "Correo: " + modCli.getCorreo_electronico() + "\n"
                                                                                + "Nombre: " + modCli.getNombre_completo() + "\n"
                                                                                + "Fecha: " + modCli.getFecha_nacimiento() + "\n"
                                                                                + "Cantidad de dinero: " + modCli.getCantidad_dinero() + "LPS \n"
                                                                                + "---------------------\n";
                                                                    }
                                                                    System.out.print("Lista de Clientes\n"
                                                                            + salida_elimC + "\n"
                                                                            + "Eliga cliente a eliminar: ");
                                                                    int op_elimCli = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_clientes.remove(op_elimCli);
                                                                    System.out.println("Se elimino el cliente exitosamente!!\n");
                                                                }
                                                            }
                                                            break;
                                                            case 2: {
                                                                if (lista_empleados.isEmpty()) {
                                                                    System.out.print("No existe ningun cliente.\n");
                                                                } else {
                                                                    String salida_elimE = "";
                                                                    for (int i = 0; i < lista_empleados.size(); i++) {
                                                                        Empleado modEmp = lista_empleados.get(i);
                                                                        salida_elimE += "[" + i + "] " + "ID: " + modEmp.getId() + "\n"
                                                                                + "Usuario: " + modEmp.getUsuario() + "\n"
                                                                                + "Password: " + modEmp.getPassword() + "\n"
                                                                                + "Correo: " + modEmp.getCorreo_electronico() + "\n"
                                                                                + "Nombre: " + modEmp.getNombre_completo() + "\n"
                                                                                + "Fecha: " + modEmp.getFecha_nacimiento() + "\n"
                                                                                + "Horario de trabajo: " + modEmp.getHorario_trabajo() + "\n"
                                                                                + "Numero de productos: " + modEmp.getNumero_productos() + "\n"
                                                                                + "---------------------\n";
                                                                    }
                                                                    System.out.print("Lista de Empleados\n"
                                                                            + salida_elimE + "\n"
                                                                            + "Eliga cliente a eliminar: ");
                                                                    int op_elimEmp = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_empleados.remove(op_elimEmp);
                                                                    System.out.println("Se elimino el empleado exitosamente!!\n");
                                                                }
                                                            }
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
                                                                    
                                                                    System.out.println("Ropa Modificacndo\n"
                                                                            + "Nombre: " + mod_r.getNombre() + "\n"
                                                                            + "Descripcion: " +mod_r.getDescripcion() + "\n"
                                                                            + "Precio: " + mod_r.getPrecio() + "lps.\n"
                                                                            + "Sexo: " + mod_r.getSexo() + "\n"
                                                                            + "Talla: " + mod_r.getTalla() + "\n"
                                                                            + "---------------------\n");
                                                                    
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
                                                                System.out.print("----------------------\n"
                                                                        + "Modificar Juguete");
                                                                String salida_modJuguetes = "";
                                                                for (int i = 0; i < lista_juguetes.size(); i++) {
                                                                    Juguetes j = lista_juguetes.get(i);
                                                                    salida_modJuguetes += "[" + i + "] Nombre: " + j.getNombre() + "\n"
                                                                            + "Descripcion: " + j.getDescripcion() + "\n"
                                                                            + "Precio: " + j.getPrecio() + "\n"
                                                                            + "---------------------\n";
                                                                }

                                                                System.out.println("Lista de Juguetes\n"
                                                                        + salida_modJuguetes + "\n"
                                                                        + "Eliga juguete a modificar: ");

                                                                int op_modJug = input.nextInt();
                                                                input = new Scanner(System.in);
                                                                System.out.println();
                                                                boolean flag_modJug = true;
                                                                //Objeto de Juguete
                                                                Juguetes j_mod = lista_juguetes.get(op_modJug);
                                                                while (flag_modJug) {
                                                                    
                                                                    System.out.println("Juguete Modificando\n"
                                                                            + "Nombre: " + j_mod.getNombre() + "\n"
                                                                            + "Descripcion: " + j_mod.getDescripcion() + "\n"
                                                                            + "Precio: " + j_mod.getPrecio() + "\n"
                                                                            + "---------------------\n");
                                                                    System.out.print("Opciones de Modificar\n"
                                                                            + "[1] Nombre\n"
                                                                            + "[2] Descripcion\n"
                                                                            + "[3] Precio\n"
                                                                            + "[4] Salir\n"
                                                                            + "Eliga opcion de modificacion: ");
                                                                    int op_modJ = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    switch (op_modJ) {
                                                                        case 1:
                                                                            System.out.print("Ingrese nueva descripcion: ");
                                                                            String mod_descripcion2 = input.nextLine();
                                                                            mod_descripcion2 = input.nextLine();
                                                                            j_mod.setDescripcion(mod_descripcion2);
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 2:
                                                                            System.out.print("Ingrese nuevo nombre de ropa: ");
                                                                            String mod_nombre2 = input.next();
                                                                            j_mod.setNombre(mod_nombre2);
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 3:
                                                                            System.out.print("Ingrese nuevo precio de ropa: ");
                                                                            int mod_precio2 = input.nextInt();
                                                                            j_mod.setPrecio(mod_precio2);
                                                                            System.out.println("Se modifico el producto exitosamente!!\n");
                                                                            break;
                                                                        case 4:
                                                                            flag_modJug = false;
                                                                            break;
                                                                        default:
                                                                            System.out.println("Ingrese una opcion valida.\n");
                                                                    }
                                                                }
                                                                break;
                                                            case 3:
                                                                System.out.print("---------------------\n"
                                                                        + "Modificar Comida");

                                                                if (lista_comidas.isEmpty()) {
                                                                    System.out.println("No hay comidas.\n");
                                                                } else {
                                                                    String salida_modComida = "";
                                                                    for (int i = 0; i < lista_comidas.size(); i++) {
                                                                        Comida c = lista_comidas.get(i);
                                                                        salida_modComida += "[" + i + "] Nombre: " + c.getNombre() + "\n"
                                                                                + "Descripcion: " + c.getDescripcion() + "\n"
                                                                                + "Precio: " + c.getPrecio() + "\n"
                                                                                + "Tipo: " + c.getTipo() + "\n"
                                                                                + "Fecha de Caducidad" + c.getFecha_caducidad() + "\n"
                                                                                + "---------------------\n";
                                                                    }

                                                                    System.out.print("Lista de Comidas\n"
                                                                            + salida_modComida + "\n"
                                                                            + "Eliga comida a modificar: ");

                                                                    int op_modCom = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    boolean flag_modComida = true;
                                                                    //Objeto de Comida
                                                                    Comida c_mod = lista_comidas.get(op_modCom);
                                                                    while (flag_modComida) {
                                                                        
                                                                        System.out.println("Comida Modificando\n"
                                                                                + "Nombre: " + c_mod.getNombre() + "\n"
                                                                                + "Descripcion: " + c_mod.getDescripcion() + "\n"
                                                                                + "Precio: " + c_mod.getPrecio() + "\n"
                                                                                + "Tipo: " + c_mod.getTipo() + "\n"
                                                                                + "Fecha de Caducidad" + c_mod.getFecha_caducidad() + "\n"
                                                                                + "---------------------\n");
                                                                        System.out.print("Opciones de Modificacion\n"
                                                                                + "[1] Nombre\n"
                                                                                + "[2] Descripcion\n"
                                                                                + "[3] Precio\n"
                                                                                + "[4] Tipo\n"
                                                                                + "[5] Fecha de Caducidad\n"
                                                                                + "[6] Salir\n"
                                                                                + "Eliga una opcion: ");
                                                                        int opcion_modCom = input.nextInt();
                                                                        System.out.println();
                                                                        switch (opcion_modCom) {
                                                                            case 1:
                                                                                System.out.print("Ingrese nueva descripcion: ");
                                                                                String mod_descripcion3 = input.nextLine();
                                                                                mod_descripcion3 = input.nextLine();
                                                                                c_mod.setDescripcion(mod_descripcion3);
                                                                                System.out.println("Se modifico el producto exitosamente!!\n");
                                                                                break;
                                                                            case 2:
                                                                                System.out.print("Ingrese nuevo nombre de ropa: ");
                                                                                String mod_nombre3 = input.next();
                                                                                c_mod.setNombre(mod_nombre3);
                                                                                System.out.println("Se modifico el producto exitosamente!!\n");
                                                                                break;
                                                                            case 3:
                                                                                System.out.print("Ingrese nuevo precio de ropa: ");
                                                                                int mod_precio3 = input.nextInt();
                                                                                c_mod.setPrecio(mod_precio3);
                                                                                System.out.println("Se modifico el producto exitosamente!!\n");
                                                                                break;
                                                                            case 4:
                                                                                System.out.println("Modificar Tipo\n"
                                                                                        + "[1] Bebida\n"
                                                                                        + "[2] Comida\n"
                                                                                        + "Eliga una opcion: ");
                                                                                int op_modTipo = input.nextInt();
                                                                                input = new Scanner(System.in);
                                                                                System.out.println();
                                                                                if (op_modTipo == 1) {
                                                                                    c_mod.setTipo("Bebida");
                                                                                } else {
                                                                                    c_mod.setTipo("Comida");
                                                                                }
                                                                                System.out.println("Se modifico el producto exitosamente!!\n");
                                                                                break;
                                                                            case 5:
                                                                                System.out.print("Ingrese nueva fecha de caducacion (dd/mm/yyyy): ");
                                                                                String fecha_mod = input.next();
                                                                                SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
                                                                                c_mod.setFecha_caducidad(sd.parse(fecha_mod));
                                                                                System.out.println("Se modifico el producto exitosamente!!\n");
                                                                                break;
                                                                            case 6:
                                                                                flag_modComida = false;
                                                                                break;
                                                                            default:
                                                                                System.out.println("Ingrese una opcion valida.\n");
                                                                        }
                                                                    }
                                                                }
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
                                                                if (lista_ropa.isEmpty()) {
                                                                    System.out.print("No existe ningun producto de ropa.\n");
                                                                } else {
                                                                    String salida_elimRopa = "";
                                                                    for (int i = 0; i < lista_ropa.size(); i++) {
                                                                        Ropa r6 = lista_ropa.get(i);
                                                                        salida_elimRopa += "[" + i + "] " + "Nombre: " + r6.getNombre() + "\n"
                                                                                + "Descripcion: " + r6.getDescripcion() + "\n"
                                                                                + "Precio: " + r6.getPrecio() + "lps.\n"
                                                                                + "Sexo: " + r6.getSexo() + "\n"
                                                                                + "Talla: " + r6.getTalla() + "\n"
                                                                                + "---------------------\n";
                                                                    }
                                                                    System.out.print("Lista de Ropas\n"
                                                                            + salida_elimRopa + "\n"
                                                                            + "Eliga ropa a eliminar: ");
                                                                    int op_elimRopa = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_ropa.remove(op_elimRopa);
                                                                    System.out.println("Se elimino el producto exitosamente!!\n");

                                                                }
                                                                break;
                                                            case 2:
                                                                if (lista_juguetes.isEmpty()) {
                                                                    System.out.println("No existe ningun producto de juguetes.\n");
                                                                } else {
                                                                    String salida_elimJug = "";
                                                                    for (int i = 0; i < lista_juguetes.size(); i++) {
                                                                        Juguetes j = lista_juguetes.get(i);
                                                                        salida_elimJug += "[" + i + "] Nombre: " + j.getNombre() + "\n"
                                                                                + "Descripcion: " + j.getDescripcion() + "\n"
                                                                                + "Precio: " + j.getPrecio() + "\n"
                                                                                + "---------------------\n";
                                                                    }

                                                                    System.out.print("Lista de Juguetes\n"
                                                                            + salida_elimJug + "\n"
                                                                            + "Eliga juguete a eliminar: ");
                                                                    int op_elimJug = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_juguetes.remove(op_elimJug);
                                                                    System.out.println("Se elimino el producto exitosamente!!\n");
                                                                }
                                                                break;
                                                            case 3:
                                                                //Eliminar Comida
                                                                if (lista_comidas.isEmpty()) {
                                                                    System.out.println("No existe ninguna comida.\n");
                                                                } else {
                                                                    String salida_comidas = "";
                                                                    for (int i = 0; i < lista_comidas.size(); i++) {
                                                                        Comida c = lista_comidas.get(i);
                                                                        salida_comidas += "[" + i + "] Nombre: " + c.getNombre() + "\n"
                                                                                + "Descripcion: " + c.getDescripcion() + "\n"
                                                                                + "Precio: " + c.getPrecio() + "\n"
                                                                                + "Tipo: " + c.getTipo() + "\n"
                                                                                + "Fecha de Caducidad" + c.getFecha_caducidad() + "\n"
                                                                                + "---------------------\n";
                                                                    }

                                                                    System.out.println("Lista de Comidas\n"
                                                                            + salida_comidas + "\n"
                                                                            + "Eliga comida a eliminar: ");
                                                                    int op_elimCom = input.nextInt();
                                                                    input = new Scanner(System.in);
                                                                    System.out.println();
                                                                    lista_comidas.remove(op_elimCom);
                                                                    System.out.println("Se elimino el producto exitosamente!!\n");
                                                                }
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
