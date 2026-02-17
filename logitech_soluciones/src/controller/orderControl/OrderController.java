package src.controller.orderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.model.order.Order;
import src.util.Util;

public class OrderController {
    private List<Order> listOrder;
    // private String nameProductGloba;

    public OrderController() {
        this.listOrder = new ArrayList<Order>();
        // this.nameProductGloba = "Nombre de producto global";
    }

    public void create(Scanner scan) {
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
        System.out.println("Orden creada ");

        this.listOrder.add(newOrder);
    }

    
}
