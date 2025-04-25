//GFG
//Majority Element - Better Method 
//Time complexity: O(N*logN) + O(N)
//Space complexity: O(N)

package GFG;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 1, 3, 5, 1 };
        System.out.println(majorityElement(arr));
    }

    static int majorityElement(int arr[]) {
        // code here
        // size of the given array:
        int n = arr.length;
        // declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();
        // storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(arr[i], 0);
            mpp.put(arr[i], value + 1);
        }
        // searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }
        return -1;
    }
}
