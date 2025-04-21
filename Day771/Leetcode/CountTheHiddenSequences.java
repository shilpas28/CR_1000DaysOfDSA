//Leetcode
//2145. Count the Hidden Sequences
//Time complexity: O(N)
//Space complexity: O(1)

public class CountTheHiddenSequences {

    public static void main(String[] args) {
        int[] differences = { 1, -3, 4 };
        int lower = 1, upper = 6;
        System.out.println(numberOfArrays(differences, lower, upper));
    }

    public static int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0, maxi = 0, mini = 0;
        for (int x : differences) {
            sum += x;
            maxi = Math.max(maxi, sum);
            mini = Math.min(mini, sum);
        }
        return (int) Math.max(0, upper - lower - maxi + mini + 1);
    }
}
