//Leetcode
//1963. Minimum Number of Swaps to Make the String Balanced - Using Constant Space
//Time complexity: O(N)
//Space complexity: O(1) 

public class MinimumNumberOfSwapsToMakeTheStringBalanced_4 {

    public static void main(String[] args) {
        String s = "][][";
        System.out.println(minSwaps(s));
    }

    public static int minSwaps(String s) {
        int open = 0, close = 0, unbalanced = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[')
                open++;
            else {
                if (open > close) // i.e we have an extra open [ to be used in a pair
                    close++;
                else
                    unbalanced++;
            }
        }
        return (unbalanced + 1) / 2;
    }
}
