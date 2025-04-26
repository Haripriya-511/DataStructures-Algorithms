package stacks.conversion;

import java.util.Stack;

public class InfixtoPrefix {
    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    static int precedence(char c) {
        if (c == '+' || c == '-') return 1;
        else if (c == '*' || c == '/') return 2;
        else if (c == '^') return 3;
        return -1;
    }
    public static String infixToPrefix(String infix) {
        StringBuilder input = new StringBuilder(infix);
        input.reverse();
        char[] chars = input.toString().toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i]=='(' ) chars[i]=')';
            else if(chars[i]==')') chars[i]='(';

    }
        Stack<Character> stack=new Stack<>();
        StringBuilder res=new StringBuilder();
        for(char c:chars){
            if(Character.isLetterOrDigit(c))
                res.append(c);
            else if(c=='(')
                stack.push('(');
            else if(c==')'){
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res.append(stack.pop());
                }
                stack.pop();
            }
            else if (isOperator(c)) {
                while (!stack.isEmpty() && precedence(c) < precedence(stack.peek())) {
                    res.append(stack.pop());
                }
                stack.push(c);
            }

        }
        while(!stack.isEmpty())
            res.append(stack.pop());
        return  res.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "(a-b/c)*(a/k-l)";
        System.out.println(infixToPrefix(s));
    }
}
