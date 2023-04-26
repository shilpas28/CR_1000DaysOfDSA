//GFG
//Seating Arrangement
//Time complexity: O(M) where M is no:of seats 
//Space complexity: O(1)

package GFG;

public class SeatingArrangement {

    public static void main(String[] args) {
        int n = 2;
        int m = 7;
        int seats[] = { 0, 0, 1, 0, 0, 0, 1 };
        System.out.println(is_possible_to_get_seats(n, m, seats));
    }

    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        if (n > m)
            return false;

        if (n == 0)
            return true;

        if (m == 1)
            return seats[0] == 0;

        int i = 0;
        while (i < m) {
            if (seats[i] == 0) {
                if (i == 0) {
                    if (seats[i + 1] != 1) {
                        n--;
                        if (n == 0)
                            return true;
                        seats[i] = 1;
                    }
                } else if (i == m - 1) {
                    if (seats[i - 1] != 1) {
                        n--;
                        seats[i] = 1;
                        if (n == 0)
                            return true;
                    }
                } else {
                    if (seats[i - 1] != 1 && seats[i + 1] != 1) {
                        n--;
                        seats[i] = 1;
                        if (n == 0)
                            return true;
                    }
                }
            }
            i++;
        }
        return n <= 0;
    }
}
