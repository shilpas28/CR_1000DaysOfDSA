//Leetcode
//552. Student Attendance Record II - Recursion with memoization
//Time complexity: O(n), due to memoization we will have only 2 * 3 * n unique states which is O(n)
//Space complexity: O(n) we use O(n) for recursion stack and O(2 * 3 * n) for memoization so O(7n) in total or just O(n)

package Leetcode;

public class StudentAttendanceRecordII {

    public static void main(String[] args) {
        int n = 2;
        System.out.println(checkRecord(n));
    }

    static final int MOD = 1000000007;

    public static int checkRecord(int n) {
        int[][][] temp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    temp[i][j][k] = -1;
                }
            }
        }
        return check_all_records(0, 0, 0, n, temp);
    }

    static int check_all_records(int cur_ind, int count_a, int count_l, int n, int[][][] temp) {
        if (cur_ind == n) {
            return 1;
        }
        if (temp[cur_ind][count_a][count_l] != -1) {
            return temp[cur_ind][count_a][count_l];
        }
        int with_a_next = (count_a == 0) ? check_all_records(cur_ind + 1, count_a + 1, 0, n, temp) : 0;
        int with_l_next = (count_l == 2) ? 0 : check_all_records(cur_ind + 1, count_a, count_l + 1, n, temp);
        int with_p_next = check_all_records(cur_ind + 1, count_a, 0, n, temp);
        int total = ((with_a_next + with_l_next) % MOD + with_p_next) % MOD;

        temp[cur_ind][count_a][count_l] = total;
        return total;
    }
}
