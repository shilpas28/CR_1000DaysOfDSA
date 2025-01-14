//GFG
//Equilibrium Point
//Time complexity: O(N)
//Space complexity: O(1)

public class EquilibriumPoint {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 0, 3 };
        System.out.println(findEquilibrium(arr));
    }

    // Function to find equilibrium point in the array.
    public static int findEquilibrium(int arr[]) {
        // code here
        int totalSum = 0;
        for (int i : arr)
            totalSum += i;

        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currSum == totalSum - currSum - arr[i]) {
                return i;
            }
            currSum += arr[i];
        }
        return -1;
    }
}
