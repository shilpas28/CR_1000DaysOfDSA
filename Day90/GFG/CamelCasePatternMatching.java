//GFG
//CamelCase Pattern Matching
//Time complexity: O(N*|S|) S=Longest string in Dictionary
//Space complexity: O(26*N)

package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class CamelCasePatternMatching {

    public static void main(String[] args) {
        int N = 8;
        String[] Dictionary = { "Hi", "Hello", "HelloWorld", "HiTech", "HiGeek", "HiTechWorld", "HiTechCity",
                "HiTechLab" };
        String Pattern = "HT";
        System.out.println(CamelCase(N, Dictionary, Pattern));
    }

    static ArrayList<String> CamelCase(int N, String[] Dictionary, String Pattern) {
        // code here
        Arrays.sort(Dictionary);
        ArrayList<String> ans = new ArrayList<>();
        for (String word : Dictionary) {
            String st = "";
            boolean flag = false;
            for (char c : word.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    st += c;
                }
                if (st.equals(Pattern)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                ans.add(word);
            }
        }
        if (ans.isEmpty()) {
            ans.add("-1");
        }
        return ans;
    }

}
