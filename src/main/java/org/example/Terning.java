package org.example;

import java.util.Random;

public class Terning {

  private Random rand = new Random();

  private int storrelse;

  public Terning(int storrelse) {
    this.storrelse = storrelse;
  }

  public int rull() {
    return rand.nextInt(storrelse) + 1;
  }

}
