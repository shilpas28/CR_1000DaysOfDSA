//Leetcode
//3100. Water Bottles II
//Time complexity: O(sqrt(N))
//Space complexity: O(1) 

public class WaterBottlesII_2 {

    public static void main(String[] args) {
        int numBottles = 13, numExchange = 6;
        System.out.println(maxBottlesDrunk(numBottles, numExchange));
    }

    public static int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        for (int empty = numBottles; empty >= numExchange; numExchange++) {
            ans++;
            empty -= numExchange - 1;
        }
        return ans;
    }
}
