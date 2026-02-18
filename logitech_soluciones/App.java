import java.util.Scanner;

import src.controller.productControl.*;
import src.controller.supplierControl.SupplierController;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductController newProduct = new ProductController();
        SupplierController newSupplier = new SupplierController();

        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN LOGITECH ---");
            System.out.println("1. Registrar Proveedores");
            System.out.println("2. Registrar Productos (vincular a NIT)");
            System.out.println("3. Ver Productos por NIT");
            System.out.println("4. Mostrar todos los Productos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scan.nextInt();
            scan.nextLine(); // Limpiar el buffer después de leer un entero

            switch (opcion) {
                case 1:
                    System.out.println("\n--- Registro de Proveedores ---");
                    // Puedes decidir cuántos registrar o pedirlo al usuario
                    newSupplier.create(scan);
                    break;

                case 2:
                    System.out.println("\n--- Registro de Productos ---");
                    System.out.print("Ingrese el NIT del proveedor para referenciar el producto: ");
                    int nitProd = scan.nextInt();
                    scan.nextLine();
                    // Verificación básica: Asegúrate de que el NIT exista antes de llamar al método
                    if (newSupplier.getSupplierByNit(nitProd) != null) {
                        newProduct.create(scan, newSupplier.getSupplierByNit(nitProd).nit);
                    } else {
                        System.out.println("Error: El NIT no existe.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Búsqueda por NIT ---");
                    System.out.print("Ingrese el NIT para mostrar los productos: ");
                    int nitBusqueda = scan.nextInt();
                    newProduct.showProductsByNit(nitBusqueda);
                    break;

                case 4:
                    System.out.println("\n--- Inventario Total ---");
                    newProduct.allProduct();
                    break;

                case 0:
                    System.out.println("Cerrando sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scan.close();
    }
}