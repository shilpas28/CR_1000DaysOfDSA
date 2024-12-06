//GFG
//Find H-Index
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.Arrays;

public class FindHIndex {

    public static void main(String[] args) {
        int citations[] = { 3, 0, 5, 3, 0 };
        System.out.println(hIndex(citations));
    }

    // Function to find hIndex
    public static int hIndex(int[] citations) {
        // code here
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; ++i) {
            if (citations[i] >= n - i) {
                return n - i;
            }
        }
        return 0;
    }
}
