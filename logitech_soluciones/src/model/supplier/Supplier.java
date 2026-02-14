package src.model.supplier;

public class Supplier {
    public int nit;
    public String name;
    public String cellPhone;

    public Supplier getSuppliers() {
        return this;
    }

    public void setSuppliers(int nit, String name, String cellPhone) {
        this.nit = nit;
        this.name = name;
        this.cellPhone = cellPhone;
    }
}
