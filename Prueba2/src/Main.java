import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Producto> productos = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1:
                    registrarProducto();
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    buscarProducto();
                    break;
                case 4:
                    ejercicioParesImpares();
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }

            System.out.println();

        } while (opcion != 0);
    }

    public static void mostrarMenu() {
        System.out.println("===== MENÚ PRINCIPAL =====");
        System.out.println("1. Registrar producto");
        System.out.println("2. Listar productos");
        System.out.println("3. Buscar producto por código");
        System.out.println("4. Pares e impares");
        System.out.println("0. Salir");
    }

    public static void registrarProducto() {
        System.out.println("--- Registrar producto ---");

        System.out.print("Código: ");
        String codigo = sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        double precio = leerDouble("Precio: ");

        Producto producto = new Producto(codigo, nombre, precio);
        productos.add(producto);

        System.out.println("Producto registrado correctamente.");
    }

    public static void listarProductos() {
        System.out.println("--- Lista de productos ---");

        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
            return;
        }

        for (Producto p : productos) {
            p.mostrar();
            System.out.println("-------------------");
        }
    }

    public static void buscarProducto() {
        System.out.println("--- Buscar producto ---");

        System.out.print("Ingrese código: ");
        String codigoBuscar = sc.nextLine();

        boolean encontrado = false;

        for (Producto p : productos) {
            if (p.getCodigo().equalsIgnoreCase(codigoBuscar)) {
                System.out.println("Producto encontrado:");
                p.mostrar();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Producto no encontrado.");
        }
    }

    public static void ejercicioParesImpares() {
        System.out.println("--- Pares e impares ---");

        int inicio = leerEntero("Ingrese número inicial: ");
        int fin = leerEntero("Ingrese número final: ");

        clasificarNumeros(inicio, fin);
    }

    public static void clasificarNumeros(int inicio, int fin) {
        if (inicio > fin) {
            System.out.println("El número inicial no puede ser mayor que el final.");
            return;
        }

        for (int i = inicio; i <= fin; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " - PAR");
            } else {
                System.out.println(i + " - IMPAR");
            }
        }
    }

    public static int leerEntero(String mensaje) {
        System.out.print(mensaje);

        while (!sc.hasNextInt()) {
            System.out.println("Debe ingresar un número entero.");
            sc.next();
            System.out.print(mensaje);
        }

        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static double leerDouble(String mensaje) {
        System.out.print(mensaje);

        while (!sc.hasNextDouble()) {
            System.out.println("Debe ingresar un precio válido.");
            sc.next();
            System.out.print(mensaje);
        }

        double numero = sc.nextDouble();
        sc.nextLine();
        return numero;
    }
}