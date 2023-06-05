//Leetcode
//1232. Check If It Is a Straight Line
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CheckIfItIsAStraightLine {

    public static void main(String[] args) {
        int[][] coordinates = { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } };
        System.out.println(checkStraightLine(coordinates));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        // base case:- there are only two points, return true
        // otherwise, check each point lies on line using above equation.
        for(int i=2;i<coordinates.length;i++){
            if(!onLine(coordinates[i], coordinates[0], coordinates[1]))
                return false;
        }
        return true;
    }

    public static boolean onLine(int[] p1, int[] p2, int[] p3){
        int x = p1[0], y = p1[1], x1 = p2[0], y1 = p2[1], x2 = p3[0], y2 = p3[1];
        return ((y - y1) * (x2 - x1) == (y2 - y1) * (x - x1));
    }
}
