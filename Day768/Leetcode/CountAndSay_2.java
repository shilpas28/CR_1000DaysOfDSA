//Leetcode
//38. Count and Say - Recursion
//Time complexity: O(2^N)
//Space complexity: O(N + (2^N))

public class CountAndSay_2 {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(countAndSay(n));
    }

    public static String countAndSay(int n) {
        if (n == 1)
            return "1";

        String prev = countAndSay(n - 1);
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < prev.length()) {
            int count = 1;
            while (i + 1 < prev.length() && prev.charAt(i) == prev.charAt(i + 1)) {
                i++;
                count++;
            }
            res.append(count).append(prev.charAt(i));
            i++;
        }

        return res.toString();
    }
}
