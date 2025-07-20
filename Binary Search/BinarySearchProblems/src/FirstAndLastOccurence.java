public class FirstAndLastOccurence {
    public   static int firstOcc(int []nums,int x){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==x)
            {
                high=mid-1;
                res=mid;
            }else if(nums[mid]>x)
                high=mid-1;
            else
                low=mid+1;
        }
        if(res!=-1 && nums[res]==x)
            return res;
        else return -1;
    }
    public static int lastOccurrence(int nums[],int x){
        int n=nums.length;
        int low=0;
        int high=n-1;
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==x)
            {
                res=mid;
                low=mid+1;
            }else if(nums[mid]<x) low=mid+1;
            else{
                high=mid-1;
            }
        }
        if(res!=-1 && nums[res]==x)
            return res;
        else return -1;
    }
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{firstOcc(nums,target),lastOccurrence(nums,target)};
    }

    public static void main(String[] args) {
        int arr[]={3,4,4,7,8,10};
        int x=5;
        int[] firstLast = searchRange(arr, x);
        for (int i : firstLast) {
            System.out.println(i);
        }
    }
}
