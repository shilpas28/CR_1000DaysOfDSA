//GFG
//Missing element of AP
//Time complexity: O(N)
//Space complexity: O(1)

public class MissingElementOfAP {

    public static void main(String[] args) {
        int arr[] = { 2, 4, 8, 10, 12, 14 };
        System.out.println(findMissing(arr));
    }

    public static int findMissing(int[] arr) {
        // code here
        int n = Math.min(arr[1] - arr[0], arr[arr.length - 1] - arr[arr.length - 2]);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1] + n)
                return arr[i - 1] + n;
        }
        return arr[arr.length - 1] + n;
    }
}
