//GFG
//How Many X's?
//Time complexity: O(RLogR)
//Space complexity: O(1)

package GFG;

public class HowManyXs {

    public static void main(String[] args) {
        int L = 10, R = 19, X = 1;
        System.out.println(countX(L, R, X));
    }

    static int countX(int L, int R, int X) {
        // code here
        int count = 0;
        for (int i = L + 1; i < R; i++) {
            int num = i;
            while (num != 0) {
                if (num % 10 == X)
                    count++;
                num = num / 10;
            }
        }
        return count;
    }
}
