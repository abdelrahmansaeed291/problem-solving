
/**
 * Practice exercise for reversing the order of words in a character array.
 * The solution and its test runner intentionally live in this single class.
 */
public class ReverseWords {

    /*
     * Problem: Reverse Words in a Character Array
     *
     * Given a char[] containing words separated by spaces,
     * reverse the ORDER of the words in place.
     *
     * Requirements:
     * - Modify the original array.
     * - Do not create another array.
     * - Use O(1) extra space.
     * - Use O(n) time.
     *
     * Example:
     * Input:  {'t','h','e',' ','s','k','y'}
     * Output: {'s','k','y',' ','t','h','e'}
     */

    // Write your solution here
    public static void reverseWords(char[] s) {
        // Suggested approach:
        // 1. Reverse the complete character array.
        // 2. Reverse each individual word to restore its character order.
        // TODO: Implement your solution

    }

    // Test cases
    public static void main(String[] args) {

        // Each input is mutable because the exercise requires an in-place update.
        char[][] inputs = {
            "the sky is blue".toCharArray(),
            "hello world".toCharArray(),
            "a good example".toCharArray(),
            "hello".toCharArray(),
            "Java is fun".toCharArray()
        };

        // Expected strings use one space between words in reversed order.
        String[] expected = {
            "blue is sky the",
            "world hello",
            "example good a",
            "hello",
            "fun is Java"
        };

        // Run every case independently and print enough detail to diagnose a failure.
        for (int i = 0; i < inputs.length; i++) {

            reverseWords(inputs[i]);

            String actual = new String(inputs[i]);

            System.out.println("Test " + (i + 1));

            // Compare the modified input with the expected word order.
            if (actual.equals(expected[i])) {
                System.out.println("PASSED");
            } else {
                System.out.println("FAILED");
                System.out.println("Expected: " + expected[i]);
                System.out.println("Actual:   " + actual);
            }

            System.out.println("----------------");
        }
    }
}
