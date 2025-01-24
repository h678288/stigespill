package org.example;

public class Spiller {

  private final int id;
  private int posisjon;

  public Spiller(int id){
    this.id = id;
    this.posisjon = 0;
  }

  public void flytt(Terning terning, Brett brett){
    posisjon += terning.rull();
    setPosisjon(brett.sjekkPosisjon(posisjon));
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

  public void setPosisjon(int posisjon) {
    this.posisjon = posisjon;
  }
}
