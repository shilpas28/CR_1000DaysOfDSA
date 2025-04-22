//GFG
//Unique Number I
//Time complexity: O(N)
//Space complexity: O(1) 

public class UniqueNumberI_3 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 1, 5, 5 };
        System.out.println(findUnique(arr));
    }

    public static int findUnique(int[] arr) {
        // code here
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }
        return ans;
    }
}
