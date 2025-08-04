📌 Problem: Reverse Words in a String
Input: A string s containing words and spaces
Goal:

Reverse the order of words

Remove leading, trailing, and extra spaces

Keep only single spaces between words

✅ Method 1: reverseWords() – Using split() and trim()
🔍 Intuition
Java’s built-in methods (trim() and split("\\s+")) help clean the string.

You reverse the words manually using a loop.

🧠 Steps / Pseudocode

1. Trim leading/trailing spaces
2. Split the string using one or more spaces: split("\\s+")
3. Iterate from end to start of the array
4. Add each word to StringBuilder with a space
5. Return final string after trimming
   ⏱️ Time & Space
   Time: O(n)

Space: O(n) (for split array and StringBuilder)

✅ Method 2: reverseWordsII() – Two Pointers + Substring
🔍 Intuition
Manually extract words and build the result string by prepending each word.

This reverses the word order on the go.

🧠 Steps / Pseudocode

1. Initialize empty result string
2. Traverse string with index i:
    - Skip spaces
    - Mark start of word (i)
    - Move j to end of word
    - Extract word from i to j
    - Prepend to result string (word + " " + existing result)
3. Skip to j + 1 and repeat
4. Return result string
   ⏱️ Time & Space
   Time: O(n²) — due to repeated string concatenation

Space: O(n) — for the result string

✅ Method 3: reverseWordsIII() – Optimal In-Place Two-Pointer
🔍 Intuition
Reverse the entire string

Then reverse each word individually

Build the final string in-place with proper spacing

🧠 Steps / Pseudocode

1. Convert string to char array
2. Reverse the entire array
3. Use two pointers:
    - i: read pointer
    - j: write pointer
4. While i < n:
    - Skip spaces
    - Add a space if it's not the first word (j != 0)
    - Copy each character of the word to write position (j++)
    - Reverse the word in-place (from start to j-1)
5. Return new String from ch[0..j)
   ⏱️ Time & Space
   Time: O(n)

Space: O(1) (in-place on char array)

✅ Conclusion
Method	Approach Type	Time	Space	Key Notes
reverseWords()	Split + Join	O(n)	O(n)	Easiest, uses built-in methods
reverseWordsII()	Manual, Brute	O(n²)	O(n)	Prepends each word, simple logic
reverseWordsIII()	Optimal Two-Pointer	O(n)	O(1)	Most efficient, no extra memory needed

-------------------------------------------------------------------------------------


🔶 Problem Recap:
You are given a string s of length n, containing only 'I' (increase) and 'D' (decrease).
You must return a permutation of integers from 0 to n such that:

If s[i] == 'I', then perm[i] < perm[i + 1]

If s[i] == 'D', then perm[i] > perm[i + 1]

✅ Approach 1: Brute Force (Generate All Permutations)
🔹 Idea:
Generate all possible permutations of integers from 0 to n.

Check for each permutation if it satisfies the condition ('I' and 'D').

Return the first one that matches.

🔹 Pseudocode:

permute(nums, index):
if index == nums.length:
if isValid(nums, s): return nums
return
for i = index to nums.length:
swap(nums, index, i)
permute(nums, index + 1)
swap(nums, index, i)
🔹 Time Complexity:
Generating all permutations: O((n+1)!)

Checking validity for each: O(n)

❌ Not scalable; leads to TLE or MLE

✅ Approach 2: Optimal Greedy Two-Pointer Approach
🔹 Idea:
Use two pointers: low = 0 and high = n

Traverse the string s

If s[i] == 'I' → assign low to result and increment low

If s[i] == 'D' → assign high to result and decrement high

Finally, assign the remaining value (low or high, both are equal now) to the last position.

🔹 Code:

public int[] diStringMatch(String s) {
int n = s.length();
int[] res = new int[n + 1];
int low = 0, high = n;

    for (int i = 0; i < n; i++) {
        if (s.charAt(i) == 'I') {
            res[i] = low++;
        } else {
            res[i] = high--;
        }
    }
    res[n] = low; // or high (both are equal)
    return res;
}
🔹 Dry Run (s = "IDID"):
Start: low = 0, high = 4

I → 0, D → 4, I → 1, D → 3, last = 2
🔁 Output: [0, 4, 1, 3, 2]

🔹 Time Complexity:
O(n) — single traversal

O(n) — for output array

🔹 Space Complexity:
O(n) — result array

✍️ Summary Table:
Approach	Time Complexity	Space Complexity	Suitable For
Brute Force	O((n+1)! * n)	O(n!)	Small inputs only
Two Pointers	O(n)	O(n)	✅ Optimal & recommended
--------------------------------------------------------------
🔸 Problem Summary
Given an unsorted array of integers, find the length of the longest sequence of consecutive integers. The sequence elements must be adjacent in value, but not necessarily in array order.

✅ Approach 1: Naive HashSet Approach
Add all elements to a HashSet.

For each element, check how long the consecutive sequence goes by incrementing the number.

No check for whether it's the start of a sequence — hence redundant work.

Time Complexity: Worst case O(n²)
Space Complexity: O(n)
Status: Works, but not optimal due to repeated checks.

✅ Approach 2: Optimized HashSet (Best Approach)
Add all elements to a HashSet.

For each element, start a sequence only if the previous number is not present.

Extend the sequence by checking for next consecutive elements.

This ensures each sequence is counted exactly once.

Time Complexity: O(n)
Space Complexity: O(n)
Status: Most efficient and interview-friendly approach.

✅ Approach 3: Sorting-Based Approach
Sort the array.

Traverse through sorted array and count consecutive numbers.

Skip duplicates to avoid incorrect counting.

Time Complexity: O(n log n) (due to sorting)
Space Complexity: O(1) (or O(n) depending on sorting method)
Status: Easy to implement, less efficient than HashSet.

✅ Advanced Approach: HashMap with Boundary Merging
Uses a HashMap to keep track of the length of sequences only at their boundaries.

When a new number bridges two sequences, it merges them and updates their lengths.

Avoids scanning entire sequences.

Time Complexity: O(n)
Space Complexity: O(n)
Status: Efficient and elegant, but harder to understand quickly. Good for advanced interviews.

🔄 Approach Comparison
Approach	Time Complexity	Space	Duplicate Handling	Suitable For
Naive HashSet	O(n²)	O(n)	Yes	Learning/debugging
Optimized HashSet	✅ O(n)	O(n)	Yes	Interviews, production
Sorting-Based	O(n log n)	O(1)	Yes	Simple fallback
Boundary Merging (Map)	✅ O(n)	O(n)	Yes	Advanced interviews

📌 Final Recommendation:
Use Optimized HashSet approach in interviews — clean, efficient, and intuitive.

Sorting is acceptable if HashSet logic isn't clear.

Avoid the naive version in interviews — it's too slow.

Boundary merging is an extra for those preparing at an advanced level.

