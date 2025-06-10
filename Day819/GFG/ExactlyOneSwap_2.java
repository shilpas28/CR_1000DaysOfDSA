//GFG
//Exactly one swap
//Time complexity: O(N)
//Space complexity: O(1)

public class ExactlyOneSwap_2 {

    public static void main(String[] args) {
        String s = "geek";
        System.out.println(countStrings(s));
    }

    static int countStrings(String s) {
        // code here
        int map[] = new int[26];
        char[] st = s.toCharArray();
        int ans = 0;
        boolean containsDuplicate = false;
        for (int i = 0; i < st.length; i++) {
            ans += (i - map[st[i] - 'a']);
            map[st[i] - 'a']++;
            if (map[st[i] - 'a'] > 1)
                containsDuplicate = true;
        }
        return containsDuplicate ? ans + 1 : ans;
    }
}
