package org.example;

import java.util.Random;

public class Terning {

  private final Random rand;

  public Terning() {
    this.rand = new Random();
  }

  /**
   * Triller terningen
   * @return terningens verdi
   */
  public int trill() {
    return rand.nextInt(6) + 1;
  }

}
