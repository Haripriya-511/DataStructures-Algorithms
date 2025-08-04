package aug6;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllPermutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean freq[]=new boolean[nums.length];
        recur(ans,ds,freq,nums);
        return ans;
    }
    public void recur(List<List<Integer>> ans,List<Integer> ds,boolean freq[],int[] nums){
        if(ds.size()==nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                ds.add(nums[i]);
                recur(ans,ds,freq,nums);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }


    }
// 2nd method
    public static void generatePermutations(int[] nums,int index,List<List<Integer>> ans){
        if(index==nums.length)
        {
            List<Integer> perm=new ArrayList<>();
            for(int num:nums)
                perm.add(num);
            ans.add(perm);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            generatePermutations(nums,index+1,ans);
            swap(nums,index,i);
        }

    }
    public static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void main(String[] args) {
        int []arr={1,2,3};
        List<List<Integer>> permute = new GenerateAllPermutations().permute(arr);
        System.out.println(permute);
        List<List<Integer>> result=new ArrayList<>();
        generatePermutations(arr,0,result);
        System.out.println(result);
    }
}
