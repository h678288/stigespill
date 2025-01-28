package org.example;

import java.util.ArrayList;
import java.util.List;

public class Stigespill {

  public static final int MAX_POENG = 100;
  public static final int TERNING_STORRELSE = 6;

  private final Brett brett;
  private final List<Spiller> spillerList = new ArrayList<>();

  public Stigespill(int spillere) {
    if (spillere < 2 || spillere > 4) {
      throw new IllegalArgumentException("Det må kun være mellom 2 og 4 spillere");
    }
    for (int i = 0; i < spillere; i++) {
      spillerList.add(new Spiller(i + 1));
    }
    brett = new Brett();
  }

  public void startSpill() {
    boolean ferdig = false;

    while (!ferdig) {
      for (Spiller spiller : spillerList) {
        // lagrer variabler for consol output, derfor litt rotete
        int kast = spiller.trillTerning();
        int forigePosisjon = spiller.getPosisjon();

        spiller.flytt(kast);

        int forStige = spiller.getPosisjon();
        int stige = brett.sjekkPosisjon(spiller.getPosisjon(), forigePosisjon);
        spiller.setPosisjon(stige);

        System.out.printf(
                "Spiller %d kastet %d og gikk fra posisjon %d til %d\n",
                spiller.getId(), kast, forigePosisjon, spiller.getPosisjon()
        );

        if (spiller.getPosisjon() != forStige) {
          System.out.printf("Spiller %d traff en stige / slange på posisjon %d og landet på posisjon %d!\n",
                  spiller.getId(), forStige, spiller.getPosisjon());
        }

        System.out.println();

        if (spiller.harVunnet()) {
          System.out.printf("Spiller nr. %d har vunnet!\n", spiller.getId());
          ferdig = true;
          break;
        }
      }
    }
  }
}
