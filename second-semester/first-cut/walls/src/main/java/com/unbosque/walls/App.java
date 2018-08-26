package com.unbosque.walls;

import java.util.Scanner;

public class App {

  private static Scanner scanner = new Scanner(System.in);

  // Get from terminal
  private static String g(String i) {
    s(i);
    return scanner.nextLine();
  }

  // show in terminal
  private static void s(String t) {
    System.out.print(t);
  }

  public static void main(String[] args) {

    // input validation
    String i;
    while (!(i = g("document: ")).matches("^\\d{0,10}$")) continue;

    String[] w = new String[10];

    // wall building
    for (int j = 0; j < i.length(); j++) {
      int c = Character.getNumericValue(i.charAt(j));
      w[j] = "";
      for (int k = 0; k < 10; k++) w[j] += k < c ? "-" : "*";
      s(w[j] + "\n");
    }

  }

}
