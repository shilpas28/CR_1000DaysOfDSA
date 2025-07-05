//Leetcode
//1394. Find Lucky Integer in an Array
//Time complexity: O(N)
//Space complexity: O(1)

public class FindLuckyIntegerInAnArray_2 {

    public static void main(String[] args) {
        int[] arr = { 2, 2, 3, 4 };
        System.out.println(findLucky(arr));
    }

    public static int findLucky(int[] arr) {
        int[] freq = new int[501];
        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
    }
}
