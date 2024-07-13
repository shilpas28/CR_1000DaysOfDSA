//Leetcode
//2751. Robot Collisions
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class RobotCollisions_2 {

    public static void main(String[] args) {
        int[] positions = { 5, 4, 3, 2, 1 };
        int[] healths = { 2, 17, 9, 15, 10 };
        String directions = "RRRRR";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> ind = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            ind.add(i);
        }
        Collections.sort(ind, (x, y) -> Integer.compare(positions[x], positions[y]));
        Stack<Integer> s = new Stack<>();
        for (int x : ind) {
            if (directions.charAt(x) == 'L') {
                while (!s.empty()) {
                    int y = s.peek();
                    if (healths[x] == healths[y]) {
                        healths[x] = 0;
                        healths[y] = 0;
                        s.pop();
                        break;
                    }
                    if (healths[x] > healths[y]) {
                        healths[x]--;
                        healths[y] = 0;
                        s.pop();
                    } else {
                        healths[x] = 0;
                        healths[y]--;
                        break;
                    }
                }
            } else {
                s.push(x);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int x : healths) {
            if (x != 0) {
                result.add(x);
            }
        }
        return result;
    }
}
