//Leetcode
//3495. Minimum Operations to Make Array Elements Zero
//Time complexity: O(nlogR)
//Space complexity: O(1)

public class MinimumOperationsToMakeArrayElementsZero {

    public static void main(String[] args) {
        int[][] queries = { { 1, 2 }, { 2, 4 } };
        System.out.println(minOperations(queries));
    }

    public static long minOperations(int[][] queries) {
        long res = 0;
        for (int[] q : queries) {
            long count1 = get(q[1]);
            long count2 = get(q[0] - 1);
            res += (count1 - count2 + 1) / 2;
        }
        return res;
    }

    static long get(int num) {
        long cnt = 0;
        int i = 1;
        int base = 1;
        while (base <= num) {
            int end = Math.min(base * 2 - 1, num);
            cnt += (long) ((i + 1) / 2) * (end - base + 1);
            i++;
            base *= 2;
        }
        return cnt;
    }
}
