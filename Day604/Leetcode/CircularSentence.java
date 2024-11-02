//Leetcode
//2490. Circular Sentence
//Time complexity: O(N)
//Space complexity: O(M) where M is the number of words in the sentence

public class CircularSentence {

    public static void main(String[] args) {
        String sentence = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(sentence));
    }

    public static boolean isCircularSentence(String sentence) {
        String[] arr = sentence.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].charAt(arr[i].length() - 1) != arr[(i + 1) % arr.length].charAt(0))
                return false;
        }
        return true;
    }
}
