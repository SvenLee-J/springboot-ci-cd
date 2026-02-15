package IFC33.Pipe_CI_CD;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PipeCiCdApplicationTests {

    @Test
    void testBasico() {
        assertTrue(1 + 1 == 2, "Matemáticas básicas funcionan");
    }

    @Test
    void testString() {
        assertTrue("Hola".length() > 0, "String no vacío");
    }
}
