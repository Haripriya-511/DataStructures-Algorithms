## ✅ Problem Statement1:
Given an array of integers nums and an integer k, return the k most frequent elements.

Step 1 (Common in All):
Build a frequency map Map<Integer, Integer> where key = number, value = frequency.

Method 1: Sorting (Brute Force)
🔧 Idea:
Count frequencies.

Store them as (num, freq) pairs in a list.

Sort list based on frequency descending.

Pick top k elements.

⚙️ Time Complexity:
O(n log n) due to sorting.

✅ When to Use:
Small input size or one-time usage.

Method 2: Min-Heap (Using PriorityQueue with k size)
🔧 Idea:
Use a min-heap to keep top k frequent elements.

For each entry in frequency map:

Add to heap.

If heap size > k, remove smallest freq element.

Finally, heap contains top k.

📌 Heap Stores:
Either Map.Entry or [num, freq] arrays.

⚙️ Time Complexity:
O(n log k)

Better than sorting when k << n.

✅ When to Use:
For large arrays when k is small.

Efficient for streaming data (sliding window, real-time ranking).

🪣 Method 3: Bucket Sort (Most Optimal)
🔧 Idea:
Max frequency possible = n → create bucket[n + 1].

Each index i in bucket holds list of elements with frequency i.

Traverse bucket from high to low and collect top k.

⚙️ Time Complexity:
O(n)

Because no sorting or heap is used.

✅ When to Use:
For most optimal and clean solution.

When input fits in memory and you need fast results.
--------------------------------------------------------------------------
## ✅ Problem Statement2:
Problem Understanding:
You are given a list of strings.
Your task is to:

Encode it into a single string.

Decode it back into the original list.

✅ Key Requirements:
Encoded string should handle any characters (including #, spaces, etc.).

Must preserve exact order and length of original strings.

Must be reversible – decoding should always recover the original input.

🔧 Encoding Approach:
✨ Intuition:
Attach the length of each string before the string itself, separated by a special delimiter (e.g., #).

This makes decoding easier, as we can read the number of characters to extract.

🔁 Format Used:
perl
Copy
Edit
length#string
Example:
List = [“neet”, “Co#de”]
Encoded string = 4#neet5#Co#de

🔄 Decoding Approach:
✨ Intuition:
Scan the string from left to right:

Read characters until # → this gives us the length of the next string.

From the next index, read exactly length characters → this is the actual string.

Repeat.

⚙️ Time & Space Complexity:
Operation	Time Complexity	Space Complexity
Encode	O(n)	O(n)
Decode	O(n)	O(n)

n = total number of characters across all strings.

🧠 Key Takeaways:
Encoding with length + delimiter is a safe and reversible approach.

Avoid using split-based methods if the string itself may contain the delimiter (#, |, etc.).

Works for any kind of string content (including empty strings, special characters, spaces, etc.).

This pattern is frequently used in system design, network communication, and serialization tasks.
-----------------------------------------------------------------------------
## ✅ Problem Statement3:
You're given a sorted array of integers.
Find two numbers that add up to a given target.
Return their 1-based indices.


✅ Key Observations
Array is sorted → enables two-pointer or binary search optimizations.

Only one solution exists and each input has exactly one solution.

Indices are 1-based, not 0-based.

🔸 Method 1: Two-Pointer Approach (Optimal)
🧠 Intuition:
Start from both ends of the array and move inward:

If sum is too small, move the left pointer to the right.

If sum is too big, move the right pointer to the left.

Stop when sum == target.

⚙️ Time Complexity: O(n)
Every element is checked at most once.

⚙️ Space Complexity: O(1)
No extra space used.

✅ When to Use:
Array is sorted

You want the most optimal and cleanest solution

🔸 Method 2: Binary Search for Complement
🧠 Intuition:
Fix one element (numbers[i]), and search for target - numbers[i] in the rest of the array using binary search.

🔁 For each index i:
Set left = i + 1, right = n - 1

Use binary search to find target - numbers[i]

⚙️ Time Complexity: O(n log n)
Loop runs n times, and each binary search takes log n.

⚙️ Space Complexity: O(1)
No additional space used.

✅ When to Use:
You want to practice binary search on sorted arrays

Or in interview follow-ups asking for different methods

🔄 Comparison Table
Method	Time	Space	Notes
Two-Pointer	O(n)	O(1)	Most efficient
Binary Search	O(n log n)	O(1)	Slightly slower, but valid approach

⚠️ Edge Cases to Remember
No need to handle duplicates or multiple answers — problem guarantees a single solution.

Indices are 1-based, not 0-based (adjust your return values).

