//GFG
//Odd Even Problem
//Time complexity: O(|s|)
//Space complexity: O(1) 

package GFG;

public class OddEvenProblem {

    public static void main(String[] args) {
        String s = "abbbcc";
        System.out.println(oddEven(s));
    }

    public static String oddEven(String s) {
        // code here
        int temp[] = new int[26];
        for (int i = 0; i < s.length(); i++)
            temp[s.charAt(i) - 'a']++;
        int x = 0, y = 0;
        for (int i = 0; i < 26; i++) {
            if ((i + 1) % 2 == 1) {
                if (temp[i] % 2 == 1)
                    y++;
            } else {
                if (temp[i] % 2 == 0 && temp[i] != 0)
                    x++;
            }
        }
        return (x + y) % 2 == 1 ? "ODD" : "EVEN";
    }
}
