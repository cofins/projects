package com.unbosque.interfaces.model;

public class Bird extends Animal implements Flyer {

  public void takeOff() {
    System.out.println("bird: take off");
  }

  public void land() {
    System.out.println("bird: land");
  }

  public void fly() {
    System.out.println("bird: fly");
  }

  public void eat() {
    System.out.println("bird: eat");
  }
}
