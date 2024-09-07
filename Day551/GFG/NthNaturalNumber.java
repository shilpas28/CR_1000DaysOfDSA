//GFG
//Nth Natural Number
//Time complexity: O(logN)
//Space complexity: O(1)

public class NthNaturalNumber {

    public static void main(String[] args) {
        long n = 8;
        System.out.println(findNth(n));
    }

    static long findNth(long n) {
        // code here
        long base10Num = n;
        long base9Num = 0;
        long pos = 1;
        while (base10Num > 0) {
            base9Num += pos * (base10Num % 9);
            base10Num /= 9;
            pos *= 10;
        }
        return base9Num;
    }
}
