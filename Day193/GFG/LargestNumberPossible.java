//GFG
//Largest number possible
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class LargestNumberPossible {

    public static void main(String[] args) {
        int N = 2, S = 9;
        System.out.println(findLargest(N, S));
    }

    static String findLargest(int N, int S) {
        // code here
        StringBuilder ans = new StringBuilder();
        if (S == 0 && N > 1)
            return "-1";
        for (int i = 0; i < N; i++) {
            if (S >= 9) {
                ans.append('9');
                S -= 9;
            }
            else {
                ans.append((char) (S + 48));
                S = 0;
            }
        }
        if (S > 0) // eg N=2, S=20
            return "-1";
        return ans.toString();
    }
}
