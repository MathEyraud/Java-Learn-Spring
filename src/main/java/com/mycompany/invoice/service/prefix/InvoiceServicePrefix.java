package com.mycompany.invoice.service.prefix;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;
import com.mycompany.invoice.service.IInvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServicePrefix implements IInvoiceService {

    /**
     * ATTRIBUTS
     */
    @Value("${invoice.lastNumber}")
    private long lastNumber;

    @Value("${invoice.prefix}")
    private String prefix;

    @Autowired
    private IInvoiceRepository invoiceRepository;

    /**
     * METHODS
     */
    public void create(Invoice invoice){
        invoice.setNumber(String.valueOf(prefix + ++this.lastNumber));
        invoiceRepository.create(invoice);
    }
    /**
     * GETTERS/SETTERS
     */
    public long getLastNumber() {
        return this.lastNumber;
    }

    public void setLastNumber(long lastNumber) {
        this.lastNumber = lastNumber;
    }

    public IInvoiceRepository getInvoiceRepository() {
        return this.invoiceRepository;
    }

    public void setInvoiceRepository(IInvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}