//GFG
//Number of occurrence - Using Linear Traversal
//Time complexity: O(N)
//Space complexity: O(1)

public class NumberOfOccurrence {

    public static void main(String[] args) {
        int N = 7, X = 2;
        int Arr[] = { 1, 1, 2, 2, 2, 2, 3 };
        System.out.println(count(Arr, N, X));
    }

    static int count(int[] arr, int n, int x) {
        // code here
        int cnt = 0;
        for (int y : arr)
            if (y == x)
                cnt++;
        return cnt;
    }
}
