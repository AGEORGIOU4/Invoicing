package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class Account {

    // Private class members
    private int number;
    private Customer customer;
    private float balance = 0;
    private Vector<Service> services;
    private Vector<Invoice> invoices;

    // Public class members

    // Constructor 1 (Simple account without services and invoices => can be set later)
    public Account(int number, Customer customer) {
        this.number = number;
        this.customer = customer;
    }

    // Constructor 2 (Full account with all necessary information from construction)
    public Account(int number, Customer customer, Vector<Service> services, Vector<Invoice> invoices) {
        this.number = number;
        this.customer = customer;
        this.services = services;
        this.invoices = invoices;

        // Auto calculate balance (Sum of all the customer's invoice total amounts)
        calculateBalance(invoices);
    }

    // Getters & Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public Vector<Service> getServices() {
        return services;
    }

    public void setServices(Vector<Service> services) {
        this.services = services;
    }

    public Vector<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Vector<Invoice> invoices) {
        this.invoices = invoices;
        calculateBalance(invoices);
    }

    // Functions
    public void calculateBalance(Vector<Invoice> invoices) {
        // Auto calculate Account balance (Sum of all the customer's invoice total amounts)
        if (this.invoices == invoices) { // Check if new invoices are added on the account
            this.balance = 0;
            for (Invoice invoice : invoices) {
                this.balance += invoice.getTotalAmount();  // Top up current invoice vector
            }
        } else { // Sum up new invoices with old
            for (Invoice invoice : invoices) {
                this.invoices.addAll(invoices); // Merge old invoices with new to keep track of current balance
                this.balance += invoice.getTotalAmount();
            }
        }
    }

    public void clearBalance() {
        this.invoices.clear();
        this.balance = 0;
    }

    // Extra Points
    public boolean generateCustomerInvoice() {
        // Customer Info
        String name = getCustomer().getFirstName() + " " + getCustomer().getMiddleName() + " " + getCustomer().getLastName();
        String address = getCustomer().getAddress();
        String phone = getCustomer().getPhone();

        StringBuilder invoice = new StringBuilder();
        invoice.append("\n\n==========================================\nName: ").append(name).append("\nAddress: ").append(address).append("\nPhone: ").append(phone).append("\nServices: \n");

        // Convert Current Milliseconds to Readable date
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");

        // Append services and items info
        Vector<Service> services = new Vector<>(getServices());

        for (int i = 0; i < getInvoices().size(); i++) {
            for (int j = 0; j < getInvoices().get(i).getItems().size(); j++) {
                Date dateCreated = new Date(getInvoices().get(i).getDateCreated());
                invoice.append(sdf.format(dateCreated)).append(" | ");
                invoice.append(getInvoices().get(i).getItems().get(j).getService().getName()).append(" | ");
                invoice.append(getInvoices().get(i).getItems().get(j).getService().getDescription()).append(" | ");
                invoice.append("x ").append(getInvoices().get(i).getItems().get(j).getQuantity()).append(" | ");
                invoice.append(getInvoices().get(i).getItems().get(j).getService().getPrice()).append("\n");
            }
        }

        invoice.append("Balance: £").append(getBalance());
        invoice.append("\n").append("Invoice: #");

        for (int k = 0; k < getInvoices().size(); k++) {
            invoice.append(getInvoices().get(k).getNumber());
            if(getInvoices().size() > 1 && k < getInvoices().size() - 1)
            {
                invoice.append(" , #");
            }
        }
        System.out.println(invoice);
        return true;
    }
}
