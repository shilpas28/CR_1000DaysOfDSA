//GFG
//Count set bits
//Time complexity: O(logN)
//Space complexity: O(1) 

public class CountSetBits {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countSetBits(n));
    }

    public static int countSetBits(int n) {
        // code here
        int sum = 0;
        int f = 2;
        while ((f / 2) <= n) {
            sum += (n / f) * (f / 2);
            int rem = n - (n / f) * f + 1;
            if (rem > f / 2) {
                sum += rem - f / 2;
            }
            f *= 2;
        }
        return sum;
    }
}
