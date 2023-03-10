//GFG
//Maximum Triplet Product
//Time complexity: O(N)
//Space complexity: O(1)

public class MaximumTripletProduct {

    public static void main(String[] args) {
        int n = 4;
        Long arr[] = { 1L, 2L, 3L, 5L };
        System.out.println(maxTripletProduct(arr, n));
    }

    static Long maxTripletProduct(Long arr[], int n) {
        // Complete the function
        long largest = Integer.MIN_VALUE, slargest = Integer.MIN_VALUE, tlargest = Integer.MIN_VALUE;
        long smallest = Integer.MAX_VALUE, ssmallest = Integer.MAX_VALUE;

        for (long el : arr) {
            if (el > largest) {
                tlargest = slargest;
                slargest = largest;
                largest = el;
            } else if (el > slargest) {
                tlargest = slargest;
                slargest = el;
            } else if (el > tlargest) {
                tlargest = el;
            }

            if (el < smallest) {
                ssmallest = smallest;
                smallest = el;
            } else if (el < ssmallest) {
                ssmallest = el;
            }
        }
        return Math.max(smallest * ssmallest * largest, largest * slargest * tlargest);
    }
}
