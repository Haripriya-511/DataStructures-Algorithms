package aug6;

public class ValidPalindrome {
    public boolean isPalindromeOptimal(String s) {
    int l = 0, r = s.length() - 1;

    while (l < r) {

        while(l<r && (!alphaNum(s.charAt(l))))
            l++;
        while(l<r && (!alphaNum(s.charAt(r))))
            r--;
        if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
            return false;
        }
        l++;
        r--;

    }
    return true;

}
    public boolean alphaNum(char c) {
        return (c >= 'A' && c <= 'Z' ||
                c >= 'a' && c <= 'z' ||
                c >= '0' && c <= '9');
    }
    public boolean isPalindromeI(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                newStr.append(Character.toLowerCase(c));
            }
        }
        return newStr.toString().equals(newStr.reverse().toString());
    }

    public static void main(String[] args) {

    }
}
