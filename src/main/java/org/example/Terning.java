package org.example;

import java.util.Random;

public class Terning {

  private final Random rand = new Random();

  private final int storrelse;

  public Terning(int storrelse) {
    this.storrelse = storrelse;
  }

  /**
   *
   * @return
   */
  public int trill() {
    return rand.nextInt(storrelse) + 1;
  }

}
