//GFG
//Maximum Length - Greedy approach
//Time complexity: O(a+b+c)
//Space complexity: O(1)

package GFG;

public class MaximumLength_1 {
    public static void main(String[] args) {
        int a = 3, b = 3, c = 3;
        System.out.println(solve(a, b, c));
    }

    static int solve(int a, int b, int c) {
        // code here
        char prev = '0';
        int freq[] = { a, b, c };

        StringBuilder ans = new StringBuilder("");

        while (true) {
            int ma = 0;
            char cur = ' ';

            for (int i = 0; i < 3; i++)
                if (prev != (char) (i + 'a') && ma < freq[i]) {
                    ma = freq[i];
                    cur = (char) (i + 'a');
                    // System.out.println(cur+ "***");
                }

            if (ma == 0) // when only one type of charcter left. aa_ -
                break;

            ans.append(String.valueOf(cur));
            freq[cur - 'a']--;

            if (ma >= 2 && (prev == '0' || ma > freq[prev - 'a'])) {
                ans.append(String.valueOf(cur));
                freq[cur - 'a']--;
            }
            prev = cur;
            // System.out.println(prev);
            // System.out.println(ans); System.out.println("****");

        }
        int n = ans.length();
        if (n != a + b + c)
            return -1;
        return n;
    }
}
