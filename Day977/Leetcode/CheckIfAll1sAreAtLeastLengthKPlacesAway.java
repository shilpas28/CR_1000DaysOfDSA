//Leetcode
//1437. Check If All 1's Are at Least Length K Places Away
//Time complexity: O(N)
//Space complexity: O(1)

public class CheckIfAll1sAreAtLeastLengthKPlacesAway {

    public static void main(String[] args) {
        int nums[] = { 1, 0, 0, 0, 1, 0, 0, 1 };
        int k = 2;
        System.out.println(kLengthApart(nums, k));
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int lastIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (lastIndex != -1 && i - lastIndex - 1 < k) {
                    return false;
                }
                lastIndex = i;
            }
        }
        return true;
    }
}
