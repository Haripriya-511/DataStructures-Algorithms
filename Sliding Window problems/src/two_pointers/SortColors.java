package two_pointers;

/*
https://leetcode.com/problems/sort-colors/
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int one = 0;
        int zero = 0;
        int two = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zero++;
            if (nums[i] == 1) one++;
            if (nums[i] == 2) two++;
        }
        int i = 0;
        while (zero > 0) {
            nums[i++] = 0;
            zero--;
        }
        while (one > 0) {
            nums[i++] = 1;
            one--;
        }
        while (two > 0) {
            nums[i++] = 2;
            two--;
        }
    }

    public void sortColorsOptimal(int[] nums) {
        int n = nums.length;
        int low = 0, mid = 0;
        int high = n - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) mid++;
            else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }
}

