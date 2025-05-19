//Leetcode
//3024. Type of Triangle - Without Sort
//Time complexity: O(1)
//Space complexity: O(1)

import java.util.HashSet;

public class TypeOfTriangle_2 {

    public static void main(String[] args) {
        int[] nums = { 3, 3, 3 };
        System.out.println(triangleType(nums));
        int[] nums1 = { 3, 4, 5 };
        System.out.println(triangleType(nums1));
    }

    public static String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        // Step 1: Check triangle inequality
        if ((a + b <= c) || (a + c <= b) || (b + c <= a)) {
            return "none";
        }
        // Step 2: Count unique side lengths
        HashSet<Integer> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        // Step 3: Determine triangle type
        return set.size() == 1 ? "equilateral" : (set.size() == 2 ? "isosceles" : "scalene");
    }
}
