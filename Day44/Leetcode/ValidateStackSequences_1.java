//Leetcode 
//946. Validate Stack Sequences - using 2 pointer technique and no extra space
//Time complexity: O(N)
//Space complexity: O(1) - space optimized as we are using no extra stack 

package Leetcode;

public class ValidateStackSequences_1 {
    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 5, 3, 2, 1 };
        System.out.println(validateStackSequences(pushed, popped));
    }

    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int i = 0, j = 0;
        for (int x : pushed) {
            pushed[i++] = x;
            while (i > 0 && pushed[i - 1] == popped[j]) {
                --i;
                ++j;
            }
        }
        return i == 0;
    }
}
