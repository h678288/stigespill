package org.example;

public class Spiller {

  private final int id;
  private int posisjon;
  private boolean kanStarte;

  public Spiller(int id){
    this.id = id;
    this.posisjon = 0;
    this.kanStarte = false;
  }

  public boolean kanStarte(){
    return kanStarte;
  }

  public void setKanStarte(boolean kanStarte){
    this.kanStarte = kanStarte;
  }
  /**
   *
   * @return
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
}
