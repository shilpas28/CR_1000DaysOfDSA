//GFG
//Count numbers containing 4
//Time complexity: O(N*M)
//Space complexity: O(1) 

public class CountNumbersContaining4 {

    public static void main(String[] args) {
        int n = 44;
        System.out.println(countNumberswith4(n));
    }

    public static int countNumberswith4(int n) {
        // code here
        int ans = 0;
        for (int i = 4; i <= n; i++) {
            int j = i;
            while (j > 0) {
                if (j % 10 == 4) {
                    ans++;
                    break;
                }
                j /= 10;
            }
        }
        return ans;
    }
}
