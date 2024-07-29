//GFG
//Row with max 1s
//Time complexity: O(n+m)
//Space complexity: O(1)

public class RowWithMax1s {

    public static void main(String[] args) {
        int arr[][] = { { 0, 1, 1, 1 },
                { 0, 0, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 0, 0, 0 } };
        System.out.println(rowWithMax1s(arr));
    }

    public static int rowWithMax1s(int arr[][]) {
        // code here
        int i = 0, j = arr[0].length - 1, ans = -1;
        while (i < arr.length && j >= 0) {
            if (arr[i][j] == 0) {
                i++;
            } else {
                ans = i;
                j--;
            }
        }
        return ans;
    }
}
