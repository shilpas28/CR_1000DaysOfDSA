//Leetcode
//552. Student Attendance Record II - Space-optimized DP
//Time complexity: O(n), due to the fact that we have 2 * 3 * n iterations.
//Space complexity: O(1) since we have only two arrays of constant size 2x3

package Leetcode;

public class StudentAttendanceRecordII_2 {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(checkRecord(n));
    }

    static final int MOD = 1000000007;

    public static int checkRecord(int n) {
        int[][] dp_last = new int[2][3]; // previous state
        int[][] dp_current = new int[2][3]; // current state

        dp_last[0][0] = 1; // empty string

        for (int i = 0; i < n; i++) {
            for (int count_a = 0; count_a < 2; count_a++) {
                for (int count_l = 0; count_l < 3; count_l++) {
                    // choose "P"
                    dp_current[count_a][0] = (dp_current[count_a][0] + dp_last[count_a][count_l]) % MOD;
                    // choose "A"
                    if (count_a == 0) {
                        dp_current[count_a + 1][0] = (dp_current[count_a + 1][0] + dp_last[count_a][count_l]) % MOD;
                    }
                    // Choose "L"
                    if (count_l < 2) {
                        dp_current[count_a][count_l
                                + 1] = (dp_current[count_a][count_l + 1] + dp_last[count_a][count_l]) % MOD;
                    }
                }
            }
            dp_last = dp_current; // Reference current to previous
            dp_current = new int[2][3]; // make new current
        }

        // Sum up the counts for all combinations of length 'n' with different count_a
        // and count_l.
        int res = 0;
        for (int count_a = 0; count_a < 2; count_a++) {
            for (int count_l = 0; count_l < 3; count_l++) {
                res = (res + dp_last[count_a][count_l]) % MOD;
            }
        }
        return res;
    }
}
