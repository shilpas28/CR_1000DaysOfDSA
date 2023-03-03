//Leetcode
//28. Find the Index of the First Occurrence in a String
//Without using inbuilt function
//Time complexity:
//Space complexity:
public class IndexOfFirstOccurenceInString_4 {
    public static void main(String[] args) {
        String haystack = "sadbutsad";
        String needle = "sad";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (compareStrings(haystack, needle, i) == true)
                    return i;
            }
        }
        return -1;
    }

    public static boolean compareStrings(String haystack, String needle, int index) {
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i < len2; i++) {

            if (index >= len1)
                return false;
            if (haystack.charAt(index++) != needle.charAt(i)) 
                return false;
            
        }
        return true;
    }
}
