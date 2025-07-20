public class MinimumBoquets {
    public int noOfBoquets(int n,int[] nums,int d,int k){
        int boquets=0;
        int counter=0;
        for(int i=0;i<n;i++){
            if(nums[i]<=d){
                counter++;
            }
            else
            {
                boquets+=(counter)/k;
                counter=0;
            }

        }
        boquets+=(counter)/k;
        return boquets;

    }
    public int roseGarden(int n, int[] nums, int k, int m) {
        if(n< (k*m))
            return -1;
        int maxi=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        for(int i:nums){
            mini=Math.min(mini,i);
            maxi=Math.max(maxi,i);
        }

        int low=mini;
        int high=maxi;

        while(low<=high){
            int mid=low+ (high-low)/2;
            if(noOfBoquets(n,nums,mid,k)<m)
                low=mid+1;
            else
                high=mid-1;
        }
        return low;

    }
}
