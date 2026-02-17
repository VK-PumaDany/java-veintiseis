package src.controller.productControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.model.product.Product;
import src.util.Util;

public class ProductController {
    private List<Product> listProducts;
    // private String nameProductGloba;

    public ProductController() {
        this.listProducts = new ArrayList<Product>();
        // this.nameProductGloba = "Nombre de producto global";
    }

    public void create(Scanner scan) {
        // Scanner scan = new Scanner(System.in);
        Product newProduct = new Product();
        // Atributos

        Util utils = new Util();
        int unique_code = utils.numRandom(100000);
        System.out.println("Código generado del producto: " + unique_code);
        scan.nextLine();
        System.out.println("Ingrese el nombre del producto: ");
        String nameProduct = scan.nextLine();

        System.out.println("Ingrese el nombre de la categoria: ");
        String category = scan.nextLine();

        System.out.println("Ingrese el precio: ");
        int unitPrecie = scan.nextInt();

        System.out.println("Cantidad de productos: ");
        int inventoryStock = scan.nextInt();

        newProduct.setUniqueCode(unique_code);
        newProduct.setProduct(nameProduct, category, unitPrecie, inventoryStock);

        this.listProducts.add(newProduct);
    }

    public void allProduct() {
        System.out.println("Mostrando todos los productos: ");
        for (Product product : this.listProducts) {
            System.out.println(
                    "Nombre " + product.nameProduct + "Categoria " + product.category + "Precio " + product.unitPrecie);
        }
    }
}
