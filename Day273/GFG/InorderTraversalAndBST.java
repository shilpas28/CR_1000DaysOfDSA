//GFG
//Inorder Traversal and BST
//Time complexity: O(N)
//Space complexity: O(1)

package GFG;

public class InorderTraversalAndBST {

    public static void main(String[] args) {
        int N = 3;
        int[] arr = { 2, 4, 5 };
        System.out.println(isRepresentingBST(arr, N));
    }

    static int isRepresentingBST(int arr[], int N) {
        // code here
        for (int i = 1; i < N; i++) {
            if (arr[i] <= arr[i - 1])
                return 0;
        }
        return 1;
    }
}
