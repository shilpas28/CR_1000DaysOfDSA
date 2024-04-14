//GFG
//Xoring and Clearing
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class XoringAndClearing {

    public static void main(String[] args) {
        int n = 10;
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        printArr(n, arr);
        xor1ToN(n, arr);
        printArr(n, arr);
        setToZero(n, arr);
        printArr(n, arr);
    }

    public static void printArr(int n, int arr[]) {
        // code here
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void setToZero(int n, int arr[]) {
        // code here
        for (int i = 0; i < n; i++)
            arr[i] = 0;
    }

    public static void xor1ToN(int n, int arr[]) {
        // code here
        for (int i = 0; i < n; i++)
            arr[i] = arr[i] ^ i;
    }
}
