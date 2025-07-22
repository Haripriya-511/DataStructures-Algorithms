## ✅ Problem Statement1:
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0
---

## 🔍 Example
Input: `arr = [7,1,5,3,6,4]` 
Output: `5` because `6-1=5`

---
Methods Overview
1. maxProfit(int[] prices)
   Approach: Preprocessing with auxiliary array (Right Maximum)

✅ Logic:
Create an array maxLeft[] where maxLeft[i] stores the maximum future price from day i+1 to end.

Then iterate through each day and calculate profit as maxLeft[i] - prices[i].

💡 Steps:
Traverse from right to left to fill maxLeft[].

Then traverse from left to right to compute the profit.

⏱️ Complexity:
Time: O(n)

Space: O(n)

🧠 Use Case:
Good for understanding the brute-force to optimized transition with preprocessing.

2. maxProfitOptimalBackward(int[] prices)
   Approach: Optimized Backward Traversal (No Extra Space)

✅ Logic:
Start from the end and track the maximum price seen so far (maxLeft).

At each day, compute profit as maxLeft - prices[i].

💡 Steps:
Traverse from right to left.

Keep updating the max future price (maxLeft) and compute profit at each step.

⏱️ Complexity:
Time: O(n)

Space: O(1)

🧠 Use Case:
Efficient but slightly less intuitive since it works backward.

3. maxProfitOptimalForward(int[] prices)
   Approach: Optimized Forward Traversal (Cleanest & Most Intuitive)

✅ Logic:
Traverse from left to right while tracking the minimum price so far.

At each step, compute profit as prices[i] - minPrice.

💡 Steps:
Start from day 1.

Update minPrice and compute the profit for each day.

⏱️ Complexity:
Time: O(n)

Space: O(1)

🧠 Use Case:
Best for interviews and real-world usage due to readability and simplicity.

✅ All three implementations correctly return 5 (buy at 1, sell at 6).

📌 Summary Table:
Method Name	Approach	Time	Space	Notes
maxProfit	Preprocessing (Right Max)	O(n)	O(n)	Uses extra space, two-pass
maxProfitOptimalBackward	Optimized Backward	O(n)	O(1)	In-place, slightly less readable
maxProfitOptimalForward	Optimized Forward	O(n)	O(1)	Most readable, best practice


--------------------------------------------------------------------------
## ✅ Problem Statement2:

🧩 Statement:
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
🎯 Goal:
To check if two strings s and t are anagrams.
An anagram means: both strings must contain the same characters with the same frequencies, possibly in a different order.

✅ Implemented Methods
1. 🔤 isAnagra1m(String s, String t)
   Approach: Sorting + Comparison

📌 Logic:
Convert both strings to character arrays.

Sort them alphabetically.

Compare the sorted arrays.

📈 Time Complexity:
O(n log n) — due to sorting.

Space: O(n) — for storing char arrays.

✅ Pros:
Simple and easy to implement.

❌ Cons:
Slower than other methods due to sorting.

2. 🗂️ isAnagram2(String s, String t)
   Approach: Two HashMaps

📌 Logic:
Use two HashMaps to count the frequency of each character in both strings.

Compare both maps for equality.

📈 Time Complexity:
O(n) — traverses the strings once.

Space: O(n) — two hash maps used.

✅ Pros:
Handles all Unicode characters (not just lowercase a–z).

❌ Cons:
Slightly more memory usage than method 3.

Slower lookup compared to using arrays for fixed-size char sets.

3. 🧮 isAnagram3(String s, String t)
   Approach: Fixed-Size Array (Character Count)

📌 Logic:
Use an integer array of size 26 (for 'a' to 'z').

For each character in s, increment its count.

For each character in t, decrement its count.

In the end, all counts should be 0 if both are anagrams.

📈 Time Complexity:
O(n)

Space: O(1) — constant space since array size is fixed (26).

✅ Pros:
Fastest and most memory-efficient for lowercase English letters.

Clean and simple.

❌ Cons:
Only works for lowercase a–z. Not suitable for Unicode or case-sensitive comparisons.

🧪 main() Method:
Tests all 3 methods using:

java
Copy
Edit
System.out.println(isAnagra1m("nagaram", "anagram")); // true
System.out.println(isAnagram2("nagaram", "anagram")); // true
System.out.println(isAnagram3("nagaram", "anagram")); // true
⚡ Optimal Solution?
You're already using the optimal approach with Method 3 for lowercase letters.
But here’s how you might extend or tweak it depending on requirements:

🔄 Optional Improvements
Case-insensitive support (e.g., "God" and "dog")
→ Convert both strings to lowercase before processing.

Unicode character support (for general characters)
→ Use a HashMap<Character, Integer> like in method 2, but optimized to use only one map:

java
Copy
Edit
public static boolean isAnagramUnicode(String s, String t) {
if (s.length() != t.length()) return false;
Map<Character, Integer> countMap = new HashMap<>();
for (int i = 0; i < s.length(); i++) {
countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
}
for (int count : countMap.values()) {
if (count != 0) return false;
}
return true;
}
✅ One-pass map, works for all characters.

📌 Summary Table
Method	Approach	Time	Space	Works for	Notes
isAnagra1m	Sort + Compare	O(n log n)	O(n)	Any characters	Simple but slower due to sorting
isAnagram2	Two HashMaps	O(n)	O(n)	Any characters	Handles Unicode
isAnagram3	Count Array (26)	O(n)	O(1)	Lowercase a–z only	Fastest and most efficient
(Bonus) isAnagramUnicode	One HashMap	O(n)	O(n)	Any characters	Optimal for general use

