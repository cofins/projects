package com.unbosque.grasp.controller;

import java.awt.BorderLayout;

import com.unbosque.grasp.view.MainView;

public class MainController {

    private MainView view;
    private PlayerController playerController;

    public MainController() {
        this.view = new MainView();
        this.view.add(this.playerController.getView(), BorderLayout.CENTER);
        this.view.setVisible(true);
    }
}