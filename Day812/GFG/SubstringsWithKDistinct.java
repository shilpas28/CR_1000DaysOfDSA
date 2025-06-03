//GFG
//Substrings with K Distinct
//Time complexity: O(|S|)
//Space complexity: O(1)

public class SubstringsWithKDistinct {

    public static void main(String[] args) {
        String s = "abc";
        int k = 2;
        System.out.println(countSubstr(s, k));
    }

    static int countSubstr(String s, int k) {
        // your code here
        return (int) (atmost(s, k) - atmost(s, k - 1));
    }

    static long atmost(String s, int k) {

        int arr[] = new int[26];
        int dist = 0, left = 0;
        long res = 0;

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            if (arr[s.charAt(i) - 'a'] == 1)
                dist++;
            while (dist > k) {
                arr[s.charAt(left) - 'a']--;
                if (arr[s.charAt(left) - 'a'] == 0)
                    dist--;
                left++;
            }
            res = res + (i - left + 1);
        }
        return res;
    }
}
