//Leetcode
//3163. String Compression III
//Time complexity: O(N)
//Space complexity: O(1) 

public class StringCompressionIII {

    public static void main(String[] args) {
        String word = "abcde";
        System.out.println(compressedString(word));
    }

    public static String compressedString(String word) {
        int n = word.length(), count = 0, i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        while (j < n) {
            count = 0;
            while (j < n && word.charAt(i) == word.charAt(j) && count < 9) {
                j++;
                count++;
            }
            ans.append(count).append(word.charAt(i));
            i = j;
        }
        return ans.toString();
    }
}
