package com.unbosque.interfaces.model;

public class CircleModel implements ShapeModel {

  private double radio;

  public CircleModel(double radio) {
    this.radio = radio;
  }

  public double getArea() {
    return Math.pow(this.radio, 2) * Math.PI;
  }

  public double getPerimeter() {
    return this.radio * 2 * Math.PI;
  }

  public double getRadio() {
    return this.radio;
  }
}
