//GFG
//Predict the Column
//Time complexity: O(N^2)
//Space complexity: O(1)

package GFG;

public class PredictTheColumn {

    public static void main(String[] args) {
        int N = 3;
        int M[][] = { { 0, 0, 0 },
                { 1, 0, 1 },
                { 0, 1, 1 } };
        System.out.println(columnWithMaxZeros(M, N));
    }

    static int columnWithMaxZeros(int arr[][], int N) {
        // code here
        int ans = 0;
        int idx = -1;
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (arr[j][i] == 0)
                    cnt++;
            }
            if (cnt > ans) {
                ans = cnt;
                idx = i;
            }
        }
        return idx;
    }
}
