//GFG
//Two Swaps
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class TwoSwaps {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(3);
        arr.add(2);
        arr.add(1);
        System.out.println(checkSorted(arr));
    }

    public static boolean checkSorted(List<Integer> arr) {
        // code here
        int count = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != i + 1) {
                int temp = arr.get(i);
                arr.set(i, arr.get(arr.get(i) - 1));
                arr.set(temp - 1, temp);
                i--;
                count++;
            }
            if (count > 2)
                return false;
        }
        return count == 2 | count == 0;
    }
}
