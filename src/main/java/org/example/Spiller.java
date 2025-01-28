package org.example;

public class Spiller {

  private final int id;
  private int posisjon;
  private final Terning terning;

  public Spiller(int id){
    this.id = id;
    this.posisjon = 0;
    this.terning = new Terning(Stigespill.TERNING_STORRELSE);
  }

  /**
   *
   * @param ruter
   */
  public void flytt(int ruter){
    posisjon += ruter;
  }

  /**
   *
   * @return
   */
  public int trillTerning() {
    return terning.trill();
  }

  /**
   *
   * @return
   */
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
