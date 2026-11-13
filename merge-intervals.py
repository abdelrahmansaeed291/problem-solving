"""
LeetCode 56: Merge Intervals
https://leetcode.com/problems/merge-intervals/

Time complexity: O(n log n)
Space complexity: O(n)
"""


class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        """Merge all overlapping intervals."""
        if(len(intervals) == 0):
            return []
        intervals.sort()
        merged_list = [intervals[0]]

        for start, end in intervals[1:]:
            previous_end = merged_list[-1][1]

            if(start <= merged_list[-1][1]):
                merged_list[-1] = [merged_list[-1][0], max(previous_end, end)]
            else:
                merged_list.append([start,end])    


        
        

        return merged_list


def main() -> None:
    solution = Solution()

    test_cases = [
        ([[1, 3], [2, 6], [8, 10], [15, 18]], [[1, 6], [8, 10], [15, 18]]),
        ([[1, 4], [4, 5]], [[1, 5]]),
        ([[1, 4], [2, 3]], [[1, 4]]),
        ([[1, 4], [0, 2], [3, 5]], [[0, 5]]),
        ([], []),
    ]

    for test_number, (intervals, expected) in enumerate(test_cases, start=1):
        actual = solution.merge(intervals)
        assert actual == expected, (
            f"Test {test_number} failed: expected {expected}, got {actual}"
        )
        print(f"Test {test_number} passed: {actual}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
