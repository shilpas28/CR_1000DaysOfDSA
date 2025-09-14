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
        // code here
        int totalGas = 0;
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        if (totalGas < totalCost) {
            return -1;
        }

        int currentGas = 0;
        int startStation = 0;
        for (int i = 0; i < gas.length; i++) {
            currentGas += gas[i] - cost[i];
            if (currentGas < 0) {
                currentGas = 0;
                startStation = i + 1;
            }
        }

        return startStation;
    }
}
