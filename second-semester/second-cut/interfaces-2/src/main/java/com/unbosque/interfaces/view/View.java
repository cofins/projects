package com.unbosque.interfaces.view;

import java.util.Scanner;

public abstract class View {

  private static final Scanner scanner = new Scanner(System.in);

  public void show(String text) {
    System.out.print(text);
  }

  public String read(String indication) {
    this.show(indication);

    return scanner.nextLine();
  }

  public boolean exit() {
    String letter = this.read("do you want to return to the main menu? (Y/N): ");
    return letter.equalsIgnoreCase("y");
  }

  public void showMenu() {
    this.show("1: add\n");
    this.show("2: remove\n");
    this.show("3: show\n");
    this.show("4: update\n");
    this.show("5: make action\n");
    this.show("6: return\n");
  }
}
