//GFG
//Minimum Jumps
//Time complexity: O(N)
//Space complexity: O(1)

public class MinimumJumps {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
        System.out.println(minJumps(arr));
    }

    public static int minJumps(int[] arr) {
        // code here
        if (arr[0] == 0)
            return -1;
        int ans = 1, jump = arr[0], mx = 0;
        for (int i = 1; i < arr.length; i++) {
            mx--;
            jump--;
            mx = Math.max(mx, arr[i]);
            if (jump == 0 && i != arr.length - 1) {
                if (mx <= 0)
                    return -1;
                jump = mx;
                mx = 0;
                ans++;
            }
        }
        return ans;
    }
}
