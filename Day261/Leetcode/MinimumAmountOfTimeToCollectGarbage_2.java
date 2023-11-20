//Leetcode
//2391. Minimum Amount of Time to Collect Garbage
//Time complexity: O(T∗G) - where T is length of travel variable and G is average time to find garbage in garbage string. But 
//once we found the garbage, it will be O(T). In reality, I think it's faster than this time complexity. In fact, this code beats 
//more than 98%.
//Space complexity: O(1)

package Leetcode;

public class MinimumAmountOfTimeToCollectGarbage_2 {

    public static void main(String[] args) {
        String[] garbage = { "G", "P", "GP", "GG" };
        int[] travel = { 2, 4, 3 };
        System.out.println(garbageCollection(garbage, travel));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int res = 0;
        for (String g : garbage) {
            res += g.length();
        }

        boolean m = false, p = false, g = false;
        for (int i = travel.length; i > 0; i--) {
            m = m || garbage[i].contains("M");
            p = p || garbage[i].contains("P");
            g = g || garbage[i].contains("G");

            res += travel[i - 1] * ((m ? 1 : 0) + (p ? 1 : 0) + (g ? 1 : 0));
        }
        return res;
    }
}
