package org.example;

import java.util.Map;
import java.util.Set;

public class Spiller {

  private int id;
  private int posisjon;

  public Spiller(int id){
    this.id = id;
    this.posisjon = 0;
  }

  public void flytt(Terning terning, Brett brett){
    posisjon += terning.rull();
    brett.sjekkPosisjon(posisjon);
  }

  public boolean harVunnet() {
    return posisjon >= Stigespill.MAX_POENG;
  }

  public int getId() {
    return id;
  }

  public int getPosisjon() {
    return posisjon;
  }
}
