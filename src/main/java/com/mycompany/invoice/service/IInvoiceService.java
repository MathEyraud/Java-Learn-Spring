package com.mycompany.invoice.service;

import com.mycompany.invoice.entity.Invoice;
import com.mycompany.invoice.repository.IInvoiceRepository;

import java.util.List;

public interface IInvoiceService{

    void create(Invoice invoice);
    void setInvoiceRepository(IInvoiceRepository invoiceRepository);
    List<Invoice> getListInvoice();
}
