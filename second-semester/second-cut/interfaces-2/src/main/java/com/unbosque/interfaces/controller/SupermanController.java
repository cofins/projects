package com.unbosque.interfaces.controller;

import com.unbosque.interfaces.model.Superman;
import com.unbosque.interfaces.view.SupermanView;
import java.util.ArrayList;

public class SupermanController {

  private SupermanView view;
  private ArrayList<Superman> model;

  public SupermanController() {
    this.model = new ArrayList<Superman>();
    this.view = new SupermanView();
  }

  public void init() {
    boolean _continue = true;
    do {
      this.view.showMenu();
      String option = this.view.read("option: ");
      switch (option) {
        case "1":
          this.addSuperman();
          break;
        case "2":
          this.removeSuperman();
          break;
        case "3":
          this.showSupermans();
          break;
        case "4":
          this.updateSuperman();
          break;
        case "5":
          this.makeAction();
          break;
        case "6":
          _continue = false;
          break;
      }
    } while (_continue);
  }

  private void addSuperman() {
    String input = this.view.readSuperman();
    Superman superman = new Superman(input);
    this.model.add(superman);
    this.view.show("Added: " + superman.getName() + "\n");
  }

  private void removeSuperman() {
    this.showSupermans();
    String input = this.view.read("id: ");
    int id = Integer.parseInt(input);
    this.model.remove(id);
  }

  private void showSupermans() {
    for (Superman superman : this.model) {
      this.view.show(this.model.indexOf(superman) + ": Superman >> \n");
      this.view.show("name: " + superman.getName() + "\n");
    }
  }

  private void updateSuperman() {
    this.showSupermans();
    String input = this.view.read("id: ");
    int id = Integer.parseInt(input);
    input = this.view.readSuperman();
    Superman superman = new Superman(input);
    this.model.set(id, superman);
    this.view.show("updated: " + superman.getName() + "\n");
  }

  private void makeAction() {
    this.showSupermans();
    String input = this.view.read("id: ");
    int id = Integer.parseInt(input);

    this.view.show("1: take off\n");
    this.view.show("2: land\n");
    this.view.show("3: fly\n");
    this.view.show("4: eat\n");
    this.view.show("5: leap building\n");
    this.view.show("6: stop bullet\n");

    input = this.view.read("action: ");

    Superman superman = this.model.get(id);
    switch (input) {
      case "1":
        superman.takeOff();
        break;
      case "2":
        superman.land();
        break;
      case "3":
        superman.fly();
        break;
      case "4":
        superman.eat();
        break;
      case "5":
        superman.leapBuilding();
        break;
      case "6":
        superman.stopBullet();
        break;
    }
  }
}
