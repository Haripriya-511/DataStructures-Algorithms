package stacks.conversion;

import java.util.Stack;

public class PostToInfix {
    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }
    static String postToInfix(String exp) {
        Stack<String> stack = new Stack<>();

        for(int i=0; i<exp.length();i++){
            char ch= exp.charAt(i);
            if(isOperator(ch)){
                String op2= stack.pop();
                String op1=stack.pop();

                String temp="("+op1+ch+op2+")";
                stack.push(temp);
            }
            else{
                stack.push(ch+"");
            }
        }
        return stack.peek();


    }
}
