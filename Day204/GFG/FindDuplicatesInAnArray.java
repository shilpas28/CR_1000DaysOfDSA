//GFG
//Find duplicates in an array
//Time complexity:
//Space complexity: 

package GFG;

import java.util.ArrayList;

public class FindDuplicatesInAnArray {

    public static void main(String[] args) {
        int N = 6;
        int a[] = { 0, 3, 1, 2, 5, 1 };
        System.out.println(duplicates(a, N));
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        int a[] = new int[n];

        for (int i = 0; i < n; i++) {
            a[arr[i]] += 1;
        }

        for (int i = 0; i < n; i++) {
            if (a[i] > 1)
                list.add(i);
        }
        if (list.size() == 0)
            list.add(-1);
        return list;
    }
}
