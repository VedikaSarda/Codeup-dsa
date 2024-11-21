/***
 * Statement : This program shows all the palindrome strings present in a string
 * Owner name : Vedika Sarda
 * Date of creation : 18-11-2024
 */
import java.util .*;
public class StringPalindrome {
      // This method finds errors
        private static boolean Error(String s) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!(c >= Constant.CHAR_A && c <= Constant.CHAR_Z) && !(c >= Constant.CHAR_CAPITAL_A && c <= Constant.CHAR_CAPITAL_Z) && !(c>=Constant.DIGIT_0 && c<=Constant.DIGIT_9)) {
                    return true;
                }
            }
            return false;
        }
        // This method check if the string is palindrome or not
        private static boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
        // This method find the Strings and check for palindrome strings
        private static void findPalindromes(String str, int start, HashSet<String> Strings) {
            if (start >= str.length()) {
                return;
            }
            for (int i = start + 1; i <= str.length(); i++) {
                String substring = str.substring(start, i);
                if (isPalindrome(substring)) {
                    Strings.add(substring);
                }
            }
            findPalindromes(str, start + 1, Strings);
        }
        // Main function
        public static void main(String[] args) {
            do {
                HashSet<String> palindromeStrings = new HashSet<>();
                System.out.println(Constant.ENTER_STRING);
                Scanner userInput = new Scanner(System.in);
                String input = userInput.nextLine();
                if (Error(input)) {
                    System.out.println(Constant.INVALID_INPUT);
                    continue;
                }
                findPalindromes(input, 0, palindromeStrings);
                System.out.println(Constant.PALINDROME + palindromeStrings);
                System.out.println(Constant.REPEAT);
                String repeat = userInput.nextLine().trim().toLowerCase();
                if (repeat.equals("no")) {
                    break;
                }
            } while (true);
        }
    }