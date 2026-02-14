package src.controller.supplierControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.model.supplier.Supplier;

public class SupplierController {
    private List<Supplier> listSupplier;

    public SupplierController() {
        this.listSupplier = new ArrayList<Supplier>();
    }

    public Supplier getSupplierByNit(int nit) {
        Supplier searchSupplier;
        for (int i = 0; i <= this.listSupplier.size(); i++) {
            Supplier inSupplier = this.listSupplier.get(i);
            if (inSupplier.nit == nit) {
                searchSupplier = inSupplier;
                break;
            }
        }
        return searchSupplier;
    }

    public void create(Scanner scan) {

        Supplier newSupplier = new Supplier();

        System.out.println("Ingrese el nit de la empresa provedora: ");
        int nit = scan.nextInt();

        System.out.println("Ingrese el nombre de la empresa: ");
        String name = scan.nextLine();

        System.out.println("Ingrese el numero telefonico de la empresa: ");
        String cellphone = scan.nextLine();

        newSupplier.setSuppliers(nit, name, cellphone);

        this.listSupplier.add(newSupplier);
    }

}
