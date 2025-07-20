import java.util.Arrays;

public class Aggressivecows {
    boolean canWePlace(int []nums,int d,int k){
        int cntCows=1;
        int lastCow=nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]-lastCow>=d)
            {
                lastCow=nums[i];
                cntCows++;
            }
        }
        return cntCows >= k;

    }
    public int aggressiveCows(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int low=1;
        int high= (nums[n-1]-nums[0]);

        while(low<=high){
            int mid=low+(high-low)/2;
            if(canWePlace(nums,mid,k)){
                low=mid+1;

            }
            else
                high=mid-1;
        }
        return high;

    }
}
