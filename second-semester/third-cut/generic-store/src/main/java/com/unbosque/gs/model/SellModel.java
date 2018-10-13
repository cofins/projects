package com.unbosque.gs.model;

public class SellModel {
    private int id;
    private double total = 0;

    public SellModel(int id, double total) {
        this.id = id;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
