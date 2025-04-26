package stacks.conversion;

import java.util.Stack;

public class PostToPrefix {
    static boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }
    static String postToPre(String post_exp) {
        Stack<String> st=new Stack<>();
        for(int i=0;i<post_exp.length();i++){
            char ch=post_exp.charAt(i);
            if(isOperator(ch)){
                String op2=st.pop();
                String op1=st.pop();
                String temp= ch+op1+op2;

                st.push(temp);
            }
            else{
                st.push(ch+"");
            }
        }
        return st.peek();

    }
}
