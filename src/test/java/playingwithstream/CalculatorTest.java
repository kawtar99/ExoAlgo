package playingwithstream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    public void shouldAddElements(){
        int result = Calculator.calculate("+", 1, 3);

        assertEquals(result, 4);
    }

    @Test
    public void shouldSubstractElements(){
        int result = Calculator.calculate("-", 1, 3);

        assertEquals(result, -2);
    }

    @Test
    public void shouldMultiplyElements(){
        int result = Calculator.calculate("*", 1, 3);

        assertEquals(result, 3);
    }

    @Test
    public void shouldDivideElements(){
        int result = Calculator.calculate("/", 4, 2);

        assertEquals(result, 2);
    }

    @Test
    public void shouldThrowUnsupportedOperationExceptionWhenPOperator(){
        Assertions.assertThrows(UnsupportedOperationException.class,
                () -> Calculator.calculate("P", 1, 3));

    }



}