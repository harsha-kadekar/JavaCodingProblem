public class ArrayProducts {

    // input: [1, 2, 3, 4, 5]
    // output: [120, 60, 30, 24]
    public static int[] getCustomProduct(int[] inputArr) {
        if(inputArr == null || inputArr.length == 1) {
            return null;
        }

        long product = 1;
        for(int x: inputArr) {
            product = product * x;
        }

        int[] outputArr = new int[inputArr.length];

        for(int i = 0; i < inputArr.length; i++) {
            outputArr[i] = (int)(product / inputArr[i]);
        }

        return outputArr;
    }

    public static int[] getCustomProduct2(int[] inputArr) {
        int[] outputArr = new int[inputArr.length];

        for(int i = 0; i < inputArr.length; i++) {
            outputArr[i] = getProductOfSubArray(inputArr, 0, i - 1) * getProductOfSubArray(inputArr, i + 1, inputArr.length - 1);
        }

        return outputArr;
    }


    public static int getProductOfSubArray(int[] arr, int startIndex, int endIndex) {
        if(startIndex > endIndex ){
            return 1;
        }

        int product = 1;
        for(int i = startIndex; i <= endIndex; i++) {
            product *= arr[i];
        }

        return product;

    }

    public static int[] getCustomProduct3(int[] ar) {
        int[] orderedProducts = new int[ar.length];
        int[] reverseProducts = new int[ar.length];
        int[] outputArr = new int[ar.length];

        orderedProducts[0] = ar[0];
        reverseProducts[0] = ar[ar.length - 1];

        for(int i = 1; i < ar.length; i++) {
            orderedProducts[i] = orderedProducts[i - 1] * ar[i];
        }

        for(int j = ar.length - 2, i = 1; j >= 0 && i < ar.length; i++, j--) {
            reverseProducts[i] = reverseProducts[i - 1] * ar[j];
        }

        outputArr[0] = reverseProducts[ar.length - 2];
        outputArr[ar.length - 1] = orderedProducts[ar.length - 2];

        for(int i = 1; i < ar.length - 1; i++) {
            outputArr[i] = orderedProducts[i - 1] * reverseProducts[ i + 1];
        }

        return outputArr;
    }

    public static void displayArray(int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int x: array) {
            stringBuilder.append(String.format("%d,", x));
        }
        System.out.println(stringBuilder.toString());
    }

    public static void main(String[] args) {
        int[] ar = {1,2,3,4,5};
        displayArray(ar);
        int[] output1 = getCustomProduct(ar);
        displayArray(output1);
        int[] output2 = getCustomProduct2(ar);
        displayArray(output2);
        int[] output3 = getCustomProduct2(ar);
        displayArray(output3);

    }

    /*
    * 1 1*2 1*2*3 1*2*3*4 1*2*3*4*5
    * 5 5*4 5*4*3 5*4*3*2 5*4*3*2*1
    */
    
}