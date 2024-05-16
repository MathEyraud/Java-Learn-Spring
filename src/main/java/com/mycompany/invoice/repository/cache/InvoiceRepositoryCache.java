package com.mycompany.invoice.repository.cache;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepositoryCache implements IInvoiceRepository {

    /**
     * ATTRIBUTS
     */
    private static List<Invoice> invoices = new ArrayList<>();

    /**
     * METHODS
     */
    public void create(Invoice invoice){
        this.invoices.add(invoice);
        System.out.println("Cache : Invoice added with number " + invoice.getNumber() + " for " + invoice.getCustomerName() + ".");
    }

    /**
     * GETTERS/SETTERS
     */
    public static List<Invoice> getInvoices() {
        return invoices;
    }

    public static void setInvoices(List<Invoice> invoices) {
        InvoiceRepositoryCache.invoices = invoices;
    }
}
