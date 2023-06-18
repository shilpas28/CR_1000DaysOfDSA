//GFG - Optimal Solution
//Ticket Counter
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class TicketCounter_2 {
    public static void main(String[] args) {
        int N = 9;
        int K = 3;
        System.out.println(distributeTicket(N, K));
    }

    public static int distributeTicket(int N, int K) {
        int step = N / K;
        int left = step / 2;
        int right = left;
        if (step % 2 == 1)
            left++;
        int i = K * left;
        int j = N + 1 - K * right;
        if (step % 2 == 1) {
            if (N % K == 0)
                return i;
            return i + 1;
        }
        if (N % K == 0)
            return j;
        return j - 1;
    }
}
