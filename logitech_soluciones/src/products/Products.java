package src.products;

import java.util.Scanner;

public class Products {
    public void create_product() {
        Scanner scan = new Scanner(System.in);
        // Atributos
        double unique_code = Math.random();

        System.out.println("Código generado: " + unique_code);

        System.out.println("Ingrese el nombre del producto: ");
        String name_product = scan.nextLine();
        System.out.println("Ingrese el nombre de la categoria: ");
        String category = scan.nextLine();

        scan.close();
    }
}
