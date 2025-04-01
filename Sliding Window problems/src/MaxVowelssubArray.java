/*
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.



Example 1:

Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
Example 2:

Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
 */


public class MaxVowelssubArray {
    public static void main(String[] args) {
        String s = "abciiidef";
        int k = 3;
        System.out.println("Brute:" + maxVowelsBrute(s, k));
        System.out.println("Optimal:" + maxVowelsOptimal(s, k));
    }

    public static int maxVowelsOptimal(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int maxValue = 0;
        int l = 0, r = 0;

        while (r < n) {
            if (s.charAt(r) == 'a' || s.charAt(r) == 'e' || s.charAt(r) == 'i' ||
                    s.charAt(r) == 'o' || s.charAt(r) == 'u') {
                cnt++;
            }

            if ((r - l + 1) == k) {
                maxValue = Math.max(maxValue, cnt);
                if (s.charAt(l) == 'a' || s.charAt(l) == 'e' || s.charAt(l) == 'i' ||
                        s.charAt(l) == 'o' || s.charAt(l) == 'u') {
                    cnt--;
                }
                l++;

            }
            r++;
        }

        return maxValue;


    }

    public static int maxVowelsBrute(String s, int k) {
        int n = s.length();
        int count = 0;
        int maxValue = 0;
        for (int i = 0; i <= (n - k); i++) {
            int cnt = 0;
            for (int j = i; j < (i + k); j++) {
                if (s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' ||
                        s.charAt(j) == 'o' || s.charAt(j) == 'u') {
                    cnt++;
                }

                maxValue = Math.max(maxValue, cnt);

            }
        }
        return maxValue;


    }
}
