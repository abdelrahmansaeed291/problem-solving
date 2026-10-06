"""
LeetCode 151: Reverse Words in a String
https://leetcode.com/problems/reverse-words-in-a-string/
"""


from typing import List


class Solution:   
    def reverseWords(self, s: str) -> str:
        """Reverse the order of the words in the given string."""
        return " ".join(reversed(s.split()))

    
    def maxOperations(self, nums: List[int], k: int) -> int:
        counter = 0
        nums.sort()
        left= 0
        right = len(nums)-1
        while left < right:
            if nums[left] + nums[right] == k:
                counter +=1
                left+=1 
                right -=1
            elif nums[left] + nums [right] < k:
                left+=1
            else:
                right -=1
        return counter           
    def maxArea(self, height: list[int]) -> int:
        max_area = 0
        left, right = 0, len(height) - 1
        while left < right:
            width = right -left
            current_area = min(height[left], height[right]) *width
            max_area = max(max_area, current_area)
            if height[left] < height[right]:
                left +=1
            else:
                right -=1    
        return max_area  
    def squareIsWhite(self, coordinates: str) -> bool:
        odd_chars={'a','c','e','g'}
        even_chars={'b','d','f','h'}
        if((coordinates[0] in odd_chars and int(coordinates[1])%2 ==1 ) or (coordinates[0] in even_chars and int(coordinates[1])%2 ==0)):
            return False
        return True   
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
