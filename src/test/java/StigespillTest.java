import org.example.Stigespill;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StigespillTest {

  private Stigespill stigespill;

  @Test
  void testAntallSpillere() {

    assertThrows(IllegalArgumentException.class, () -> {
      stigespill = new Stigespill(1);
    });

    assertThrows(IllegalArgumentException.class, () -> {
      stigespill = new Stigespill(5);
    });

    assertDoesNotThrow(() -> {
      stigespill = new Stigespill(2);
    });

    assertDoesNotThrow(() -> {
      stigespill = new Stigespill(4);
    });
  }

}
