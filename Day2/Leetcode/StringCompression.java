//Leetcode - not accepting this solution as it expects original array to be modified
//443. String Compression - Not so optimal(uses extra space)
//Time complexity: O(N)
//Space complexity: O(N)
package Leetcode;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
        System.out.println(compress(chars));
    }

    public static int compress(char[] chars) {
        if (chars.length == 1)
            return 1;
        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < chars.length) {
            int j = i;
            while (j < chars.length && chars[j] == chars[i]) {
                j++;
            }
            str.append(chars[i]);
            if ((j - i) > 1) {
                str.append(j - i);
            }
            i = j;
        }
        return str.length();
    }
}
