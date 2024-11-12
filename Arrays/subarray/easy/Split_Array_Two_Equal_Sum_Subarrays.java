package Arrays.subarray.easy;
 
/**
 * Given an array of integers greater than zero, find if it is possible to split it in two subarrays 
 * (without reordering the elements), 
 * such that the sum of the two subarrays is the same. Print the two subarrays.
sc: o(1)
tc: o(2n)~o(n)

 */
public class Split_Array_Two_Equal_Sum_Subarrays {
public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,5}; 
    int n = arr.length; 
    printTwoParts(arr, n); 
          
    }
    
    private static void printTwoParts(int[] arr, int n) {
        int total_sum=0;
        for(int i=0;i<n;i++){
            total_sum+=arr[i];
        }
        int forward_sum=0;
        int index=-1;
        for(int i=0;i<n;i++){
            forward_sum+=arr[i];
            total_sum-=arr[i];
            if(total_sum==forward_sum){
                index=i;
                break;
            }
        }
        if(index==-1){
        System.out.println("Not possible");
        return;
        }
        for(int i=0;i<n;i++){
            if(index+1==i)
            System.out.println();
            System.out.print(arr[i]+" ");
        }
     
    }
    

}