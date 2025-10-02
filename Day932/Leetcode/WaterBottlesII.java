//Leetcode
//3100. Water Bottles II
//Time complexity: O(N)
//Space complexity: O(1)

public class WaterBottlesII {

    public static void main(String[] args) {
        int numBottles = 13, numExchange = 6;
        System.out.println(maxBottlesDrunk(numBottles, numExchange));
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum = numBottles, bottle = numBottles;
        while (bottle >= numExchange) {
            bottle -= numExchange;
            numExchange++;
            sum++;
            bottle++;
        }
        return sum;
    }
}
