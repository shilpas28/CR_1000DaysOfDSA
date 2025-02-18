//Leetcode
//2375. Construct Smallest Number From DI String - Brute Force
//Time complexity: O(n!*(n^2))
//Space complexity: O(n)

public class ConstructSmallestNumberFromDIString {

    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern));
    }

    public static String smallestNumber(String pattern) {
        int patternLength = pattern.length();
        char[] numberSequence = new char[patternLength + 1];
        // Create a sequence of numbers from '1' to 'n+1'
        for (int position = 0; position <= patternLength; position++) {
            numberSequence[position] = (char) ('1' + position);
        }
        // Generate permutations and check for the correct pattern
        while (!check(new String(numberSequence), pattern)) {
            if (!findNextPermutation(numberSequence)) {
                break;
            }
        }
        return new String(numberSequence);
    }

    // Check if the current sequence matches the pattern of 'I' and 'D'
    static boolean check(String sequence, String pattern) {
        for (int index = 0; index < pattern.length(); index++) {
            if (pattern.charAt(index) == 'I') {
                // Ensure the sequence is in increasing order at 'I' positions
                if (sequence.charAt(index) > sequence.charAt(index + 1)) {
                    return false;
                }
            } else {
                // Ensure the sequence is in decreasing order at 'D' positions
                if (sequence.charAt(index) < sequence.charAt(index + 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Custom implementation of the next permutation function
    static boolean findNextPermutation(char[] numberSequence) {
        int lastIncreasingIndex = numberSequence.length - 2;
        // Find the rightmost character smaller than its next character
        while (lastIncreasingIndex >= 0 &&
                numberSequence[lastIncreasingIndex] >= numberSequence[lastIncreasingIndex + 1]) {
            lastIncreasingIndex--;
        }
        if (lastIncreasingIndex == -1)
            return false;
        // Find the rightmost character greater than numberSequence[lastIncreasingIndex]
        // and swap
        int swapIndex = numberSequence.length - 1;
        while (numberSequence[swapIndex] <= numberSequence[lastIncreasingIndex]) {
            swapIndex--;
        }
        swapCharacters(numberSequence, lastIncreasingIndex, swapIndex);
        // Reverse the suffix to get the next lexicographically smallest permutation
        reverseSuffix(
                numberSequence,
                lastIncreasingIndex + 1,
                numberSequence.length - 1);
        return true;
    }

    static void swapCharacters(char[] array, int firstIdx, int secondIdx) {
        char temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }

    static void reverseSuffix(char[] array, int startIdx, int endIdx) {
        while (startIdx < endIdx) {
            swapCharacters(array, startIdx, endIdx);
            startIdx++;
            endIdx--;
        }
    }
}
