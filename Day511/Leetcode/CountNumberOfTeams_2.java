//Leetcode
//1395. Count Number of Teams
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class CountNumberOfTeams_2 {

    public static void main(String[] args) {
        int[] rating = { 2, 5, 3, 4, 1 };
        System.out.println(numTeams(rating));
    }

    public static int numTeams(int[] rating) {
        if (rating.length < 3)
            return 0;

        int[] leftTree = new int[(int) 1e5 + 1];
        int[] rightTree = new int[(int) 1e5 + 1];
        for (int r : rating)
            update(rightTree, r, 1);

        int res = 0;
        for (int r : rating) {
            update(rightTree, r, -1);
            res += (getPrefixSum(leftTree, r - 1) * getSuffixSum(rightTree, r + 1)); // count increase
            res += (getSuffixSum(leftTree, r + 1) * getPrefixSum(rightTree, r - 1)); // count decrease
            update(leftTree, r, 1);
        }
        return res;
    }

    static void update(int[] BIT, int index, int val) {
        while (index < BIT.length) {
            BIT[index] += val;
            index += index & (-index);
        }
    }

    static int getPrefixSum(int[] BIT, int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }

    static int getSuffixSum(int[] BIT, int index) {
        return getPrefixSum(BIT, (int) 1e5) - getPrefixSum(BIT, index - 1);
    }
}
