package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P1LargestElement {
    public static void main(String[] args) {
        int arr[] = {20, 10, 20, 4, 100};

        // Initialize maximum element
        int max = arr[0];

        // Traversing and comparing max element
        for (int i = 1; i < arr.length; i++) {
            // If current element is greater than max
            if (arr[i] > max)
                // Then update max element
                max = arr[i];
        }
        System.out.println("Maxi:"+max);

        //java 8
        System.out.println("Java 8:"+ Arrays.stream(arr).max().getAsInt());
        // sorting
        Arrays.sort(arr);
        System.out.println("Sort:"+arr[arr.length-1]);
        //Collections
        List<Integer> list=new ArrayList<>();

        for(int i:arr) list.add(i);
        // or  Arrays.stream(arr).forEach(list::add);
        System.out.println("Collections:"+ Collections.max(list));
        // recursion
        System.out.println("Recursive:"+findMax(arr,0));


    }
    // recursive approach
    static int findMax(int []arr,int i){
        if(i==arr.length-1) return arr[i];
        int recMax=findMax(arr,i+1);
        return Math.max(recMax,arr[i]);
    }
}
