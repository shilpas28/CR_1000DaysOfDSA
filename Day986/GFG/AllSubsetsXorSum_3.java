//GFG
//All Subsets Xor Sum
//Time complexity: O(N)
//Space complexity: O(1)

public class AllSubsetsXorSum_3 {

    public static void main(String[] args) {
        int[] arr = {7, 2};
        System.out.println(subsetXORSum(arr));
    }

    static int subsetXORSum(int arr[]) {
        // code here
        int or = 0;
        for (int x : arr) {
            or |= x;
        }
        int n = arr.length;
        return or * (1 << (n - 1));
    }
}
