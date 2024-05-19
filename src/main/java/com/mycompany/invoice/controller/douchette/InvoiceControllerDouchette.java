package com.mycompany.invoice.controller.douchette;

import com.mycompany.invoice.controller.IInvoiceController;
import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//@Controller
public class InvoiceControllerDouchette implements IInvoiceController {

    /**
     * ATTRIBUTS
     */
    @Autowired
    private IInvoiceService invoiceService;

    /**
     * METHODS
     */
    public void createInvoice(){
        // On imagine que le nom a été saisi via une douchette
        String customerName = "Math";

        Invoice newInvoice = new Invoice();
        newInvoice.setCustomerName(customerName);

        invoiceService.create(newInvoice);
    }

    /**
     * GETTERS/SETTERS
     */
    public IInvoiceService getInvoiceService() {
        return invoiceService;
    }

    public void setInvoiceService(IInvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }
}