"""
LeetCode 151: Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/
"""


class Solution:
    def reverseWords(self, s: str) -> str:
        """Reverse the order of the words in the given string."""
        return " ".join(reversed(s.split()))


def main() -> None:
    solution = Solution()

    test_cases = [
        ("the sky is blue", "blue is sky the"),
        ("  hello world  ", "world hello"),
        ("a good   example", "example good a"),
        ("hello", "hello"),
        ("  Bob    Loves  Alice   ", "Alice Loves Bob"),
    ]

    for test_number, (text, expected) in enumerate(test_cases, start=1):
        actual = solution.reverseWords(text)
        assert actual == expected, (
            f"Test {test_number} failed for {text!r}: "
            f"expected {expected!r}, got {actual!r}"
        )
        print(f"Test {test_number} passed: {text!r} -> {actual!r}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
