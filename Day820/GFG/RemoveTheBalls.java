//GFG
//Remove the balls
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Stack;

public class RemoveTheBalls {

    static class Pair {
        int color;
        int radius;

        Pair(int color, int radius) {
            this.color = color;
            this.radius = radius;
        }
    }

    public static void main(String[] args) {
        int color[] = { 2, 3, 5 };
        int radius[] = { 3, 3, 5 };
        System.out.println(findLength(color, radius));
    }

    public static int findLength(int[] color, int[] radius) {
        // code here
        Stack<Pair> stack = new Stack<>();
        int N = color.length;
        for (int i = 0; i < N; i++) {
            if (!stack.isEmpty()) {
                if (stack.peek().color == color[i] && stack.peek().radius == radius[i])
                    stack.pop();
                else
                    stack.add(new Pair(color[i], radius[i]));
            } else
                stack.add(new Pair(color[i], radius[i]));
        }
        return stack.size();
    }
}
