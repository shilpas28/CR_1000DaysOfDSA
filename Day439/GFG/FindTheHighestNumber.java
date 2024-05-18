//GFG
//Find the Highest number
//Time complexity: O(logN)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;
import java.util.List;

public class FindTheHighestNumber {

    public static void main(String[] args) {
        // 1 2 3 4 5 6 5 4 3 2 1
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        a.add(5);
        a.add(4);
        a.add(3);
        a.add(2);
        a.add(1);
        System.out.println(findPeakElement(a));
    }

    public static int findPeakElement(List<Integer> a) {
        // Code here
        int low = 0, high = a.size() - 1, mid = -1, n = a.size();
        boolean temp1 = false, temp2 = false, temp3 = false;
        while (low <= high) {
            mid = (low + high) / 2;
            temp1 = mid != n - 1 ? a.get(mid) > a.get(mid + 1) : true;
            temp2 = mid != 0 ? a.get(mid) > a.get(mid - 1) : true;
            temp3 = mid != 0 ? a.get(mid) < a.get(mid - 1) : true;
            if (temp1 && temp2)
                break;
            else if (temp1 && temp3)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return a.get(mid);
    }
}
