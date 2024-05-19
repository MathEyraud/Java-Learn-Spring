package com.mycompany.invoice.repository;

import com.mycompany.invoice.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

public interface IInvoiceRepository {

    void create(Invoice invoice);
    List<Invoice> getListInvoice();
}
