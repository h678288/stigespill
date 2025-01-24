package org.example;

import java.util.ArrayList;
import java.util.List;

public class Stigespill {

  public static final int MAX_POENG = 90;
  public final int TERNING_STORRELSE = 6;

  private final Brett brett;
  private final Terning terning;
  private final List<Spiller> spillerList;

  public Stigespill(int spillere) {
    spillerList = new ArrayList<Spiller>();
    for (int i = 0; i < spillere; i++) {
      spillerList.add(new Spiller(i + 1));
    }
    brett = new Brett();
    terning = new Terning(TERNING_STORRELSE);
  }

  public void start() {
    boolean ferdig = false;

    while(!ferdig) {
      for (Spiller spiller : spillerList) {
        spiller.flytt(terning, brett);
        System.out.printf("Spiller nr. %d er på posisjon %d\n", spiller.getId(), spiller.getPosisjon());
        if(spiller.harVunnet()) {
          System.out.printf("Spiller nr. %d har vunnet!", spiller.getId());
          ferdig = true;
          break;
        }
      }
    }
  }

}
