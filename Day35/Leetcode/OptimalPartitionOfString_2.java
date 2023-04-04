//Leetcode - using Bit operations
//2405. Optimal Partition of String
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class OptimalPartitionOfString_2 {

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {
        int i = 0, ans = 1, flag = 0;
        while (i < s.length()) {
            int val = s.charAt(i) - 'a';
            if ((flag & (1 << val)) != 0) {
                flag = 0;
                ans++;
            }
            flag = flag | (1 << val);
            i++;
        }
        return ans;
    }
}
