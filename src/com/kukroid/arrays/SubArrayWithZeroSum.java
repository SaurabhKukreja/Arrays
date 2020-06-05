package com.kukroid.arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SubArrayWithZeroSum {

    public static void main(String[] args){
        int[] arr = new int[] { 3,4,-7,3,1,3,1,-4,-2,-2};
        int[] arr2 = new int[] {7,1,4,5,1 };
        int[] arr1 = new int[] {1,1,1,1,1,1,1};
        int sum = 10 ;
        System.out.println("Sub Array found:" + hasSubArray(arr2, sum));
        getPairs(arr, 0);
    }

    public static boolean hasSubArray(int[] arr, int target) {
        /*
         * Check if Array contains a subarray having 0 sum
         * Input: { 3,4,-7,3,1,3,1,-4,-2,-2};
         * Outout: true
         * Reason:
         * {3,4,-7}
         * {3,1,-4} and other subarray exist which have sum = 0
         * */

        Set<Integer> set = new HashSet<Integer>();
        set.add(0);
        int sum = 0;
        for(int elements: arr) {
            sum += elements;
            if(set.contains(target)){
                return true;
            } else {
                set.add(sum);
            }
        }
        return false;
    }

    public static void getPairs(int[] arr, int target) {
        /*
         * Get the pairs that have sum = 0 or later extend it to a target SUM
         * Input: { 3,4,-7,3,1,3,1,-4,-2,-2};
         * Outout:
         * Subarray [0..2]
         * Subarray [1..3]
         * Subarray [2..5]
         * Subarray [5..7]
         * Subarray [0..9]
         * Subarray [3..9]
         * */

        int sum = 0;
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        insert(hashMap , 0 , -1);
        for(int i = 0 ; i< arr.length; i++) {
            sum += arr[i];

            if(hashMap.containsKey(sum - target)) {
                List<Integer> subArrays = hashMap.get(sum - target);
                for(Integer element: subArrays){
                    System.out.println("Subarray [" + (element + 1 ) + ".." +
                            i + "]");
                }
            }
            insert(hashMap, sum, i);
        }
    }

    public static void insert(Map<Integer, List<Integer>> hashmap, int key, int value) {
        if(!hashmap.containsKey(key)) {
            hashmap.put(key, new ArrayList<Integer>());
        }
        hashmap.get(key).add(value);
    }
}
