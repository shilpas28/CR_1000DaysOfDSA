//Leetcode
//744. Find Smallest Letter Greater Than Target - Using Binary Search 
//Time complexity: O(logN)
//Space complexity: O(1)

package Leetcode;

public class FindSmallestLetterGreaterThanTarget {

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        char res = letters[0];
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (letters[mid] < target) {
                left = mid + 1;
            } else if (letters[mid] == target) {
                left = mid + 1;
            } else {
                res = letters[mid];
                right = mid - 1;
            }
        }
        return res;
    }
}
