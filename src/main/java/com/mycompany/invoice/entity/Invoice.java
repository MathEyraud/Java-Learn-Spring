package com.mycompany.invoice.entity;

public class Invoice {

    /**
     * ATTRIBUTS
     */
    private String number;
    private String customerName;

    /**
     * GETTERS/SETTERS
     */
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
