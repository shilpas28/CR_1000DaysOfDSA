//GFG
//Number of occurrence - Using Linear Traversal
//Time complexity: O(N)
//Space complexity: O(1)

public class NumberOfOccurrence_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2, 2, 3 };
        int target = 2;
        System.out.println(countFreq(arr, target));
    }

    static int countFreq(int[] arr, int target) {
        // code here
        int cnt = 0;
        for (int y : arr)
            if (y == target)
                cnt++;
        return cnt;
    }
}
