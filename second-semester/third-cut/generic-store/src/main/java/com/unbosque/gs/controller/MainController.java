package com.unbosque.gs.controller;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.unbosque.gs.model.MainData;
import com.unbosque.gs.model.ProductModel;
import com.unbosque.gs.model.SellModel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;

public class MainController {

    private static final String DB_PATH = "/data.json";
    private static final Type mainDataType = MainData.class;
    private MainData mainData;
    private ProductController productController;
    private SellController sellController;
    private SellProductController sellProductController;

    public MainController() {
        this.loadMainData();

        String productDbPath = this.mainData.getProductDbPath();
        String sellDbPath = this.mainData.getSellDbPath();
        String sellProductDbPath = this.mainData.getSellProductDbPath();
        double VAT = this.mainData.getVAT();

        this.productController = new ProductController(productDbPath);
        this.sellController = new SellController(sellDbPath, VAT);

        ArrayList<SellModel> sellModels = sellController.requestModels();
        ArrayList<ProductModel> productModels = productController.requestModels();
        this.sellProductController = new SellProductController(sellProductDbPath, sellModels, productModels);

        this.sellProductController.calculateTotal();
        this.sellController.calculateConsolidation();
    }

    private void loadMainData() {
        try {
            URL fileURL = this.getClass().getResource(DB_PATH);
            String finalPath = fileURL.getPath();
            Gson gson = new Gson();
            FileReader fileReader = new FileReader(finalPath);
            JsonReader jsonReader = new JsonReader(fileReader);
            this.mainData = gson.fromJson(jsonReader, mainDataType);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
