package src.model.order;

public class Order {
    public int numOrder;
    public String dispathDate;
    private String status; // pendiente, despachada o cancelada
    public int allPrecieOrder;

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

}
