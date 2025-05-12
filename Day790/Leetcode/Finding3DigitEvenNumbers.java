//Leetcode
//2094. Finding 3-Digit Even Numbers
//Time complexity: O(900*d) = O(900)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Finding3DigitEvenNumbers {

    public static void main(String[] args) {
        int[] digits = { 2, 1, 3, 0 };
        System.out.println(Arrays.toString(findEvenNumbers(digits)));
    }

    public static int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits)
            freq[d]++;

        List<Integer> result = new ArrayList<>();
        for (int i = 100; i <= 998; i += 2) {
            int a = i / 100, b = (i / 10) % 10, c = i % 10;
            int[] local = new int[10];
            local[a]++;
            local[b]++;
            local[c]++;
            boolean valid = true;
            for (int d = 0; d < 10; d++) {
                if (local[d] > freq[d]) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                result.add(i);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
