"""
LeetCode 11: Container With Most Water
https://leetcode.com/problems/container-with-most-water/
"""


class Solution:
    def maxArea(self, height: list[int]) -> int:
        """Return the maximum amount of water a pair of lines can contain."""
        max_area = 0
        left = 0
        right = len(height) - 1

        while left < right:
            width = right - left
            current_area = min(height[left], height[right]) * width
            max_area = max(max_area, current_area)

            if height[left] < height[right]:
                left += 1
            else:
                right -= 1

        return max_area


def main() -> None:
    solution = Solution()

    test_cases = [
        ([1, 8, 6, 2, 5, 4, 8, 3, 7], 49),
        ([1, 1], 1),
        ([4, 3, 2, 1, 4], 16),
        ([1, 2, 1], 2),
    ]

    for test_number, (height, expected) in enumerate(test_cases, start=1):
        actual = solution.maxArea(height)
        assert actual == expected, (
            f"Test {test_number} failed for {height!r}: "
            f"expected {expected}, got {actual}"
        )
        print(f"Test {test_number} passed: {height!r} -> {actual}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
