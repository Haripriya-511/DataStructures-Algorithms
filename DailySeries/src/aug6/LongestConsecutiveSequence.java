package aug6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutiveI(int[] nums) {
        int n=nums.length;
   Set<Integer> set=new HashSet<>();
   int res=0;
   for(int num:nums){
       set.add(num);
   }
   for(int i=0;i<nums.length;i++){
       int count=0;
       int current=nums[i];
       while(set.contains(current)){
           count++;
           current++;
       }
       res=Math.max(res,count);
   }
   return res;

    }
    public int longestConsecutiveII(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        int res=0;
        for(int num:nums){
            set.add(num);
        }
        for(int num:set){
            if(!set.contains(num-1)) {
                int count = 0;
                int current = num;
                while (set.contains(current)) {
                    count++;
                    current++;
                }
                res = Math.max(res, count);
            }
        }
        return res;

    }

    public int longestConsecutiveIII(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int longest = 0;
        int current = nums[0];
        int count = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != current) {
                // If there's a gap, reset count
                current = nums[i];
                count = 0;
            }

            // Skip duplicates
            while (i < nums.length && nums[i] == current) {
                i++;
            }
            count++;
            current++;
            longest = Math.max(longest, count);
        }

        return longest;

    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,2};
        int res=new LongestConsecutiveSequence().longestConsecutiveI(nums);
        System.out.println(res);

    }
}
