//GFG
//Minimum repeat to make substring - not accepted as TLE
//Time complexity: O(n+m) where n =length of s1 and m = length of s2
//Space complexity: O(n)

public class MinimumRepeatToMakeSubstring_2 {

    public static void main(String[] args) {
        String s1 = "abcd", s2 = "cdabcdab";
        System.out.println(minRepeats(s1, s2));
    }

    static int minRepeats(String s1, String s2) {
        // code here
        for (int i = 0; i < s2.length(); i++) {
            if (!s1.contains(String.valueOf(s2.charAt(i))))
                return -1;
        }

        int count = 0;
        int stop = (s2.length() / s1.length()) + 1;
        StringBuilder str = new StringBuilder();
        while (count <= stop) {
            str.append(s1);
            count++;
            if (str.toString().contains(s2))
                return count;
        }
        return -1;
    }
}
