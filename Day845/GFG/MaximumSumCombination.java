//GFG
//Maximum Sum Combination
//Time complexity: O(NlogN)
//Space complexity: O(N) 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSumCombination {

    public static void main(String[] args) {
        int a[] = { 3, 2 };
        int b[] = { 1, 4 };
        int k = 2;
        System.out.println(topKSumPairs(a, b, k));
    }

    public static ArrayList<Integer> topKSumPairs(int[] a, int[] b, int k) {
        // code here
        PriorityQueue<Integer> p = new PriorityQueue<>();
        ArrayList<Integer> list = new ArrayList<>();

        Arrays.sort(a);
        Arrays.sort(b);
        int N = a.length;

        for (int i = N - 1; i > N - k - 1; i--) {
            for (int j = N - 1; j > N - k - 1; j--) {

                int sum = a[i] + b[j];
                if (p.size() < k)
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
