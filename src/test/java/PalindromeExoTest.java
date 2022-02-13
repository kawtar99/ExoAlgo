import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeExoTest {

    @Test
    public void shouldReturnTrueToPalindrome(){
        int x = 212;
        boolean isPalindrome = PalindromeExo.isPalindrome(x);

        assertTrue(isPalindrome);
    }

    @Test
    public void shouldReturnTrueToOneUnitInteger(){
        int x = 0;
        boolean isPalindrome = PalindromeExo.isPalindrome(x);

        assertTrue(isPalindrome);
    }

    @Test
    public void shouldReturnFalse(){
        int x = 43;
        boolean isPalindrome = PalindromeExo.isPalindrome(x);

        assertFalse(isPalindrome);
    }

    @Test
    public void shouldReturnFalseToNegativeInteger(){
        int x = -22;
        boolean isPalindrome = PalindromeExo.isPalindrome(x);

        assertFalse(isPalindrome);
    }

}