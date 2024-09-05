//GFG
//Missing in Array
//Time complexity: O(N)
//Space complexity: O(1) 

public class MissingInArray {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 5 };
        int n = 5;
        System.out.println(missingNumber(n, arr));
    }

    // Note that the size of the array is n-1
    static int missingNumber(int n, int arr[]) {
        // Your Code Here
        int totalSum = 0;
        int sum = 0;
        // total sum from 1 to n
        for (int i = 1; i <= n; i++) {
            totalSum += i;
        }
        // sum of all elements that are present in Array
        for (int i : arr) {
            sum += i;
        }
        return (totalSum - sum);
    }
}
