import java.util.Scanner;

import src.controller.productControl.*;
import src.controller.supplierControl.SupplierController;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductController newProduct = new ProductController();
        SupplierController newSupplier = new SupplierController();

        for (int i = 0; i < 3; i++) {
            newSupplier.create(scan);
        }

        // for (int i = 0; i < 2; i++) {
        // newProduct.create(scan);
        // }

        for (int i = 0; i < 3; i++) {
            System.out.println("Ingrese el nit a buscar: ");
            int nit = scan.nextInt();
            System.out.println(newSupplier.getSupplierByNit(nit).name);
        }

        scan.close();
        newProduct.allProduct();

    }
}