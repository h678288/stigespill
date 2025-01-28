package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Stigespill {

  public static final int MAX_POENG = 100;

  private final Brett brett;
  public final List<Spiller> spillerList;
  public Terning terning;
  public int sekserTeller;

  public Stigespill() {
    this.spillerList = new ArrayList<>();
    this.brett = new Brett();
    this.terning = new Terning();
  }

  /**
   * Starter spillet
   */
  public void start() {
    System.out.println("Velkommen til stigespill\n----------------------------");
    spillerInit();
    startSpill();
  }

  /**
   * initialiserer antall spillere basert på brukerinput fra konsoll. Lar deg bare velge mellom 2 og 4 spillere
   */
  private void spillerInit() {
    Scanner s = new Scanner(System.in);
    System.out.print("Du kan velge mellom 2 og 4 spillere ");
    int antallSpiller = s.nextInt();
    while (antallSpiller < 2 || antallSpiller > 4) {
      System.out.print("Ugyldig antall spillere. Velg mellom 2 og 4 ");
      antallSpiller = s.nextInt();
    }
    for (int i = 1; i <= antallSpiller; i++) {
      spillerList.add(new Spiller(i));
    }
  }

  /**
   * Starter hovedspilloopen
   */
  public void startSpill() {
    outerloop:
    while (true) {
      for (Spiller spiller : spillerList) {
        System.out.printf("\nSpiller %d: sin tur\n", spiller.getId());
        int kast;

        do {
          kast = terning.trill();
          System.out.printf("Spiller %d: kastet en %d\n", spiller.getId(), kast);
          if (kast == 6) {
            if (spiller.getKanFlytte()) {
              sekserTeller++;
            }
            if (sekserTeller == 3) {
              System.out.printf("Spiller %d: Kastet 6 tre ganger på rad, går tilbake til start\n", spiller.getId());
              spiller.setPosisjon(1);
              spiller.setKanFlytte(false);
              continue outerloop;
            }
            if (!spiller.getKanFlytte()) {
              spiller.setKanFlytte(true);
              System.out.printf("Spiller %d: kan nå starte! Kast på nytt for å bevege deg\n", spiller.getId());
              continue;
            }
            flyttSpiller(spiller, kast);
          } else {
            sekserTeller = 0;
            if (spiller.getKanFlytte()) {
              flyttSpiller(spiller, kast);
            } else {
              System.out.printf("Spiller %d: må kaste en 6 for å starte\n", spiller.getId());
            }
          }
          if (spiller.getPosisjon() == MAX_POENG) {
            System.out.printf("Spiller nr. %d har vunnet!\n", spiller.getId());
            break outerloop;
          }
        } while (kast == 6);
      }
    }
  }

  /**
   * Flytter spilleren og skjekker om den har truffet en stige eller slange
   * @param spiller spilleren som skal flyttes
   * @param terningkast hvor mye terningen viste
   */
  public void flyttSpiller(Spiller spiller, int terningkast) {
    int posisjon = spiller.getPosisjon() + terningkast;
    if (posisjon > MAX_POENG) {
      System.out.printf("Spiller %d: går forbi bretter, og blir stående på %d\n",spiller.getId(), spiller.getPosisjon());
      return;
    }
    spiller.setPosisjon(posisjon);
    System.out.printf("Spiller %d: flyttet til rute %d\n", spiller.getId(), posisjon);
    int nyPosisjon = brett.sjekkPosisjon(spiller.getPosisjon());
    if (nyPosisjon != posisjon) {
      spiller.setPosisjon(nyPosisjon);
      System.out.printf("Spiller %d: flyttet til rute %d pga Stige eller Slange\n",spiller.getId(), nyPosisjon);
    }
  }
}
