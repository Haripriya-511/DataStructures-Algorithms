package aug7;

import java.util.*;
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {

        int n=s.length();
        int res=0;
        for(int i=0;i<n;i++){
            Map<Character,Integer> map=new HashMap<>();
            int maxFreq=0;
            for(int j=i;j<n;j++){
                char ch=s.charAt(j);
                map.putIfAbsent(ch,0);
                map.put(ch,map.get(ch)+1);
                maxFreq=Math.max(maxFreq,map.get(ch));
                if(((j-i+1)-maxFreq)> k)
                    break;
                res=Math.max(res,j-i+1);
            }
        }
        return res;
    }
    public int characterReplacementOptimal1(String s, int k) {

        int n=s.length();
        int l=0,r=0;
        Map<Character,Integer> map=new HashMap<>();
        int maxFreq=0;
        int res=0;
        while(r<n){
            char ch=s.charAt(r);
            map.putIfAbsent(ch,0);
            map.put(ch,map.get(ch)+1);
            maxFreq=Math.max(maxFreq,map.get(ch));
            int subStringLen= (r-l+1);
            if(subStringLen-maxFreq>k){
                char toRemove=s.charAt(l);
                map.put(toRemove,map.get(toRemove)-1);
                l++;

            }
            res=Math.max(r-l+1,res);
            r++;
        }
        return res;
    }
    public int characterReplacementOptimalII(String s, int k) {

        int n=s.length();
        int l=0,r=0;
        int[] map = new int[26];
        int maxFreq=0;
        int res=0;
        while(r<n){
            char ch=s.charAt(r);
            map[ch-'A']++;
            maxFreq=Math.max(maxFreq,map[ch-'A']);
            int subStringLen= (r-l+1);
            if(subStringLen-maxFreq>k){
                char toRemove=s.charAt(l);
                map[toRemove-'A']--;
                l++;

            }
            res=Math.max(r-l+1,res);
            r++;
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
