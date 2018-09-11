package com.unbosque.interfaces.view;

public class SupermanView extends View {

  public String readSuperman() {
    String name = super.read("name: ");
    return name;
  }
}
