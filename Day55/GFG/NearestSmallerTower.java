//GFG
//Nearest Smaller Tower
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerTower {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2 };
        System.out.println(Arrays.toString(nearestSmallestTower(arr)));
    }

    static int[] nearestSmallestTower(int[] arr) {
        // Write your code here
        int n = arr.length;
        Stack<Integer> left = new Stack<>();
        Stack<Integer> right = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n; i++) {
            while (!left.empty() && arr[left.peek()] >= arr[i])
                left.pop();

            if (!left.empty())
                res[i] = left.peek();

            left.push(i);
        }

        for (int i = n - 1; i >= 0; i--) {
            while (!right.empty() && arr[right.peek()] >= arr[i])
                right.pop();

            if (!right.empty()) {
                // right.peek() is my ans here, do the comparison.
                if (res[i] != -1) {
                    // if dist equal, take the lower height
                    if (Math.abs(res[i] - i) == Math.abs(right.peek() - i)) {
                        if (arr[res[i]] > arr[right.peek()])
                            res[i] = right.peek();
                    }
                    // take nearest towr.
                    else if (Math.abs(res[i] - i) > Math.abs(right.peek() - i))
                        res[i] = right.peek();
                }
                // if res[i]== -1 => no samller tower was found in left.
                else
                    res[i] = right.peek();
            }
            right.push(i);
        }
        return res;
    }
}
