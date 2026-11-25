"""
LeetCode 134: Gas Station
https://leetcode.com/problems/gas-station/

Time complexity: O(n)
Space complexity: O(1)
"""


class Solution:
    def canCompleteCircuit(self, gas: list[int], cost: list[int]) -> int:
        """Return the starting station index, or -1 if the circuit is impossible."""
        if len(gas) == 0:
            return -1

        total_balance = 0
        current_balance = 0
        start_index = 0

        for station in range(len(gas)):
            balance = gas[station] - cost[station]
            total_balance += balance
            current_balance += balance
            if current_balance < 0:
                start_index = station + 1
                current_balance = 0


        if total_balance < 0:
            return -1

        return start_index


def main() -> None:
    solution = Solution()

    test_cases = [
        ([1, 2, 3, 4, 5], [3, 4, 5, 1, 2], 3),
        ([2, 3, 4], [3, 4, 3], -1),
        ([5], [4], 0),
        ([2], [2], 0),
        ([3, 1, 1], [1, 2, 2], 0),
    ]

    for test_number, (gas, cost, expected) in enumerate(test_cases, start=1):
        actual = solution.canCompleteCircuit(gas, cost)
        assert actual == expected, (
            f"Test {test_number} failed: expected {expected}, got {actual}"
        )
        print(f"Test {test_number} passed: {actual}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
