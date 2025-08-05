//Leetcode
//3477. Fruits Into Baskets II
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class FruitsIntoBasketsII_2 {

    public static void main(String[] args) {
        int[] fruits = { 4, 2, 5 };
        int[] baskets = { 3, 5, 4 };
        System.out.println(numOfUnplacedFruits(fruits, baskets));
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length, alloted = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (fruits[i] <= baskets[j]) {
                    alloted++;
                    baskets[j] = -1;
                    break;
                }
            }
        }
        return n - alloted;
    }
}
