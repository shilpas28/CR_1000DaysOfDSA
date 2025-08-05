//GFG
//Palindrome Sentence
//Time complexity: O(N)
//Space complexity: O(1)

public class PalindromeSentence_2 {

    public static void main(String[] args) {
        String s = "Too hot to hoot";
        System.out.println(isPalinSent(s));
    }

    public static boolean isPalinSent(String s) {
        // code here
        int n = s.length();
        int i = 0;
        int j = n - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            char ch1 = Character.toUpperCase(s.charAt(i));
            char ch2 = Character.toUpperCase(s.charAt(j));
            if (ch1 != ch2)
                return false;
            i++;
            j--;
        }
        return true;
    }
}
