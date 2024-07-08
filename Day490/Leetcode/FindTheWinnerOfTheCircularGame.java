//Leetcode
//1823. Find the Winner of the Circular Game - Simulation
//Time complexity: O(n^2), since you remove n - 1 friends from circle with pop operation (which is O(n)).
//Space complexity: O(n), since we use additional array of size n - circle

import java.util.ArrayList;

public class FindTheWinnerOfTheCircularGame {

    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.println(findTheWinner(n, k));
    }

    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> circle = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            circle.add(i);
        }

        int cur_ind = 0;
        while (circle.size() > 1) {
            int next_to_remove = (cur_ind + k - 1) % circle.size();
            circle.remove(next_to_remove);
            cur_ind = next_to_remove;
        }
        return circle.get(0);
    }
}
