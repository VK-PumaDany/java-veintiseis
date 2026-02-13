import java.util.Scanner;

import src.controller.productControl.*;

public class App {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductController newProduct = new ProductController();

        for (int i = 0; i < 2; i++) {
            newProduct.create(scan);
        }
        scan.close();
        newProduct.allProduct();

    }
}