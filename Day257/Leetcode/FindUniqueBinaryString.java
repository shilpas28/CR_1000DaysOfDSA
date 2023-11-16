//Leetcode
//1980. Find Unique Binary String - Brute force: Base intuition
//Time complexity: O(2^N)
//Space complexity: O(N)

package Leetcode;

import java.util.HashSet;
import java.util.Set;

public class FindUniqueBinaryString {

    public static void main(String[] args) {
        String[] nums = { "01", "10" };
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> binSet = new HashSet<>();

        for (String s : nums) {
            binSet.add(s);
        }
        return binGenerate("", n, binSet);
    }

    static String binGenerate(String curr, int n, Set<String> binSet) {
        if (curr.length() == n) {
            if (!binSet.contains(curr))
                return curr;
            return "";
        }

        String addZero = binGenerate(curr + "0", n, binSet);
        if (!addZero.isEmpty())
            return addZero;

        return binGenerate(curr + "1", n, binSet);
    }
}
