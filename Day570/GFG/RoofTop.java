//GFG
//Roof Top
//Time complexity: O(N)
//Space complexity: O(1)

public class RoofTop {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 3, 2 };
        System.out.println(maxStep(arr));
    }

    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public static int maxStep(int arr[]) {
        // Your code here
        int ans = 0, increaseCount = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                increaseCount++;
            else {
                ans = Math.max(ans, increaseCount);
                increaseCount = 0;
            }
        }
        ans = Math.max(ans, increaseCount);
        return ans;
    }
}
