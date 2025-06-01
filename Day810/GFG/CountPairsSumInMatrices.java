//GFG
//Count pairs Sum in matrices
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.HashMap;

public class CountPairsSumInMatrices {

    public static void main(String[] args) {
        int x = 21;
        int mat1[][] = { { 1, 5, 6 }, { 8, 10, 11 }, { 15, 16, 18 } };
        int mat2[][] = { { 2, 4, 7 }, { 9, 10, 12 }, { 13, 16, 20 } };
        System.out.println(countPairs(mat1, mat2, x));
    }

    static int countPairs(int[][] mat1, int[][] mat2, int x) {
        // code here
        int n = mat1.length;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(mat2[i][j], map.getOrDefault(0, 1) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int remaining = x - mat1[i][j];
                if (map.containsKey(remaining)) {
                    count = count + 1;
                }
            }
        }
        return count;
    }
}
