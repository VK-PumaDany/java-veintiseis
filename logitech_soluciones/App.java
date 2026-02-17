import java.util.Scanner;

import src.controller.productControl.*;
import src.controller.supplierControl.SupplierController;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductController newProduct = new ProductController();
        SupplierController newSupplier = new SupplierController();

        // Crear empresas provedoras
        for (int i = 0; i < 2; i++) {
            System.out.println("\n");
            newSupplier.create(scan);
        }
        // Buscar nit de la empresa y asignarle el nit a al nuevo prodcut
        for (int i = 0; i < 3; i++) {
            System.out.println("\n Ingrese el nit para referenciar el producto: ");
            int nit = scan.nextInt();
            scan.nextLine();
            newProduct.create(scan, newSupplier.getSupplierByNit(nit).nit);
        }

        for (int i = 0; i < 2; i++) {
            System.out.println("\n Ingrese el nit para mostrar los productos: ");
            int nit = scan.nextInt();
            newProduct.showProductsByNit(nit);
        }

        scan.close();
        newProduct.allProduct();

    }
}