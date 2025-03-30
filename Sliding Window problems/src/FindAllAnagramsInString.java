import java.util.ArrayList;
import java.util.List;

/*
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.


 */
public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String txt = "cbaebabacd", pat = "abc";
        System.out.println("Brute Force:" + findAllAnagramsBrute(txt, pat));

        System.out.println("Optimal :" + findAllAnagramsOptimal(txt, pat));
    }

    public static List<Integer> findAllAnagramsBrute(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int l = 0, r = 0;
        int n = s.length();
        int k = p.length();
        int hash[] = new int[26];
        for (int i = 0; i < k; i++) {
            hash[p.charAt(i) - 'a']++;
        }
        int cnt = 0;
        while (r < n) {
            hash[s.charAt(r) - 'a']--;
            if ((r - l + 1) == k) {
                if (check(hash, p))
                    list.add(l);
                hash[s.charAt(l) - 'a']++;
                l++;
            }
            r++;

        }
        return list;

    }

    public static boolean check(int hash[], String pat) {
        for (int i = 0; i < pat.length(); i++) {
            if (hash[pat.charAt(i) - 'a'] != 0)
                return false;
        }
        return true;
    }

    public static List<Integer> findAllAnagramsOptimal(String s, String p) {
        List<Integer> list = new ArrayList<>();

        int k = p.length();
        int n = s.length();
        for (int i = 0; i <= (n - k); i++) {
            int hash[] = new int[26];
            for (int l = 0; l < k; l++) {
                hash[p.charAt(l) - 'a']++;
            }
            int cnt = 0;
            for (int j = i; j < (i + k); j++) {
                if (hash[s.charAt(j) - 'a'] > 0) {
                    cnt++;
                    hash[s.charAt(j) - 'a']--;
                }

            }
            if (cnt == k) {
                list.add(i);
            }
        }
        return list;
    }
}
