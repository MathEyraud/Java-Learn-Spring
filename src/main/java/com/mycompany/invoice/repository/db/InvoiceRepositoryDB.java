package com.mycompany.invoice.repository.db;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

//@Repository
public class InvoiceRepositoryDB implements IInvoiceRepository {

    /**
     * ATTRIBUTS
     */
    private static List<Invoice> invoices = new ArrayList<>();

    /**
     * METHODS
     */
    public void create(Invoice invoice){
        this.invoices.add(invoice);
        System.out.println("DB : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName() + ".");
    }

    public List<Invoice> getListInvoice(){

        // On crée des données fictives, car on a pas encore de DB
        Invoice invoice1 = new Invoice();
        invoice1.setNumber("1");
        invoice1.setCustomerName("Customer1");

        Invoice invoice2 = new Invoice();
        invoice2.setNumber("2");
        invoice2.setCustomerName("Customer2");

        // On les ajoutes à une liste qu'on va renvoyer
        List<Invoice> listInvoice = new ArrayList<>();
        listInvoice.add(invoice1);
        listInvoice.add(invoice2);

        // On retourne les données
        return listInvoice;
    }

    /**
     * GETTERS/SETTERS
     */
    public static List<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(List<Invoice> invoices) {
        InvoiceRepositoryDB.invoices = invoices;
    }
}
