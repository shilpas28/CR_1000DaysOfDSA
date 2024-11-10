//GFG
//Union of Two Sorted Arrays with Distinct Elements
//Time complexity: O(n+m)
//Space complexity: O(n+m)

import java.util.ArrayList;

public class UnionOfTwoSortedArraysWithDistinctElements {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5 };
        int b[] = { 1, 2, 3, 6, 7 };
        System.out.println(findUnion(a, b));
    }

    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // add your code here
        int n = a.length, m = b.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = 0, j = 0;
        while (i < n || j < m) {
            if (i < n && j < m) {
                if (a[i] == b[j]) {
                    res.add(a[i]);
                    i++;
                    j++;
                } else if (a[i] < b[j]) {
                    res.add(a[i]);
                    i++;
                } else {
                    res.add(b[j]);
                    j++;
                }
            } else if (i < n) {
                res.add(a[i]);
                i++;
            } else {
                res.add(b[j]);
                j++;
            }
        }
        return res;
    }
}
