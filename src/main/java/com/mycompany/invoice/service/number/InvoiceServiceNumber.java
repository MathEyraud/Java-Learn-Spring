package com.mycompany.invoice.service.number;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;
import com.mycompany.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceNumber implements IInvoiceService {

    /**
     * ATTRIBUTS
     */
    private static long lastNumber=0L;

    @Autowired
    private IInvoiceRepository invoiceRepository;

    /**
     * METHODS
     */
    public void create(Invoice invoice){
        invoice.setNumber(String.valueOf(++this.lastNumber));
        invoiceRepository.create(invoice);
    }
    /**
     * GETTERS/SETTERS
     */
    public static long getLastNumber() {
        return lastNumber;
    }

    public static void setLastNumber(long lastNumber) {
        InvoiceServiceNumber.lastNumber = lastNumber;
    }

    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}