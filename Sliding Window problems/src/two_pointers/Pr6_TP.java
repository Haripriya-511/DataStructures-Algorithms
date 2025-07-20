package two_pointers;

public class Pr6_TP {
    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {

        int i = 0, j = 1;
        int n = nums.length;
        if (n == 0 || n == 1) return n;
        while (j < n) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
