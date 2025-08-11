//Leetcode
//2438. Range Product Queries of Powers
//Time complexity: O(N^2)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Arrays;

public class RangeProductQueriesOfPowers {

    public static void main(String[] args) {
        int n = 15;
        int[][] queries = { { 0, 1 }, { 2, 2 }, { 0, 3 } };
        System.out.println(Arrays.toString(productQueries(n, queries)));
    }

    public static int[] productQueries(int n, int[][] queries) {
        String str = Integer.toBinaryString(n); // convert n into binary string to get minimum number of powers of 2
        ArrayList<Long> list = new ArrayList<>();
        long pow = 1;

        for (int i = str.length() - 1; i >= 0; i--) { // now loop on binary string
            if (str.charAt(i) == '1')
                list.add(pow); // if i'th bit is set add its power to our list
            pow = pow * 2;
        }

        long mod = (long) 1e9 + 7;
        int ans[] = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long mul = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) { // compute answer for each query
                mul = (mul * list.get(j)) % mod;
            }

            ans[i] = (int) mul;
        }
        return ans;
    }
}
