package org.example;

import java.util.HashMap;
import java.util.Map;

public class Brett {

  private final Map<Integer, Integer> stiger;

  /*
   *  Oppretter et HashMap med stiger og ødelagtestiger
   *  Et key-value par med positiv stigning øker poeng
   *  Et key-value par med negativ stigning minker poeng
   *  Stigene inisialiseres basert på standard stigespill utgitt av Capellen Damm
   */
  public Brett() {
    stiger = new HashMap<Integer, Integer>();
    stiger.put(1, 40);
    stiger.put(8, 10);
    stiger.put(36, 52);
    stiger.put(43, 62);
    stiger.put(49, 79);
    stiger.put(65, 82);
    stiger.put(68, 85);
    stiger.put(33, 3);
    stiger.put(24, 5);
    stiger.put(74, 12);
    stiger.put(64, 27);
    stiger.put(56, 37);
    stiger.put(87, 75);
  }

  public int sjekkPosisjon(int poeng) {
    return stiger.getOrDefault(poeng, poeng);
  }
}
