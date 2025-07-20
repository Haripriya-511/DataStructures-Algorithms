import java.util.ArrayList;

public class FindMinimumInSortedArray {
    public int findMin(ArrayList<Integer> arr) {
        int ans=Integer.MAX_VALUE;
        int n=arr.size();
        int low=0;
        int high=n-1;

        while(low<=high){
            int mid= low+(high-low)/2;
            if(arr.get(low)<=arr.get(high))
            {
                ans=Math.min(arr.get(low),ans);
                break;
            }
            if(arr.get(low)<=arr.get(mid)){
                ans=Math.min(arr.get(low),ans);
                low=mid+1;
            }
            else{
                ans=Math.min(arr.get(mid),ans);
                high=mid-1;
            }
        }
        return ans;
    }
}
