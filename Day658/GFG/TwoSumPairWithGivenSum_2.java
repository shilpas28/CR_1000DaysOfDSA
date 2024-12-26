//GFG
//Two Sum - Pair with Given Sum
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.HashMap;

public class TwoSumPairWithGivenSum_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 4, 45, 6, 10, 8 };
        int target = 16;
        System.out.println(twoSum(arr, target));
    }

    static boolean twoSum(int arr[], int target) {
        // code here
        HashMap<Integer, Integer> hp = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int b = target - arr[i];
            if (hp.containsKey(b))
                return true;

            hp.put(arr[i], i);
        }
        return false;
    }
}
