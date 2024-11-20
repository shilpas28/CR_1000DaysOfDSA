//GFG
//Majority Element II
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

    public static void main(String[] args) {
        int arr[] = { 2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6 };
        System.out.println(findMajority(arr));
    }

    // Function to find the majority elements in the array
    public static List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        int num1 = -1;
        int num2 = -1;
        int f1 = 0;
        int f2 = 0;
        for (int num : nums) {
            if (num == num1)
                ++f1;
            else if (num == num2)
                ++f2;
            else if (f1 == 0) {
                num1 = num;
                ++f1;
            } else if (f2 == 0) {
                num2 = num;
                ++f2;
            } else {
                --f1;
                --f2;
            }
        }

        f1 = 0;
        f2 = 0;

        for (int num : nums) {
            if (num == num1)
                ++f1;
            else if (num == num2)
                ++f2;
        }

        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        if (f1 > n / 3)
            res.add(num1);

        if (f2 > n / 3)
            res.add(num2);

        if (res.size() == 2) {
            if (res.get(0) > res.get(1)) {
                int temp = res.get(0);
                res.set(0, res.get(1));
                res.set(1, temp);
            }
        }
        return res;
    }
}
