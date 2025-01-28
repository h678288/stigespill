package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Stigespill {

  public static final int MAX_POENG = 100;

  private final Brett brett;
  public final List<Spiller> spillerList;
  public Terning terning;

  public Stigespill() {
    this.spillerList = new ArrayList<>();
    this.brett = new Brett();
    this.terning = new Terning();
  }

  // Testing av testTrilleSeksTreGanger()
  public Stigespill(Terning test) {
    this.spillerList = new ArrayList<>();
    this.brett = new Brett();
    this.terning = test;
  }

  public void start() {
    System.out.println("Velkommen til stigespill");
    spillerInit();
    startSpill(true);
  }

  private void spillerInit() {
    Scanner s = new Scanner(System.in);
    System.out.print("Det må kun være mellom 2 og 4 spillere");
    int antallSpiller = s.nextInt();
    while (antallSpiller < 2 || antallSpiller > 4) {
      System.out.print("Ugyldig antall spillere. Velg mellom 2 - 4 ");
      antallSpiller = s.nextInt();
    }
    for (int i = 1; i <= antallSpiller; i++) {
      spillerList.add(new Spiller(i));
    }
  }

  public void startSpill(boolean test) {
    boolean ferdig = false;

    outerloop:
    while (!ferdig) {
      for (Spiller spiller : spillerList) {
        System.out.println("\n" + spiller.getId() + " sin tur");
        int kast;
        int sekserTeller = 0;

        do {
          kast = terning.trill();
          System.out.println(spiller.getId() + " kastet en " + kast);
          if (kast == 6) {
            if (spiller.kanStarte()) {
              sekserTeller++;
            }
            if (sekserTeller == 3) {
              System.out.println(spiller.getId() + " Kastet 6 tre ganger på rad, går tilbake til start ");
              spiller.setPosisjon(1);
              spiller.setKanStarte(false);
              if (test) return;
              break outerloop;
            }
            if (!spiller.kanStarte()) {
              spiller.setKanStarte(true);
              System.out.println(spiller.getId() + " kan nå starte! Kast på nytt for å bevege deg");
              continue;
            }
            flyttSpiller(spiller, kast);
          } else {
            sekserTeller = 0;
            if (spiller.kanStarte()) {
              flyttSpiller(spiller, kast);
            } else {
              System.out.println(spiller.getId() + " må kaste en 6 for å starte ");
            }
          }
          if (spiller.getPosisjon() == MAX_POENG) {
            System.out.printf("Spiller nr. %d har vunnet!\n", spiller.getId());
            ferdig = true;
            if (test) return;
            break;
          }
        } while (kast == 6);
      }
    }
  }

  /**
   *
   * @param spiller
   * @param rull
   */
  public void flyttSpiller(Spiller spiller, int rull) {
    int posisjon = spiller.getPosisjon() + rull;
    if (posisjon > MAX_POENG) {
      System.out.println(spiller.getId() + " går forbi bretter, og blir stående på " + spiller.getPosisjon());
      return;
    }
    spiller.setPosisjon(posisjon);
    System.out.println(spiller.getId() + " flyttet til rute " + posisjon);
    int nyPosisjon = brett.sjekkPosisjon(spiller.getPosisjon());
    if (nyPosisjon != posisjon) {
      spiller.setPosisjon(nyPosisjon);
      System.out.println(spiller.getId() + " flyttet til rute " + nyPosisjon + " pga tige eller Slange");
    }
  }
}
