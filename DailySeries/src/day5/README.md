## ✅ Problem Statement1:
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:
✅ 1. Brute Force (3 HashSet per check)
🔸 Idea:
Validate each row, column, and 3x3 box separately.

Use a HashSet<Character> to check for duplicates.

🔸 Logic:
validateRow: Check if a row has duplicates (ignoring '.').

validateCol: Same for column.

validateBox: Check each 3×3 grid using top-left index and nested loops.

🔸 Time Complexity:
O(81) = O(1) (since board is always 9×9).

🔸 Space Complexity:
O(9) per function call × 3 (set for row, column, box) = still O(1) overall.

Each call resets the set.

✅ 2. Optimized One-Pass (27 HashSets)
🔸 Idea:
Traverse the board once.

Maintain 3 arrays of HashSet<Character> for:

Rows (9 sets)

Columns (9 sets)

Boxes (9 sets)

🔸 Box Index Formula:

boxIndex = (i / 3) * 3 + (j / 3)
Divides board into 9 regions (top-left box = 0, bottom-right = 8).

🔸 Logic:
If a digit already exists in any of the corresponding sets → invalid.

Otherwise, insert digit in respective row, col, and box sets.

🔸 Time Complexity:
O(81) = O(1)

🔸 Space Complexity:
O(27) sets → O(1) because it's fixed size.

✅ 3. Optimal Using Bitmasking
🔸 Idea:
Replace HashSets with int[] arrays.

Use bitmasking to track digits efficiently.

🔸 How it works:
Each int represents presence of digits 1-9 using bits 0-8.

For a digit d, compute mask = 1 << (d - 1)

Check if bit is already set using rows[i] & mask

Set the bit using rows[i] |= mask

🔸 Box Index:

boxIndex = (i / 3) * 3 + (j / 3)
🔸 Example:
Digit 5 → digit = 4 → mask = 1 << 4 = 0b00010000

If row[i] & mask != 0, digit already exists.

🔸 Time Complexity:
O(1)

🔸 Space Complexity:
3 arrays of size 9 → total O(1) space

✅ Advantage:
Fastest and most memory-efficient approach.

Avoids HashSet overhead.


| Approach         | Passes | Space Used         | Time | Optimized For      |
| ---------------- | ------ | ------------------ | ---- | ------------------ |
| Brute Force      | 3-pass | 1 HashSet each run | O(1) | Simplicity         |
| One-Pass HashSet | 1-pass | 27 HashSets        | O(1) | Cleaner and faster |
| Bitmasking       | 1-pass | 3 `int[]` arrays   | O(1) | Best performance   |

