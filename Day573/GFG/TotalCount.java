//GFG
//Total count
//Time complexity: O(N)
//Space complexity: O(1)

public class TotalCount {

    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 5, 8, 10, 13 };
        System.out.println(totalCount(k, arr));
    }

    static int totalCount(int k, int[] arr) {
        // code here
        // code here
        int ans = 0;
        for (int x : arr) {
            ans += (x + k - 1) / k;
        }
        return ans;
    }
}
