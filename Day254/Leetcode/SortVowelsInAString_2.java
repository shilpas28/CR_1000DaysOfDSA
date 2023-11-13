//Leetcode
//2785. Sort Vowels in a String - using Modified Counting Sort 
//Time complexity: O(N) - The algorithm iterates through the input string s once, and the subsequent iteration through 
//the vowelCount array takes constant time.
//Space complexity: O(1) - The additional space used is independent of the input size, making it constant space. The 
//arrays (vowelCount and countIndexMap) have fixed sizes.

package Leetcode;

public class SortVowelsInAString_2 {

    public static void main(String[] args) {
        String s = "lEetcOde";
        System.out.println(sortVowels(s));
    }

    public static String sortVowels(String s) {
        int[] vowelCount = new int[11];
        int[] countIndexMap = new int[128];
        char[] result = s.toCharArray();
        char[] charMap = "AEIOUaeiou".toCharArray();

        for (int i = 0; i < charMap.length; i++)
            countIndexMap[charMap[i]] = i + 1;

        for (char c : result)
            vowelCount[countIndexMap[c]]++;
        int j = 1;
        int i = 0;

        while (j < vowelCount.length) {
            if (vowelCount[j] > 0)
                while (i < result.length) {
                    if (countIndexMap[result[i]] == 0) {
                        i++;
                        continue;
                    }
                    vowelCount[j]--;
                    result[i++] = charMap[j - 1];
                    break;
                }
            else
                j++;
        }
        return new String(result);
    }
}
