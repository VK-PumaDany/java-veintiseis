package src.model.order;

import java.util.List;

import src.model.product.Product;

public class Order {
    public int numOrder;
    public String dispathDate;
    private String status; // pendiente, despachada o cancelada
    public int allPrecieOrder;
    private List<Product> listProductsOrder;

    public Order getOrder() {
        return this;
    }

    public void setOrder(int num, String date, String status, int precie) {
        this.numOrder = num;
        this.dispathDate = date;
        this.status = status;
        this.allPrecieOrder = precie;
    }

    public String getOrderStatus() {
        return this.status;
    }

    public void setOrderStatus(String status) {
        this.status = status;
    }

    public List<Product> getListProductsOrder() {
        return this.listProductsOrder;
    }

    public void setListProductsOrder(List<Product> list) {
        this.listProductsOrder = list;
    }

}
