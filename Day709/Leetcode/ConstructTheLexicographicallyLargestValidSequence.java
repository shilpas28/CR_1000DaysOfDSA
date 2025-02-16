//Leetcode
//1718. Construct the Lexicographically Largest Valid Sequence
//Time complexity: O(N!)
//Space complexity: O(N)

import java.util.Arrays;

public class ConstructTheLexicographicallyLargestValidSequence {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(Arrays.toString(constructDistancedSequence(n)));
    }

    public static int[] constructDistancedSequence(int n) {
        int[] sol = new int[(2 * n) - 1];
        boolean[] visited = new boolean[n + 1];
        helper(0, sol, visited, n);
        return sol;
    }

    static boolean helper(int i, int[] sol, boolean[] visited, int n) {
        if (i == sol.length)
            return true;

        if (sol[i] != 0) {
            return helper(i + 1, sol, visited, n);
        }

        for (int j = n; j > 0; j--) {
            if (!visited[j] && (j == 1 || i + j < sol.length && sol[i + j] == 0)) {
                sol[i] = j;
                if (j != 1)
                    sol[i + j] = j;
                visited[j] = true;

                if (helper(i + 1, sol, visited, n))
                    return true;

                sol[i] = 0;
                if (j != 1)
                    sol[i + j] = 0;
                visited[j] = false;
            }
        }
        return false;
    }
}
