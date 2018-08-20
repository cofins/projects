package com.unbosque.settlement.view;

import java.util.Scanner;

public class RosterView {

  private static final Scanner scanner = new Scanner(System.in);

  public void show(String output) {
    System.out.println(output);
  }

  public String request(String indication) {
      System.out.print(indication);
      return scanner.nextLine();
  }
}
