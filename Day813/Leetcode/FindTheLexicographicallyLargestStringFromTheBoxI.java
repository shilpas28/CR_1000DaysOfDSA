//Leetcode
//3403. Find the Lexicographically Largest String From the Box I - Enumeration
//Time complexity: O(N^2)
//Space complexity: O(N) or O(1) 

public class FindTheLexicographicallyLargestStringFromTheBoxI {

    public static void main(String[] args) {
        String word = "dbca";
        int numFriends = 2;
        System.out.println(answerString(word, numFriends));
    }

    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            String s = word.substring(i, Math.min(i + n - numFriends + 1, n));
            if (res.compareTo(s) <= 0) {
                res = s;
            }
        }
        return res;
    }
}
