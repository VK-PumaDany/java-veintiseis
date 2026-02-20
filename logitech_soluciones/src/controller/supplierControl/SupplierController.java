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
        Supplier foundSupplier = null;
        for (int i = 0; i < this.listSupplier.size(); i++) {
            Supplier findSupplier = this.listSupplier.get(i);
            if (findSupplier.nit == nit) {
                foundSupplier = findSupplier;
                break;
            }
        }
        return foundSupplier;
    }

    public void create(Scanner scan) {

        Supplier newSupplier = new Supplier();

        System.out.println("Ingrese el nit de la empresa provedora: ");
        int nit = scan.nextInt();
        scan.nextLine();
        System.out.println("Ingrese el nombre de la empresa: ");
        String name = scan.nextLine();

        System.out.println("Ingrese el numero telefonico de la empresa: ");
        String cellphone = scan.nextLine();

        newSupplier.setSuppliers(nit, name, cellphone);

        this.listSupplier.add(newSupplier);
    }

}
