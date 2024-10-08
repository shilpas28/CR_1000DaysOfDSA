//GFG
//Largest Pair Sum
//Time complexity: O(N)
//Space complexity: O(1)

public class LargestPairSum {

    public static void main(String[] args) {
        int arr[] = { 12, 34, 10, 6, 40 };
        System.out.println(pairsum(arr));
    }

    public static int pairsum(int[] arr) {
        // code here
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for (int x : arr) {
            if (x > largest) {
                secondLargest = largest;
                largest = x;
            } else if (x > secondLargest)
                secondLargest = x;
        }
        return largest + secondLargest;
    }
}
