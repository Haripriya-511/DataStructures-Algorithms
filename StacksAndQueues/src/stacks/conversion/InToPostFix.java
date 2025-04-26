package stacks.conversion;

import java.util.Stack;

public class InToPostFix {

    public static int precedence(char ch){
        if(ch=='^')
            return 3;
        if(ch=='/' || ch=='*')
            return 2;
        if(ch=='+' || ch=='-')
            return 1;

        return -1;
    }
    public static String infixToPostfix(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){

            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch))
                result.append(ch);

            else if(ch=='(')
                stack.push(ch);

            else if(ch==')')
            {
                while(!stack.isEmpty() && stack.peek()!='(')
                    result.append(stack.pop());

                stack.pop();

            }
            else{
                while(!stack.isEmpty() && precedence(ch) <= precedence(stack.peek()))
                    result.append(stack.pop());

                stack.push(ch);

            }
        }
        while(!stack.isEmpty())
            result.append(stack.pop());
        return result.toString();

    }

    public static void main(String[] args) {
        String s="a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(s));
    }
}
