//GFG
//Split the Array
//Time complexity: O(N)
//Space complexity: O(1)

public class SplitTheArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.out.println(countgroup(arr));
    }

    public static int countgroup(int arr[]) {
        // Complete the function
        int xor = 0, n = arr.length;
        for (int i : arr)
            xor ^= i;
        if (xor != 0)
            return 0;
        return (1 << (n - 1)) - 1;
    }
}
