//Leetcode
//1052. Grumpy Bookstore Owner
//Time complexity: O(N)
//Space complexity: O(1)

public class GrumpyBookstoreOwner_2 {

    public static void main(String[] args) {
        int[] customers = { 1, 0, 1, 2, 1, 1, 7, 5 }, grumpy = { 0, 1, 0, 1, 0, 1, 0, 1 };
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0, maxMakeSatisfied = 0;
        for (int i = 0, winOfMakeSatisfied = 0; i < grumpy.length; ++i) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            } else {
                winOfMakeSatisfied += customers[i];
            }
            if (i >= minutes) {
                winOfMakeSatisfied -= grumpy[i - minutes] * customers[i - minutes];
            }
            maxMakeSatisfied = Math.max(winOfMakeSatisfied, maxMakeSatisfied);
        }
        return satisfied + maxMakeSatisfied;
    }
}
