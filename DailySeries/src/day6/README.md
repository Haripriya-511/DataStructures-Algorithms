🔹 Problem Statement:
Given an integer array nums, return an array output such that:


output[i] = product of all elements of nums except nums[i]
⛔ Division is not allowed in some variations (e.g., LeetCode 238), and we need to handle 0s carefully.

✅ Approach 1: Brute Force
📌 Code: productExceptSelf1

for each i in nums:
multiply all elements except nums[i]
⏱ Time: O(N²)
🧠 Space: O(1) (excluding result array)
✅ Pros:
Easy to implement

❌ Cons:
Very inefficient for large arrays

✅ Approach 2: With Division & Zero Handling
📌 Code: productExceptSelf2

- Count 0s in the array
- If zero count > 1, result is all zeros
- Else, calculate total product of non-zero elements
- For each element:
    - If zero exists and nums[i] == 0 → assign product
    - Else if zero exists → assign 0
    - Else → assign product / nums[i]
      ⏱ Time: O(N)
      🧠 Space: O(1) (excluding result array)
      ✅ Pros:
      Fastest when division is allowed

Handles 0s smartly

❌ Cons:
Division used

Cannot be used if division is disallowed

✅ Approach 3: Prefix & Suffix Arrays
📌 Code: productExceptSelf3

- prefix[i] = product of all nums[0..i-1]
- suffix[i] = product of all nums[i+1..n-1]
- result[i] = prefix[i] * suffix[i]
  ⏱ Time: O(N)
  🧠 Space: O(N) for prefix & suffix arrays
  ✅ Pros:
  No division

Handles 0s

Easy to understand step-by-step

❌ Cons:
Uses extra space (2 arrays)

✅ Approach 4: Optimal Space – Prefix in res[], Suffix via variable
📌 Code: productExceptSelf (final method)

1. res[i] = product of elements before i (prefix)
2. Then traverse from end and multiply res[i] *= postfix
3. Update postfix *= nums[i] while going backward
   ⏱ Time: O(N)
   🧠 Space: O(1) extra (excluding result)
   ✅ Pros:
   💯 Optimal: O(N) time & O(1) space

No division

Handles 0s naturally

❌ Cons:
Slightly tricky to understand at first

🧠 When to Use What:
Approach	Division	Zero Handling	Extra Space	Efficiency
Brute Force	❌	✅	❌	❌ (O(N²))
Division w/ 0s	✅	✅	❌	✅
Prefix + Suffix	❌	✅	✅ (O(N))	✅
Optimal (1 pass)	❌	✅	✅ (O(1))	✅✅✅

🔚 Final Notes:
Interviewers often disallow division — go with prefix/postfix method.

Always test edge cases:

[1,2,3,4]

[1,0,3,4]

[0,0,1,2]
