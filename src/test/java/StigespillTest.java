import org.example.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StigespillTest {

  private Stigespill stigespill;
  private final List<Spiller> spillere = new ArrayList<>();
  private Terning terning;
  private Brett brett;

  @BeforeEach
  void setUp() {
    stigespill = new Stigespill();
    for (int i = 0; i < 5; i++) {
      spillere.add(new Spiller(i + 1));
    }
    terning = new Terning();
    brett = new Brett();
  }

  @Test
  void testAvKanStarte() {

  }

  @Test
  void spillerHarVunnet() {
    Spiller spiller = spillere.get(1);
    spiller.setPosisjon(1);
    assertFalse(spiller.harVunnet());
    spiller.setPosisjon(100);
    assertTrue(spiller.harVunnet());
  }

  @Test
  void spillerKanIkkeGaaOver100() {
    Spiller spiller = spillere.get(1);
    spiller.setPosisjon(99);
    int kast = 5;
    stigespill.flyttSpiller(spiller, kast);
    assertEquals(99, spiller.getPosisjon());
    kast = 1;
    stigespill.flyttSpiller(spiller, kast);
    assertEquals(100, spiller.getPosisjon());
  }

  @Test
  void terning() {
    for (int i = 0; i < 10; i++) {
      int kast = terning.trill();
      assertTrue(kast >= 1 && kast <= 6);
    }
  }

  @Test
  void stige() {
    Spiller s1 = spillere.get(1);
    Spiller s2 = spillere.get(2);
    Spiller s3 = spillere.get(3);
    Spiller s4 = spillere.get(4);

    // posisjon 2 sender spiller til posisjon 38
    s1.setPosisjon(2);
    assertEquals(38, brett.sjekkPosisjon(s1.getPosisjon()));

    // posisjon 28 sender spiller til posisjon 84
    s2.setPosisjon(28);
    assertEquals(84, brett.sjekkPosisjon(s2.getPosisjon()));
    s3.setPosisjon(1);
    assertEquals(s3.getPosisjon(), brett.sjekkPosisjon(s3.getPosisjon()));
    s4.setPosisjon(33);
    assertEquals(s4.getPosisjon(), brett.sjekkPosisjon(s4.getPosisjon()));
  }

  @Test
  void slange() {
    Spiller s1 = spillere.get(1);
    Spiller s2 = spillere.get(2);
    Spiller s3 = spillere.get(3);
    Spiller s4 = spillere.get(4);

    // posisjon 98 sender spiller til posisjon 78
    s1.setPosisjon(98);
    assertEquals(78, brett.sjekkPosisjon(s1.getPosisjon()));

    // posisjon 62 sender spiller til posisjon 18
    s2.setPosisjon(62);
    assertEquals(18, brett.sjekkPosisjon(s2.getPosisjon()));
    s3.setPosisjon(1);
    assertEquals(s3.getPosisjon(), brett.sjekkPosisjon(s3.getPosisjon()));
    s4.setPosisjon(33);
    assertEquals(s4.getPosisjon(), brett.sjekkPosisjon(s4.getPosisjon()));
  }
}
