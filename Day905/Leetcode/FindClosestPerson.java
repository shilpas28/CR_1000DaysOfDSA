//Leetcode
//3516. Find Closest Person
//Time complexity: O(1)
//Space complexity: O(1)

public class FindClosestPerson {

    public static void main(String[] args) {
        int x = 2, y = 7, z = 4;
        System.out.println(findClosest(x, y, z));
    }

    public static int findClosest(int x, int y, int z) {
        int d1 = Math.abs(x - z);
        int d2 = Math.abs(y - z);

        if (d1 < d2)
            return 1;
        else if (d2 < d1)
            return 2;
        else
            return 0;
    }
}
