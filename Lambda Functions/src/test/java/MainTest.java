import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void doStringStuff() {
        UpperConcat uc = (s1, s2) -> s1.toUpperCase() + s2.toUpperCase();

        assertEquals("MAARTENBAKKER", Main.doStringStuff(uc, "maarten",  "bakker"));
    }
}