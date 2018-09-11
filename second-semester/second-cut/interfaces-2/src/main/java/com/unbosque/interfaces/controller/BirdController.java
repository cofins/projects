package com.unbosque.interfaces.controller;

import com.unbosque.interfaces.model.Bird;
import com.unbosque.interfaces.view.BirdView;
import java.util.ArrayList;

public class BirdController {

  private BirdView view;
  private ArrayList<Bird> model;

  public BirdController() {
    this.model = new ArrayList<Bird>();
    this.view = new BirdView();
  }

  public void init() {
    boolean _continue = true;
    do {
      this.view.showMenu();
      String option = this.view.read("option: ");
      switch (option) {
        case "1":
          this.addBird();
          break;
        case "2":
          this.removeBird();
          break;
        case "3":
          this.showBirds();
          break;
        case "4":
          this.updateBird();
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

  private void addBird() {
    String input = this.view.readBird();
    Bird bird = new Bird(input);
    this.model.add(bird);
    this.view.show("Added: " + bird.getName() + "\n");
  }

  private void removeBird() {
    this.showBirds();
    String input = this.view.read("id: ");
    int id = Integer.parseInt(input);
    this.model.remove(id);
  }

  private void showBirds() {
    for (Bird bird : this.model) {
      this.view.show(this.model.indexOf(bird) + ": Bird >> \n");
      this.view.show("name: " + bird.getName() + "\n");
    }
  }

  private void updateBird() {
    this.showBirds();
    String input = this.view.read("id: ");
    int id = Integer.parseInt(input);
    input = this.view.readBird();
    Bird bird = new Bird(input);
    this.model.set(id, bird);
    this.view.show("updated: " + bird.getName() + "\n");
  }

  private void makeAction() {
    this.showBirds();
    String input = this.view.read("id: ");
    int id = Integer.parseInt(input);

    this.view.show("1: take off\n");
    this.view.show("2: land\n");
    this.view.show("3: fly\n");
    this.view.show("4: eat\n");

    input = this.view.read("action: ");

    Bird bird = this.model.get(id);
    switch (input) {
      case "1":
        bird.takeOff();
        break;
      case "2":
        bird.land();
        break;
      case "3":
        bird.fly();
        break;
      case "4":
        bird.eat();
        break;
    }
  }
}
