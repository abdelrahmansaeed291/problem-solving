# Study Notes

Short notes about patterns used while solving LeetCode problems.

## Sliding Window

Use a sliding window when a problem asks about a contiguous substring or subarray.

- Expand the right side to include new values.
- Move the left side when the window becomes invalid.
- Update the best result while scanning the input.

Examples in this repository:

- Longest Substring Without Repeating Characters
- Maximum Number of Vowels in a Substring of Given Length

## Two Pointers

Use two pointers when values can be compared from both ends of a sequence.

- Move the pointer that cannot improve the current result.
- Sort first when the algorithm depends on increasing value order.
- Aim to process each position only once after any required sorting.

Examples in this repository:

- Container With Most Water
- Max Number of K-Sum Pairs

## Complexity Checklist

Before submitting, record the time and space complexity and confirm that each loop does only the work the explanation claims.
