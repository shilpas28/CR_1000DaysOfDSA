//GFG
//Generate Binary Numbers
//Time complexity: O(N)
//Space complexity: O(N)

package GFG;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbers_2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(generateBinary(n));
    }

    public static ArrayList<String> generateBinary(int n) {
        // code here
        Queue<String> q = new LinkedList<>();
        ArrayList<String> ans = new ArrayList<>();

        q.add("1");

        while (n-- != 0) {
            String curr = q.peek();
            ans.add(q.poll());
            q.add(curr + "0");
            q.add(curr + "1");

        }

        return ans;
    }
}