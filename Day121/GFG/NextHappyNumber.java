//GFG
//Next Happy Number
//Time complexity: O(Nlog10N)
//Space complexity: O(1)

package GFG;

import java.util.HashMap;

public class NextHappyNumber {

    public static void main(String[] args) {
        int N = 8;
        System.out.println(nextHappy(N));
    }

    static int nextHappy(int N) {
        // code here
        int nextNumber = N + 1;
        while (true) {
            if (isHappy(nextNumber)) {
                return nextNumber;
            }
            nextNumber++;
        }
    }

    public static boolean isHappy(int n) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        while (!mp.containsKey(n)) {
            mp.put(n, 1);
            int sum = 0;
            while (n > 0) {
                int digit = n % 10;
                sum += digit * digit;
                n = n / 10;
            }
            if (sum == 1) {
                return true;
            }
            n = sum;
        }
        return false;
    }
}
