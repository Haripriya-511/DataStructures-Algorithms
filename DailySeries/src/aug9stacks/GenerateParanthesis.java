package aug9stacks;

import java.util.*;

public class GenerateParanthesis {
    public static void generate(List<String> result, int open, int close, String str, int n){
        if((open+close)==2*n)
        {
            result.add(str);
            return;
        }
        if(open<n)
            generate(result,open+1,close,str+"(",n);
        if(close<open)
            generate(result,open,close+1,str+")",n);
    }
    public static List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generate(result,0,0,"",n);
        return result;

    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(9));
    }
}
