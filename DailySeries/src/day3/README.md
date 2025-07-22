## ✅ Problem Statement1:
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.



Example 1:

Input: nums = [1,2,3,1]

Output: true

Explanation:

The element 1 occurs at the indices 0 and 3.

Example 2:

Input: nums = [1,2,3,4]

Output: false

Method 1: containsDuplicate1


Uses two nested loops to compare every pair of elements.

Returns true if any duplicate is found.

Time Complexity: O(n^2)
Space Complexity: O(1)
Use Case: Only for very small arrays due to performance.

🔢 Method 2: containsDuplicate2

Explanation:

Sorts the array first.

Checks adjacent elements for duplicates.

Time Complexity: O(n log n) (due to sorting)
Space Complexity: O(1) (ignoring sorting space)
Use Case: When you are allowed to modify the input array.

🧠 Method 3: containsDuplicate3

Explanation:

Uses a HashSet to store unique elements.

Compares the size of the set with the original array length.

Time Complexity: O(n)
Space Complexity: O(n)
Use Case: Efficient and doesn't modify the original array.

Method 4: containsDuplicate4

public static boolean containsDuplicate4(int nums[]) {
return Arrays.stream(nums).distinct().count() < nums.length;
}
Explanation:

Uses Java Streams.

Counts distinct elements and compares with array length.

Time Complexity: O(n)
Space Complexity: O(n)
Use Case: Concise and readable (modern Java style)
--------------------------------------------------------------------------
## ✅ Problem Statement2:
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.

Method 1: groupAnagramsWithSorting

✅ Explanation:
Converts each string to a character array and sorts it.

Uses the sorted string as a key to group anagrams.

Adds the original word to the list corresponding to the sorted key.

🧮 Time & Space Complexity:
Time: O(n·k log k)
(where n = number of strings, k = max length of a string, due to sorting)

Space: O(n·k)
(for the hashmap and lists)

📌 Use Case:
Easy to understand and implement.

Works well for small-to-medium inputs.

🔣 Method 2: groupAnagramsWithoutSorting (Using Character Count)

✅ Explanation:
Builds a frequency array (count) for each word.

Converts the count array to a string and uses it as a key.

Grouped words with identical character counts are anagrams.

🧮 Time & Space Complexity:
Time: O(n·k)
(No sorting; just character counting)

Space: O(n·k)

📌 Use Case:
Faster than sorting-based approach.

Best for longer strings or large input sizes.

Avoids the overhead of Arrays.sort().


Bonus Optimization (Advanced Idea - Optional)
Instead of using Arrays.toString(count), which creates a long string:

String key = Arrays.toString(count);
You can build a custom key manually, which is faster and uses less memory:

StringBuilder keyBuilder = new StringBuilder();
for (int freq : count) {
keyBuilder.append('#').append(freq); // '#' as delimiter
}
String key = keyBuilder.toString();