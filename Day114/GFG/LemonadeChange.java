//GFG
//Lemonade Change
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class LemonadeChange {

    public static void main(String[] args) {
        int N = 5;
        int bills[] = { 5, 5, 5, 10, 20 };
        System.out.println(lemonadeChange(N, bills));
    }

    static boolean lemonadeChange(int N, int bills[]) {
        // code here
        int five = 0;
        int ten = 0;
        for (int i = 0; i < N; i++) {
            int x = bills[i];
            if (x == 5)
                five++;
            else if (x == 10) {
                five--;
                ten++;
            } else {
                if (x == 20) // will not use anytime for returning as change
                {
                    if (ten > 0) {
                        ten--;
                        five--;
                    } else {
                        five -= 3;
                    }
                }
            }
            if (five < 0)
                return false;
        }
        return true;
    }
}
