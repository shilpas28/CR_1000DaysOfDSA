//Leetcode
//1957. Delete Characters to Make Fancy String
//Time complexity: O(N) 
//Space complexity: O(N) // space used for answer string otherwise O(1)

public class DeleteCharactersToMakeFancyString {

    public static void main(String[] args) {
        String s = "leeetcode";
        System.out.println(makeFancyString(s));
    }

    public static String makeFancyString(String s) {
        StringBuilder ans = new StringBuilder();
        ans.append(s.charAt(0));
        int n = s.length(), cnt = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ans.charAt(ans.length() - 1)) {
                cnt++;
                if (cnt < 3) {
                    ans.append(s.charAt(i));
                }
            } else {
                cnt = 1;
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}
