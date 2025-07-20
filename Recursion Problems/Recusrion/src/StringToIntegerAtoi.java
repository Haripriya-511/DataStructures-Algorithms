public class StringToIntegerAtoi {
        public static int myAtoi(String str) {
            int i=0;
            int n=str.length();
            int sign=1;
            long result=0;
            while(i<n && Character.isWhitespace(str.charAt(i)))
                i++;

            if (i < n) {
                char ch = str.charAt(i);
                if (ch == '+') {
                    sign = 1;
                    i++;
                } else if (ch == '-') {
                    sign = -1;
                    i++;
                }
            }
            while (i < n && Character.isDigit(str.charAt(i))){
                int digit = str.charAt(i) - '0';
                result = result * 10 + digit;

                if (sign == 1 && result > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (sign == -1 && -result < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                i++;
            }
            return (int) (sign * result);



        }
    public  static int myAtoiRecusrsive(String str) {
        return parse(str,0,0L,1,false,false);
    }
    public static int parse(String s,int i,long result,int sign,
                     boolean signProcesssed,boolean numberStarted){
        if(i>=s.length()) return (int) (sign*result);

        char ch=s.charAt(i);

        if(!signProcesssed && !numberStarted && ch==' ')
            return parse(s,i+1,result,sign,signProcesssed,numberStarted);

        if(!signProcesssed && !numberStarted && (ch=='-' || ch=='+'))
        {
            sign= (ch=='-')? -1:1;
            return parse(s,i+1,result,sign,true,numberStarted);
        }
        if(Character.isDigit(ch)){
            int digit= ch-'0';
            result= result*10+digit;
            if(sign==1 && result>Integer.MAX_VALUE)return Integer.MAX_VALUE;
            if(sign==-1 && -result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
            return parse(s,i+1,result,sign,true,true);
        }
        return (int)(sign*result);
    }
    public static void main(String[] args) {
        String str="42";
        System.out.println(myAtoi(str));
        System.out.println(myAtoiRecusrsive(str));

    }
}
