package src.controller.orderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.controller.productControl.ProductController;
import src.model.order.Order;
import src.model.product.Product;
import src.util.Util;

public class OrderController {
    private List<Order> listOrder;
    // private String nameProductGloba;

    public OrderController() {
        this.listOrder = new ArrayList<Order>();
        // this.nameProductGloba = "Nombre de producto global";
    }

    public void create(Scanner scan, ProductController productControl) {
        // Scanner scan = new Scanner(System.in);
        Order newOrder = new Order();
        // Atributos

        Util utils = new Util();
        int numOrder = utils.numRandom(100000);
        System.out.println("Código de la orden generado: " + numOrder);
        String distpathDate = utils.createDateDDMMYYYY();
        System.out.println("Fecha generada: " + distpathDate);

        System.out.println("Estado de la orden: " + "PENDIENTE");
        newOrder.setOrder(numOrder, distpathDate, "PENDIENTE", numOrder);

        System.out.println("Desea agregar productos a la order: si / no");
        String yesOrNo = scan.nextLine();

        if (yesOrNo == "no") {
            System.out.println("Orden creada sin productos");
            return;
        }

        productControl.showAllProducts();

        System.out.println("\n Cuantos productos desea agregar a la order");
        int amountProductAdd = scan.nextInt();
        newOrder.setListProductsOrder(new ArrayList<Product>());
        for (int i = 0; i < amountProductAdd; i++) {
            // Con la clase productControl llamamos a la funcion que controla la resta de
            // los productos y actualizarlos
            int subtractedStockProduct = productControl.subtractStock(scan);
            // Con la clase getProductByUniqueCode llamamos a la funcion que controla si el
            // producto existe
            Product getProductFound = productControl.getProductByUniqueCode(scan);
            // Creamos un nuevo producto aparte desde cero para guardarlo en la orden
            Product saveProductStock = new Product();
            saveProductStock.setProduct(getProductFound.nameProduct, getProductFound.category,
                    getProductFound.unitPrecie, subtractedStockProduct);
            // Establecer el nit
            saveProductStock.setNitSupplier(getProductFound.getNitSupplier());
            // Obtenemos la lista de productos de la orden
            List<Product> listProductsOrder = newOrder.getListProductsOrder();
            // Lo agregamos
            listProductsOrder.add(saveProductStock);
            // Lo guardamos nuevamente
            newOrder.setListProductsOrder(listProductsOrder);
        }

        System.out.println("Orden creada ");

        this.listOrder.add(newOrder);
    }

}
