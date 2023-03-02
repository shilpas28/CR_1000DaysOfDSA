//Leetcode 
//443. String Compression - Optimal solution 
//Time complexity: O(N)
//Space complexity: O(1)
package Leetcode;

public class StringCompression_2 {

    public static void main(String[] args) {
        char[] chars = {'a','b', 'b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        int index = 0;
        int i = 0;
        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            chars[index++] = chars[i];
            if ((j - i) > 1) {
                String countVal = j - i + ""; // to convert int to char
                for (char val : countVal.toCharArray()) {
                    chars[index++] = val;
                }
            }
            i = j;
        }
        return index;
    }
}
