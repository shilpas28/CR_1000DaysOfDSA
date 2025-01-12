//GFG
//Trapping Rain Water - Better solution
//Time complexity: O(3*N) as we are traversing through the array only once. And O(2*N) for computing prefix and suffix array
//Space complexity: O(N)+O(N) for prefix and suffix arrays

public class TrappingRainWater_2 {

    public static void main(String[] args) {
        int arr[] = { 3, 0, 1, 0, 4, 0, 2 };
        System.out.println(maxWater(arr));
    }

    public static int maxWater(int arr[]) {
        // code here
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }
        suffix[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.max(suffix[i + 1], arr[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            waterTrapped += Math.min(prefix[i], suffix[i]) - arr[i];
        }
        return waterTrapped;
    }
}
