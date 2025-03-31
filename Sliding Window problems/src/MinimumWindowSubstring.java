public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Brute Force:" + minWindowBrute(s, t));

        System.out.println("Optimal :" + minWindowOptimal(s, t));


    }

    public static String minWindowBrute(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (n > m)
            return "";
        int minLen = Integer.MAX_VALUE;
        int ind = -1;

        for (int i = 0; i < m; i++) {

            int[] hash = new int[256];
            for (int k = 0; k < n; k++) {
                hash[t.charAt(k)]++;
            }
            int cnt = 0;
            for (int j = i; j < m; j++) {
                if (hash[s.charAt(j)] > 0) {
                    cnt++;
                    hash[s.charAt(j)]--;
                }
                if (cnt == n) {
                    if ((j - i + 1) < minLen) {
                        minLen = Math.min(minLen, (j - i + 1));
                        ind = i;

                    }
                    break;
                }


            }
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(ind, ind + minLen);

    }

    public static String minWindowOptimal(String s, String t) {
        int m = s.length();
        int n = t.length();

        if (n > m)
            return "";
        int minLen = Integer.MAX_VALUE;
        int ind = -1;

        int[] hash = new int[256];
        for (int k = 0; k < n; k++) {
            hash[t.charAt(k)]++;
        }
        int l = 0, r = 0;
        int cnt = 0;
        while (r < m) {
            if (hash[s.charAt(r)] > 0)
                cnt++;

            hash[s.charAt(r)]--;

            while (cnt == n) {
                if (minLen > (r - l + 1)) {
                    minLen = (r - l + 1);
                    ind = l;
                }
                hash[s.charAt(l)]++;
                if (hash[s.charAt(l)] > 0) {
                    cnt--;
                }
                l++;

            }
            r++;
        }
        if (minLen == Integer.MAX_VALUE)
            return "";
        return s.substring(ind, ind + minLen);
    }
}
