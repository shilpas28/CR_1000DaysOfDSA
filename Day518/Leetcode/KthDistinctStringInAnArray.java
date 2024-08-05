//Leetcode
//2053. Kth Distinct String in an Array - Brute Force
//Time complexity: O(n^2)
//Space complexity: O(1)

public class KthDistinctStringInAnArray {

    public static void main(String[] args) {
        String[] arr = { "d", "b", "c", "b", "c", "a" };
        int k = 2;
        System.out.println(kthDistinct(arr, k));
    }

    public static String kthDistinct(String[] arr, int k) {
        int distinctCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (isDistinct(arr, i)) {
                distinctCount++;
                if (distinctCount == k) {
                    return arr[i];
                }
            }
        }
        return "";
    }

    static boolean isDistinct(String[] arr, int index) {
        for (int i = 0; i < arr.length; i++) {
            if (i != index && arr[i].equals(arr[index])) {
                return false;
            }
        }
        return true;
    }
}
