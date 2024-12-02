//Leetcode
//1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
//Time complexity: O(N)
//Space complexity: O(N)

public class CheckIfWordOccursAsPrefixOfAnyWordInASentence {

    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i].startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}
