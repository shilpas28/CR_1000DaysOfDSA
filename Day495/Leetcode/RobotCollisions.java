//Leetcode
//2751. Robot Collisions
//Time complexity: O(nlogn)
//Space complexity: O(n)

import java.util.ArrayList;
import java.util.List;

public class RobotCollisions {

    static class Robot {
        int position;
        int health;
        char direction;
        int index;

        Robot(int position, int health, char direction, int index) {
            this.position = position;
            this.health = health;
            this.direction = direction;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        int[] positions = { 5, 4, 3, 2, 1 };
        int[] healths = { 2, 17, 9, 15, 10 };
        String directions = "RRRRR";
        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Robot> vals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            vals.add(new Robot(positions[i], healths[i], directions.charAt(i), i));
        }
        vals.sort((a, b) -> a.position - b.position);

        List<Robot> stack = new ArrayList<>();
        for (Robot robot : vals) {
            if (robot.direction == 'R') {
                stack.add(robot);
                continue;
            }
            boolean gone = false;
            while (!stack.isEmpty() && stack.get(stack.size() - 1).health <= robot.health
                    && stack.get(stack.size() - 1).direction == 'R') {
                if (stack.get(stack.size() - 1).health == robot.health) {
                    stack.remove(stack.size() - 1);
                    gone = true;
                    break;
                }
                robot.health--;
                stack.remove(stack.size() - 1);
            }
            if (!gone && !stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R'
                    && stack.get(stack.size() - 1).health > robot.health) {
                stack.get(stack.size() - 1).health--;
                gone = true;
            }
            if (!gone) {
                stack.add(robot);
            }
        }

        stack.sort((a, b) -> a.index - b.index);
        List<Integer> result = new ArrayList<>();
        for (Robot robot : stack) {
            result.add(robot.health);
        }
        return result;
    }
}
