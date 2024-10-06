//Leetcode
//1813. Sentence Similarity III
//Time complexity: O(n1 + n2), where n1 = sentence1.length(), n2 = sentence2.length()
//Space complexity: O(n1 + n2), where n1 = sentence1.length(), n2 = sentence2.length()

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SentenceSimilarityIII_2 {

    public static void main(String[] args) {
        String sentence1 = "My name is Haley", sentence2 = "My Haley";
        System.out.println(areSentencesSimilar(sentence1, sentence2));
    }

    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        Deque<String> dq1 = new ArrayDeque<>(Arrays.asList(sentence1.split(" ")));
        Deque<String> dq2 = new ArrayDeque<>(Arrays.asList(sentence2.split(" ")));
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peek().equals(dq2.peek())) {
            dq1.poll();
            dq2.poll();
        }
        while (!dq1.isEmpty() && !dq2.isEmpty() && dq1.peekLast().equals(dq2.peekLast())) {
            dq1.pollLast();
            dq2.pollLast();
        }
        return dq1.isEmpty() || dq2.isEmpty();
    }
}
