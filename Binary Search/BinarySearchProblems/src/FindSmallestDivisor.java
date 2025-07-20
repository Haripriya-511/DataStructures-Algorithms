public class FindSmallestDivisor {
    public int calc(int nums[],int divisor,int n){
        int sum=0;
        for (int i = 0; i < n; i++) {
            sum += Math.ceil((double) nums[i] / (double)(divisor));
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int limit) {
        int n=nums.length;
        if(n>limit) return -1;
        int max=Integer.MIN_VALUE;
        for(int i:nums)
            max=Math.max(max,i);
        int low=1;
        int high=max;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            int sum= calc(nums,mid,n);
            if(sum<= limit)
                high=mid-1;
            else
                low=mid+1;

        }
        return low;

    }
}
