//Leetcode
//976. Largest Perimeter Triangle
//Time complexity: O(N+k)
//Space complexity: O(k)

public class LargestPerimeterTriangle_2 {

    public static void main(String[] args) {
        int[] nums = { 2, 1, 2 };
        System.out.println(largestPerimeter(nums));
    }

    public static int largestPerimeter(int[] nums) {
        int minVal = nums[0];
        int maxVal = nums[0];
        for (int x : nums) {
            if (x < minVal)
                minVal = x;
            if (x > maxVal)
                maxVal = x;
        }

        int[] freq = new int[maxVal - minVal + 1];
        for (int x : nums)
            freq[x - minVal]++;

        int idx = 0;
        for (int v = maxVal; v >= minVal; v--) {
            while (freq[v - minVal] > 0) {
                nums[idx++] = v;
                freq[v - minVal]--;
            }
        }

        for (int i = 0; i <= nums.length - 3; i++) {
            if (nums[i + 1] + nums[i + 2] > nums[i])
                return nums[i] + nums[i + 1] + nums[i + 2];
        }
        return 0;
    }
}
