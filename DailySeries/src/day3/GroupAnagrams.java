package day3;

import java.sql.SQLException;
import java.util.*;

public class GroupAnagrams {
    public static List<List<String>> groupAnagramsWithSorting(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        int n=strs.length;
        for (int i=0;i<n;i++){
        char ch[]=strs[i].toCharArray();
        Arrays.sort(ch);
        String sorted = new String(ch);
        map.putIfAbsent(sorted,new ArrayList<>());
        map.get(sorted).add(strs[i]);
        }

        return new ArrayList<>(map.values());

    }
    public static List<List<String>> groupAnagramsWithoutSorting(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        int n=strs.length;
        for (int i=0;i<n;i++){
            int []count=new int[26];
            for(char c: strs[i].toCharArray()){
                count[c-'a']++;
            }
            String key=Arrays.toString(count);
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }

        return new ArrayList<>(map.values());

    }
    public static List<List<String>> groupAnagramsWithoutSorting2(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        int n=strs.length;
        for (int i=0;i<n;i++){
            int []count=new int[26];
            for(char c: strs[i].toCharArray()){
                count[c-'a']++;
            }
            StringBuilder keyBuilder = new StringBuilder();
            for (int freq : count) {
                keyBuilder.append('#').append(freq);
            }
            String key = keyBuilder.toString();
            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(strs[i]);
        }


        return new ArrayList<>(map.values());

    }

    public static void main(String[] args) {
        String strs[]=new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagramsWithoutSorting(strs));
        System.out.println(groupAnagramsWithSorting(strs));
        System.out.println(groupAnagramsWithoutSorting2(strs));

    }
}
