import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class HikerTest {

    static int hikers;
    static int answersPerHiker;

    @BeforeAll
    static void share_out_the_answers() {
        answersPerHiker = Hiker.answer() / hikers;
    }

    @Test
    void life_the_universe_and_everything() {
        assertEquals(42, answersPerHiker);
    }
}
