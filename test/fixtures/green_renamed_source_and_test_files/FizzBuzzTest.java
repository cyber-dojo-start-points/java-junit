import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class FizzBuzzTest {

    @Test
    void three_is_fizz() {
        assertEquals("Fizz", FizzBuzz.say(3));
    }
}
