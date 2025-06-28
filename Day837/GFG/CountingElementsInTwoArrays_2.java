//GFG
//Counting elements in two arrays
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;

public class CountingElementsInTwoArrays_2 {

    public static void main(String[] args) {
        int a[] = { 4, 8, 7, 5, 1 };
        int b[] = { 4, 48, 3, 0, 1, 1, 5 };
        System.out.println(countLessEq(a, b));
    }

    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        int n = a.length, m = b.length;
        int maxi = 0;
        for (int i = 0; i < n; i++)
            maxi = Math.max(a[i], maxi);
        for (int i = 0; i < m; i++)
            maxi = Math.max(b[i], maxi);
        int[] freq = new int[maxi + 1];

        for (int i = 0; i < m; i++)
            freq[b[i]]++;

        for (int i = 1; i <= maxi; i++) {
            freq[i] += freq[i - 1];
        }

        ArrayList<Integer> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(freq[a[i]]);
        }
        return l;
    }
}
