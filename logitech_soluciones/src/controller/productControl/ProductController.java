package src.controller.productControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.controller.supplierControl.SupplierController;
import src.model.product.Product;
import src.model.supplier.Supplier;
import src.util.Util;

public class ProductController {
    private List<Product> listProducts;
    // private String nameProductGloba;

    public ProductController() {
        this.listProducts = new ArrayList<Product>();
        // this.nameProductGloba = "Nombre de producto global";
    }

    public void create(Scanner scan, int nitSupplier) {
        // Scanner scan = new Scanner(System.in);
        Product newProduct = new Product();
        // Atributos

        Util utils = new Util();
        int unique_code = utils.numRandom(100000);
        System.out.println("Código generado del producto: " + unique_code);

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
        System.out.println("Cantidad de productos: ");

        newProduct.setNitSupplier(nitSupplier);
        this.listProducts.add(newProduct);
    }

    public void showAllProducts() {
        showAllProducts(this.listProducts);
    }

    public void showAllProducts(List<Product> list) {
        System.out.println("Mostrando todos los productos: ");
        for (Product product : list) {
            System.out.println(
                    "--- Nit " + product.getNitSupplier() +
                            ", Codigo: " + product.getUniqueCode() + ", Nombre: " + product.nameProduct
                            + ", Categoria: "
                            + product.category + ", Precio: "
                            + product.unitPrecie + ", Stock Disponible: " + product.inventoryStock + " ---");
        }
    }

    public void showProductsByNit(int nit) {
        List<Product> productsFound = this.listProducts.stream()
                .filter(p -> p.getNitSupplier() == nit)
                .toList();

        if (productsFound.isEmpty()) {
            System.out.println("No se encontraron productos para el NIT: " + nit);
        } else {
            showAllProducts(productsFound);
        }
    }

    public int subtractStock(Scanner scan) {
        Product productFound = this.getProductByUniqueCode(scan);
        if (productFound == null) {
            System.out.println("Producto encontrado no encontrado");
            return 0;
        }
        System.out.println("Producto encontrado: ");
        System.out.println("Escribe la cantidad de productos que necesitas: ");
        int stockSubtractWrited = scan.nextInt();
        if (productFound.getInventoryStock() < stockSubtractWrited) {
            System.out.println("Ha escrito una cantidad mayor a la que hay disponible: ");
            return 0;
        }
        productFound.setInventoryStock(productFound.inventoryStock - stockSubtractWrited);
        System.out.println("Se ha restado el stock correctamente quedan: " + productFound.getInventoryStock());
        return stockSubtractWrited;
    }

    public Product getProductByUniqueCode(Scanner scan) {
        Product productFound = null;
        System.out.println("Escribe el código del producto a buscar: ");
        int uniqueCodeInsert = scan.nextInt();
        productFound = this.listProducts.stream().filter(p -> p.getUniqueCode() == uniqueCodeInsert).findAny()
                .orElse(productFound);
        // for (Product productItem : this.listProducts) {
        // if (productItem.getUniqueCode() == uniqueCodeInsert) {
        // productFound = productItem;
        // }
        // }
        return productFound;
    }

    public void autoCreateProducts(SupplierController controlSupplier) {
        if (controlSupplier.getListSuplier().isEmpty()) {
            System.out.println("No se puede ejecutar Auto Creacion de productos si no hay proveedores");
            return;
        }
        List<Supplier> listSuppliers = controlSupplier.getListSuplier();
        Supplier retailMin = listSuppliers.get(0);
        Supplier retailMax = listSuppliers.get(1);

        Util utils = new Util();
        Product productChicle = new Product();
        productChicle.setUniqueCode(utils.numRandom(1000));
        productChicle.setProduct("Chicle", "dulce", 10, 999);
        productChicle.setNitSupplier(retailMin.nit);
        this.listProducts.add(productChicle);

        Product productBomBomBun = new Product();
        productBomBomBun.setUniqueCode(utils.numRandom(1000));
        productBomBomBun.setProduct("BomBomBun", "dulce", 18, 500);
        productBomBomBun.setNitSupplier(retailMin.nit);
        this.listProducts.add(productBomBomBun);

        Product productBianchi = new Product();
        productBianchi.setUniqueCode(utils.numRandom(1000));
        productBianchi.setProduct("Bianchi", "dulce", 3, 999);
        productBianchi.setNitSupplier(retailMin.nit);
        this.listProducts.add(productBianchi);

        Product productChocolateJet = new Product();
        productChocolateJet.setUniqueCode(utils.numRandom(1000));
        productChocolateJet.setProduct("Chocolatina Jet", "dulce", 10, 500);
        productChocolateJet.setNitSupplier(retailMax.nit);
        this.listProducts.add(productChocolateJet);

        Product productJumbo = new Product();
        productJumbo.setUniqueCode(utils.numRandom(1000));
        productJumbo.setProduct("Chocolatina Jumbo", "dulce", 16, 300);
        productJumbo.setNitSupplier(retailMax.nit);
        this.listProducts.add(productJumbo);

        Product productKipitos = new Product();
        productKipitos.setUniqueCode(utils.numRandom(1000));
        productKipitos.setProduct("Kipitos", "dulce", 8, 699);
        productKipitos.setNitSupplier(retailMax.nit);
        this.listProducts.add(productKipitos);

        this.showAllProducts();
    }
}
