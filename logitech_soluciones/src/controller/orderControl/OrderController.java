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
        newOrder.setOrder(numOrder, distpathDate, "PENDIENTE", 0);

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
            // Con la clase getProductByUniqueCode llamamos a la funcion que controla si el
            // producto existe
            Product getProductFound = productControl.getProductByUniqueCode(scan);
            // Con la clase productControl llamamos a la funcion que controla la resta de
            // los productos y actualizarlos
            int subtract = productControl.subtractStock(scan, getProductFound);
            // Creamos un nuevo producto aparte desde cero para guardarlo en la orden
            Product saveProductStock = new Product();
            saveProductStock.setUniqueCode(getProductFound.getUniqueCode());
            saveProductStock.setProduct(getProductFound.nameProduct, getProductFound.category,
                    getProductFound.unitPrecie, subtract);
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

    public Order getOrderByNumOrder(Scanner scan) {
        System.out.println("\n Escriba el numero de la orden");
        int numOrder = scan.nextInt();

        Order orderFound = null;

        for (Order orderItem : this.listOrder) {
            if (orderItem.getOrder().numOrder == numOrder) {
                orderFound = orderItem;
            }
        }
        if (orderFound == null) {
            System.out.println("\n La orden no fue encontrada");
            return null;
        }

        return orderFound;
    }

    public void showOrderByNumOrder(Scanner scan, ProductController productControl) {
        Order orderFound = this.getOrderByNumOrder(scan);
        if (orderFound == null)
            return;

        System.out.println("\n--- Orden No. " + orderFound.numOrder + ", Fecha de despacho: " + orderFound.dispathDate
                + ", Estado: " + orderFound.getOrderStatus() + " ---");

        if (orderFound.getListProductsOrder().isEmpty()) {
            System.out.println("\n La orden no tiene productos");
            return;
        }

        productControl.showAllProducts(orderFound.getListProductsOrder());
        int total = productControl.calcTotalPriceListProduct(scan, orderFound.getListProductsOrder());
        System.out.println("--- Precio total :" + total + " ---");
    }

    public void showAllOrder(ProductController productControl) {
        if (this.listOrder.isEmpty()) {
            System.out.println("No se han creado ninguna orden");
            return;
        }
        System.out.println("--- Mostrando todas las ordenes: ---");
        for (Order orderItem : this.listOrder) {
            System.out
                    .println("\n--- Orden No. " + orderItem.numOrder + ", Fecha de despacho: " + orderItem.dispathDate
                            + ", Estado: " + orderItem.getOrderStatus() + " ---");
            productControl.showAllProducts(orderItem.getListProductsOrder());
        }
    }

    public void updateOrderStatus(Scanner scan) {
        Order orderFound = this.getOrderByNumOrder(scan);
        if (orderFound == null)
            return;
        System.out.println("--- Escriba el numero si fue despachada o cancelada la orden ---");

        System.out.println("--- 1. Despachada ---");
        System.out.println("--- 2. Cancelada ---");
        scan.nextLine();
        String selector = scan.nextLine();

        switch (selector) {
            case "1":
                orderFound.setOrderStatus("Despachada");
                System.out.println("Orden despachada con exito");
                break;
            case "2":
                orderFound.setOrderStatus("Cancelada");
                System.out.println("Orden cancelada");
                break;
            default:
                System.out.println("--- La orden no se le pudo actualizar el estado ---");
                break;
        }

    }
}
