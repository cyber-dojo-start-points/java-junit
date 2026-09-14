import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AnswerSizeTest {

    @Test
    void the_answer_is_two_digits_long() {
        assertEquals(2, String.valueOf(Hiker.answer()).length());
    }

    @Test
    void the_answer_is_three_digits_long() {
        assertEquals(3, String.valueOf(Hiker.answer()).length());
    }
}
