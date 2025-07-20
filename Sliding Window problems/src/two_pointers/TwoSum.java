package two_pointers;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {

    }
    /*
https://leetcode.com/problems/two-sum/description/
     */

    //LeetCode 1 if array not sorted
    public int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public int[] twoSumBrute(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    /*
    https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
     */
    //LeetCode 167 array is sorted
    public int[] twoSumSorted(int[] numbers, int target) {
        int n = numbers.length;
        int left = 0, right = n - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target)
                return new int[]{left + 1, right + 1};
            else if (sum < target)
                left++;
            else
                right--;
        }
        return new int[]{-1, -1};
    }
}
