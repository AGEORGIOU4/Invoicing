package com.company;


import java.util.Vector;

public class Invoice {

    // Private class members
    private int number;
    private long dateCreated;
    private Vector<Item> items;
    private float totalAmount;

    // Public class members
    public Invoice(int number, long dateCreated, Vector<Item> items) {
        this.number = number;
        this.dateCreated = dateCreated;
        this.items = items;

        // Auto-calculated (Sum of item amounts)
        calculateTotalAmount(items);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Vector<Item> getItems() {
        return items;
    }

    public void setItems(Vector<Item> items) {
        this.items = items;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void calculateTotalAmount(Vector<Item> items) {
        // Auto-calculated (Sum of item amounts)
        if (this.items == items) { // Check if new items are added on
            this.totalAmount = 0;
            for (Item item : items) {
                this.totalAmount += item.getAmount();
            }
        } else {
            for (Item item : items) {
                this.totalAmount += item.getAmount();
            }
        }
    }
}
