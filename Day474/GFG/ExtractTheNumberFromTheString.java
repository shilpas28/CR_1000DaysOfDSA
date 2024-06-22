//GFG
//Extract the Number from the String
//Time complexity: O(N)
//Space complexity: O(1)

public class ExtractTheNumberFromTheString {

    public static void main(String[] args) {
        String sentence = "This is alpha 5057 and 97";
        System.out.println(ExtractNumber(sentence));
    }

    static long ExtractNumber(String sentence) {
        // code here
        long ans = 0, temp = 0;
        boolean indication = false;
        for (int i = 0; i < sentence.length(); i++) {
            char x = sentence.charAt(i);
            if (x >= '0' && x <= '9') {
                if (x == '9')
                    indication = true;
                temp = temp * 10 + (x - '0');
            } else if (x == ' ') {
                if (!indication)
                    ans = Math.max(ans, temp);
                temp = 0;
                indication = false;
            }
        }
        if (!indication)
            ans = Math.max(ans, temp);
        return ans == 0 ? -1 : ans;
    }
}
