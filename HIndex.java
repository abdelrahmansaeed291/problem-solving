/**
 * LeetCode 274: H-Index
 * https://leetcode.com/problems/h-index/
 *
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
public class HIndex {
    public int hIndex(int[] citations) {
        int numOfPapers = citations.length;
        int [] citationCount = new int[citations.length+1];

        for (int citation : citations) {
            if(citation >= numOfPapers){
                citationCount[numOfPapers]++;
            }else{
                citationCount[citation]++;
            }
            
        }
        int count = 0;

        for (int i = numOfPapers; i >= 0; i--) {
            if(citationCount[i]+count >= i
            ){
                return i;
            }else{
                count +=citationCount[i];
            }
            
        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex solution = new HIndex();

        int[][] inputs = {
            {3, 0, 6, 1, 5},
            {1, 3, 1},
            {},
            {0},
            {100},
            {4, 4, 0, 0}
        };

        int[] expected = {3, 1, 0, 0, 1, 2};

        for (int i = 0; i < inputs.length; i++) {
            int actual = solution.hIndex(inputs[i]);

            if (actual != expected[i]) {
                throw new AssertionError(
                    "Test " + (i + 1) + " failed: expected "
                        + expected[i] + ", got " + actual
                );
            }

            System.out.println("Test " + (i + 1) + " passed: " + actual);
        }

        System.out.println("All tests passed!");
    }
}
