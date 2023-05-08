//GFG
//Binary Modulo
//Time complexity: O(N)
//Space complexity: O(N)

public class BinaryModulo {

    public static void main(String[] args) {
        String s = "101";
        int m = 2;
        System.out.println(modulo(s, m));
    }

    static int modulo(String s, int m) {
        // Write your code here
        int base = 1;
        int dec_value = 0;
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1')
                dec_value += base;

            dec_value %= m;
            base = base * 2;
            base %= m;
        }
        return dec_value % m;
    }
}
