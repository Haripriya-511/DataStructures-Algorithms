package aug8;

import java.util.*;

public class MinimumWindowSubString {
    public static String minWindow(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if(n2==0) return "";
        if(n2>n1) return "";
        int l=0,r=0;
        int resLen=Integer.MAX_VALUE;
        Map<Character,Integer> mapT=new HashMap<>();
        for(char ch: t.toCharArray()){
            mapT.put(ch,mapT.getOrDefault(ch,0)+1);
        }
        for(int i=0;i<n1;i++){
            Map<Character,Integer> mapS=new HashMap<>();
            for(int j=i;j<n1;j++){
                mapS.put(s.charAt(j),mapS.getOrDefault(s.charAt(j),0)+1);
                boolean check=true;
                for(char ch:mapT.keySet()){
                    if(mapS.getOrDefault(ch,0)<mapT.get(ch)){
                        check=false;
                        break;
                    }
                }
                if(check && ((j-i+1)<resLen)){
                    resLen=j-i+1;
                    l=i;
                    r=j;

                }

            }
        }
        return resLen==Integer.MAX_VALUE? "": s.substring(l,r+1);
    }

    public static String minWindowOptimal
            (String s, String t) {
        if(s.isEmpty() || t.isEmpty()) return "";
        int n1=s.length();
        int n2=t.length();
        if(n2==0 || n1==0) return "";
        if(n2>n1) return "";
        int l=0,r=0;
       int minLen=Integer.MAX_VALUE;
       int sIndex=-1;
       int cnt=0;
       int tFreq[]=new int[256];
       for(char ch:t.toCharArray()){
           tFreq[ch]++;
       }
       while(r<n1){
        char ch=s.charAt(r);
        if(tFreq[ch]>0)
            cnt++;
        tFreq[ch]--;
        while(cnt==n2){
            if(r-l+1 < minLen){
                minLen=r-l+1;
                sIndex=l;
            }
            tFreq[s.charAt(l)]--;
            if(tFreq[s.charAt(l)]>0)
                cnt--;
            l++;

        }
        r++;

       }
       return sIndex==-1? "":s.substring(sIndex,sIndex+minLen);

    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC","ABC"));

    }
}
