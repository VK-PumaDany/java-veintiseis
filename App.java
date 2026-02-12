import src.Products;

public class App {
    public static void main(String[] args) {
        // Al estar en la misma carpeta, App ya sabe quién es Products
        Products cellPhone = new Products();
        cellPhone.create_product();
    }
}