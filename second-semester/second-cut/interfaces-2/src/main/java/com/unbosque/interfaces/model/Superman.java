package com.unbosque.interfaces.model;

public class Superman extends Kryptonian implements Flyer {

  public void takeOff() {
    System.out.println("superman: take off");
  }

  public void land() {
    System.out.println("superman: land");
  }

  public void fly() {
    System.out.println("superman: fly");
  }

  public void leapBuilding() {}

  public void stopBullet() {}
}
