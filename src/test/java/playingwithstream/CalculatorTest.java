package playingwithstream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldAddElements(){
        int result1 = Calculator.calculate("+", 1, 3);
        int result2 = Calculator.calculate2("+", 1, 3);

        assertEquals(result1, 4);
        assertEquals(result2, 4);
    }

    @Test
    public void shouldSubstractElements(){
        int result = Calculator.calculate("-", 1, 3);
        assertEquals(result, -2);

        int result2 = Calculator.calculate2("-", 1, 3);
        assertEquals(result2, -2);
    }

    @Test
    public void shouldMultiplyElements(){
        int result = Calculator.calculate("*", 1, 3);
        assertEquals(result, 3);

        int result2 = Calculator.calculate2("*", 1, 3);
        assertEquals(result2, 3);
    }

    @Test
    public void shouldDivideElements(){
        int result = Calculator.calculate("/", 4, 2);
        assertEquals(result, 2);

        int result2 = Calculator.calculate2("/", 4, 2);
        assertEquals(result2, 2);
    }

    @Test
    public void shouldThrowUnsupportedOperationExceptionWhenPOperator(){
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> Calculator.calculate("P", 1, 3));
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> Calculator.calculate2("P", 1, 3));

    }



}