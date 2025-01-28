package org.example;

import java.util.Random;

public class Terning {

  private final Random rand;


  public Terning() {
    this.rand = new Random();
  }

  /**
   *
   * @return
   */
  public int trill() {
    return rand.nextInt(6) + 1;
  }

}
