//Leetcode
//904. Fruit Into Baskets
//Time complexity: O(N)
//Space complexity: O(1)

public class FruitIntoBaskets_2 {

    public static void main(String[] args) {
        int[] fruits = { 1, 2, 1 };
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits) {
        // track last two fruits seen
        int lastFruit = -1;
        int secondLastFruit = -1;
        int lastFruitCount = 0;
        int currMax = 0;
        int max = 0;

        for (int fruit : fruits) {
            if (fruit == lastFruit || fruit == secondLastFruit)
                currMax++;
            else
                currMax = lastFruitCount + 1; // last fruit + new fruit

            if (fruit == lastFruit)
                lastFruitCount++;
            else
                lastFruitCount = 1;

            if (fruit != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = fruit;
            }

            max = Math.max(max, currMax);
        }

        return max;
    }
}
