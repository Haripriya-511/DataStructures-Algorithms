package stacks.conversion;

import java.util.Stack;

public class PreToPost {
    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }
    static String preToPost(String pre_exp) {
        Stack<String> stack = new Stack<>();

        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch= pre_exp.charAt(i);
            if(isOperator(ch)){
                String op1= stack.pop();
                String op2=stack.pop();

                String temp=op1+op2+ch;
                stack.push(temp);
            }
            else{
                stack.push(ch+"");
            }
        }
        return stack.peek();


    }

    public static void main(String[] args) {
        String s="*-A/BC-/AKL";
        System.out.println(preToPost(s));
    }
}

