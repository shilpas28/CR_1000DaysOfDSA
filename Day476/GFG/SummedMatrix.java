//GFG
//Summed Matrix
//Time complexity: O(1)
//Space complexity: O(1) 

public class SummedMatrix {

    public static void main(String[] args) {
        long n = 4, q = 7;
        System.out.println(sumMatrix(n, q));
    }

    static long sumMatrix(long n, long q) {
        // code here
        if (q > 2 * n || q < 2)
            return 0;
        else if (n >= q)
            return q - 1;
        else {
            long diff = q - n;
            return n - (diff - 1);
        }
    }
}
