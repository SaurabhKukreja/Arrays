package com.kukroid.arrays;

import com.sun.codemodel.internal.JForEach;

class Rotate {
    /*
    * @params: ar[] :  Array
    * @param: d : rotate array by d
    * @param: n : size of array ar[]
    *
    * */
    public void rotateWithNewArray(int ar[], int n, int d) {

        if(d >= n) {
            d = d % n;
        }
        int[] outputArr = new int[n];
        int index = 0;
        for(int i = d ; i < n ;i++) {
            outputArr[index] = ar[i];
            index++;
        }
        int lastIndex = 0;
        for(int i = index; i< n; i++) {
            outputArr[i] = ar[lastIndex];
            lastIndex++;
        }
        printArray(outputArr);

        /*
        * Time Complexity : O(n)
        * Space Complexity : O(n)
        * */
    }

    public void rotateWithNewArrayBetter(int arr[], int n, int d) {
        if(d >= n) {
            d = d % n;
        }
        int[] temp = new int[d];
        for(int i = 0 ; i < d; i++){
            temp[i] = arr[i];
        }

        for(int i = d ; i < n ; i++) {
            arr[i-d] = arr[i];
        }

        int tempD = d;
        for(int i = 0 ; i < d ; i++) {
            arr[n-tempD] = temp[i];
            tempD--;
        }
        printArray(arr);

        /*
         * Time Complexity : O(n)
         * Space Complexity : O(d)
         * */
    }

    public void rotateLeftWithJugglingSolution(int arr[], int n, int k) {
        k = k % n;
        int d = -1;
        int i, temp, j;
        int gcd = g_c_d(n,k);
        System.out.println("GCD of "+ n +" and " + k+ " : "+ gcd);

        for(i =0 ; i < gcd; i++) {
            j = i;
            temp = arr[i];

            while(true) {
                d = (j + k) %n;
                if(d==i)
                    break;
                arr[j] = arr[d];
                j = d;
            }
            arr[j] = temp;
        }
        printArray(arr);

        /*
         * Time Complexity : O(n)
         * Space Complexity : O(1)
         */
    }

    public void rotateRightWithReverse(int arr[], int n, int k) {
        k = k % n;

        // reverse last k elements
        reverse(arr, n-k , n-1);

        //reverse first k elements
        reverse( arr, 0, n-k-1);

        // reverse all array
        reverse(arr , 0 , n-1);
        printArray(arr);

        /*
         * Time Complexity : O(n) loop ran for k times
         * Space Complexity : O(1)
         */
    }

    public void rotateLeftWithReverse(int arr[], int n, int k) {
        //reverse first K elements
        reverse(arr, 0, k-1);

        //reverse last k elements
        reverse(arr, n-k-1, n-1);

        //reverse all array
        reverse(arr, 0, n-1);
        printArray(arr);

        /*
         * Time Complexity : O(n) loop ran for k times
         * Space Complexity : O(1)
         */
    }

    public void reverse(int[] nums, int low, int high) {
        for(int i = low, j= high ; i < j ; i++,j--) {
            swap(nums, i, j);
        }
    }

    public void swap(int[] nums, int i, int j ) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int g_c_d(int a, int b) {
        if(b == 0)
            return a;
        return g_c_d(b, b % a);
    }

    public void printArray(int[] arr) {
        for(int i = 0 ; i < arr.length;i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
public class ArrayRotation {
    // Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
    /*
    * Input --> 1, 2, 3, 4, 5, 6, 7
    *
    * Rotate the above array by 2
    *
    * Output --> 3, 4, 5, 6, 7, 1, 2
    *
    * */

    public static void main(String[] args) {
        Rotate rotate = new Rotate();
       /* int[] arr = new int[] {1,2,3,4,5,6,7};
        rotate.printArray(arr);
        System.out.println(" ");*/
        /*rotate.rotateWithNewArray(arr, arr.length,3);
        System.out.println(" ");
        rotate.rotateWithNewArrayBetter(arr, arr.length,3);
        System.out.println(" ");
        int[] arr1 = new int[] {1,2,3,4,5,6,7};
        rotate.rotateLeftWithJugglingSolution(arr1, 3, 7);*/

        int[] arr2 = new int[] {1,2,3,4,5};
        rotate.printArray(arr2);
        System.out.println(" ");
        rotate.rotateLeftWithReverse(arr2,5,2);
    }

}
