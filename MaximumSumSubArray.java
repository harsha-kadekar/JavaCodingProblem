
/**
 * INPUT: [34, -50, 42, 14, -5, 86]
 * OUTPUT: 137   // 42, 14, -5, 86
 * 
 * INPUT: [-5, -1, -8, -9]
 * OUTPUT: 0   
 * 
 * INPUT: [8, -1, 3, 4]
 * OUTPUT: 15
 */

import java.util.Arrays;

public class MaximumSumSubArray {

    public static int getMaximumSumSubArray(int[] arr) {
        int maxSum = 0;
        int currentSum = 0;

        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            if(currentSum > maxSum) {
                maxSum = currentSum;
            } else if (currentSum < 0) {
                currentSum = 0;
            }
        }

        return maxSum;
    }

    public static int getMaximumSumSubCircularArray(int[] arr) {
        int sum = getSumOfArray(arr);
        int minSum = getMinimumSumSubArray(arr);
        int maxSum = getMaximumSumSubArray(arr);

        int cirularMaxSum = sum - minSum;

        return cirularMaxSum > maxSum ? cirularMaxSum : maxSum;
    }

    public static int getSumOfArray(int[] arr) {
        int sum = 0;

        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static int getMinimumSumSubArray(int[] arr) {
        int minSum = 0;
        int currentSum = 0;

        for(int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if(currentSum < minSum) {
                minSum = currentSum;
            } else if (currentSum >= 0) {
                currentSum = 0;
            }
        }

        return minSum;

    }

    public static void main(String[] args) {
        int[] arr1 = {34, -50, 42, 14, -5, 86 };
        System.out.println(Arrays.toString(arr1));
        System.out.println(getMaximumSumSubArray(arr1));
        System.out.println(getMaximumSumSubCircularArray(arr1));
        int[] arr2 = {-5, -1, -8, -9};
        System.out.println(Arrays.toString(arr2));
        System.out.println(getMaximumSumSubArray(arr2));
        System.out.println(getMaximumSumSubCircularArray(arr2));
        int[] arr3 = {8, -1, 3, 4};
        System.out.println(Arrays.toString(arr3));
        System.out.println(getMaximumSumSubArray(arr3));
        System.out.println(getMaximumSumSubCircularArray(arr3));

    }
}