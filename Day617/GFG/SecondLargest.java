//GFG
//Second Largest
//Time complexity: O(N)
//Space complexity: O(1) 

public class SecondLargest {

    public static void main(String[] args) {
        int arr[] = { 12, 35, 1, 10, 34, 1 };
        System.out.println(getSecondLargest(arr));
    }

    public static int getSecondLargest(int[] arr) {
        // Code Here
        int lar = -1;
        int secLar = -1;
        for (int ele : arr) {
            if (ele > lar) {
                secLar = lar;
                lar = ele;
            } else if (ele > secLar && ele < lar) {
                secLar = ele;
            }
        }
        return secLar;
    }
}
