//GFG
//Not a subset sum
//Time complexity: O(N)
//Space complexity: O(1)

public class NotASubsetSum {

    public static void main(String[] args) {
        int arr[] = { 3, 6, 9, 10, 20, 28 };
        System.out.println(findSmallest(arr));
    }

    public static long findSmallest(int[] arr) {
        // Your code goes here
        long ans = 1;
        for (int x : arr) {
            if (x > ans)
                return ans;
            ans += x;
        }
        return ans;
    }
}
