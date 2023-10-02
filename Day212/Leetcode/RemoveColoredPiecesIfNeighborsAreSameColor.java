//Leetcode
//2038. Remove Colored Pieces if Both Neighbors are the Same Color
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class RemoveColoredPiecesIfNeighborsAreSameColor {

    public static void main(String[] args) {
        String colors = "AAABABB";
        System.out.println(winnerOfGame(colors));
    }

    public static boolean winnerOfGame(String colors) {
        int a = 0, b = 0;

        for (int i = 1; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i - 1) && colors.charAt(i) == colors.charAt(i + 1)) {
                if (colors.charAt(i) == 'A')
                    a++;
                else
                    b++;
            }
        }
        return a > b;
    }
}
