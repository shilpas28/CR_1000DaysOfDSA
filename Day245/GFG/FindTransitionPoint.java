//GFG
//Find Transition Point
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class FindTransitionPoint {

    public static void main(String[] args) {
        int N = 5;
        int arr[] = { 0, 0, 0, 1, 1 };
        System.out.println(transitionPoint(arr, N));
    }

    static int transitionPoint(int arr[], int n) {
        // code here
        for (int i = 0; i < n; i++)
            if (arr[i] == 1)
                return i;
        return -1;
    }
}
