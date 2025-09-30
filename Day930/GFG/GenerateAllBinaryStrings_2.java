//GFG
//Generate all binary strings
//Time complexity: O(n * 2^n)
//Space complexity: O(n)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class GenerateAllBinaryStrings_2 {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(binstr(n));
    }

    public static ArrayList<String> binstr(int n) {
        // code here
        Queue<String> q = new ArrayDeque<>(Arrays.asList("0", "1"));
        int x = 1;

        while (!q.isEmpty()) {
            if (x == n) {
                break;
            }
            int y = q.size();
            for (int i = 0; i < y; i++) {
                String s = q.poll();
                q.offer(s + "0");
                q.offer(s + "1");
            }
            x++;
        }

        ArrayList<String> ans = new ArrayList<>();
        while (!q.isEmpty())
            ans.add(q.poll());

        return ans;
    }
}
