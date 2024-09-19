//GFG
//Reverse Words
//Time complexity: O(|str|)
//Space complexity: O(|str|)

public class ReverseWords {

    public static void main(String[] args) {
        String str = "i.like.this.program.very.much";
        System.out.println(reverseWords(str));
    }

    // Function to reverse words in a given string.
    static String reverseWords(String str) {
        // code here
        StringBuilder temp = new StringBuilder();
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '.') {
                temp.reverse();
                temp.append('.');
                ans.append(temp);
                temp = new StringBuilder();
            } else if (i == str.length() - 1) {
                temp.append(str.charAt(i));
                temp.reverse();
                ans.append(temp);
            } else
                temp.append(str.charAt(i));
        }
        ans.reverse();
        return ans.toString();
    }
}
