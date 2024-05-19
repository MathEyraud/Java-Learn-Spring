package com.mycompany.invoice.controller.cmd;

import com.mycompany.invoice.controller.IInvoiceController;
import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

//@Controller
public class InvoiceControllerCMD implements IInvoiceController {

    /**
     * ATTRIBUTS
     */
    @Autowired
    private IInvoiceService invoiceService;

    /**
     * METHODS
     */
    public void createInvoice(){
        System.out.println( "What is the customer name ?" );
        Scanner scanner = new Scanner(System.in);

        String customerName = scanner.nextLine();
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