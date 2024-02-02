//Leetcode
//1291. Sequential Digits
//Time complexity: O(1)
//Space complexity: O(1) 

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits_2 {

    public static void main(String[] args) {
        int low = 1000, high = 13000;
        System.out.println(sequentialDigits(low, high));
    }

    public static List<Integer> sequentialDigits(int low, int high) {
        String c = "123456789";
        List<Integer> a = new ArrayList<>();

        for (int i = 0; i < c.length(); i++) {
            for (int j = i + 1; j <= c.length(); j++) {
                int curr = Integer.parseInt(c.substring(i, j));
                if (curr <= high && curr >= low) {
                    a.add(curr);
                }
            }
        }
        a.sort(null);
        return a;
    }
}
