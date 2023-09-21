//GFG
//Stickler Thief
//Time complexity: O(N)
//Space complexity: O(N)

public class SticklerThief {

    public static void main(String[] args) {
        int n = 5;
        int a[] = { 6, 5, 5, 7, 4 };
        System.out.println(FindMaxSum(a, n));
    }

    // Function to find the maximum money the thief can get.
    public static int FindMaxSum(int arr[], int n) {
        // Your code here
        int pre = arr[0];
        int pop = 0;
        int max = pre;

        for (int i = 1; i < n; i++) {
            max = Math.max(pre, pop + arr[i]);
            pop = pre;
            pre = max;
        }
        return max;
    }
}
