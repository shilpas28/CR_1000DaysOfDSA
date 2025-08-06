//Leetcode
//3479. Fruits Into Baskets III - Brute Force (Not accepted as TLE)
//Time complexity: O(N^2)
//Space complexity: O(1)

public class FruitsIntoBasketsIII {

    public static void main(String[] args) {
        int[] fruits = { 4, 2, 5 };
        int[] baskets = { 3, 5, 4 };
        System.out.println(numOfUnplacedFruits(fruits, baskets));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int rem = 0;
        int n = baskets.length;

        for (int fruit : fruits) {
            boolean placed = false;

            for (int i = 0; i < n; i++) {
                if (fruit <= baskets[i]) {
                    baskets[i] = 0;
                    placed = true;
                    break;
                }
            }

            if (!placed)
                rem++;
        }

        return rem;
    }
}
