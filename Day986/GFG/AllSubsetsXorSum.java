//GFG
//All Subsets Xor Sum
//Time complexity: O(N)
//Space complexity: O(1)

public class AllSubsetsXorSum {

    public static void main(String[] args) {
        int[] arr = {7, 2};
        System.out.println(subsetXORSum(arr));
    }

    static int subsetXORSum(int arr[]) {
        // code here
        int n = arr.length;
        int ans = 0;

        for (int bit = 0; bit <= 10; bit++) {
            int countSet = 0;
            for (int i = 0; i < n; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    countSet++;
                }
            }
            if (countSet > 0) {
                ans += (1 << bit) * (1 << (n - 1));
            }
        }
        return ans;
    }
}
