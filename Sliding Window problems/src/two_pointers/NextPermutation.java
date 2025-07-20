package two_pointers;

/*
https://leetcode.com/problems/next-permutation/
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int pivot = -1;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                pivot = i;
                break;
            }
        }
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        for (int j = n - 1; j > pivot; j--) {
            if (nums[j] > nums[pivot]) {
                int temp = nums[j];
                nums[j] = nums[pivot];
                nums[pivot] = temp;
                break;
            }
        }
        reverse(nums, pivot + 1, n - 1);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
}
