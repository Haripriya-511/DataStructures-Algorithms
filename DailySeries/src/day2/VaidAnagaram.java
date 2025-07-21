package day2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class VaidAnagaram {
    public static boolean isAnagra1m(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2)
            return false;
        char ch1[]=s.toCharArray();
        Arrays.sort(ch1);
        char ch2[]=t.toCharArray();
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
    public static boolean isAnagram2(String s,String t){
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2)
            return false;
        Map<Character,Integer> map1=new HashMap<>();
        Map<Character,Integer> map2=new HashMap<>();
        for(int i=0;i<n1;i++){
            map1.put(s.charAt(i),map1.getOrDefault(s.charAt(i),0)+1);
            map2.put(t.charAt(i),map2.getOrDefault(t.charAt(i),0)+1);
        }
        return map1.equals(map2);
    }
    public static boolean isAnagram3(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2)
            return false;
        int hash[]=new int[26];
        for(int i=0;i<n1;i++){
            hash[s.charAt(i)-'a']++;
            hash[t.charAt(i)-'a']--;
        }
        for(int i:hash)
        {
            if(i!=0)
                return false;
        }
        return true;
    }
    public static boolean isAnagram4(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
            countMap.put(t.charAt(i), countMap.getOrDefault(t.charAt(i), 0) - 1);
        }
        for (int count : countMap.values()) {
            if (count != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagra1m("nagaram","anagram"));
        System.out.println(isAnagram2("nagaram","anagram"));
        System.out.println(isAnagram3("nagaram","anagram"));
        System.out.println(isAnagram4("nagaram","anagram"));
    }
}
