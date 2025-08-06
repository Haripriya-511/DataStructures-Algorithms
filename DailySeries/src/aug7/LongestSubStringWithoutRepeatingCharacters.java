package aug7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstringOptimal(String s) {
        int n=s.length();
        int longestLength=0;
        int l=0,r=0;
        Map<Character,Integer> map=new HashMap<>();

        while(r<n){
            if(map.containsKey(s.charAt(r))){
                int index=map.get(s.charAt(r));
                if(index>=l){
                    l=index+1;
                }
            }
            longestLength=Math.max(longestLength,r-l+1);
            map.put(s.charAt(r),r);
            r++;
        }
        return longestLength;
    }
    public int lengthOfLongestSubstringBrute(String s) {
        int n=s.length();
        int longestLength=0;
        for(int i=0;i<n;i++){
            int hash[]=new int[256];
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)]==1){
                    break;
                }
                hash[s.charAt(j)]=1;
                longestLength=Math.max(longestLength,j-i+1);

            }
        }
        return longestLength;
    }
    public int lengthOfLongestSubstringBruteII(String s) {
        int n=s.length();
        int longestLength=0;
        for(int i=0;i<n;i++){
            Set<Character> set=new HashSet<>();
            for(int j=i;j<n;j++){
                if(set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                longestLength=Math.max(longestLength,j-i+1);

            }
        }
        return longestLength;
    }
    public static void main(String[] args) {

    }
}
