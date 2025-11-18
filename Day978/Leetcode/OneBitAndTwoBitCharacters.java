//Leetcode
//717. 1-bit and 2-bit Characters - Increment Pointer
//Time complexity: O(N)
//Space complexity: O(1) 

public class OneBitAndTwoBitCharacters {

    public static void main(String[] args) {
        int[] bits = { 1, 0, 0 };
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }
}
