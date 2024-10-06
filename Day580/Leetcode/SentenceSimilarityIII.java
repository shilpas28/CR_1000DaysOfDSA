//Leetcode
//1813. Sentence Similarity III
//Time complexity: O(n1 + n2), where n1 = sentence1.length(), n2 = sentence2.length()
//Space complexity: O(n1 + n2), where n1 = sentence1.length(), n2 = sentence2.length()

public class SentenceSimilarityIII {

    public static void main(String[] args) {
        String sentence1 = "My name is Haley", sentence2 = "My Haley";
        System.out.println(areSentencesSimilar(sentence1, sentence2));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" "), words2 = sentence2.split(" ");
        int i = 0, n1 = words1.length, n2 = words2.length;
        if (n1 > n2)
            return areSentencesSimilar(sentence2, sentence1);

        while (i < n1 && words1[i].equals(words2[i]))
            ++i;

        while (i < n1 && words1[i].equals(words2[n2 - n1 + i]))
            ++i;
        return i == n1;
    }
}
