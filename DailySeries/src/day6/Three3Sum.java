package day6;


import java.util.*;

public class Three3Sum {
    public List<List<Integer>> threeSumI(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]+nums[j]+nums[k]==0)
                    {
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        list.sort((a, b) -> a - b);
                        result.add(list);
                    }
                }
            }

        }
        return new ArrayList<>(result);
    }


    public static List<List<Integer>> threeSumII(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();

        int n=nums.length;
        for(int i=0;i<n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=i+1;j<n;j++){
                int target= -1*(nums[i]+nums[j]);
                if(set.contains(target)){
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(target);
                    list.sort((a, b) -> a - b);
                    result.add(list);
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }
    public static List<List<Integer>> threeSumIII(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k=n-1;
            while(j<k){
                int sum=(nums[i]+nums[j]+nums[k]);
                if(sum<0){
                    j++;
                }
                else if(sum>0){
                    k--;
                }
                else{
                List<Integer> l=new ArrayList<>();
                l.add(nums[i]);
                l.add(nums[j]);
                l.add(nums[k]);
                result.add(l);
                j++;
                k--;
                while(j<k && nums[j]==nums[j-1]) j++;
                while(j<k && nums[k]==nums[k+1]) k++;
                }
            }
        }
        return result;

    }

        public static void main(String[] args) {
        int[] nums={-1,0,1,2,-1,-4};
        System.out.println(threeSumII(nums));
    }

}
