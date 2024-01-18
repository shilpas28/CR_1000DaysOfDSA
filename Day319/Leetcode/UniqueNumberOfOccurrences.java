//Leetcode
//1207. Unique Number of Occurrences
//Time complexity: O(nlogn)
//Space complexity: O(n)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(uniqueOccurrences(arr));
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Arrays.sort(arr);
        ArrayList<Integer> arl = new ArrayList<>();

        int c = 1;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1])
                c++;
            else {
                arl.add(c);
                c = 1;
            }
        }

        arl.add(c);
        Collections.sort(arl);

        for (int i = 0; i < arl.size() - 1; i++) {
            if (arl.get(i) == arl.get(i + 1))
                return false;
        }
        return true;
    }
}
