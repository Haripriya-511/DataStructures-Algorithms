package stacks;

import java.util.*;
/*
Every opening bracket must have a corresponding closing bracket and vice versa.
Example: "(){}" is valid but "(]{}" is invalid.
The order of opening brackets must follow the order to closing brackets.
Example: "([{}])" is valid but "({[}])" is invalid.

In order to find whether a paranthesis is matching or not, we need to know what was the last opened paranthesis for every closing paranthesis found.
Example: If a ')' (closing paranthesis) is found, the last opened paranthesis must be '(', then only the paranthesis will be matched, otherwise it's a mismatch.

Now, in order to find the last opened paranthesis first, a data structure like stack will be helpful.
The stack will store opening brackets (i.e., '(' or '[' or '{') to maintain them in LIFO order. The following operations will be performed:
For every opening bracket found, it must be pushed on top of the stack.
For every closing bracket found, the last opened bracket (top element of the stack) can be taken out. Now there can be the following cases:
Match: If the opening bracket found matches with the closing bracket.
Mismatch: If the opening bracket found does not match with the closing bracket. This leads to an unbalanced paranthesis.
If all the paranthesis are matched, the given pair of paranthesis is valid otherwise it is not valid.
Edge Cases:
What if there is no top element in stack when a closing bracket is found?
This will happen for strings like "()]", where there is no opening bracket to compare with the ']' bracket. In such cases, the parantheis will be invalid.
 */
public class BalancedParanthesis {
    public static boolean isValid(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) return false; // unmatched closing

                char top = stack.peek();
                if ((ch == ')' && top == '(') ||
                        (ch == '}' && top == '{') ||
                        (ch == ']' && top == '[')) {
                    stack.pop();
                } else {
                    return false; // mismatch
                }
            }
        }

        return stack.isEmpty();


    }

    public static void main(String[] args) {
boolean isBalanced=isValid("[[[[]]]]{})");
        System.out.println(isBalanced);
    }
}
