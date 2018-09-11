package com.unbosque.interfaces.controller;

import com.unbosque.interfaces.view.MainView;

public class MainController {

  private BirdController birdController;
  private SupermanController supermanController;
  private MainView view;

  public MainController() {
    this.birdController = new BirdController();
    this.supermanController = new SupermanController();
    this.view = new MainView();

    boolean _continue = true;
    do {
      this.view.showMenu();
      String option = this.view.read("option: ");
      switch (option) {
        case "1":
          this.birdController.init();
          break;
        case "2":
          this.supermanController.init();
          break;
        case "3":
          _continue = false;
          break;
      }
    } while (_continue);
  }
}
