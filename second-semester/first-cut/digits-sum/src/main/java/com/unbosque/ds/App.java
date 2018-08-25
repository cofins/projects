package com.unbosque.ds;

import java.util.Scanner;

public class App {

  private static Scanner scanner = new Scanner(System.in);

  // get from terminal
  private static String g(String i) {
    s(i);
    return scanner.nextLine();
  }

  // show in terminal
  private static void s(Object t) {
    System.out.print(t);

  }

  private static int sum(int n) {
    return (n = (n == 0 ? 0 : n % 10 + sum(n / 10))) > 9 ? sum(n) : n;
  }

  public static void main(String[] args) {
    s(sum(Integer.parseInt(g("number: "))));
  }


}
