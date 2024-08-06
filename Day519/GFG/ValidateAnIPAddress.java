//GFG
//Validate an IP Address
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class ValidateAnIPAddress {

    public static void main(String[] args) {
        String str = "222.111.111.111";
        System.out.println(isValid(str));
    }

    public static boolean isValid(String str) {
        // Write your code here
        int temp = -1, count = 0, index = -1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                count++;
                if (temp < 0 || temp > 255)
                    return false;
                if (temp != 0 && str.charAt(index + 1) == '0')
                    return false;
                temp = -1;
                index = i;
            } else {
                if (temp == -1)
                    temp = 0;
                temp = temp * 10 + (str.charAt(i) - '0');
            }
        }
        if (temp < 0 || temp > 255 || count != 3)
            return false;
        if (temp != 0 && str.charAt(index + 1) == '0')
            return false;
        return true;
    }
}
