package com.unbosque.interfaces.model;

public class RectangleModel implements ShapeModel {

  private double width;
  private double height;

  public RectangleModel(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double getArea() {
    return this.width * this.height;
  }

  public double getPerimeter() {
    return this.width * 2 + this.height * 2;
  }

  public double getWidth() {
    return this.width;
  }

  public double getHeight() {
    return this.height;
  }
}
