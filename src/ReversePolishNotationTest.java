import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ReversePolishNotationTest {

    @org.junit.jupiter.api.Test
    void evaluatePostfix() {
        assertEquals(-14, ReversePolishNotation.evaluatePostfix("7 2 + 9 / 3 5 * -"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->ReversePolishNotation.evaluatePostfix("7 2 + 9 / 3 5 *"));
    }

    @org.junit.jupiter.api.Test
    void infixToPostfix() {
        assertEquals("a b c * + d e * f + g * +", ReversePolishNotation.infixToPostfix("a + b * c + ( d  * e + f ) * g"));
    }

    @org.junit.jupiter.api.Test
    void evaluatePrefix() {
        assertEquals(-7,ReversePolishNotation.evaluatePrefix("* - 5 6 7"));
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,()->ReversePolishNotation.evaluatePostfix("+ 7 2 9 / 3 5 *"));
    }
}