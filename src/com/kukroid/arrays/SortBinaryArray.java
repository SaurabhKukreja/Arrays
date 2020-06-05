package com.kukroid.arrays;

public class SortBinaryArray {

    public static void main(String[] args) {
        /*Sort a Binary Array in linear time nd constant space.
        * Input: {1,1,1,0,1,0,1,0,0,0,1}
        * Output : {0,0,0,0,0,1,1,1,1,1,1}
        * */

        int[] arr = new int[] {1,1,1,0,1,0,1,0,0,0,1};
        sortArraySolution1(arr);
        System.out.println(" ");
        int[] arr1 = new int[] {1,1,1,0,1,0,1,0,0,0,1};
        sortArraySolution2(arr1);
    }

    public static void sortArraySolution1(int[] arr){
        int totalZero = 0;

        for(int i = 0; i< arr.length;i++) {
            if(arr[i]==0) {
                totalZero++;
            }
        }
        for(int i = 0 ; i< totalZero; i++){
            arr[i] = 0;
        }
        for(int i = totalZero ; i < arr.length ; i ++) {
            arr[i] = 1;
        }

        printArray(arr);

        /*Time Complexity: O(n)
        * Space Complexoty: O(1)*/
    }


    public static void sortArraySolution2(int[] arr){
        int i = 0 ;
        int j = arr.length - 1;

        while(i < j ){
            if(arr[i] == 0){
                i++;
                continue;
            }
            if(arr[j] == 1){
                j--;
                continue;
            }
            swap(arr,i,j);
        }
        printArray(arr);

        /*Time Complexity: O(n)
         * Space Complexoty: O(1)*/
    }

    public static void swap(int[] arr, int i , int j) {
        int temp = arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }
    public static void printArray(int[] arr) {
        for(int i = 0 ; i< arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
