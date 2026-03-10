import java.util.Scanner;

import src.controller.orderControl.OrderController;
import src.controller.productControl.*;
import src.controller.supplierControl.SupplierController;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductController newProduct = new ProductController();
        SupplierController newSupplier = new SupplierController();
        OrderController newOrder = new OrderController();

        int opcion;

        do {
            System.out.println("\n--- SISTEMA DE GESTIÓN LOGITECH ---");
            System.out.println("1. Registrar Proveedores");
            System.out.println("2. Mostrar Proveedores");
            System.out.println("3. Registrar Productos (vincular a NIT)");
            System.out.println("4. Ver Productos por NIT");
            System.out.println("5. Mostrar todos los Productos");
            System.out.println("6. Crear una nueva orden");
            System.out.println("7. Mostrar orden por codigo");
            System.out.println("8. Mostrar todas las ordenes");
            System.out.println("9. Actualizar estado de la orden");
            // System.out.println("100. Auto completar");
            System.out.println("101. Auto registrar proveedores total 2");
            System.out.println("102. Auto registrar productos total 15");
            // System.out.println("103. Auto registrar ordenes total 1");
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
                    System.out.println("\n--- Mostrando Proveedores ---");
                    // Puedes decidir cuántos registrar o pedirlo al usuario
                    newSupplier.showAllSuppliers();
                    break;
                case 3:
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

                case 4:
                    System.out.println("\n--- Búsqueda por NIT ---");
                    System.out.print("Ingrese el NIT para mostrar los productos: ");
                    int nitBusqueda = scan.nextInt();
                    newProduct.showProductsByNit(nitBusqueda);
                    break;

                case 5:
                    System.out.println("\n--- Inventario Total ---");
                    newProduct.showAllProducts();
                    break;
                case 6:
                    System.out.println("\n--- Crear nueva Orden ---");
                    newOrder.create(scan, newProduct);
                    break;
                case 7:
                    System.out.println("\n--- Mostrar Orden por numero ---");
                    newOrder.showOrderByNumOrder(scan, newProduct);
                    break;
                case 8:
                    System.out.println("\n--- Mostrar todas las ordenes ---");
                    newOrder.showAllOrder(newProduct);
                    break;
                case 9:
                    System.out.println("\n--- Actualizar estado de la orden ---");
                    newOrder.updateOrderStatus(scan);
                    break;
                case 101:
                    System.out.println("\n--- Auto Registrar proveedores ---");
                    newSupplier.autoCreateSuppliers();
                    break;
                case 102:
                    System.out.println("\n--- Auto Registrar productos ---");
                    newProduct.autoCreateProducts(newSupplier);
                    break;
                case 103:
                    System.out.println("\n--- Auto  Registrar Orden ---");
                    newOrder.showOrderByNumOrder(scan, newProduct);
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