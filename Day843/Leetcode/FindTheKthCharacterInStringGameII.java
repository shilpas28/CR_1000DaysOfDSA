//Leetcode
//3307. Find the K-th Character in String Game II
//Time complexity: O(logk)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.List;

public class FindTheKthCharacterInStringGameII {

    public static void main(String[] args) {
        long k = 5;
        int[] operations = { 0, 0, 0 };
        System.out.println(kthCharacter(k, operations));
    }

    public static char kthCharacter(long k, int[] operations) {
        int shift = 0; // total number of +1 (mod 26) operations
        List<Long> lengths = new ArrayList<>();
        long len = 1;

        for (int op : operations) {
            len *= 2;
            lengths.add(len);
            if (len >= k)
                break;
        }

        for (int i = lengths.size() - 1; i >= 0; i--) {
            long half = lengths.get(i) / 2;
            int op = operations[i];

            if (k > half) {
                k -= half;
                if (op == 1)
                    shift++;
            }
            // else: k remains the same
        }
        // Apply total shift from 'a'
        return (char) ((('a' - 'a' + shift) % 26) + 'a');
    }
}
