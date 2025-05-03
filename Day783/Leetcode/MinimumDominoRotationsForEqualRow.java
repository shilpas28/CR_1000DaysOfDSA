//Leetcode
//1007. Minimum Domino Rotations For Equal Row - Brute Force
//Time complexity: O(N) [O(12N) approx O(N)]
//Space complexity: O(1)

package Leetcode;

public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        int[] tops = { 2, 1, 2, 4, 2, 2 };
        int[] bottoms = { 5, 2, 6, 2, 3, 2 };
        System.out.println(minDominoRotations(tops, bottoms));
    }

    public static int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Integer.MAX_VALUE;
        for (int i = 1; i <= 6; i++) {
            res = Math.min(res, getRotation(tops, bottoms, i));
            res = Math.min(res, getRotation(bottoms, tops, i));
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    static int getRotation(int[] tops, int[] bottoms, int target) {
        int rotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] == target)
                continue;
            if (bottoms[i] == target)
                rotations++;
            else
                return Integer.MAX_VALUE;
        }
        return rotations;
    }
}
