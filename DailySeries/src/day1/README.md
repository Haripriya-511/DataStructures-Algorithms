## ✅ Problem Statement1:
Given an array of integers `numbers[]` and an integer `target`, return the **indices of two numbers** such that they add up to the target.

> Return an empty array `[]` if no such pair exists.

---

## 🔍 Example
Input: `arr = [3, 4, 5, 6]`, `target = 7`  
Output: `[0, 1]` because `arr[0] + arr[1] = 3 + 4 = 7`

---

## 🧠 Approaches Implemented

### 1. `twoSumBrute(int[] numbers, int target)`

#### 💡 Logic:
- Loop through every pair `(i, j)` where `j > i`.
- Check if `numbers[i] + numbers[j] == target`.
- Return indices as soon as match is found.

#### ⏱️ Time Complexity:
- O(n²) — Nested loop checks all pairs
- O(1) — Space

#### ✅ Use When:
- Input size is small
- Simplicity > performance

---

### 2. `twoSumOptimalI(int[] numbers, int target)`

#### 💡 Logic:
- First pass: Store all values in a HashMap `{value → index}`
- Second pass: For each element, compute `target - numbers[i]` (the difference).
- Check if that difference exists in the map and is **not the same index**.

#### ⏱️ Time Complexity:
- O(n) — Two linear passes
- O(n) — Space for the HashMap

#### ⚠️ Notes:
- May return wrong index ordering (e.g., `[1, 0]` instead of `[0, 1]`)

---

### 3. `twoSumOptimalII(int[] numbers, int target)`

#### 💡 Logic:
- Single-pass optimized HashMap approach.
- For each element:
    - Check if its complement (`target - numbers[i]`) already exists in the map.
    - If yes, return the stored index and current index.
    - If not, store the current element in the map.

#### ⏱️ Time Complexity:
- O(n) — Single pass
- O(n) — Space

#### ✅ Use When:
- You want the fastest and cleanest solution.
- You want to return the **first pair** that matches.

#### ⚠️ Notes:
- May return wrong index ordering (e.g., `[1, 0]` instead of `[0, 1]`)


--------------------------------------------------------------------------
## ✅ Problem Statement2:

🧩 Statement:
Given an array height[] of positive integers, where each value represents the height of a vertical line drawn at that index, find two lines that, together with the x-axis, can form a container that holds the maximum amount of water.

🧮 Area Between Two Lines:
If you pick two lines at index i and j (i < j), the area (water the container holds) is:

Area = min(height[i], height[j]) * (j - i)

min(height[i], height[j]): The container is limited by the shorter line — water will overflow from it.

j - i: The width between the two lines.

📊 Example
Input:

height = [1,8,6,2,5,4,8,3,7]
Visualizing the heights:

Index:   0 1 2 3 4 5 6 7 8
Height:  1 8 6 2 5 4 8 3 7
Answer:
Max water can be held between lines at index 1 and 8:

min(8, 7) * (8 - 1) = 7 * 7 = 49
🧠 Core Ideas
We want the maximum area.

For any two lines i and j, the area depends on shorter line and the distance between them.

💻 Implementation Breakdown
🔸 1. Brute Force Approach

✅ How It Works:
Try every combination of two lines (i and j)

Calculate the area

Track the maximum area

⏱ Time Complexity:
O(n²) → Very slow for large arrays

🧠 Space Complexity:
O(1) → No extra space used

🔹 2. Optimal Two-Pointer Approach


✅ How It Works:
Start with two pointers:

l at the beginning

r at the end

In each step:

Compute area between height[l] and height[r]

Move the pointer that has the shorter line inward

Why? Because to potentially increase area, we need higher height, not just wider width.

🔍 Why Move the Smaller Line?
If you keep the smaller height and reduce the width (move other pointer), area will never increase. So we only move the smaller one to try finding a taller line.

⏱ Time Complexity:
O(n) → Each element is visited at most once

🧠 Space Complexity:
O(1) → No extra memory used

🖼️ Dry Run (Visual)
For input:

height = [1,8,6,2,5,4,8,3,7]
Step-by-step (only key steps):

l=0, r=8 → min(1,7)=1 → area=8 → water=8

l=1, r=8 → min(8,7)=7 → area=49 → ✅ max

Try shrinking pointers:

Height at l=1 is taller → move r--

Keep checking and updating water

No future pair has larger area than 49
