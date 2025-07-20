package two_pointers;

import java.util.ArrayList;
import java.util.List;

public class Pr3_TP {
    public static void main(String[] args) {

    }

    public int[] sortArrayByParity(int[] nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0)
                even.add(nums[i]);
            else
                odd.add(nums[i]);
        }
        int i = 0, j = 0;
        while (j < even.size()) {
            nums[i++] = even.get(j);
            j++;
        }
        j = 0;
        while (j < odd.size()) {
            nums[i++] = odd.get(j);
            j++;
        }
        return nums;

    }

    // using while loop
    public int[] sortArrayByParity2(int[] nums) {
        int n = nums.length;
        int i = 0, j = 0;
        while (j < n) {
            if (nums[j] % 2 == 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }
        return nums;
    }

    //using for loop
    public int[] sortArrayByParity3(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }

        return nums;
    }
}

