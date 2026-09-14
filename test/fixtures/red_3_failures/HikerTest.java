import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HikerTest {

    @Test
    void life_the_universe_and_everything() {
        assertEquals(42, Hiker.answer());
    }

    @Test
    void the_answer_is_a_multiple_of_seven() {
        assertEquals(0, Hiker.answer() % 7);
    }

    @Test
    void the_hiker_is_called_arthur() {
        assertEquals("Arthur Dent", Hiker.name());
    }
}
