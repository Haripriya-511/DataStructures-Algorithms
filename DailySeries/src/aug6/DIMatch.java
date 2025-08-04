package aug6;

import java.util.ArrayList;
import java.util.List;

public class DIMatch {
    public int[] diStringMatchOptimal(String s) {
        int res[]=new int[s.length()+1];
        int low=0,high=s.length();
      for(int i=0;i<s.length();i++){
          if(s.charAt(i)=='I'){
              res[i]=low++;
          }
          else{
              res[i]=high--;
          }
      }
      res[s.length()]=high;
      return res;

    }

    public void generatePermutations(int[] nums,int index,List<int[]> ans){
        if(index==nums.length)
        {
            int []perm=new int[nums.length];
            int ind=0;
            for(int num:nums)
                perm[ind++]=num;
            ans.add(perm);
            return;
        }
        for(int i=index;i<nums.length;i++){
            swap(nums,index,i);
            generatePermutations(nums,index+1,ans);
            swap(nums,index,i);
        }

    }
    public boolean dICheck(int nums[],String s){
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I' && nums[i] >= nums[i + 1]) return false;
            if (s.charAt(i) == 'D' && nums[i] <= nums[i + 1]) return false;
        }
        return true;


    }
    public  void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public int[] diStringMatch(String s) {
        int nums[]=new int[s.length()+1];
        for(int i=0;i<=s.length();i++){
            nums[i]=i;
        }
        List<int[]> result=new ArrayList<>();
        generatePermutations(nums,0,result);

        System.out.println(result);
        for(int[] list:result){
            if(dICheck(list,s))
                return list;
        }
        return new int[0];
    }
    public static void main(String[] args) {
       int res[]= new DIMatch().diStringMatchOptimal("IDID");
       for(int num:res)

        System.out.println(num);
    }
}
