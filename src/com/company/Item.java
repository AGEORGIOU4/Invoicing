package com.company;

public class Item {

    // Private class members
    private Service service;
    private int quantity;
    private float amount;

    public void setAmount(float amount) {
        this.amount = amount;
    }

    // Public class members
    public Item(Service service, int quantity) {
        this.service = service;
        this.quantity = quantity;

        // Auto-calculated (com.company.Service price * quantity)
        calculateAmount(service);
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getAmount() {
        return amount;
    }

    public void calculateAmount(Service service) {
        // Auto-calculated (com.company.Service price * quantity)
        this.amount = service.getPrice() * quantity;
    }
}
