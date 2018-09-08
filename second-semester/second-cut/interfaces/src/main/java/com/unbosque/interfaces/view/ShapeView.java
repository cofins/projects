package com.unbosque.interfaces.view;

import com.unbosque.interfaces.model.CircleModel;
import com.unbosque.interfaces.model.RectangleModel;
import java.util.Scanner;

public class ShapeView {

  private static final Scanner scanner = new Scanner(System.in);

  public void show(String text) {
    System.out.print(text);
  }

  public String read(String indication) {
    this.show(indication);
    return scanner.nextLine();
  }

  public String readCircle() {
    String radio = this.read("radio: ");
    return radio;
  }

  public String[] readRectangle() {
    String width = this.read("width: ");
    String height = this.read("height: ");

    return new String[] {width, height};
  }

  public void showRectangle(RectangleModel rectangle) {
    this.show("rectangle: \n");
    this.show(" >> width: " + rectangle.getWidth() + "\n");
    this.show(" >> height: " + rectangle.getHeight() + "\n");
    this.show(" >> area: " + rectangle.getArea() + "\n");
    this.show(" >> periemeter: " + rectangle.getPerimeter() + "\n");
  }

  public void showCircle(CircleModel circle) {
    this.show("circle: \n");
    this.show(" >> radio: " + circle.getRadio() + "\n");
    this.show(" >> area: " + circle.getArea() + "\n");
    this.show(" >> periemeter: " + circle.getPerimeter() + "\n");
  }
}
