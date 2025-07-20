import java.util.ArrayList;

public class FindOutHowmanyTimesSorted {
    public int findKRotation(ArrayList<Integer> arr){
        int ans=Integer.MAX_VALUE;
        int n=arr.size();
        int low=0;
        int ind=-1;
        int high=n-1;

        while(low<=high){
            int mid= low+(high-low)/2;
            if(arr.get(low)<=arr.get(high))
            {
                if(arr.get(low)<ans){
                    ans=arr.get(low);
                    ind=low;
                    break;
                }

            }
            if(arr.get(low)<=arr.get(mid)){
                if(arr.get(low)<ans){
                    ans=arr.get(low);

                }

                low=mid+1;
            }
            else{
                if(arr.get(mid)<ans)
                {
                    ans=arr.get(mid);
                    ind=mid;
                }
                high=mid-1;
            }
        }
        return ind;
    }
}
