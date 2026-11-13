/**
 * LeetCode 45: Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Time complexity: O(n^2) in the worst case
 * Space complexity: O(1)
 */
public class JumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }

        int position = 0;
        int jumps = 0;

        while (position < nums.length - 1) {
            if (position + nums[position] >= nums.length - 1) {
                jumps++;
                break;
            }

            int bestPosition = position + 1;
            int farthestReach = bestPosition + nums[bestPosition];
            int lastReachablePosition = position + nums[position];

            for (int next = position + 1;
                    next <= lastReachablePosition;
                    next++) {
                int nextReach = next + nums[next];

                if (nextReach > farthestReach) {
                    farthestReach = nextReach;
                    bestPosition = next;
                }
            }

            position = bestPosition;
            jumps++;
        }

        return jumps;
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();

        int[][] inputs = {
            {2, 3, 1, 1, 4},
            {2, 3, 0, 1, 4},
            {1},
            {1, 2},
            {1, 1, 1, 1}
        };

        int[] expected = {2, 2, 0, 1, 3};

        for (int i = 0; i < inputs.length; i++) {
            int actual = solution.jump(inputs[i]);

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
