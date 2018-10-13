package com.unbosque.gs.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.unbosque.gs.model.ProductModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;

public class ProductController {

    private static final Type modelType = new TypeToken<ArrayList<ProductModel>>() {
    }.getType();

    private ArrayList<ProductModel> models;
    private String dbPath;

    public ProductController(String dbPath) {
        this.dbPath = dbPath;
        this.loadModels();
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

    ArrayList<ProductModel> requestModels() {
        return this.models;
    }
}
