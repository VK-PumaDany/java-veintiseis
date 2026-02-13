package src.model.product;

public class Product {
    private int uniqueCode;
    public String nameProduct;
    public String category;
    public int unitPrecie;
    public int inventoryStock;

    public int getUniqueCode() {
        return this.uniqueCode;
    }

    public void setUniqueCode(int newUniqueCode) {
        this.uniqueCode = newUniqueCode;
    }

    public Product getProduct() {
        return this;
    }

    public void setProduct(String name, String category, int price, int stock) {
        this.nameProduct = name;
        this.category = category;
        this.unitPrecie = price;
        this.inventoryStock = stock;
    }
}
