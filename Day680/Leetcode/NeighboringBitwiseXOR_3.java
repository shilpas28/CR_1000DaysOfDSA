//Leetcode
//2683. Neighboring Bitwise XOR - Sum Parity 
//Time complexity: O(N)
//Space complexity: O(1) 

public class NeighboringBitwiseXOR_3 {

    public static void main(String[] args) {
        int derived[] = { 1, 1, 0 };
        System.out.println(doesValidArrayExist(derived));
    }

    public static boolean doesValidArrayExist(int[] derived) {
        int sum = 0;
        for (int num : derived) {
            sum += num;
        }
        return sum % 2 == 0;
    }
}
