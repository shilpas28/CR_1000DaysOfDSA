//Leetcode
//458. Poor Pigs
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class PoorPigs {

    public static void main(String[] args) {
        int buckets = 4, minutesToDie = 15, minutesToTest = 15;
        System.out.println(poorPigs(buckets, minutesToDie, minutesToTest));
    }

    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Calculate the max time for a pig to test buckets...
        // Note that, max time will not be (minutesToTest / minutesToDie)...
        // Thinking about all pigs drinking all buckets at last, but no one died
        // immediately, so the poison bucket is the last bucket...
        int max_time = minutesToTest / minutesToDie + 1;
        // Initialize the required minimum number of pigs...
        int req_pigs = 0;
        // To find the minimum number of pigs, find the minimum req_pigs such that
        // Math.pow(max_time, req_pigs) >= buckets...
        while (Math.pow(max_time, req_pigs) < buckets)
            // Increment until it will be greater or equals to bucket...
            ++req_pigs;
        // Return the required minimum number of pigs...
        return req_pigs;
    }
}
