package com.unbosque.interfaces.model;

public class Bird extends Animal implements Flyer {

  private String name;

  public Bird(String name) {
    this.name = name;
  }

  public void takeOff() {
    System.out.println(">> Hey i am " + name + " the bird and i am going to: take off");
  }

  public void land() {
    System.out.println(">> Hey i am " + name + " the bird and i am going to: land");
  }

  public void fly() {
    System.out.println(">> Hey i am " + name + " the bird and i am going to: fly");
  }

  public void eat() {
    System.out.println(">> Hey i am " + name + " the bird and i am going to: eat");
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
