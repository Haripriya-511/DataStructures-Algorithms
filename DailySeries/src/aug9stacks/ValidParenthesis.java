package aug9stacks;

import java.util.Stack;

public class ValidParenthesis {

        public boolean matchCheck(char ch1,char ch2){

            if(ch2=='{' && ch1=='}')
                return true;
            if(ch2=='(' && ch1==')')
                return true;
            if(ch2=='[' && ch1==']')
                return true;

            return false;

        }
        public boolean isValid(String s) {
            Stack<Character> stack=new Stack<>();
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(ch=='(' || ch=='{' || ch=='['){
                    stack.push(ch);
                }
                else{
                    if(!stack.isEmpty() ){
                        if(matchCheck(ch,stack.peek())){
                            stack.pop();
                        }
                        else
                            return false;
                    }
                    else{
                        return false;
                    }
                }
            }

            return stack.size()==0;
        }
    public boolean isValidBrute(String s) {
        while (s.contains("()") || s.contains("{}") || s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }
        return s.isEmpty();
    }


    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();

    }
}
