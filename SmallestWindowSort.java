/**
 * Given an array of integers that are out of order , determine the bounds of the smallest window must be sorted in order for the entire array to be sorted.
 * Input: [3, 7, 5, 6, 9]
 * Output: (1, 3)
 */

import java.util.Arrays;

public class SmallestWindowSort {

    //3, 7, 5, 6, 9
    //3, 5, 6, 7, 9

    //3, 5, 4, 6, 8, 7, 9
    //3, 4, 5, 6, 7, 8, 9

    public static int[] findSmallestWindowToSort1(int[] arr) {
        int[] toBeSortedArr = arr.clone();
        Arrays.sort(toBeSortedArr);
        int startIndex = -1;
        int endIndex = -1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != toBeSortedArr[i]) {
                startIndex = i;
                break;
            }
        }

        for(int i = arr.length - 1; i > startIndex; i--){
            if(arr[i] != toBeSortedArr[i]) {
                endIndex = i;
                break;
            }
        }

        int[] bounds = new int[2];
        bounds[0] = startIndex;
        bounds[1] = endIndex;

        return bounds;
    }

    public static int[] findSmallestWindowToSort2(int[] arr) {
        int[] bounds = new int[2];
        bounds[0] = -1;
        bounds[1] = -1;

        int maxValue = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= maxValue) {
                maxValue = arr[i];
            } else {
                bounds[1] = i;
            }
        }

        int minValue = Integer.MAX_VALUE;
        for(int i = arr.length - 1; i >= 0; i--){
            if(arr[i] <= minValue) {
                minValue = arr[i];
            } else {
                bounds[0] = i;
            }
        }

        return bounds;
    }

    private static void displayArray(int[] arr) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            stringBuilder.append(String.format("%d,", arr[i]));
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        int[] inputArr1 = {3, 7, 5, 6, 9};
        displayArray(inputArr1);
        displayArray(findSmallestWindowToSort1(inputArr1));
        int[] inputArr2 = {3, 5, 4, 6, 8, 7, 9};
        displayArray(inputArr2);
        displayArray(findSmallestWindowToSort1(inputArr2));
        displayArray(inputArr1);
        displayArray(findSmallestWindowToSort2(inputArr1));
        displayArray(inputArr2);
        displayArray(findSmallestWindowToSort2(inputArr2));

    }

}