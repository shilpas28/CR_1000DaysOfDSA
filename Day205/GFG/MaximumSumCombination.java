//GFG
//Maximum Sum Combination
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSumCombination {

    public static void main(String[] args) {
        int N = 2;
        int K = 2;
        int A[] = { 3, 2 };
        int B[] = { 1, 4 };
        System.out.println(maxCombinations(N, K, A, B));
    }

    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        PriorityQueue<Integer> p = new PriorityQueue<>();
        List<Integer> list = new ArrayList<>();

        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = N - 1; i > N - K - 1; i--) {
            for (int j = N - 1; j > N - K - 1; j--) {

                int sum = A[i] + B[j];
                if (p.size() < K)
                    p.add(sum);
                else {
                    if (p.peek() < sum) {
                        p.remove();
                        p.add(sum);
                    } else
                        break;
                }
            }
        }
        while (p.size() > 0) {
            list.add(0, p.poll());
        }
        return list;
    }
}
