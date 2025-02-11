//Leetcode
//1910. Remove All Occurrences of a Substring - Iteration
//Time complexity: O((n^2)/m)
//Space complexity: O(n)

public class RemoveAllOccurrencesOfASubstring {

    public static void main(String[] args) {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));
    }

    public static String removeOccurrences(String s, String part) {
        // Continue removing occurrences of 'part' as long as it exists in 's'
        while (s.contains(part)) {
            // Find the index of the leftmost occurrence of 'part'
            int partStartIndex = s.indexOf(part);
            // Remove the substring 'part' from 's' by concatenating the segments before and
            // after 'part'
            s = s.substring(0, partStartIndex) +
                    s.substring(partStartIndex + part.length());
        }
        // Return the updated string after all occurrences are removed
        return s;
    }
}
