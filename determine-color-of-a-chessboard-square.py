"""
LeetCode 1812: Determine Color of a Chessboard Square
https://leetcode.com/problems/determine-color-of-a-chessboard-square/
"""


class Solution:
    def squareIsWhite(self, coordinates: str) -> bool:
        """Return True when the given chessboard square is white."""
        odd_columns = {"a", "c", "e", "g"}
        even_columns = {"b", "d", "f", "h"}

        if (
            coordinates[0] in odd_columns
            and int(coordinates[1]) % 2 == 1
        ) or (
            coordinates[0] in even_columns
            and int(coordinates[1]) % 2 == 0
        ):
            return False

        return True


def main() -> None:
    solution = Solution()

    test_cases = [
        ("a1", False),
        ("h3", True),
        ("c7", False),
        ("d4", False),
        ("a2", True),
    ]

    for test_number, (coordinates, expected) in enumerate(test_cases, start=1):
        actual = solution.squareIsWhite(coordinates)
        assert actual == expected, (
            f"Test {test_number} failed for {coordinates!r}: "
            f"expected {expected}, got {actual}"
        )
        print(f"Test {test_number} passed: {coordinates!r} -> {actual}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
