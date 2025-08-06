package aug7;

import java.util.Arrays;

public class PermutationInString {
    public String sortString(String s){
        char[] ch=s.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }
    public boolean checkInclusion(String s1, String s2) {
        s1=sortString(s1);
        int n1=s1.length();
        int n2=s2.length();
        if(n1>n2) return false;
        for(int i=0;i<=(n2-n1);i++){

            String subString=s2.substring(i,i+n1);
            subString=sortString(subString);
            if(subString.equals(s1))
                return true;
        }
        return false;
    }
    public boolean compare(int freq1[],int freq2[]){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusionOptimal(String s1, String s2) {

        int n1=s1.length();
        int n2=s2.length();
        if(n1>n2) return false;
        int freq1[]=new int[26];
        for(int i=0;i<n1;i++){
            freq1[s1.charAt(i)-'a']++;
        }

        int freq2[]=new int[26];
        for(int i=0;i<n1;i++){
            freq2[s2.charAt(i)-'a']++;
        }
        if(compare(freq1,freq2))
            return true;
        int l=0;int r=n1-1;
        while(r<n2-1){

            freq2[s2.charAt(l)-'a']--;
            l++;
            r++;

            freq2[s2.charAt(r)-'a']++;
            if(compare(freq1,freq2))
                return true;
        }

        return false;
    }
    public boolean checkInclusionOptimaII(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        if (n1 > n2) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Fill freq1 with s1's character counts
        for (int i = 0; i < n1; i++) {
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) {
                matches++;
            }
        }

        int l = 0;
        int r = n1;

        while (r < n2) {
            if (matches == 26) return true;

            // Add new character on the right
            int idxRight = s2.charAt(r) - 'a';
            freq2[idxRight]++;
            if (freq2[idxRight] == freq1[idxRight]) {
                matches++;
            } else if (freq2[idxRight] - 1 == freq1[idxRight]) {
                matches--;
            }

            // Remove old character on the left
            int idxLeft = s2.charAt(l) - 'a';
            freq2[idxLeft]--;
            if (freq2[idxLeft] == freq1[idxLeft]) {
                matches++;
            } else if (freq2[idxLeft] + 1 == freq1[idxLeft]) {
                matches--;
            }

            l++;
            r++;
        }

        return matches == 26;
    }
    public static void main(String[] args) {

    }
}
