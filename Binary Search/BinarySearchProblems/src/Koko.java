public class Koko {
    public int calc(int mid,int[] nums){
        int sum=0;
        int n=nums.length;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) nums[i] / (double)(mid));
        }
        return sum;
    }
    public int minimumRateToEatBananas(int[] nums, int h) {
        int n=nums.length;
        if(n>h) return -1;
        int max=Integer.MIN_VALUE;
        for(int i:nums)
            max=Math.max(max,i);
        int low=1;
        int high=max;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            int hours= calc(mid,nums);
            if(hours<= h)
                high=mid-1;
            else
                low=mid+1;

        }
        return low;
    }
}
