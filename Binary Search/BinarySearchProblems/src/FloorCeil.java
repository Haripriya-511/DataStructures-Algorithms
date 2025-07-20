public class FloorCeil {
    public static int floor(int[] nums,int x){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            if(nums[mid]<=x){
                low=mid+1;
                ans=nums[mid];
            }
            else{
                high=mid-1;
            }
        }
        return ans;

    }
    public static int ceil(int nums[],int x){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int ans=-1;
        while(low<=high){
            int mid=(low)+(high-low)/2;
            if(nums[mid]>=x){
                ans=nums[mid];
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;

    }
    public static int[] getFloorAndCeil(int[] nums, int x) {
        int []res=new int[2];
        res[0]=floor(nums,x);
        res[1]=ceil(nums,x);
        return res;
    }

    public static void main(String[] args) {
        int arr[]={3,4,4,7,8,10};
        int x=5;
        int[] floorAndCeil = getFloorAndCeil(arr, x);
        for (int i : floorAndCeil) {
            System.out.println(i);
        }
        //brute
        int floor = -1, ceil = -1;
        for (int num : arr) {
            if (num <= x && num > floor) floor = num;
            if (num >= x && (ceil == -1 || num < ceil))
                ceil = num;
        }

    }
}
