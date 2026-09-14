import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        for (int i = 0; i != 20000; i++) {
            System.out.println("debug: i is " + i);
        }
        assertEquals(42, Hiker.answer());
    }
}
