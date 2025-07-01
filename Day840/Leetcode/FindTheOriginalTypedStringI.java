//Leetcode
//3330. Find the Original Typed String I
//Time complexity: O(N)
//Space complexity: O(1) 

public class FindTheOriginalTypedStringI {

    public static void main(String[] args) {
        String word = "abbcccc";
        System.out.println(possibleStringCount(word));
    }

    public static int possibleStringCount(String word) {
        int n = word.length();
        int count = n;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(i - 1)) {
                count--;
            }
        }
        return count;
    }
}
