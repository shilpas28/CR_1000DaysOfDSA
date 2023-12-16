//GFG
//String's Count
//Time complexity: O(1)
//Space complexity: O(1)

public class StringsCount_2 {

    public static void main(String[] args) {
        long n = 1;
        System.out.println(countStr(n));
    }

    static long countStr(long n) {
        // code here
        long ans = ((1 + 2 * n) + (n * (n * n - 1) / 2));
        return ans;
    }
}
