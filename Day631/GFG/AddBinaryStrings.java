//GFG
//Add Binary Strings
//Time complexity: O(N)
//Space complexity: O(N) 

public class AddBinaryStrings {

    public static void main(String[] args) {
        String s1 = "1101", s2 = "111";
        System.out.println(addBinary(s1, s2));
    }

    public static String addBinary(String s1, String s2) {
        // code here
        int i = s1.length() - 1;
        int j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int bit1 = i >= 0 ? s1.charAt(i) - '0' : 0;
            int bit2 = j >= 0 ? s2.charAt(j) - '0' : 0;
            int sum = bit1 + bit2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
            --i;
            --j;
        }

        String res = sb.reverse().toString();
        i = 0;
        int n = res.length();
        while (i < n && res.charAt(i) == '0')
            ++i;

        if (i > 0)
            res = res.substring(i);

        return res;
    }
}
