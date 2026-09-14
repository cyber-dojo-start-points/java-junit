import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        assertEquals(42, Hiker.answer());
    }

    @Test
    void the_answer_is_two_digits_long() {
        assertEquals(2, Hiker.digitsInAnswer());
    }
}
