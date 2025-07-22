package day3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static boolean containsDuplicate1(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]==nums[j])
                    return true;
            }
        }
        return false;
    }
    public static boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1])
                return true;

        }
        return false;
    }
    public static boolean containsDuplicate3(int[] nums){
       Set<Integer> set=new HashSet<>();
       for(int i:nums){
           set.add(i);
       }
        return nums.length!=set.size();
    }
    public static boolean containsDuplicate4(int nums[]){
        return Arrays.stream(nums).distinct().count()<nums.length;
    }
    public static void main(String[] args) {
    int nums[]={1,2,3,4,5};
        System.out.println(containsDuplicate1(nums));
        System.out.println(containsDuplicate2(nums));
        System.out.println(containsDuplicate3(nums));
        System.out.println(containsDuplicate4(nums));
    }
}
