//GFG
//Rotate and delete
//Time complexity: O(N^2)
//Space complexity: O(1)

import java.util.ArrayList;

public class RotateAndDelete {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        System.out.println(rotateDelete(arr));
    }

    public static int rotateDelete(ArrayList<Integer> arr) {
        // code here
        int n = arr.size(), temp = n / 2;
        int i = 3 * (temp / 2);
        if (temp % 2 == 1)
            i++;
        return arr.get(n - i);
    }
}
