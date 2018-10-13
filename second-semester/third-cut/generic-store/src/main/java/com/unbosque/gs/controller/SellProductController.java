package com.unbosque.gs.controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.unbosque.gs.model.ProductModel;
import com.unbosque.gs.model.SellModel;
import com.unbosque.gs.model.SellProductModel;
import com.unbosque.gs.view.SellProductView;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;

public class SellProductController {

    private static final Type modelType = new TypeToken<ArrayList<SellProductModel>>() {
    }.getType();

    private ArrayList<SellProductModel> models;
    private SellProductView view;
    private String dbPath;
    private ArrayList<SellModel> sellModels;
    private ArrayList<ProductModel> productModels;
    private String registry;

    public SellProductController(String dbPath, ArrayList<SellModel> sellModels, ArrayList<ProductModel> productModels) {
        this.dbPath = dbPath;
        this.sellModels = sellModels;
        this.productModels = productModels;
        this.loadModels();
        this.view = new SellProductView();
    }

    public void calculateTotal() {
        this.registry = "";

        for (SellModel sell : this.sellModels) {
            this.registry += "sell #" + sell.getId() + " \n";
            ArrayList<SellProductModel> relations = this.requestRelations(sell.getId());
            for (SellProductModel relation : relations) {
                ProductModel product = relation.getProduct();

                double price = product.getPrice();
                double amount = relation.getAmount();
                double total = (price * amount) + sell.getTotal();
                sell.setTotal(total);

                this.registry += "-> " + product.getName() + " x " + amount + " : " + total + "\n";
            }
            this.registry += "total: " + sell.getTotal() + "\n";
        }
        this.view.show(this.registry);
    }

    private ArrayList<SellProductModel> requestRelations(int sellId) {
        ArrayList<SellProductModel> relations = new ArrayList<>();
        for (SellProductModel sellProduct : this.models) {
            if (sellProduct.getSell().getId() == sellId) {
                relations.add(sellProduct);
            }
        }
        return relations;
    }


    private void loadModels() {
        try {
            URL fileURL = this.getClass().getResource(this.dbPath);
            String finalPath = fileURL.getPath();

            FileReader fileReader = new FileReader(finalPath);

            JsonParser jsonParser = new JsonParser();
            JsonElement jsonElement = jsonParser.parse(fileReader);

            JsonArray jsonArray = jsonElement.getAsJsonArray();
            this.models = new ArrayList<SellProductModel>();

            jsonArray.forEach(je -> {
                JsonObject jsonObject = je.getAsJsonObject();

                int id = jsonObject.get("id").getAsInt();
                int sellId = jsonObject.get("sellId").getAsInt();
                int productId = jsonObject.get("productId").getAsInt();
                double amount = jsonObject.get("amount").getAsDouble();

                SellModel sell = this.requestSell(sellId);
                ProductModel product = this.requestProduct(productId);
                SellProductModel sellProduct = new SellProductModel(id, sell, product, amount);

                this.models.add(sellProduct);
            });


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private SellModel requestSell(int id) {
        for (SellModel sell : this.sellModels) {
            if (sell.getId() == id) {
                return sell;
            }
        }
        return null;
    }

    private ProductModel requestProduct(int id) {
        for (ProductModel product : this.productModels) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
