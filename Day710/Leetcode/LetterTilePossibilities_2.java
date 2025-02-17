//Leetcode
//1079. Letter Tile Possibilities - Optimized Recursion
//Time complexity: O(2^n)
//Space complexity: O(n)

public class LetterTilePossibilities_2 {

    public static void main(String[] args) {
        String tiles = "AAB";
        System.out.println(numTilePossibilities(tiles));
    }

    public static int numTilePossibilities(String tiles) {
        // Track frequency of each uppercase letter (A-Z)
        int[] charCount = new int[26];
        for (char c : tiles.toCharArray()) {
            charCount[c - 'A']++;
        }
        // Find all possible sequences using character frequencies
        return findSequences(charCount);
    }

    static int findSequences(int[] charCount) {
        int totalCount = 0;
        // Try using each available character
        for (int pos = 0; pos < 26; pos++) {
            if (charCount[pos] == 0) {
                continue;
            }
            // Add current character and recurse
            totalCount++;
            charCount[pos]--;
            totalCount += findSequences(charCount);
            charCount[pos]++;
        }
        return totalCount;
    }
}
