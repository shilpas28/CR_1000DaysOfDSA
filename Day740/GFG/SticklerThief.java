//GFG
//Stickler Thief
//Time complexity: O(N)
//Space complexity: O(1) 

package GFG;

public class SticklerThief {

    public static void main(String[] args) {
        int arr[] = { 6, 5, 5, 7, 4 };
        System.out.println(findMaxSum(arr));
    }

    public static int findMaxSum(int arr[]) {
        // code here
        int n = arr.length;
        int pre = arr[0];
        int pop = 0;
        int max = pre;

        for (int i = 1; i < n; i++) {
            max = Math.max(pre, pop + arr[i]);
            pop = pre;
            pre = max;
        }
        return max;
    }
}
