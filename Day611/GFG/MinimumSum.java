//GFG
//Minimum sum
//Time complexity: O(NlogN)
//Space complexity: O(N)

public class MinimumSum {

    public static void main(String[] args) {
        int[] arr = { 6, 8, 4, 5, 2, 3 };
        System.out.println(minSum(arr));
    }

    static String minSum(int[] arr) {
        // code here
        int[] count = new int[10];
        for (int ele : arr)
            count[ele]++;

        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        boolean toggle = true;
        for (int dig = 0; dig <= 9; ++dig) {
            while (count[dig] > 0) {
                if (toggle) {
                    num1.append(dig);
                } else {
                    num2.append(dig);
                }
                count[dig]--;
                toggle = !toggle;
            }
        }

        String res1 = removeLeadingZeroes(num1.toString());
        String res2 = removeLeadingZeroes(num2.toString());
        return addString(res1, res2);
    }

    static String removeLeadingZeroes(String num) {
        int i = 0;
        while (i < num.length() && num.charAt(i) == '0')
            ++i;

        return num.substring(i);
    }

    static String addString(String res1, String res2) {
        int i = res1.length() - 1;
        int j = res2.length() - 1;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while (i >= 0 || j >= 0 || carry == 1) {
            int dig1 = i >= 0 ? res1.charAt(i) - '0' : 0;
            int dig2 = j >= 0 ? res2.charAt(j) - '0' : 0;
            int sum = dig1 + dig2 + carry;
            res.append(sum % 10);
            carry = sum / 10;
            i--;
            j--;
        }
        return res.reverse().toString();
    }
}
