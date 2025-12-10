//GFG
//Missing And Repeating
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;

public class MissingAndRepeating {

    public static void main(String[] args) {
        int arr[] = {4, 3, 6, 2, 1, 1};
        System.out.println(findTwoElement(arr));
    }

    static ArrayList<Integer> findTwoElement(int arr[]) {
        // code here
        int[] n = new int[arr.length + 1];
        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            n[arr[i]]++;
        }

        for (int i = 1; i < n.length; i++) {
            if (n[i] == 2) {
                al.add(i);
            }
        }
        
        for (int i = 1; i < n.length; i++) {
            if (n[i] == 0) {
                al.add(i);
            }
        }
        return al;
    }
}
