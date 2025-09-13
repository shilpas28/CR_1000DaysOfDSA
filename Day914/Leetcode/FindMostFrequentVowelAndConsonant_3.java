//Leetcode
//3541. Find Most Frequent Vowel and Consonant - Frequency Array
//Time complexity: O(N)
//Space complexity: O(1)

public class FindMostFrequentVowelAndConsonant_3 {

    public static void main(String[] args) {
        String s = "successes";
        System.out.println(maxFreqSum(s));
    }

    public static int maxFreqSum(String s) {
        int[] freq = new int[26];
        int maxVowel = 0, maxConso = 0;
        for (char c : s.toCharArray()) {
            int i = c - 'a';
            freq[i]++;
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                maxVowel = Math.max(maxVowel, freq[i]);
            else
                maxConso = Math.max(maxConso, freq[i]);
        }
        return maxVowel + maxConso;
    }
}
