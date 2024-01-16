//Leetcode
//380. Insert Delete GetRandom O(1)
//Time complexity:
//Space complexity: 

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;

public class InsertDeleteGetRandomOrder1 {

    static class RandomizedSet {
        ArrayList<Integer> nums;
        HashMap<Integer, Integer> locs;
        java.util.Random rand = new java.util.Random();

        /** Initialize your data structure here. */
        public RandomizedSet() {
            nums = new ArrayList<Integer>();
            locs = new HashMap<Integer, Integer>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain
         * the specified element.
         */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if (contain)
                return false;
            locs.put(val, nums.size());
            nums.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified
         * element.
         */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain)
                return false;
            int loc = locs.get(val);
            if (loc < nums.size() - 1) { // not the last one than swap the last one with this val
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                locs.put(lastone, loc);
            }
            locs.remove(val);
            nums.remove(nums.size() - 1);
            return true;
        }

        /** Get a random element from the set. */
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(randomizedSet.remove(2)); // Returns false as 2 does not exist in the set.
        System.out.println(randomizedSet.insert(2)); // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(randomizedSet.getRandom()); // getRandom() should return either 1 or 2 randomly.
        System.out.println(randomizedSet.remove(1)); // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(randomizedSet.insert(2)); // 2 was already in the set, so return false.
        System.out.println(randomizedSet.getRandom()); // Since 2 is the only number in the set, getRandom() will always return 2.
    }
}
