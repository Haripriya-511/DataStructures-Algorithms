/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
 */


public class MinimumSizeSubarray {
    public static void main(String[] args) {
        int target = 7;
        int nums[] = {2, 3, 1, 2, 4, 3};
        System.out.println("Brute Force:" + minSubArrayLenBrute(target, nums));

        System.out.println("Optimal :" + minSubArrayLenOptimal(target, nums));


    }

    public static int minSubArrayLenBrute(int target, int nums[]) {
        int n = nums.length;
        int minArrayLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    minArrayLen = Math.min(minArrayLen, (j - i + 1));
                }
            }

        }
        return minArrayLen == Integer.MAX_VALUE ? 0 : minArrayLen;

    }

    public static int minSubArrayLenOptimal(int target, int nums[]) {
        int n = nums.length;
        int l = 0, r = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        while (r < n) {
            sum += nums[r];
            while (sum >= target) {
                minLen = Math.min(minLen, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }

}
