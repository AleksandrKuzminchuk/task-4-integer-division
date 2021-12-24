package test.java;

import main.java.Divider;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DividerTest {

    Divider divider;

    @BeforeEach
    void init() {
        divider = new Divider();
    }

    @Test
    @DisplayName("testDividesTheNumbersIntoColumnsShouldMakeDivision")
    void testDividesTheNumbersIntoColumnsShouldMakeDivision() {

        String expected = "_15744│541\n" +
                " 1082 │--\n" +
                " ---- │29\n" +
                " _4924\n" +
                "  4869\n" +
                "  ----\n" +
                "    55\n";

        assertEquals(expected.length(), divider.dividesTheNumbersIntoColumns(15744, 541).length());

    }

    @Test
    @DisplayName("testDividesTheNumbersIntoColumnsShouldReturnStringWithSameLength")
    void testDividesTheNumbersIntoColumnsShouldReturnStringWithSameLength(){

        String expected = "_18522154│8752\n" +
                " 17504   │----\n" +
                " -----   │2116\n" +
                " _10181\n" +
                "   8752\n" +
                "   -----\n" +
                "  _14295\n" +
                "    8752\n" +
                "    -----\n" +
                "   _55434\n" +
                "    52512\n" +
                "    -----\n" +
                "     2922\n";

        assertEquals(expected.length(), divider.dividesTheNumbersIntoColumns(18522154, 8752).length());

    }

    @Test
    @DisplayName("testDividesTheNumbersIntoColumnsShouldThrowExceptionOnZero")
    void testDividesTheNumbersIntoColumnsShouldThrowExceptionOnZero(){
        assertThrows(IllegalArgumentException.class,
                () -> divider.dividesTheNumbersIntoColumns(10, 0));
    }
}
