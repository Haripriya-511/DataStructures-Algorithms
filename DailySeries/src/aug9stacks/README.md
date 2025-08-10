Valid Parenthesis
-------------------------------------------

Easy way to remember the logic
Think of it like checking a matching pair from top of the stack:

If you see an opening bracket → push it onto the stack.

If you see a closing bracket →

Stack must not be empty. (if not return false)

The top of stack (last opening) must match this closing.

If matched → pop it. If not → return false.

--------------------------------------------

1. Brute Force (MinStackBrute)
   Idea: Store all elements in a stack.
   To get the min, pop all elements into a temp stack while tracking the smallest, then push them back.

Time Complexity:

push() / pop() / top() → O(1)

getMin() → O(n)

Space Complexity: O(n) for stack + temp stack during getMin().

When to use: Rarely. Only for teaching or very small datasets. Too slow for frequent getMin() calls.

2. Pair Stack (MinStack1)
   Idea: Each stack element is stored as (value, minSoFar).

This way, getMin() just looks at the second value of the top pair.

Time Complexity: All operations O(1).

Space Complexity: O(n) (store 2 integers per element).

Pros: Simple logic, easy to explain, handles negatives and large numbers without special handling.

Cons: Slightly more space per element (double storage).

3. Two Stacks (MinStack2)
   Idea:

Main stack: stores all values.

Min stack: stores current minimums. Push to min stack only when val <= currentMin.

Pop from min stack when the popped element equals the current min.

Time Complexity: O(1) for all operations.

Space Complexity: O(n) (min stack only stores elements that were mins at some point).

Pros: Saves some space vs pair stack in cases where min changes rarely.

Cons: Needs careful syncing between stacks.

4. Optimal Encoding (MinStackOptimal)
   Idea: Single stack + mini variable.

When pushing a new minimum, store an encoded value: encoded = 2*val - mini (in long).

This encodes both the value and the old min in one number, so we can recover old min during pop.

When popping an encoded value, decode to restore previous min.

Time Complexity: All O(1).

Space Complexity: O(n) but only one stack.

Pros: Saves one stack, very memory efficient.

Cons: Trickier to explain; requires careful handling of overflows (use long).

Interview Flow to Explain
Start with brute force to show baseline thinking.

Optimize to Pair Stack for O(1) getMin().

Show Two Stack approach for slightly better space in some cases.

Finish with Optimal Encoding to impress with space optimization and math trick.


--------------------------------------------------------------------------------
1. Restate the Problem Clearly
   You’re given an expression in postfix notation (operator comes after operands).

Example:

css
Copy
Edit
["2", "1", "+", "3", "*"]  
means: (2 + 1) * 3 = 9
You need to evaluate it.

2. Recognize the Pattern
   Postfix expressions don’t need parentheses to show precedence.

The most recent operands must be used first when you hit an operator.

This is Last-In-First-Out (LIFO) → a stack is perfect.

3. Why a Stack? (Interview Reasoning)
   As you read tokens left to right:

If it’s a number, push it on the stack.

If it’s an operator, you must:

Pop the last two numbers (because they are the ones this operator applies to).

Apply the operation (num1 op num2 — note order!).

Push the result back for future operations.

The stack automatically keeps track of operands in the right order and scope.

No need to manually manage indexes or precedence — the RPN format plus stack logic handles it naturally.

Analogy:
Think of it like a plate stack in a cafeteria:

New numbers get stacked on top.

When you need to apply an operator, you take the top two plates (latest numbers), combine them into one (the result), and put it back.

4. Step-by-Step Example
   For:

ini
Copy
Edit
tokens = ["2", "1", "+", "3", "*"]
Token	Action	Stack
"2"	push 2	[2]
"1"	push 1	[2, 1]
"+"	pop 1, pop 2 → 2+1=3 → push 3	[3]
"3"	push 3	[3, 3]
"*"	pop 3, pop 3 → 3*3=9 → push 9	[9]

Final answer: 9

5. Time & Space Complexity
   Time: O(n) — one pass over tokens.

Space: O(n) in worst case (all numbers before any operator).

6. Short Interview Script
   "We can solve this using a stack because postfix notation naturally processes the most recent operands first, which matches LIFO behavior.
   As we read tokens, we push numbers onto the stack. When we see an operator, we pop the last two numbers, apply the operator, and push the result back.
   This continues until we’ve processed all tokens, leaving one result in the stack."
------------------------------------------------------------------
Approach: Backtracking (DFS with pruning)
1. Core Idea

Build the string step-by-step.

At each step, you can add:

"(" if you still have unused left parentheses.

")" if the number of ")" so far is less than "(" (ensures validity).

Stop when the string length reaches 2 * n.

2. Why Backtracking Works Best

Pruning early: We never generate invalid sequences (like ")("), so we avoid wasted work.

Natural recursion tree: Fits the problem’s combinatorial nature.

Catalan number growth: Output size = C(n) = (1 / (n+1)) * (2n choose n).

3. Steps

Start with open = 0, close = 0, str = "".

At each recursive call:

If open < n → add "(".

If close < open → add ")".

When (open + close) == 2n, add to result.

4. Complexity

Time: O(C(n)) where C(n) is the n-th Catalan number ≈ 4^n / (n^(3/2) * sqrt(pi)).

Space: O(n) for recursion depth (plus output storage).

5. Why Interviewers Like This

Shows understanding of recursion + pruning.

No extra validation needed — correctness is built into the recursion logic.

Easily extendable to variations (like generating other balanced symbol sequences).

6. Pseudocode

generate(open, close, str):
if length == 2 * n:
add str to result
return
if open < n:
generate(open+1, close, str + "(")
if close < open:
generate(open, close+1, str + ")")

