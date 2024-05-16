package com.mycompany.invoice.service.prefixinv;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;
import com.mycompany.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServicePrefixINV implements IInvoiceService {

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
        invoice.setNumber(String.valueOf("INV_" + ++this.lastNumber));
        invoiceRepository.create(invoice);
    }
    /**
     * GETTERS/SETTERS
     */
    public static long getLastNumber() {
        return lastNumber;
    }

    public static void setLastNumber(long lastNumber) {
        InvoiceServicePrefixINV.lastNumber = lastNumber;
    }

    public IInvoiceRepository getInvoiceRepository() {
        return invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }
}