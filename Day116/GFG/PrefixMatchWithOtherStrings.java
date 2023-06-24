//GFG
//Prefix match with other strings
//Time complexity: O(n*l) where l is the length of the longest word in arr[].
//Space complexity: O(n*l) where l is the length of the longest word in arr[].

package GFG;

public class PrefixMatchWithOtherStrings {

    public static void main(String[] args) {
        int n = 6;
        String arr[] = { "abba", "abbb", "abbc", "abbd", "abaa", "abca" };
        String str = "abbg";
        int k = 3;
        System.out.println(klengthpref(arr, n, k, str));
    }

    public static int klengthpref(String[] arr, int n, int k, String str) {
        // code here
        if (k > str.length())
            return 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (k <= arr[i].length()) {
                int j = 0;
                while (j < k) {
                    if (arr[i].charAt(j) != str.charAt(j))
                        break;
                    j++;
                }
                if (j == k)
                    ans++;
            }
        }
        return ans;
    }
}
