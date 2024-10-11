//GFG
//Reorganize The Array
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class ReorganizeTheArray {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(-1);
        arr.add(-1);
        arr.add(6);
        arr.add(1);
        arr.add(9);
        arr.add(3);
        arr.add(2);
        arr.add(-1);
        arr.add(4);
        arr.add(-1);
        System.out.println(rearrange(arr));
    }

    public static List<Integer> rearrange(List<Integer> arr) {
        // Code here
        int i = 0, n = arr.size();
        while (i < n) {
            if (arr.get(i) == -1 || arr.get(i) == i)
                i++;
            else {
                int id = arr.get(i);
                arr.set(i, arr.get(id));
                arr.set(id, id);
            }
        }
        return arr;
    }
}
