//GFG
//Minimum repeat to make substring - not accepted as TLE
//Time complexity: O(n+m) where n =length of s1 and m = length of s2
//Space complexity: O(n)

public class MinimumRepeatToMakeSubstring {

    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdabcdab";
        System.out.println(minRepeats(s1, s2));
    }

    static int minRepeats(String s1, String s2) {
        // code here
        String c = "";
        int count = 0;
        while (c.length() <= 2 * s2.length()) {
            c += s1;
            count++;
            if (c.contains(s2)) 
                return count;
        }
        return -1;
    }
}
