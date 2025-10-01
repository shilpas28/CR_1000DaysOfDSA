//Leetcode
//1518. Water Bottles
//Time complexity: O(logN)
//Space complexity: O(1)

public class WaterBottles {

    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange) {
            int remainder = numBottles % numExchange;
            numBottles /= numExchange;
            ans += numBottles;
            numBottles += remainder;
        }
        return ans;
    }
}
