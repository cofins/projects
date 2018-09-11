package com.unbosque.interfaces.model;

public class Superman extends Kryptonian implements Flyer {

  private String name;

  public Superman(String name) {
    this.name = name;
  }

  public void takeOff() {
    System.out.println(
        ">> Hey i am " + this.name + " the clone of superman and i'm going to: take off");
  }

  public void land() {
    System.out.println(
        ">> Hey i am " + this.name + " the clone of superman and i'm going to: land");
  }

  public void fly() {
    System.out.println(">> Hey i am " + this.name + " the clone of superman and i'm going to: fly");
  }

  public void leapBuilding() {
    System.out.println(
        ">> Hey i am " + this.name + " the clone of superman and i'm going to: leap building");
  }

  public void stopBullet() {
    System.out.println(
        ">> Hey i am " + this.name + " the clone of superman and i'm going to: stop buller");
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
