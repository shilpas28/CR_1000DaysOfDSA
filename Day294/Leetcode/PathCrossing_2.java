//Leetcode
//1496. Path Crossing
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class PathCrossing_2 {

    public static void main(String[] args) {
        String path = "NESWW";
        System.out.println(isPathCrossing(path));
    }

    public static boolean isPathCrossing(String path) {
        int x = 0, y = 0;
        Set<String> visited = new HashSet<>();
        visited.add("0,0");

        for (char direction : path.toCharArray()) {
            if (direction == 'E') {
                x++;
            } else if (direction == 'W') {
                x--;
            } else if (direction == 'N') {
                y++;
            } else if (direction == 'S') {
                y--;
            }

            String currentPos = x + "," + y;
            if (visited.contains(currentPos)) {
                return true;
            }

            visited.add(currentPos);
        }
        return false;
    }
}
