//Leetcode
//717. 1-bit and 2-bit Characters - Greedy
//Time complexity: O(N)
//Space complexity: O(1) 

public class OneBitAndTwoBitCharacters_2 {

    public static void main(String[] args) {
        int[] bits = { 1, 0, 0 };
        System.out.println(isOneBitCharacter(bits));
    }

    public static boolean isOneBitCharacter(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0) {
            i--;
        }
        return (bits.length - i) % 2 == 0;
    }
}
