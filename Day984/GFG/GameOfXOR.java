//GFG
//Game of XOR
//Time complexity: O(N)
//Space complexity: O(1)

public class GameOfXOR {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subarrayXor(arr));
    }

    public static int subarrayXor(int[] arr) {
        // code here
        int x = 0;
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            int y = (i + 1) * (N - i);
            if ((y & 1) == 1) {
                x ^= arr[i];
            }
        }
        return x;
    }
}
