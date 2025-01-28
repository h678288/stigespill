package org.example;

import java.util.Scanner;

public class Main {
  static Scanner s = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.print("Hvor mange spillere: ");
    int spillere = s.nextInt();
    s.close();
    Stigespill spill = new Stigespill(spillere);
    spill.startSpill();
  }
}