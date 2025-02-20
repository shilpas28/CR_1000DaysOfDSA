//Leetcode
//1980. Find Unique Binary String - Most optimized: Flipping the binarys
//Time complexity: O(N)
//Space complexity: O(1)

public class FindUniqueBinaryString_3 {

    public static void main(String[] args) {
        String[] nums = { "01", "10" };
        System.out.println(findDifferentBinaryString(nums));
    }

    public static String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
            ans.append(nums[i].charAt(i) == '0' ? '1' : '0'); // Using ternary operator
        return ans.toString();
    }
}
