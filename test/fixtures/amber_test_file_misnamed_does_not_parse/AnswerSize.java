import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AnswerSize {

    @Test
    void the_answer_is_two_digits_long() {
        assertEquals(2, String.valueOf(Hiker.answer()).length())
    }
}
