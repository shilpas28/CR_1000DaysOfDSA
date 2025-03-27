//GFG
//2780. Minimum Index of a Valid Split - Not accepted as code doesnt work for all test cases 
//Time complexity: O(N^2)
//Space complexity: O(1)

public class MinimumPlatforms {

    public static void main(String[] args) {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        System.out.println(findPlatform(arr, dep));
    }

    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        int ans = 1; // final value
        for (int i = 0; i <= n - 1; i++) {
            int count = 1; // count of overlapping interval of only this iteration
            for (int j = i + 1; j <= n - 1; j++) {
                if ((arr[i] >= arr[j] && arr[i] <= dep[j]) ||
                        (arr[j] >= arr[i] && arr[j] <= dep[i])) {
                    count++;
                }
            }
            ans = Math.max(ans, count); // updating the value
        }
        return ans;
    }
}
