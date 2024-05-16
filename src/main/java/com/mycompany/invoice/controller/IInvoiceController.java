package com.mycompany.invoice.controller;

import com.mycompany.invoice.service.IInvoiceService;

public interface IInvoiceController {

    void createInvoice();
    void setInvoiceService(IInvoiceService invoiceService);
}