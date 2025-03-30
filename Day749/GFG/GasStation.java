//GFG
//Gas Station
//Time complexity: O(N)
//Space complexity: O(1)

public class GasStation {

    public static void main(String[] args) {
        int gas[] = { 4, 5, 7, 4 };
        int cost[] = { 6, 6, 3, 5 };
        System.out.println(startStation(gas, cost));
    }

    public static int startStation(int[] gas, int[] cost) {
        // Your code here
        int n = gas.length;

        int sum = 0;
        int start = 0;
        int total = 0;

        for (int i = 0; i < 2 * n; i++) {
            int index = i % n;
            sum += gas[index] - cost[index];
            total += gas[index] - cost[index];

            if (sum < 0) {
                sum = 0;
                start = i + 1;
            }
        }

        return total >= 0 ? start % n : -1;
    }
}
