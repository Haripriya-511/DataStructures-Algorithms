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
-------------------------------------------------------------
✅ threeSumI – Brute Force Approach
🔍 Approach:
Use 3 nested loops to check all combinations of triplets.

For each triplet (i, j, k), check if nums[i] + nums[j] + nums[k] == 0.

Sort and add triplet to a Set to avoid duplicates.

⏱️ Time Complexity:
O(n³) — 3 nested loops

🧠 Space Complexity:
O(k) — number of unique triplets stored in the set

✅ Pros:
Simple to write and understand

❌ Cons:
Very slow for large inputs

Not suitable for real interviews

✅ threeSumII – HashSet + Two Loops
🔍 Approach:
Fix the first number (nums[i])

Use a HashSet to find the complement (target = - (nums[i] + nums[j]))

For each pair, check if third number (target) exists in set

Sort and store triplets in a Set to remove duplicates

⏱️ Time Complexity:
O(n²) — outer loop + inner loop + HashSet lookups

🧠 Space Complexity:
O(n + k) — for HashSet and result set

✅ Pros:
Much better than brute force

No need to sort input array

❌ Cons:
Still uses extra space (set and sorting)

Slightly more overhead due to sorting each triplet

✅ threeSumIII – Optimal 2-Pointer Approach (on Sorted Array)
🔍 Approach:
Sort the array first

Fix one element (nums[i])

Use two pointers j and k to find the remaining pair

Move pointers based on whether sum is < 0 or > 0

Skip duplicates using conditions:

if(i > 0 && nums[i] == nums[i-1]) continue;

while(j < k && nums[j] == nums[j-1]) j++; etc.

⏱️ Time Complexity:
O(n²) — due to nested loop and two-pointer search

🧠 Space Complexity:
O(k) — only for storing result triplets

✅ Pros:
Most efficient in practice

No need for extra sets

Very interview-friendly

❌ Cons:
Requires sorting the input

Needs extra logic to skip duplicates

📊 Summary Table
Version	Approach	Time	Space	Duplicates Handled By
threeSumI	Brute force (3 loops)	O(n³)	O(k)	Sort + Set
threeSumII	HashSet-based 2Sum	O(n²)	O(n + k)	Sort + Set
threeSumIII	Two-pointer after sorting	O(n²)	O(k)	Skip logic

------------------------------------------------------------------------------
Trapping Rain water
🔹 Problem Statement:
Given an array height[] representing elevation map, compute how much water it can trap after raining.

Example:
makefile
Copy
Edit
Input:  height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
✅ Idea:
At every index i, the water it can trap is determined by:


water_at_i = min(maxLeft[i], maxRight[i]) - height[i]
Where:

maxLeft[i] = highest bar to the left of index i

maxRight[i] = highest bar to the right of index i

Only if water_at_i > 0, it contributes to total water.

🧠 Approach 1: Brute Force – trapI(int[] height)
🔍 Logic:
For each index i, calculate:

maxLeft: maximum height on the left of i

maxRight: maximum height on the right of i

Compute trapped water using the formula

⏱️ Time Complexity:
O(n²) — for each element, linear scan left and right

🧠 Space Complexity:
O(1) — no extra space used

✅ Pros:
Easy to understand

❌ Cons:
Inefficient for large arrays due to repeated computation

🧠 Approach 2: Prefix Arrays – trapII(int[] height)
🔍 Logic:
Precompute:

maxLeft[i]: max height to the left of each index

maxRight[i]: max height to the right of each index

Then use formula:
water += min(maxLeft[i], maxRight[i]) - height[i]

⏱️ Time Complexity:
O(n) — 3 passes: maxLeft, maxRight, and final sum

🧠 Space Complexity:
O(n) — two auxiliary arrays

✅ Pros:
Much faster than brute force

Easy to implement

❌ Cons:
Extra space required for maxLeft[] and maxRight[]

📊 Summary Table:
Approach	Description	Time	Space	Key Idea
trapI	Brute force	O(n²)	O(1)	For each i, scan left and right
trapII	Prefix max arrays	O(n)	O(n)	Precompute maxLeft and maxRight

Intuition:
To trap water at any position i, you need:


water[i] = min(maxLeft[i], maxRight[i]) - height[i]
Instead of precomputing maxLeft[] and maxRight[] arrays like in the prefix array approach, we use two pointers and update leftMax and rightMax on the fly to avoid extra space.

🎯 Step-by-Step Explanation:
📌 Initialization:

int l = 0, r = n - 1;
int leftMax = height[l], rightMax = height[r];
int res = 0;
l points to start of array, r to end.

leftMax is the tallest bar seen so far from the left

rightMax is the tallest bar seen so far from the right

res is the total trapped water

🔁 While Loop Logic:
Case 1: leftMax < rightMax
If the left side is shorter:

Then the max height to the left is the limiting factor.

So we move l++ and try to trap water at that new position.

l++;
leftMax = Math.max(leftMax, height[l]);
res += leftMax - height[l];
✅ leftMax - height[l] = how much water we can trap at l.

Case 2: rightMax <= leftMax
If the right side is shorter (or equal):

Then the max height to the right is the limiting factor.

So we move r-- and try to trap water at that new position.


r--;
rightMax = Math.max(rightMax, height[r]);
res += rightMax - height[r];
✅ rightMax - height[r] = water trapped at r.

❗ Why it works:
Always move the shorter boundary, because:

The water trapped at a point depends on the shorter of the two sides.

If left is smaller, the water is bounded by leftMax and we are safe to move l.

Similarly for right.

📊 Time and Space Complexity
Metric	Value
Time	O(n)
Space	O(1) – optimal ✅
Stable for large inputs	✅ Yes

✅ Dry Run Example
Input:


height = [0,1,0,2,1,0,1,3,2,1,2,1]
Initial:
l=0, r=11

leftMax = 0, rightMax = 1

Loop runs until l < r:

leftMax < rightMax → move l

l = 1 → height[1] = 1 → leftMax = max(0, 1) = 1

Water trapped = 1 - 1 = 0

Next:

l = 2 → height[2] = 0 → leftMax = 1

Water trapped = 1 - 0 = 1

And so on... accumulating trapped water.

📝 Summary:
Component	Meaning
leftMax	Max height from 0 to l
rightMax	Max height from r to n-1
leftMax < rightMax	Water depends on left, so move l++
rightMax <= leftMax	Water depends on right, so move r--
res += maxBound - height[i]	Actual trapped water at each step