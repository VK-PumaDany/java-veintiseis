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

    public List<Supplier> getListSuplier()  {
        return this.listSupplier;
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
        boolean isValidNit = this.validateNitExits(nit);
        if (!isValidNit) {
            System.out.println("El nit ya esta resgistrado por favor intente con otro ");
            return;
        }
        System.out.println("Ingrese el nombre de la empresa: ");
        String name = scan.nextLine();

        System.out.println("Ingrese el numero telefonico de la empresa: ");
        String cellphone = scan.nextLine();

        newSupplier.setSuppliers(nit, name, cellphone);

        this.listSupplier.add(newSupplier);
    }

    public boolean validateNitExits(int nit) {
        boolean existsSupplier = this.listSupplier.stream().filter(supplier -> supplier.nit == nit).findFirst()
                .isEmpty();
        return existsSupplier;
    }

    public void showAllSuppliers() {
        if (this.listSupplier.isEmpty()) {
            System.out.println("No hay proveedores creados: ");
            return;
        }

        for (Supplier supplier : this.listSupplier) {
            System.out.println(
                    "--- Nit: " + supplier.nit + ", Nombre: " + supplier.name + ", Telefono: " + supplier.cellPhone
                            + " ---");
        }
    }

    public void autoCreateSuppliers() {
        Supplier minSupplier = new Supplier();
        minSupplier.setSuppliers(999, "Minorista Dulces", "3002004455");
        this.listSupplier.add(minSupplier);
        Supplier maxSupplier = new Supplier();
        maxSupplier.setSuppliers(888, "Mayorista de Dulces y Gaseosas", "3002004455");
        this.listSupplier.add(maxSupplier);
        System.out.println("Se crearon los proveedores Minoristas ( 999 ) y Mayoristas ( 888 )");
    }
}
