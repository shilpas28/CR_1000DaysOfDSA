//Leetcode
//1346. Check If N and Its Double Exist - Using HashSet
//Time complexity: O(NlogN) --> set.contains() costs O(logn) at worst case
//Space complexity: O(N)

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist_3 {

    public static void main(String[] args) {
        int[] arr = { 10, 2, 5, 3 };
        System.out.println(checkIfExist(arr));
    }

    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            if (set.contains(i * 2) || (i % 2 == 0 && set.contains(i / 2))) {
                return true;
            }
            set.add(i);
        }
        return false;
    }
}
