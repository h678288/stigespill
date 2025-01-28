package org.example;

import java.util.HashMap;
import java.util.Map;

public class Brett {

  private final Map<Integer, Integer> stigerOgSlanger = new HashMap<>();

  /*
   *  Oppretter et HashMap med stiger og ødelagtestiger
   *  Et key-value par med positiv stigning øker poeng
   *  Et key-value par med negativ stigning minker poeng
   *  Stigene inisialiseres basert på standard stigespill utgitt av Capellen Damm
   */
  public Brett() {
    stigerOgSlanger.put(2, 38);
    stigerOgSlanger.put(4, 14);
    stigerOgSlanger.put(8, 31);
    stigerOgSlanger.put(21, 42);
    stigerOgSlanger.put(28, 84);
    stigerOgSlanger.put(36, 44);
    stigerOgSlanger.put(51, 67);
    stigerOgSlanger.put(71, 91);
    stigerOgSlanger.put(80, 100);
    stigerOgSlanger.put(74, 12);
    stigerOgSlanger.put(98, 78);
    stigerOgSlanger.put(95, 75);
    stigerOgSlanger.put(93, 73);
    stigerOgSlanger.put(87, 24);
    stigerOgSlanger.put(64, 60);
    stigerOgSlanger.put(62, 18);
    stigerOgSlanger.put(56, 53);
    stigerOgSlanger.put(49, 11);
    stigerOgSlanger.put(47, 26);
    stigerOgSlanger.put(16, 6);
  }

  /**
   *
   * @param poeng (posisjon)
   * @return oppdatert poengsum eller samme poengsum
   */
  public int sjekkPosisjon(int poeng) {
    return stigerOgSlanger.getOrDefault(poeng, poeng);
  }
}
