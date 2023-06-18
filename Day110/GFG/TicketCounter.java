//GFG - Brute Force Method (Accepted by GFG) 
//Ticket Counter
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class TicketCounter {

    public static void main(String[] args) {
        int N = 9;
        int K = 3;
        System.out.println(distributeTicket(N, K));
    }

    public static int distributeTicket(int N, int K) {
        int i = 1, j = N, ans = 0;
        boolean a = false;
        while (i <= j) {
            if (a == false) {
                i += K;
                ans = j;
            } else {
                j -= K;
                ans = i;
            }
            a = !a;
        }
        return ans;
    }
}
