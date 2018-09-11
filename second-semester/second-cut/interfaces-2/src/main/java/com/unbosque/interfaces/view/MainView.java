package com.unbosque.interfaces.view;

public class MainView extends View {

  @Override
  public void showMenu() {
    super.show("1: bird menu\n");
    super.show("2: superman\n");
    super.show("3: exit\n");
  }

  @Override
  public boolean exit() {
    String letter = this.read("do you want to exit? (Y/N): ");
    return letter.equalsIgnoreCase("y");
  }
}
