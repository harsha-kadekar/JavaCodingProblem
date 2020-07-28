import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * INPUT:  [3,4,9,6,1]
 * OUTPUT: [1,1,2,1,0]
 */
public class SmallerNumbersToRight {
    public static int[] findSmallerNumberToRight1(int[] arr) {
        int[] output = new int[arr.length];

        for(int i = 0; i < arr.length; i++) {
            int count = 0;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] < arr[i]) {
                    count += 1;
                }
            }
            output[i] = count;
        }

        return output;
    }

    public static int[] findSmallerNumberToRight2(int[] arr) {
        int[] output = new int[arr.length];

        for(int i = arr.length - 2; i >= 0; i--) {
            if(arr[i] == arr[i + 1]) {
                output[i] = output[i +1];
            } else if(arr[i] > arr[i+1]) {
                output[i] = output[i + 1] + 1;
            } else {
                int j = i + 2;
                while(j <= arr.length - 1) {
                    if(arr[i] == arr[j]) {
                        output[i] = output[j];
                        break;
                    } else if(arr[i] > arr[j]) {
                        output[i] = output[j] + 1;
                        break;
                    }
                    j++;

                }
            }
        }

        return output;
    }

    private static int addTreeNode(int value, BSTreeNode top) {
        if( value > top.getValue()) {
            if(top.getRightNode() == null) {
                BSTreeNode newNode = new BSTreeNode(value, top.getCount() + 1);
                top.setRightNode(newNode);
                return newNode.getCount();
            } else {
                return addTreeNode(value, top.getRightNode());
            }
        } else {
            if(top.getLeftNode() == null) {
                BSTreeNode newNode = new BSTreeNode(value, top.getCount());
                top.setLeftNode(newNode);
                return newNode.getCount();
            } else {
                return addTreeNode(value, top.getLeftNode());
            }
        }
    }

    public static int[] findSmallerNumberToRight3(int[] arr) {
        //Need to solve via binary search tree
        int[] output = new int[arr.length];

        BSTreeNode top = null;

        top = new BSTreeNode(arr[arr.length - 1], 0);

        for(int i = arr.length - 2; i >= 0; i--) {
            output[i] = addTreeNode(arr[i], top);
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 9, 6, 1};
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(findSmallerNumberToRight1(arr1)));
        System.out.println(Arrays.toString(findSmallerNumberToRight2(arr1)));
        System.out.println(Arrays.toString(findSmallerNumberToRight3(arr1)));
        int[] arr2 = {5, 2, 6, 1};
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(findSmallerNumberToRight1(arr2)));
        System.out.println(Arrays.toString(findSmallerNumberToRight2(arr2)));
        System.out.println(Arrays.toString(findSmallerNumberToRight3(arr2)));
    }

    
}