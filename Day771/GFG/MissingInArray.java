//GFG
//Missing in Array
//Time complexity: O(N)
//Space complexity: O(1)

public class MissingInArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5 };
        System.out.println(missingNum(arr));
    }

    static int missingNum(int arr[]) {
        // code here
        int n = arr.length + 1;
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 0; i < n - 1; i++) {
            xor1 ^= arr[i];
        }

        for (int i = 1; i <= n; i++) {
            xor2 ^= i;
        }

        return xor1 ^ xor2;
    }
}
