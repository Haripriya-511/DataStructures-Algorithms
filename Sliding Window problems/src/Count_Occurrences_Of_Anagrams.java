/*
Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.

Example 1:
Input: txt = "forxxorfxdofr", pat = "for"
Output: 3
Explanation: for, orf and ofr appears in the txt, hence answer is 3.
--------------------------------------------------------------------
Example 2:
Input: txt = "aabaabaa", pat = "aaba"
Output: 4
Explanation: aaba is present 4 times in txt.
 */

public class Count_Occurrences_Of_Anagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr", pat = "for";
        System.out.println("Brute Force:" + searchBrute(txt, pat));

        System.out.println("Optimal :" + searchOptimal(txt, pat));
    }

    static boolean check(int hash[], String pat) {
        for (int i = 0; i < pat.length(); i++) {
            if (hash[pat.charAt(i) - 'a'] != 0)
                return false;
        }
        return true;
    }

    // optimal approach
    static int searchOptimal(String txt, String pat) {
        int l = 0, r = 0;
        int n = txt.length();
        int k = pat.length();
        int hash[] = new int[26];
        for (int i = 0; i < k; i++) {
            hash[pat.charAt(i) - 'a']++;
        }
        int cnt = 0;
        while (r < n) {
            hash[txt.charAt(r) - 'a']--;
            if ((r - l + 1) == k) {
                if (check(hash, pat))
                    cnt++;
                hash[txt.charAt(l) - 'a']++;
                l++;

            }

            r++;

        }
        return cnt;
    }

    //brute force
    static int searchBrute(String txt, String pat) {
        // code here
        int count = 0;

        int k = pat.length();
        int n = txt.length();
        for (int i = 0; i <= (n - k); i++) {
            int hash[] = new int[26];
            for (int l = 0; l < k; l++) {
                hash[pat.charAt(l) - 'a']++;
            }
            int cnt = 0;
            for (int j = i; j < (i + k); j++) {
                if (hash[txt.charAt(j) - 'a'] > 0) {
                    cnt++;
                    hash[txt.charAt(j) - 'a']--;
                }

            }
            if (cnt == k)
                count++;
        }
        return count;
    }
}
