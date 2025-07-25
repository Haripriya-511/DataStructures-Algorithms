package day4;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TopKFreqElements {
    public int[] topKFrequentSortingBrute(int[] nums, int k) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i:nums){
            map.putIfAbsent(i,0);
            map.put(i,map.get(i)+1);
        }
        List<int[]> arr = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
          arr.add(new int[]{entry.getKey(), entry.getValue()});
        }
        arr.sort((a,b)-> (b[0]-a[0]));
        int[] res=new int[k];
        for(int i=0;i<k;i++){
            res[i]=arr.get(i)[0];
        }
        return res;
    }
    public int[] topKFrequentHeap1(int[] nums, int k) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int i:nums){
            map.putIfAbsent(i,0);
            map.put(i,map.get(i)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
       for(Map.Entry<Integer,Integer> entry: map.entrySet()){
           pq.offer(entry);
           if(pq.size()>k){
               pq.poll();
           }
       }
       int res[]=new int[pq.size()];
       int ind=0;
       while (!pq.isEmpty()){
           res[ind++]=pq.poll().getKey();

       }
        return res;
    }
    public int[] topKFrequentHeap2(int[] nums, int k) {
        Map<Integer,Integer> map=new TreeMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll()[0];
        }

        return res;
    }

    public int[] topKFrequentBucketSort(int nums[],int k){
        Map<Integer,Integer> map=new TreeMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket=new List[nums.length+1];
        for(int i=0;i<=nums.length;i++)
            bucket[i]=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int key= entry.getKey();
            int val= entry.getValue();
            bucket[val].add(key);
        }
        int[] res = new int[k];
        int index = 0;
        for(int i=bucket.length-1;i>0 && index<k;i--){
            for(int n:bucket[i]){
                res[index++]=n;
                if(index==k)
                    return res;
            }


        }
        return res;
    }
    public static void main(String[] args) {



    }
}
