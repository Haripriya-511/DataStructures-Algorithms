import java.util.Arrays;

public class Problem3 {
    public static void main(String[] args) {

    }
    //brute force using sorting

    int searchBrute1(String pat, String txt) {
        int k = pat.length();
        int n = txt.length();
        int cnt = 0;
        int freqP[] = new int[26];
        char[] patArr = pat.toCharArray();
        Arrays.sort(patArr);

        for (int i = 0; i <= (n - k); i++) {
            String sub = txt.substring(i, i + k);
            char subArr[] = sub.toCharArray();
            Arrays.sort(subArr);
            if (Arrays.equals(subArr, patArr))
                cnt++;
        }
        return cnt;
    }

    // brute force using frequency array
    int searchBetter(String pat, String txt) {
        int n1 = pat.length();
        int n2 = txt.length();
        int cnt = 0;
        int freqP[] = new int[26];
        for (int i = 0; i < n1; i++) {
            freqP[pat.charAt(i) - 'a']++;
        }

        for (int i = 0; i <= (n2 - n1); i++) {
            int hash[] = new int[26];
            for (int j = i; j < (i + n1); j++) {
                hash[txt.charAt(j) - 'a']++;
            }
            if (isSame(hash, freqP)) cnt++;

        }
        return cnt;
    }


    boolean isSame(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
