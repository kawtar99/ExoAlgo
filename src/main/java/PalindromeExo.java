import java.util.ArrayDeque;

public class PalindromeExo {

    /**
     *
     * @param x an integer
     * @return true if x is palindrome integer
     */

    public static boolean isPalindrome(int x) {

        String s = String.valueOf(x);
        ArrayDeque<Character> isPalindrome = new ArrayDeque<>();
        for(char c : s.toCharArray()){
            isPalindrome.add(c);
        }

        int midLength = isPalindrome.size()/2;
        for(int i=0; i<midLength; i++){
            Character first = isPalindrome.removeFirst();
            Character last = isPalindrome.removeLast();
            if (!first.equals(last)){
                return false;
            }
        }
        return true;
    }
}
