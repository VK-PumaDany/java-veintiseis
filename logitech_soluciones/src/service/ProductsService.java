package src.service;

public class ProductsService {
    private List<Products> listProducts; 

    public ProductsService {
        this.listProducts = new ArrayList();
    }

    public void create() {
        Scanner scan = new Scanner(System.in);
        // Atributos

        Utils utils = new Utils();
        double unique_code =  utils.numRandom(); 

        System.out.println("Código generado del producto: " + unique_code);
        System.out.println("Ingrese el nombre del producto: ");
        System.out.println("Ingrese el nombre de la categoria: ");

        nameProduct = scan.nextLine();
        category = scan.nextLine();
        unitPrecie = scan.nextInt();


        scan.close();
    }
}
