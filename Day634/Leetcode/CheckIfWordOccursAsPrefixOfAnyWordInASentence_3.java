//Leetcode
//1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence
//Time complexity: O(N)
//Space complexity: O(1) 

public class CheckIfWordOccursAsPrefixOfAnyWordInASentence_3 {

    public static void main(String[] args) {
        String sentence = "i love eating burger", searchWord = "burg";
        System.out.println(isPrefixOfWord(sentence, searchWord));
    }

    public static int isPrefixOfWord(String sentence, String searchWord) {
        boolean search = true;
        for (int i = 0, j = 0, wordCount = 1; i < sentence.length(); i++) {
            if (search) {
                if (searchWord.charAt(j) == sentence.charAt(i)) {
                    j++;
                    if (j == searchWord.length())
                        return wordCount;
                } else
                    search = false;
            }
            if (sentence.charAt(i) == ' ') {
                search = true;
                j = 0;
                wordCount++;
            }
        }
        return -1;
    }
}
