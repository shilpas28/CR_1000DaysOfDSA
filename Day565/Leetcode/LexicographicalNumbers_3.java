//Leetcode
//386. Lexicographical Numbers - BFS
//Time complexity: O(N)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers_3 {

    public static void main(String[] args) {
        int n = 13;
        System.out.println(lexicalOrder(n));
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>(n);
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr *= 10;
            } else if (curr % 10 != 9 && curr + 1 <= n) {
                curr++;
            } else {
                while ((curr / 10) % 10 == 9) {
                    curr /= 10;
                }
                curr = curr / 10 + 1;
            }
        }
        return list;
    }
}
