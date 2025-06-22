//Leetcode
//2138. Divide a String Into Groups of Size k
//Time complexity: O(N)
//Space complexity: O(N)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DivideAStringIntoGroupsOfSizeK {

    public static void main(String[] args) {
        String s = "abcdefghi";
        int k = 3;
        char fill = 'x';
        System.out.println(Arrays.toString(divideString(s, k, fill)));
    }

    public static String[] divideString(String s, int k, char fill) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        for (int i = 0; i < n; i += k) {
            StringBuilder chunk = new StringBuilder();
            for (int j = i; j < i + k; j++) {
                if (j < n)
                    chunk.append(s.charAt(j));
                else
                    chunk.append(fill);
            }
            result.add(chunk.toString());
        }

        return result.toArray(new String[0]);
    }
}
