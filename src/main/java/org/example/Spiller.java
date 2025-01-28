package org.example;


public class Spiller {

  private final int id;
  private int posisjon;
  private boolean kanFlytte;

  /**
   * Oppretter spiller på posisjon 0.
   * @param id spillerens id
   */
  public Spiller(int id){
    this.id = id;
    this.posisjon = 0;
    this.kanFlytte = true;
  }

  /**
   * Sjekker om Spiller har vunnet
   * @return true / false om spiller har vunnet (er på posisjon 100)
   */
  public boolean harVunnet() {
    return posisjon == Stigespill.MAX_POENG;
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

  public boolean getKanFlytte(){
    return kanFlytte;
  }

  public void setKanFlytte(boolean kanFlytte){
    this.kanFlytte = kanFlytte;
  }
}
