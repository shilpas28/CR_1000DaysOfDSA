//GFG
//Tree Transformation
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

public class TreeTransformation {

    public static void main(String[] args) {
        int N = 5;
        int p[] = { -1, 0, 0, 1, 1 };
        System.out.println(solve(N, p));
    }

    public static int solve(int N, int[] p) {
        // code here
        int con[] = new int[N];
        for (int i = 1; i < N; i++) {
            con[i]++;
            con[p[i]]++;
        }
        int ans = 0; // leaf
        for (int x : con)
            if (x == 1)
                ans++;
        if (ans == N)
            return 0;
        return N - ans - 1;
    }
}
