//Leetcode
//28. Find the Index of the First Occurrence in a String
//Using inbuilt function
//Time complexity:
//Space complexity:
public class IndexOfFirstOccurenceInString {

    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        if (haystack.contains(needle)) {
            return haystack.indexOf(needle);
        }
        return -1;
    }
}
