//GFG
//Find Number
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

public class FindNumber {

    public static void main(String[] args) {
        long N = 3;
        System.out.println(findNumber(N));
    }

    public static long findNumber(long N) {
        long ans = 0;
        while (N != 0) {
            ans *= 10;
            if (N % 5 == 0) {
                ans += 9;
                N /= 5;
                N--;
            } else if (N % 5 == 1) {
                ans += 1;
                N /= 5;
            } else if (N % 5 == 2) {
                ans += 3;
                N /= 5;
            } else if (N % 5 == 3) {
                ans += 5;
                N /= 5;
            } else {
                ans += 7;
                N /= 5;
            }
        }
        long temp = 0;
        while (ans != 0) {
            temp = temp * 10 + ans % 10;
            ans /= 10;
        }
        return temp;
    }
}
