//Leetcode
//2683. Neighboring Bitwise XOR - Cumulative XOR
//Time complexity: O(N)
//Space complexity: O(1) 

public class NeighboringBitwiseXOR_2 {

    public static void main(String[] args) {
        int derived[] = { 1, 1, 0 };
        System.out.println(doesValidArrayExist(derived));
    }

    public static boolean doesValidArrayExist(int[] derived) {
        int XOR = 0;
        for (int element : derived) {
            XOR = XOR ^ element;
        }
        return XOR == 0;
    }
}
