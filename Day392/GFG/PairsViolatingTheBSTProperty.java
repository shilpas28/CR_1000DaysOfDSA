//GFG
//Pairs violating the BST property
//Time complexity: O(NlogN)
//Space complexity: O(N) 

package GFG;

import java.util.ArrayList;

public class PairsViolatingTheBSTProperty {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        Node root = new Node(10);
        root.left = new Node(50);
        root.right = new Node(40);
        root.right.left = new Node(20);
        root.right.right = new Node(30);
        System.out.println(pairsViolatingBST(n, root));
    }

    static int ans = 0;

    public static int pairsViolatingBST(int n, Node root) {
        // code here
        ans = 0;
        ArrayList<Integer> nodes = new ArrayList<>();
        help(root, nodes);
        int arr[] = new int[nodes.size()];
        for (int i = 0; i < nodes.size(); i++)
            arr[i] = nodes.get(i);
        mergesort(arr, 0, n - 1);
        return ans;
    }

    static void help(Node root, ArrayList<Integer> nodes) {
        if (root == null)
            return;
        help(root.left, nodes);
        nodes.add(root.data);
        help(root.right, nodes);
    }

    static void mergesort(int arr[], int low, int high) {
        if (low >= high)
            return;
        int mid = (low + high) / 2;
        mergesort(arr, low, mid);
        mergesort(arr, mid + 1, high);
        merge(arr, low, mid, high);
    }

    static void merge(int arr[], int low, int mid, int high) {
        int a = mid - low + 1;
        int b = high - mid;
        int arr1[] = new int[a];
        int arr2[] = new int[b];
        for (int i = 0; i < a; i++)
            arr1[i] = arr[low + i];
        for (int i = 0; i < b; i++)
            arr2[i] = arr[mid + i + 1];
        int i = 0, k = low, j = 0;
        while (i < a && j < b) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                ans += a - i;
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }
        while (i < a) {
            arr[k++] = arr1[i++];
        }
        while (j < b) {
            arr[k++] = arr2[j++];
        }
    }
}
