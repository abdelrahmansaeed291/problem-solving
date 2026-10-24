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

## Sets for Membership

Use a set when the algorithm repeatedly asks whether a value is already present; membership checks are O(1) on average.

## Edge Cases

Test empty inputs, one-element inputs, repeated values, and cases where the best answer occurs at the beginning or end.

## Clear Naming

Prefer names such as `left`, `right`, `currentSum`, and `maxLength` so the purpose of each pointer and value stays clear.

## Before Submission

Run every local test, recheck the method signature, and confirm that debugging output is removed before submitting to LeetCode.

## Hash Maps

Use a hash map when the solution needs to associate each value with a count, index, or other piece of information.

## Sorting Tradeoff

Sorting costs O(n log n), but it can simplify pair searches and make a two-pointer solution possible.

## Loop Invariants

State what must remain true after every iteration; this makes pointer movement and correctness easier to reason about.

## Manual Dry Runs

Trace a small example on paper and record pointer positions, current state, and the best answer after each iteration.

## After Solving

Review the accepted solution once more and write down the key observation that turned the brute-force approach into an efficient one.

## Binary Search

Use binary search when the search space is ordered and each comparison can eliminate half of the remaining candidates.

## Prefix Sums

Build a prefix-sum array when many queries need the sum of different ranges from the same input.

## Stacks

Use a stack when the most recently added value must be processed first, such as matching brackets or undoing operations.

## Queues

Use a queue when values must be processed in arrival order, especially in breadth-first search and level-order traversal.

## Recursion

Define a clear base case first, then ensure every recursive call moves the problem closer to that base case.

## Linked Lists

Use dummy nodes to simplify operations near the head and avoid separate logic for empty lists or first-node changes.

## Breadth-First Search

Use breadth-first search with a queue when you need shortest paths in an unweighted graph or level-by-level traversal.
