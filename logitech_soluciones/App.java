import java.util.ArrayList;

import src.products.Products;

public class App {
    public static void main(String[] args) {
        ArrayList<Products> listProducts = new ArrayList<Products>();

        // Al estar en la misma carpeta, App ya sabe quién es Products
        Products cellPhone = new Products();
        cellPhone.create_product();

        listProducts.add(cellPhone);

        System.out.print(listProducts);

    }
}