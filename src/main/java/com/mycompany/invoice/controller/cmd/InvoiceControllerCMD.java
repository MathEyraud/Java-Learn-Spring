package com.mycompany.invoice.controller.cmd;

import com.mycompany.invoice.controller.IInvoiceController;
import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
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
    @Override
    public void createInvoice(){
        System.out.println( "What is the customer name ?" );
        Scanner scanner = new Scanner(System.in);

        String customerName = scanner.nextLine();
        Invoice newInvoice = new Invoice();

        newInvoice.setCustomerName(customerName);

        invoiceService.create(newInvoice);
    }

    /* PAS FORCEMENT LA MEILLEUR MANIERE QUAND ON RETOURNE QU'UNE SEULE VALEUR */
    @RequestMapping("/invoice-list-invoice")
    public String displayListInvoice(Model model){
        System.out.println(" ----- displayListInvoice ----- ");

        // Récupérer les données depuis le service
        List<Invoice> listInvoice = invoiceService.getListInvoice();

        // Envoyer les données vers le fichier html
        model.addAttribute("invoices",listInvoice);

        return "list-invoice";
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