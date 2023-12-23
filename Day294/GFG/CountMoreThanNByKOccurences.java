//GFG
//Count More than n/k Occurences
//Time complexity: O(N)
//Space complexity: O(N) 

package GFG;

import java.util.HashMap;
import java.util.HashSet;

public class CountMoreThanNByKOccurences {

    public static void main(String[] args) {
        int N = 8;
        int[] arr = { 3, 1, 2, 2, 1, 2, 3, 3 };
        int k = 4;
        System.out.println(countOccurence(arr, N, k));
    }

    // Function to find all elements in array that appear more than n/k times.
    public static int countOccurence(int[] arr, int n, int k) {
        // your code here,return the answer
        HashMap<Integer, Integer> hm = new HashMap<>();
        k = n / k;
        HashSet<Integer> set = new HashSet<>();
        for (int x : arr) {
            hm.put(x, hm.getOrDefault(x, 0) + 1);
            if (hm.get(x) > k)
                set.add(x);
        }
        return set.size();
    }
}
