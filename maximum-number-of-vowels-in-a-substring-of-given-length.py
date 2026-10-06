"""
LeetCode 1456: Maximum Number of Vowels in a Substring of Given Length
https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/
"""


class Solution:
    def maxVowels(self, s: str, k: int) -> int:
        """Return the maximum number of vowels in any substring of length k."""
        vowels = ['a','u','i','o','e']
        max_count =0
        for i in range(0,k):
            if s[i] in vowels:
                max_count+=1
        
        left_pointer = 0
        right_pointer = k
        counter = max_count
        while(right_pointer < len(s)):
            if(s[left_pointer] in vowels):
                counter -=1
            left_pointer +=1
                
            if(s[right_pointer] in vowels):
                counter +=1
            right_pointer +=1
            max_count = max(counter, max_count)    
                              

        return max_count


def main() -> None:
    solution = Solution()

    test_cases = [
        ("abciiidef", 3, 3),
        ("aeiou", 2, 2),
        ("leetcode", 3, 2),
        ("rhythms", 4, 0),
        ("tryhard", 4, 1),
    ]

    for test_number, (text, k, expected) in enumerate(test_cases, start=1):
        actual = solution.maxVowels(text, k)
        assert actual == expected, (
            f"Test {test_number} failed for s={text!r}, k={k}: "
            f"expected {expected}, got {actual}"
        )
        print(f"Test {test_number} passed: s={text!r}, k={k} -> {actual}")

    print("All tests passed!")


if __name__ == "__main__":
    main()
