//GFG
//Find All Triplets with Zero Sum
//Time complexity: O(N^2)
//Space complexity: O(N^2)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindAllTripletsWithZeroSum_2 {

    public static void main(String[] args) {
        int arr[] = { 0, -1, 2, -3, 1 };
        System.out.println(findTriplets(arr));
    }

    public static List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        Set<List<Integer>> ansSet = new HashSet<>();
        Map<Integer, List<int[]>> mp = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (!mp.containsKey(sum)) {
                    mp.put(sum, new ArrayList<>());
                }
                mp.get(sum).add(new int[] { i, j });
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int tar = -arr[i];
            if (mp.containsKey(tar)) {
                List<int[]> pairs = mp.get(tar);
                for (int[] pair : pairs) {
                    if (pair[0] != i && pair[1] != i) {
                        List<Integer> curr = Arrays.asList(i, pair[0], pair[1]);
                        Collections.sort(curr);
                        ansSet.add(curr);
                    }
                }
            }
        }
        return new ArrayList<>(ansSet);
    }
}
