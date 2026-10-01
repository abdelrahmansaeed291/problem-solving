"""
LeetCode 3: Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/
"""
from collections import deque

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """Return the length of the longest substring without repeated characters."""
        characters =deque()
        MaxLength = 0
        left_Index = 0
        for right_Index in range(len(s)):
            while s[right_Index] in characters:
                characters.popleft()
                left_Index += 1
            
            characters.append(s[right_Index])
            MaxLength = max(MaxLength, right_Index - left_Index + 1)
        return MaxLength


def main() -> None:
    solution = Solution()

    test_cases = [
        ("abcabcbb", 3),
        ("bbbbb", 1),
        ("pwwkew", 3),
        ("", 0),
        (" ", 1),
        ("au", 2),
        ("dvdf", 3),
    ]

    for test_number, (text, expected) in enumerate(test_cases, start=1):
        actual = solution.lengthOfLongestSubstring(text)
        assert actual == expected, (
            f"Test {test_number} failed for {text!r}: "
            f"expected {expected}, got {actual}"
        )
        print(f"Test {test_number} passed: {text!r} -> {actual}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
