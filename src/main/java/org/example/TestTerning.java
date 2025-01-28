package org.example;

import java.util.Queue;
import java.util.LinkedList;

public class TestTerning extends Terning{
  private final Queue<Integer> testTrill = new LinkedList<>();

  public void leggTilTrill(int trill) {
    testTrill.add(trill);
  }

  @Override
  public int trill() {
    return testTrill.isEmpty() ? super.trill() : testTrill.poll();
  }
}
