//Leetcode
//2594. Minimum Time to Repair Cars - Space Optimized Binary Search
//Time complexity: O(n*log(m*max_rank))
//Space complexity: O(1) 

public class MinimumTimeToRepairCars_2 {

    public static void main(String[] args) {
        int[] ranks = { 4, 2, 3, 1 };
        int cars = 10;
        System.out.println(repairCars(ranks, cars));
    }

    public static long repairCars(int[] ranks, int cars) {
        // The minimum possible time is 1,
        // and the maximum possible time is when the slowest mechanic (highest rank)
        // repairs all cars.
        long low = 1, high = 1L * ranks[0] * cars * cars;
        // Perform binary search to find the minimum time required.
        while (low < high) {
            long mid = (low + high) / 2, carsRepaired = 0;
            // Calculate the number of cars that can be repaired in 'mid' time by all
            // mechanics.
            for (int rank : ranks)
                carsRepaired += (long) (Math.sqrt(
                        (1.0 * mid) / rank));
            // If the total cars repaired is less than required, increase the time.
            if (carsRepaired < cars)
                low = mid + 1;
            else
                high = mid; // Otherwise, try a smaller time.
        }
        return low;
    }
}
