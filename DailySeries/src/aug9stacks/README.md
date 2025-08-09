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

