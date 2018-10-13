package com.unbosque.gs.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.unbosque.gs.model.SellModel;
import com.unbosque.gs.view.SellView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;

public class SellController {

    private static final Type modelType = new TypeToken<ArrayList<SellModel>>() {
    }.getType();
    private final double VAT;
    private String registry;
    private SellView view;
    private ArrayList<SellModel> models;
    private String dbPath;
    private double totalSells;
    private double totalVATSells;
    private double total;


    public SellController(String dbPath, double VAT) {
        this.dbPath = dbPath;
        this.VAT = VAT;
        this.totalSells = 0;
        this.totalVATSells = 0;
        this.total = 0;
        this.loadModels();
        this.view = new SellView();
    }

    public void calculateConsolidation() {
        for (SellModel sell : this.models) {
            this.totalSells += sell.getTotal();
        }
        this.totalVATSells = (this.totalSells * this.VAT);
        this.total = (this.totalSells + this.totalVATSells);

        this.registry = "";
        this.registry += "total sells: " + this.totalSells + "\n";
        this.registry += "total VAT: " + this.totalVATSells + "\n";
        this.registry += "total sells with VAT: " + this.total + "\n";

        this.view.show(this.registry);
    }

    private void loadModels() {
        try {
            URL fileURL = this.getClass().getResource(this.dbPath);
            String finalPath = fileURL.getPath();
            Gson gson = new Gson();
            FileReader fileReader = new FileReader(finalPath);
            JsonReader jsonReader = new JsonReader(fileReader);
            this.models = gson.fromJson(jsonReader, modelType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    ArrayList<SellModel> requestModels() {
        return this.models;
    }
}
