//Leetcode
//1497. Check If Array Pairs Are Divisible by k
//Time complexity: O(N)
//Space complexity: O(k)

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisibleByK {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 10, 6, 7, 8, 9 };
        int k = 5;
        System.out.println(canArrange(arr, k));
    }

    public static boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remainderFreqMap = new HashMap<>();
        int count = 0; // available pair count

        for (int num : arr) {
            int remainder = (num % k + k) % k; // if n % k < 0, add k to make it positive
            int complementaryRemainder = (k - remainder) % k;
            if (remainderFreqMap.containsKey(complementaryRemainder)
                    && remainderFreqMap.get(complementaryRemainder) > 0) {
                remainderFreqMap.put(complementaryRemainder, remainderFreqMap.get(complementaryRemainder) - 1);
                count++;
            } else {
                remainderFreqMap.put(remainder, remainderFreqMap.getOrDefault(remainder, 0) + 1);
            }
        }

        return count == arr.length / 2;
    }
}
