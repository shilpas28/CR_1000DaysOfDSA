//Leetcode
//2141. Maximum Running Time of N Computers
//Time complexity: O(NlogM) where N is no:of batteries and M is sum of time of all batteries
//Space complexity: O(1)

public class MaximumRunningTimeOfNComputers {

    public static void main(String[] args) {
        int n = 2;
        int[] batteries = {3, 3, 3};
        System.out.println(maxRunTime(n, batteries));
    }

    public static long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries) {
            sumPower += power;
        }
        long left = 1, right = sumPower / n;

        while (left < right) {
            long time = (left + right + 1) / 2;
            if (check(batteries, n, time)) {
                left = time; 
            }else {
                right = time - 1;
            }
        }
        return left;
    }

    public static boolean check(int[] B, int n, long time) {
        long sum = 0;
        for (int battery : B) {
            sum += Math.min(battery, time);
        }
        return (sum >= (long) time * n);
    }
}
