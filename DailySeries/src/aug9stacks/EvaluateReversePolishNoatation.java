package aug9stacks;

import java.util.Stack;

public class EvaluateReversePolishNoatation {
    class Solution {
        public int performOperation(String op,int num1,int num2){
            switch (op) {
                case "+": return num1 + num2;
                case "-": return num1 - num2;
                case "*": return num1 * num2;
                case "/": return num1 / num2;
            }
            return 0;
        }
        public boolean isOperator(String str){
            return (str.equals("+")|| str.equals("*") || str.equals("-") || str.equals("/"));
        }
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack=new Stack<>();
            for(String str:tokens){
                if(isOperator(str)){

                    int s1=stack.pop();
                    int s2=stack.pop();
                    stack.push(performOperation(str,s2,s1));
                }
                else{

                    stack.push(Integer.parseInt(str));
                }
            }

            return stack.pop();

        }
    }

    public static void main(String[] args) {

    }
}
