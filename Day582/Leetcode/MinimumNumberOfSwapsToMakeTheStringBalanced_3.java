//Leetcode
//1963. Minimum Number of Swaps to Make the String Balanced - Using Constant Space
//Time complexity: O(N)
//Space complexity: O(1)

public class MinimumNumberOfSwapsToMakeTheStringBalanced_3 {

    public static void main(String[] args) {
        String s = "][][";
        System.out.println(minSwaps(s));
    }

    public static int minSwaps(String s) {
        int open = 0, unbalanced = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '[')
                open++;
            else {
                // check if we have found an open bracket before
                if (open > 0) {
                    // we have a proper pair
                    open--; // we used one open bracket for this pair
                } else
                    unbalanced++;
            }
        }
        // add the remaining open bracket which are left out for a pair
        unbalanced += open;
        unbalanced /= 2; // # of open brackets or # of close brackets
        return (unbalanced + 1) / 2;
    }
}
