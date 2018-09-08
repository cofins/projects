package com.unbosque.interfaces.controller;

import com.unbosque.interfaces.model.CircleModel;
import com.unbosque.interfaces.model.RectangleModel;
import com.unbosque.interfaces.view.ShapeView;
import java.util.ArrayList;

public class ShapeController {

  // components
  private ShapeView view;

  private ArrayList<RectangleModel> rectangles;
  private ArrayList<CircleModel> circles;

  public ShapeController() {
    this.rectangles = new ArrayList<RectangleModel>();
    this.circles = new ArrayList<CircleModel>();

    this.view = new ShapeView();

    do {
      this.menu();
    } while (!this.exit());
  }

  private void menu() {
    this.view.show("menu\n");
    this.view.show("1: rectangle\n");
    this.view.show("2: circle\n");

    String option = this.view.read("option: ");
    switch (option) {
      case "1":
        this.rectangleMenu();
        break;
      case "2":
        this.circleMenu();
        break;
    }
  }

  private void circleMenu() {
    this.view.show("circle menu\n");
    this.view.show("1: add\n");
    this.view.show("2: delete\n");
    this.view.show("3: show\n");

    String option = this.view.read("option: ");
    CircleModel circle;

    switch (option) {
      case "1":
        {
          String input;
          while (!(input = this.view.readCircle()).matches("\\d+")) ;

          int radio = Integer.parseInt(input);

          circle = new CircleModel(radio);
          this.circles.add(circle);
          break;
        }
      case "2":
        {
          for (CircleModel c : this.circles) {
            this.view.show(this.circles.indexOf(c) + ": ");
            this.view.showCircle(c);
          }

          while (!(option = this.view.read("circle id: ")).matches("\\d+")) ;
          int id = Integer.parseInt(option);
          this.circles.remove(id);
        }
        break;
      case "3":
        {
          for (CircleModel c : this.circles) {
            this.view.show(this.circles.indexOf(c) + ": ");
            this.view.showCircle(c);
          }
        }
        break;
      default:
        this.view.show("wrong entry!\n");
        break;
    }
  }

  private void rectangleMenu() {
    this.view.show("rectangle menu\n");
    this.view.show("1: add\n");
    this.view.show("2: delete\n");
    this.view.show("3: show\n");

    String option = this.view.read("option: ");
    RectangleModel rectangle;

    switch (option) {
      case "1":
        {
          String[] inputs;
          while (!(inputs = this.view.readRectangle())[0].matches("\\d+")
              || !inputs[1].matches("\\d+")) ;

          int width = Integer.parseInt(inputs[0]);
          int height = Integer.parseInt(inputs[1]);

          rectangle = new RectangleModel(width, height);
          this.rectangles.add(rectangle);
          break;
        }
      case "2":
        {
          for (RectangleModel r : this.rectangles) {
            this.view.show(this.rectangles.indexOf(r) + ": ");
            this.view.showRectangle(r);
          }

          while (!(option = this.view.read("rectangle id: ")).matches("\\d+")) ;
          int id = Integer.parseInt(option);
          this.rectangles.remove(id);
        }
        break;
      case "3":
        {
          for (RectangleModel r : this.rectangles) {
            this.view.show(this.rectangles.indexOf(r) + ": ");
            this.view.showRectangle(r);
          }
        }
        break;
      default:
        this.view.show("wrong entry!\n");
        break;
    }
  }

  private boolean exit() {
    String option = this.view.read("Do you want to exit of the application? (Y/N): ");
    return option.equalsIgnoreCase("Y");
  }
}
