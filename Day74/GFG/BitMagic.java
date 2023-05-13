//GFG
//Bit Magic
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class BitMagic {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = { 1, 0, 0, 0 };
        System.out.println(bitMagic(n, arr));
    }

    public static int bitMagic(int n, int[] arr) {
        // code here
        // Initialize count of differences
        int differenceCount = 0;
        // Initialize indices startIndex and endIndex
        int startIndex = 0;
        int endIndex = n - 1;
        // Iterate through the array until startIndex < endIndex
        while (startIndex < endIndex) {
            // If arr[startIndex] and arr[endIndex] are not equal, increment the count of
            // differences
            if (arr[startIndex] != arr[endIndex]) {
                differenceCount++;
            }
            // Move the indices inward
            startIndex++;
            endIndex--;
        }
        // Calculate the minimum number of operations required as (differenceCount + 1)
        // / 2
        return (differenceCount + 1) / 2;
    }
}
