package com.mycompany.invoice.controller.frontend;

import com.mycompany.invoice.controller.IInvoiceController;
import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.service.IInvoiceService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class InvoiceControllerFrontend implements IInvoiceController {

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

        // On imagine que le nom a été rempli dans un formulaire en front
        String customerName = "Math By Controller FrontEnd";

        Invoice newInvoice = new Invoice();
        newInvoice.setCustomerName(customerName);

        invoiceService.create(newInvoice);
    }

    @RequestMapping("/home")
    public String displayHome(){
        System.out.println(" ----- displayHome ----- ");
        return "index";
    }

    @RequestMapping("/invoice-local-country")
    public String displayLocalCountry(){
        System.out.println(" ----- displayLocalCountry ----- ");
        return "local-country";
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