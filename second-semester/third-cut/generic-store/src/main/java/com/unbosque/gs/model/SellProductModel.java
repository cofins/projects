package com.unbosque.gs.model;

public class SellProductModel {
    private int id;
    private SellModel sell;
    private ProductModel model;
    private double amount;

    public SellProductModel(int id, SellModel sell, ProductModel model, double amount) {
        this.id = id;
        this.sell = sell;
        this.model = model;
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public SellModel getSell() {
        return sell;
    }

    public ProductModel getProduct() {
        return model;
    }

    public double getAmount() {
        return amount;
    }
}
