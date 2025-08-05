//GFG
//Palindrome Sentence
//Time complexity: O(N)
//Space complexity: O(1)

public class PalindromeSentence {

    public static void main(String[] args) {
        String s = "Too hot to hoot";
        System.out.println(isPalinSent(s));
    }

    public static boolean isPalinSent(String s) {
        // code here
        StringBuilder builder = new StringBuilder();
        for (char i : s.toCharArray()) {
            if (i >= '0' && i <= '9') {
                builder.append(i);
            } else if ((i >= 'A' && i <= 'Z') || (i >= 'a' && i <= 'z')) {
                builder.append(("" + i).toLowerCase());
            }
        }
        return builder.toString().equals(builder.reverse().toString());
    }
}
