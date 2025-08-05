package day6;

public class ValidPaindrome {
    public boolean isPalindromeOptimal(String s) {
        int n=s.length();
        int l=0;
        int r=n-1;
        while(l<r){
            while(l<r &&!isAlphaNumeric(s.charAt(l)) )
                l++;
            while(l<r &&!isAlphaNumeric(s.charAt(r)) )
                r--;
            if(Character.toLowerCase(s.charAt(l))!=Character.toLowerCase(s.charAt(r)))
                return false;
            l++;
            r--;

        }
        return true;
    }
    public boolean isAlphaNumeric(char ch){
        return((ch>= 'A' && ch<='Z') ||
                (ch>='a' && ch<='z')||
                (ch >='0' && ch<='9'));

    }
    public static boolean isPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch))
                sb.append(Character.toLowerCase(ch));
        }
        return sb.toString().equals(sb.reverse().toString());
    }
        public static void main(String[] args) {
String str="race a car";
            System.out.println(isPalindrome(str));
    }
}
