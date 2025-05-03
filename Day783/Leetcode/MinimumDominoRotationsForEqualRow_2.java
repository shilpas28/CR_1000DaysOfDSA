//Leetcode
//1007. Minimum Domino Rotations For Equal Row - Using HashMap 
//Time complexity: O(N) [O(7N) approx O(N)]
//Space complexity: O(1)

package Leetcode;

public class MinimumDominoRotationsForEqualRow_2 {

    public static void main(String[] args) {
        int[] tops = { 2, 1, 2, 4, 2, 2 };
        int[] bottoms = { 5, 2, 6, 2, 3, 2 };
        System.out.println(minDominoRotations(tops, bottoms));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int n = tops.length, res = Integer.MAX_VALUE;
        int[] face = new int[7];
        for (int i = 0; i < n; i++) {
            face[tops[i]]++;
            if (bottoms[i] != tops[i])
                face[bottoms[i]]++;
        }

        for (int x = 1; x <= 6; x++) {
            if (face[x] < n)
                continue;
            int maintainTop = 0, maintainBottom = 0;
            boolean possible = true;

            for (int i = 0; i < n; i++) {
                if (tops[i] != x && bottoms[i] != x) {
                    possible = false;
                    break;
                }
                if (tops[i] != x)
                    maintainTop++;
                if (bottoms[i] != x)
                    maintainBottom++;
            }

            if (possible)
                res = Math.min(res, Math.min(maintainTop, maintainBottom));
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
