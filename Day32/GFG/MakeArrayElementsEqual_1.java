//GFG - Optimal solution (using Mean)
//Make Array Elements Equal
//Time complexity: O(1)
//Space complexity: O(1)

package GFG;

public class MakeArrayElementsEqual_1 {
    public static void main(String[] args) {
        int N = 3;
        System.out.println(minOperations(N));
    }

    public static long minOperations(int N) {
        // Code here
        return (long)N*(long)N/4;
    }
}
