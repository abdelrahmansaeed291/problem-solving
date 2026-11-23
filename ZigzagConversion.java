import java.util.ArrayList;



/**
 * LeetCode 6: Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 *
 * Arrange the characters of a string in a zigzag pattern using numRows,
 * then return the result produced by reading each row from top to bottom.
 */
public class ZigzagConversion {
    public String convert(String s, int numRows) {
        ArrayList<Integer>[] rows = new ArrayList[numRows];
        if(numRows == 1){
            return s;
        }
        for (int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<Integer>();
        }
        int rowPointer = 0;
        int incrementValue = -1;
        for (int index = 0; index < s.length(); index++) {
            if (rowPointer == 0 || rowPointer == numRows - 1) {
                incrementValue = incrementValue * -1;
            }
            rows[rowPointer].add(index);
            rowPointer += incrementValue;

        }
        String result = "";
        for (ArrayList<Integer> row : rows) {
            for (int index : row) {
                result = result + s.charAt(index);
                
            }
            
        }
        return result;
    }

    public static void main(String[] args) {
        ZigzagConversion solution = new ZigzagConversion();

        String[] inputs = {
                "PAYPALISHIRING",
                "PAYPALISHIRING",
                "A",
                "AB"
        };

        int[] rows = { 3, 4, 1, 1 };

        String[] expected = {
                "PAHNAPLSIIGYIR",
                "PINALSIGYAHRPI",
                "A",
                "AB"
        };

        for (int i = 0; i < inputs.length; i++) {
            String actual = solution.convert(inputs[i], rows[i]);

            if (!actual.equals(expected[i])) {
                throw new AssertionError(
                        "Test " + (i + 1) + " failed: expected "
                                + expected[i] + ", got " + actual);
            }

            System.out.println("Test " + (i + 1) + " passed: " + actual);
        }

        System.out.println("All tests passed!");
    }
}
