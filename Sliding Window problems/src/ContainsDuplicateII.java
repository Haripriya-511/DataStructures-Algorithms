/*
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.



Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
 */

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        int k = 3;

        System.out.println("Brute Force:" + containsNearbyDuplicateBrute(nums, k));

        System.out.println("Optimal :" + containsNearbyDuplicateOptimal(nums, k));

    }

    public static boolean containsNearbyDuplicateBrute(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {
                if ((j - i) <= k) {
                    if (i != j && nums[i] == nums[j]) {

                        return true;
                    }
                    if ((j - i + 1) > k)
                        break;
                }
            }
        }
        return false;


    }

    public static boolean containsNearbyDuplicateOptimal(int[] nums, int k) {

        int n = nums.length;
        int l = 0, r = 0;
        Set<Integer> st = new HashSet<>();
        while (r < n) {
            if ((r - l) > k) {
                if (st.remove(nums[l]))
                    l++;

            }
            if (st.contains(nums[r])) {
                {
                    return true;
                }

            }
            st.add(nums[r]);
            r++;
        }

        return false;

    }
}
