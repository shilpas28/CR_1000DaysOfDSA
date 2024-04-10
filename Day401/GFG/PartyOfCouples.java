//GFG
//Party of Couples
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class PartyOfCouples {

    public static void main(String[] args) {
        int n = 5;
        int[] arr = { 1, 2, 3, 2, 1 };
        System.out.println(findSingle(n, arr));
    }

    static int findSingle(int n, int arr[]) {
        // code here
        int x = 0;
        for (int i = 0; i < n; i++)
            x ^= arr[i];
        return x;
    }
}
