//Leetcode
//1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
//Time complexity: O(N)
//Space complexity: O(N)

public class CheckIfWordOccursAsPrefixOfAnyWordInASentence_2 {

    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        int i = 0;
        for (String str : sentence.split(" ")) {
            if (str.startsWith(searchWord)) {
                return i + 1;
            }
            i++;
        }
        return -1;
    }
}
