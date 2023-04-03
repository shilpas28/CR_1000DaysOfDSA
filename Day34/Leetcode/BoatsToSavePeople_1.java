//Leetcode - using Count Sort to optimize further
//881. Boats to Save People
//Time complexity: O(n * log(limit))
//Space complexity: O(1)

package Leetcode;

public class BoatsToSavePeople_1 {

    public static void main(String[] args) {
        int[] people = { 1, 2 };
        int limit = 3;
        System.out.println(numRescueBoats(people, limit));
    }

    public static int numRescueBoats(int[] people, int limit) {
        int[] count = new int[limit + 1]; //Count Sort
        for (int p : people)
            count[p]++;
        int idx = 0;
        for (int val = 1; val <= limit; val++) {
            while (count[val]-- > 0)
                people[idx++] = val;
        }
        //Same code as earlier
        int boatCount = 0, left = 0, right = people.length - 1;
        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
                right--;
            } else {
                right--;
            }
            boatCount++;
        }
        return boatCount;
    }
}
