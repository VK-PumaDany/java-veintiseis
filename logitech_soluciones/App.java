import java.util.Scanner;

import src.controller.productControl.*;
import src.controller.supplierControl.SupplierController;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductController newProduct = new ProductController();
        SupplierController newSupplier = new SupplierController();

        newSupplier.create(scan);

        newSupplier.listSupplier

        for (int i = 0; i < 2; i++) {
            newProduct.create(scan);
        }
        scan.close();
        newProduct.allProduct();

    }
}