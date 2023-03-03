//Leetcode
//28. Find the Index of the First Occurrence in a String
//Without using inbuilt function
//Time complexity:
//Space complexity:
public class IndexOfFirstOccurenceInString_3 {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sead";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int needleIndex = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(needleIndex)) {
                needleIndex++;
            } else {
                i -= needleIndex;
                needleIndex = 0;
            }
            if (needleIndex == needle.length()) {
                i -= needleIndex - 1;
                return i;
            }
        }
        return -1;
    }
}
