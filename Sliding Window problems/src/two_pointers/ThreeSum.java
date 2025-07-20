package two_pointers;

import java.util.*;

/*
https://leetcode.com/problems/3sum/submissions/1675131039/
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Step 1: Sort the array

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // Step 2: Skip duplicates for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left and right
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;
                } else if (sum < 0) {
                    left++; // Increase sum
                } else {
                    right--; // Decrease sum
                }
            }
        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int target = -nums[i];
            Map<Integer, Integer> map = new HashMap<>();

            for (int j = i + 1; j < nums.length; j++) {
                int complement = target - nums[j];

                if (map.containsKey(complement)) {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(complement);
                    Collections.sort(l);
                    set.add(l);

                }


                map.put(nums[j], j);
            }
        }
        return new ArrayList<>(set);

    }

    public List<List<Integer>> threeSumBrute(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        set.add(list);

                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

}
