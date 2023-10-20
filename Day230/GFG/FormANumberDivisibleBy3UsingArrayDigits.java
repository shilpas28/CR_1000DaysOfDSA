//GFG
//Form a number divisible by 3 using array digits
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class FormANumberDivisibleBy3UsingArrayDigits {

    public static void main(String[] args) {
        int N = 3;
        int[] arr = { 40, 50, 90 };
        System.out.println(isPossible(N, arr));
    }

    static int isPossible(int N, int arr[]) {
        // code here
        long sum = 0;
        for (int x : arr)
            sum += x;
        if (sum % 3 == 0)
            return 1;
        return 0;
    }
}
