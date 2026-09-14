import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class AnswerSizeTest {

    static int columns;
    static int digitsPerColumn;

    @BeforeAll
    static void lay_out_the_answer() {
        digitsPerColumn = String.valueOf(Hiker.answer()).length() / columns;
    }

    @Test
    void the_answer_is_two_digits_long() {
        assertEquals(2, digitsPerColumn);
    }
}
