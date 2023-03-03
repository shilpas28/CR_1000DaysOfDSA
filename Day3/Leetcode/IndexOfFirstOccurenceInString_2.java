//Leetcode
//28. Find the Index of the First Occurrence in a String
//Using inbuilt function
//Time complexity:
//Space complexity:
public class IndexOfFirstOccurenceInString_2 {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {

        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i, needle.length() + i).equals(needle))
                    return i;
            }
        }
        return -1;

    }
}
