//Leetcode
//1518. Water Bottles
//Time complexity: O(1)
//Space complexity: O(1)

public class WaterBottles_2 {

    public static void main(String[] args) {
        int numBottles = 9, numExchange = 3;
        System.out.println(numWaterBottles(numBottles, numExchange));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        return numBottles + (numBottles - 1) / (numExchange - 1);
    }
}
