//Leetcode
//2179. Count Good Triplets in an Array - Binary Indexed Tree / Fenwick Tree
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class CountGoodTripletsInAnArray_3 {

    public static void main(String[] args) {
        int[] nums1 = { 2, 0, 1, 3 };
        int[] nums2 = { 0, 1, 2, 3 };
        System.out.println(goodTriplets(nums1, nums2));
    }

    static class Fenwick {
        public long[] tree;

        Fenwick(int n) {
            tree = new long[n + 1];
        }

        public void update(int k, int x) {
            k++;
            while (k < tree.length) {
                tree[k] += x;
                k += k & -k;
            }
        }

        public long query(int k) {
            long total = 0;
            k++;
            while (k > 0) {
                total += tree[k];
                k -= k & -k;
            }
            return total;
        }
    }

    public static long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long total = 0;
        int[] mpp = new int[n];
        for (int i = 0; i < n; i++)
            mpp[nums1[i]] = i;
        Fenwick fw = new Fenwick(n);
        for (int i : nums2) {
            int idx = mpp[i];
            long left = fw.query(idx);
            long total_inner = fw.query(n - 1);
            long right = (n - 1 - idx) - (total_inner - left);
            total += left * right;
            fw.update(idx, 1);
        }
        return total;
    }
}
