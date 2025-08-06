🧠 Problem: Longest Substring Without Repeating Characters
Goal:
Given a string s, return the length of the longest substring without repeating characters.

1. 🔁 Brute Force using int[256]
   ✅ Approach:
   Try every possible substring

Use a frequency array (ASCII size 256) to check if a character is repeated.

💡 Intuition:
For each starting index i, expand the substring to the right until a duplicate is found.

Reset at each new starting index.

🧠 Thoughts:
Simple to code.

Inefficient for large strings.

Doesn’t reuse previous work.

2. 🔁 Brute Force using HashSet
   ✅ Approach:
   Same nested loop, but use HashSet instead of array for uniqueness check.

💡 Intuition:
Use a Set to track characters seen so far in the current substring.

Break when a character is repeated.

🧠 Thoughts:
Cleaner than array approach.

Still O(n²).

Doesn’t optimize past work done.

3. 🚀 Optimal Sliding Window with HashMap
   ✅ Approach:
   Use a sliding window with two pointers: l and r.

HashMap keeps track of the last index of every character.

On seeing a duplicate, jump l past the last index of that character.

💡 Intuition:
Don’t restart for every i. Instead, grow the window with r and only shrink from l when a duplicate is found.

The window always contains only unique characters.

🧠 Thoughts:
Reuses past work with dynamic window.

Efficient for large inputs.

Perfect for interviews: O(n) time, optimal space.

🧠 When to Use What
Scenario	Use This Approach
Learning basics / brute force	Brute with array / set
Real-world use or large data	Optimal sliding window
Interview / optimal code	Always go with Map + sliding window

-----------------------------------------------------------------------

characterReplacement — Brute Force Approach
🧠 Intuition Steps:
For each possible substring, calculate character frequencies.

Track the most frequent character in that substring.

To make all characters same:
→ Replace all other characters = (length of substring - max frequency)

If replacements needed ≤ k, it's valid.

Track the max length of all such valid substrings.

🚀 characterReplacementOptimal1 — Sliding Window with HashMap
🧠 Intuition Steps:
Expand a window from left to right.

Keep count of characters in the current window.

Track the most frequent character seen so far.

If (window size - maxFreq) > k, shrink the window from the left.

Update result with the largest valid window size found.

⚡ characterReplacementOptimalII — Sliding Window with Array
🧠 Intuition Steps:
Same logic as Optimal1, but faster with a fixed array (26 slots for A–Z).

Reduces overhead from dynamic structures (like HashMap).

Tracks character counts and max frequency using array indices.

Uses same window expansion and shrinking strategy based on k.

---------------------------------------------------

🔍 Problem Statement
Check if any permutation of string s1 exists as a substring in s2.

✅ Brute Force – checkInclusion
🔸 Intuition
If s1 is a permutation of some substring of s2, then that substring should have the same frequency of characters.

So, for every substring of s2 with length = s1.length(), check if it's a permutation.

🔸 Working
Sort s1 alphabetically → store it.

For every substring of length s1.length() in s2:

Sort it

Compare it with sorted s1

If equal → it’s a permutation.

🔸 Time Complexity
Sorting for each window: O(NlogN)

Total windows = O(N)

So, O(N * K log K) where K = s1.length(), N = s2.length()

⚡ Optimal I – checkInclusionOptimal
🔸 Intuition
Instead of sorting, maintain frequency arrays for both s1 and current window in s2.
Just compare these frequency arrays for equality.

🔸 Working
Create freq1[] for s1 (static).

Create freq2[] for first window in s2 of size s1.length().

Slide the window using 2 pointers (l, r):

Decrease the frequency of the outgoing character.

Increase the frequency of the incoming character.

After each update, compare freq1[] and freq2[] using a helper method.

🔸 Time Complexity
O(N * 26) → because you check arrays of length 26 on each slide.

Better than brute but still not optimal.

🚀 Optimal II – checkInclusionOptimaII (Best)
🔸 Intuition
Instead of comparing the entire frequency arrays (which takes O(26) time),
track how many characters match in frequency.
If 26 characters match → it means full permutation match.

🔸 Working
Create freq1[] for s1, freq2[] for first window in s2.

Count how many characters match in frequency → store in matches.

Start sliding window:

Add character from right → update frequency, update matches.

Remove character from left → update frequency, update matches.

If matches == 26 at any point → permutation exists.

🔸 Time Complexity
O(N), since we only do constant-time work on each slide.

Most efficient approach.

🔁 Sliding Window Summary
Version	Window Type	Sliding How?	Matching Logic	Time
Brute	Fixed size	Check every substring	Sort and compare	O(N·KlogK)
Optimal	Fixed size	Slide by adding/removing chars	Compare frequency arrays	O(N·26)
Optimal II	Fixed size	Same as above	Maintain match count	O(N)