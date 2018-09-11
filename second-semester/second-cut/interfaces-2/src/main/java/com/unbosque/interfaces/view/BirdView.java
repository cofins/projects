package com.unbosque.interfaces.view;

public class BirdView extends View {

  public String readBird() {
    String name = super.read("name: ");
    return name;
  }
}
