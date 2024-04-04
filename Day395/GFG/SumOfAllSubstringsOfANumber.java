//GFG
//Sum of all substrings of a number
//Time complexity: O(|S|)
//Space complexity: O(|S|)

public class SumOfAllSubstringsOfANumber {

    public static void main(String[] args) {
        String s = "1234";
        System.out.println(sumSubstrings(s));
    }

    // Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s) {
        // Your code here
        long ans = 0, previous = 0, mod = 1000000007;
        for (int i = 0; i < s.length(); i++) {
            long curr = (previous * 10) % mod + (s.charAt(i) - '0') * (i + 1) % mod;
            previous = curr;
            ans = (ans + curr) % mod;
        }
        return ans;
    }
}
