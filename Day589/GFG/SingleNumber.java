//GFG
//Single Number
//Time complexity: O(N)
//Space complexity: O(1)

public class SingleNumber {

    public static void main(String[] args) {
        int arr[] = { 1, 1, 2, 2, 2 };
        System.out.println(getSingle(arr));
    }

    static int getSingle(int arr[]) {
        int ans = 0;
        for (int x : arr)
            ans ^= x;
        return ans;
    }
}
