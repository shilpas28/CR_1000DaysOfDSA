//Leetcode
//564. Find the Closest Palindrome
//Time complexity: O(1) - Well TBH its O(log n) where n is the input number. This is because we're primarily working with the digits of the 
//number, and the number of digits is logarithmic in the value of the number. The generatePalindrome function runs in O(log n) time, and we 
//call it a constant number of times.
//Space complexity: O(1) - We're using a constant amount of extra space (the candidates array is always size 5), but we need O(log n) space 
//to store the string representation of the number and the result.

public class FindTheClosestPalindrome {

    public static void main(String[] args) {
        String n = "123";
        System.out.println(nearestPalindromic(n));
    }

    public static String nearestPalindromic(String n) {
        long number = Long.parseLong(n);
        if (number <= 10)
            return String.valueOf(number - 1);
        if (number == 11)
            return "9";

        int length = n.length();
        long leftHalf = Long.parseLong(n.substring(0, (length + 1) / 2));

        long[] palindromeCandidates = new long[5];
        palindromeCandidates[0] = generatePalindromeFromLeft(leftHalf - 1, length % 2 == 0);
        palindromeCandidates[1] = generatePalindromeFromLeft(leftHalf, length % 2 == 0);
        palindromeCandidates[2] = generatePalindromeFromLeft(leftHalf + 1, length % 2 == 0);
        palindromeCandidates[3] = (long) Math.pow(10, length - 1) - 1;
        palindromeCandidates[4] = (long) Math.pow(10, length) + 1;

        long nearestPalindrome = 0;
        long minDifference = Long.MAX_VALUE;

        for (long candidate : palindromeCandidates) {
            if (candidate == number)
                continue;
            long difference = Math.abs(candidate - number);
            if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
                minDifference = difference;
                nearestPalindrome = candidate;
            }
        }
        return String.valueOf(nearestPalindrome);
    }

    static long generatePalindromeFromLeft(long leftHalf, boolean isEvenLength) {
        long palindrome = leftHalf;
        if (!isEvenLength)
            leftHalf /= 10;
        while (leftHalf > 0) {
            palindrome = palindrome * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        return palindrome;
    }
}
