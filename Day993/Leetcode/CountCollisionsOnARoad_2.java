//Leetcode
//2211. Count Collisions on a Road - Simulation
//Time complexity: O(N)
//Space complexity: O(1)

public class CountCollisionsOnARoad_2 {

    public static void main(String[] args) {
        String directions = "RLRSLL";
        System.out.println(countCollisions(directions));
    }

    public static int countCollisions(String directions) {
        int res = 0;
        int flag = -1;
        for (char c : directions.toCharArray()) {
            if (c == 'L') {
                if (flag >= 0) {
                    res += flag + 1;
                    flag = 0;
                }
            } else if (c == 'S') {
                if (flag > 0) {
                    res += flag;
                }
                flag = 0;
            } else {
                if (flag >= 0) {
                    flag++;
                } else {
                    flag = 1;
                }
            }
        }
        return res;
    }
}
