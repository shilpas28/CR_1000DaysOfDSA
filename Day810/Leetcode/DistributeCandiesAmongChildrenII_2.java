//Leetcode
//2929. Distribute Candies Among Children II - Inclusion-Exclusion Principle
//Time complexity: O(1)
//Space complexity: O(1) 

public class DistributeCandiesAmongChildrenII_2 {

    public static void main(String[] args) {
        int n = 5, limit = 2;
        System.out.println(distributeCandies(n, limit));
    }

    public static long distributeCandies(int n, int limit) {
        return (cal(n + 2) -
                3 * cal(n - limit + 1) +
                3 * cal(n - (limit + 1) * 2 + 2) -
                cal(n - 3 * (limit + 1) + 2));
    }

    public static long cal(int x) {
        if (x < 0) {
            return 0;
        }
        return ((long) x * (x - 1)) / 2;
    }
}
