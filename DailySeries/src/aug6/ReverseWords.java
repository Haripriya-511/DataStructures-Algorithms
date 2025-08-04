package aug6;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseWords {
    public static String reverseWords(String s) {
        String[] split=s.trim().split("\\s+");
        StringBuilder sb=new StringBuilder();
        for(int i=split.length-1;i>=0;i--){
            sb.append(split[i]);
            sb.append(" ");
        }
        return sb.toString();

    }
      public static String reverseWordsII(String s) {
          int n=s.length();
          int i=0;
          String res="";
          while(i<n){
              while(i<n && s.charAt(i)==' ')i++;
              if(i>=n)break;
              int j=i+1;
              while(j<n && s.charAt(j)!=' ') j++;
              if(res.length()==0)
                  res=s.substring(i,j);
              else
                  res=s.substring(i,j)+" "+res;
              i=j+1;
          }
          return res;

    }
    public static String reverseWordsIII(String s){
        int n=s.length();
        char ch[]=s.toCharArray();
        reverse(ch,0,n-1);
        int i=0,j=0;
        while(i<n){
            while(i<n && ch[i]==' ')i++;
            if(i>=n) break;
            if(j!=0) {
                ch[j++]=' ';
            }
            int start=j;

            while(i<n && ch[i]!=' '){
                ch[j++]=ch[i++];
            }
            reverse(ch,start,j-1);

        }
        return new String(ch,0,j);
    }

    private static void reverse(char[] ch, int i, int j) {
        while(i<j){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            i++;
            j--;
        }
    }



    public static void main(String[] args) {

        String s = "  hello world  ";

        System.out.println(reverseWords(s));

        System.out.println(reverseWordsII(s));

        System.out.println(reverseWordsIII(s));
    }
}
