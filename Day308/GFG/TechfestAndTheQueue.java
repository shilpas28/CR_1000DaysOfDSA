//GFG
//Techfest and the Queue
//Time complexity: O( b*log(b) )
//Space complexity: O( b*log(b) ) 

package GFG;

public class TechfestAndTheQueue {

    public static void main(String[] args) {
        long a = 9, b = 12;
        System.out.println(sumOfPowers(a, b));
    }

    public static long sumOfPowers(long a, long b) {
        // code here
        long sum = 0;
        while (a <= b && (b - a) <= 100000) {
            sum += factors(a);
            a++;
        }
        return sum;
    }

    public static long factors(long num) {
        long factorSum = 0;
        if (num <= 1)
            return 0;
        while (num % 2 == 0) {
            factorSum++;
            num /= 2;
        }
        for (long i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0 && num > 0) {
                factorSum++;
                num /= i;
            }
        }
        if (num > 2)
            factorSum++;
        return factorSum;
    }
}
