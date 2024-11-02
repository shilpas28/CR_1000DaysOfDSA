//Leetcode
//2490. Circular Sentence
//Time complexity: O(N)
//Space complexity: O(1)

public class CircularSentence_2 {

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(sentence));
    }

    public static boolean isCircularSentence(String sentence) {
        int n = sentence.length();

        if (sentence.charAt(0) != sentence.charAt(n - 1))
            return false;

        for (int i = 1; i < n - 1; i++) {
            if (sentence.charAt(i) == ' ')
                if (sentence.charAt(i - 1) != sentence.charAt(i + 1))
                    return false;
        }
        return true;
    }
}
