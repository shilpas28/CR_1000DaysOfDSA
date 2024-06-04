//GFG
//Binary representation of next number
//Time complexity: O(N)
//Space complexity: O(N)

public class BinaryRepresentationOfNextNumber {

    public static void main(String[] args) {
        String s = "10";
        System.out.println(binaryNextNumber(s));
    }

    static String binaryNextNumber(String s) {
        // code here.
        boolean indication = true;
        char[] temp = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (temp[i] == '0') {
                temp[i] = '1';
                indication = false;
                break;
            } else
                temp[i] = '0';
        }
        StringBuilder ans = new StringBuilder();
        if (indication == true) {
            ans.append('1');
            ans.append(temp);
        } else {
            int index = 0;
            while (index < s.length() && temp[index] == '0')
                index++;
            ans.append(temp, index, s.length() - index);
        }
        return ans.toString();
    }
}
