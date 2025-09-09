//GFG
//Assign Mice Holes
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.Arrays;

public class AssignMiceHoles {

    public static void main(String[] args) {
        int mices[] = { 4, -4, 2 };
        int holes[] = { 4, 0, 5 };
        System.out.println(assignHole(mices, holes));
    }

    public static int assignHole(int[] mices, int[] holes) {
        // code here
        // minimise max distance
        // by greedlily calculating the minimum largest distance
        Arrays.sort(mices);
        Arrays.sort(holes);
        int max = 0;

        for (int i = 0; i < mices.length; i++) {
            max = Math.max(max, Math.abs(holes[i] - mices[i]));
        }
        return max;
    }
}
