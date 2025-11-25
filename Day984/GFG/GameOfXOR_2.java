//GFG
//Game of XOR
//Time complexity: O(N)
//Space complexity: O(1)

public class GameOfXOR_2 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subarrayXor(arr));
    }

    public static int subarrayXor(int[] arr) {
        // code here
        int N = arr.length;
        if (N % 2 == 0) {
            return 0;
        }

        int final_xor = 0;
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                final_xor ^= arr[i];
            }
        }
        return final_xor;
    }
}
