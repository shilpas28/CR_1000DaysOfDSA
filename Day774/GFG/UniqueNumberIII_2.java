//GFG
//Unique Number III
//Time complexity: O(N)
//Space complexity: O(1)

public class UniqueNumberIII_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 10, 1, 1 };
        System.out.println(getSingle(arr));
    }

    public static int getSingle(int[] arr) {
        // code here
        int ones = 0, twos = 0;

        for (int num : arr) {
            ones = (ones ^ num) & ~twos;
            twos = (twos ^ num) & ~ones;
        }

        return ones;
    }
}
