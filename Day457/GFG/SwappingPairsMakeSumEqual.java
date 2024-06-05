//GFG
//Swapping pairs make sum equal
//Time complexity: O(mlogm+nlogn)
//Space complexity: O(1)

import java.util.Arrays;

public class SwappingPairsMakeSumEqual {

    public static void main(String[] args) {
        int n = 6, m = 4;
        long a[] = { 4, 1, 2, 1, 1, 2 };
        long b[] = { 3, 6, 3, 3 };
        System.out.println(findSwapValues(a, n, b, m));
    }

    static long findSwapValues(long a[], int n, long b[], int m) {
        // Your code goes here
        long sumA = 0;
        long sumB = 0;
        for (long num : a)
            sumA += num;
        for (long num : b)
            sumB += num;
        if ((sumA - sumB) % 2 != 0)
            return -1;
        long targetDiff = (sumA - sumB) / 2;

        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;

        while (i < n && j < m) {
            long currentDiff = a[i] - b[j];
            if (currentDiff == targetDiff)
                return 1;
            else if (currentDiff < targetDiff)
                i++;
            else
                j++;
        }
        return -1;
    }
}
