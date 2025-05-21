//GFG
//Kth Smallest Number in Multiplication Table
//Time complexity: O(m * log (m*n))
//Space complexity: O(1)

public class KthSmallestNumberInMultiplicationTable_2 {

    public static void main(String[] args) {
        int m = 3, n = 3, k = 5;
        System.out.println(kthSmallest(m, n, k));
    }

    public static int kthSmallest(int m, int n, int k) {
        // code here
        int low = 1, high = m * n;

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = countLessEqual(mid, m, n);

            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    static int countLessEqual(int x, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count;
    }
}
