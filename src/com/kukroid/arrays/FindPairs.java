package com.kukroid.arrays;

import java.util.HashMap;

public class FindPairs {

    /*
     * Given an unsorted array of Integers, find a pair with given sum in it
     * Input : [8,7,2,5,3,1] Sum = 10
     * Output : Pair at 0 and 2 ==> ( 8 + 2)
     * Or
     * Pair at 1 and 4 ==> (7 + 3)
     * **/
    public static void main(String[] args) {
        int[] arr = new int[] {8,7,2,5,3,1};
        int sum = 10;
        getPairs(arr, sum);
    }

    public static void getPairs(int[] arr, int sum) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < arr.length ; i++) {
            int val = sum - arr[i];
            if(map.containsKey(arr[i])){
                System.out.println("Found the pair at: "+ i +" and "+ map.get(arr[i]));
            } else{
                map.put(val, i);
            }
        }
    }
}
