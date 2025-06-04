//Leetcode
//3403. Find the Lexicographically Largest String From the Box I - Two Pointers
//Time complexity: O(N)
//Space complexity: O(N) or O(1)

public class FindTheLexicographicallyLargestStringFromTheBoxI_2 {

    public static void main(String[] args) {
        String word = "dbca";
        int numFriends = 2;
        System.out.println(answerString(word, numFriends));
    }

    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        String last = lastSubstring(word);
        int n = word.length(), m = last.length();
        return last.substring(0, Math.min(m, n - numFriends + 1));
    }

    public static String lastSubstring(String s) {
        int i = 0, j = 1, n = s.length();
        while (j < n) {
            int k = 0;
            while (j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                k++;
            }
            if (j + k < n && s.charAt(i + k) < s.charAt(j + k)) {
                int t = i;
                i = j;
                j = Math.max(j + 1, t + k + 1);
            } else {
                j = j + k + 1;
            }
        }
        return s.substring(i);
    }
}
