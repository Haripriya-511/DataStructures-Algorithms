package day1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public static int[] twoSumBrute(int[] numbers, int target) {
        int n=numbers.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(numbers[i]+numbers[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
    public static int[] twoSumOptimalI(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int res[]=new int[2];
        int n=numbers.length;
        for(int i=0;i<n;i++){
            map.put(numbers[i],i);
        }
        for(int i=0;i<n;i++){
            int diff= target-numbers[i];
            if(map.containsKey(diff)){
                int ind=map.get(diff);
                if(ind!=i){
                    return new int[]{i,ind};
                }
            }
        }
        return new int[0];
    }
    public static int[] twoSumOptimalII(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<>();

        int n=numbers.length;

        for(int i=0;i<n;i++){
            int diff= target-numbers[i];
            if(map.containsKey(diff)){
                return new int[]{i,map.get(diff)};
            }
            map.put(numbers[i],i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int arr[]={3,4,5,6};
        int target=7;
        System.out.println("Brute");
        Arrays.stream(twoSumBrute(arr, target))
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\nOptimal1");
        Arrays.stream(twoSumOptimalI(arr, target))
                .forEach(i -> System.out.print(i + " "));
        System.out.println("\nOptimal2");
        Arrays.stream(twoSumOptimalII(arr, target))
                .forEach(i -> System.out.print(i + " "));

    }

}
