Minimum Window Substring — Detailed Notes
✅ Problem Statement
Given: Two strings s and t.
Goal: Find the smallest window in s that contains all characters from t (including their frequency).
Return: The minimum window substring from s. If no such window exists, return an empty string.

🧪 Example:
text
Copy
Edit
Input:  s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"

Explanation:
The substring "BANC" contains all characters A, B, and C from t.
🔴 Brute Force Approach — minWindow(String s, String t)
💡 Approach:
Create a frequency map for string t.

For each possible substring of s:

Build a frequency map of the substring.

Check if it contains all characters of t with required frequency.

If valid and smaller than current best window, update result.

📦 Data Structures:
mapT: Frequency map for string t

mapS: Frequency map for the current substring of s

Variables to track the best window: l, r, resLen

⏱ Time Complexity:
O(n³)

O(n²) for generating all substrings

O(n) for checking frequency maps

🧠 Space Complexity:
O(n + m)

mapS for each substring (size up to s.length())

mapT (size up to t.length())

✅ Pros:
Easy to implement

Good for understanding the problem

❌ Cons:
Very inefficient for large strings

Not suitable for production or competitive coding

🟢 Optimal Sliding Window Approach — minWindowOptimal(String s, String t)
💡 Approach:
Use a sliding window with two pointers l and r (left and right).

Maintain a character frequency array tFreq[256] for characters in t.

Traverse string s:

Expand the window by moving r.

Track character matches using a counter cnt.

When all required characters are matched (cnt == t.length()), try to shrink the window from the left.

Update result if a smaller valid window is found.

📦 Data Structures:
tFreq[256]: Array to store frequency of characters in t (ASCII-based)

Two pointers: l (left), r (right)

cnt: Counter for matched characters

minLen, sIndex: To track the minimum window

⏱ Time Complexity:
O(n + m)

m for initializing the frequency array

n for traversing string s using l and r

🧠 Space Complexity:
O(1) (constant space)

Fixed-size frequency array (256 for ASCII)

⚠️ Important Notes:
This approach only works correctly if:

Characters in t are unique

You're dealing with ASCII characters

If t contains duplicate characters (e.g., t = "AABC"), this approach will fail because cnt == t.length() no longer guarantees that all frequencies are matched.

To support Unicode or duplicate character counts, use a Map<Character, Integer> instead of int[256].

✅ Pros:
Efficient and fast

Uses sliding window technique — a popular interview pattern

❌ Cons:
Not immediately intuitive

Needs adjustments for duplicate characters or Unicode

🔁 Comparison Table
Feature	Brute Force	Sliding Window (Optimal)
Time Complexity	O(n³)	O(n + m)
Space Complexity	O(n + m)	O(1)
Handles duplicates in t	✅ Yes	❌ No (fails for repeated chars)
Frequency structure	HashMap<Character, Integer>	int[256] for ASCII
Interview readiness	❌ Only for discussion	✅ Yes

🧠 Key Sliding Window Pattern Recap
Use two pointers: left and right

Expand right until all constraints are met

Shrink from left to minimize the window

Update answer during the shrinking phase

--------------------------------------------------------------------