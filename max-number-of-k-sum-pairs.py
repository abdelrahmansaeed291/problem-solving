"""
LeetCode 1679: Max Number of K-Sum Pairs
https://leetcode.com/problems/max-number-of-k-sum-pairs/
"""


class Solution:
    def maxOperations(self, nums: list[int], k: int) -> int:
        """Return the maximum number of pairs whose sum equals k."""
        nums = sorted(nums)
        counter = 0
        left = 0
        right = len(nums) - 1

        while left < right:
            current_sum = nums[left] + nums[right]

            if current_sum == k:
                counter += 1
                left += 1
                right -= 1
            elif current_sum < k:
                left += 1
            else:
                right -= 1

        return counter


def main() -> None:
    solution = Solution()

    test_cases = [
        ([1, 2, 3, 4], 5, 2),
        ([3, 1, 3, 4, 3], 6, 1),
        ([2, 5, 4, 1, 3], 6, 2),
        ([], 5, 0),
    ]

    for test_number, (nums, k, expected) in enumerate(test_cases, start=1):
        actual = solution.maxOperations(nums, k)
        assert actual == expected, (
            f"Test {test_number} failed for nums={nums!r}, k={k}: "
            f"expected {expected}, got {actual}"
        )
        print(f"Test {test_number} passed: nums={nums!r}, k={k} -> {actual}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
