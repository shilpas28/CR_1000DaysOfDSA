//Leetcode
//319. Bulb Switcher
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class BulbSwitcher {
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(bulbSwitch(n));
    }

    public static int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }
}
