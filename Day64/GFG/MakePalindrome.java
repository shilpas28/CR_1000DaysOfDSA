//GFG
//Make Palindrome
//Time complexity: O(n * len(arr[i]))
//Space complexity: O(n * len(arr[i]))

package GFG;

import java.util.HashMap;
import java.util.Map;

public class MakePalindrome {

    public static void main(String[] args) {
        int n = 4;
        String[] arr = { "djfh", "gadt", "hfjd", "tdag" };
        System.out.println(makePalindrome(n, arr));
    }

    public static boolean makePalindrome(int n, String[] arr) {
        // code here
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            String str = arr[i];
            String rev = new StringBuffer(str).reverse().toString();

            if (!map.get(str).equals(map.get(rev))) {
                return false;
            }
        }
        return true;
    }
}
