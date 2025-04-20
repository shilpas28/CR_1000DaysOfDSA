//GFG
//Find Only Repetitive Element from 1 to n-1
//Time complexity: O(N)
//Space complexity: O(1) 

public class FindOnlyRepetitiveElementFrom1ToNMinus1_2 {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 3, 4 };
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] arr) {
        // code here
        int n = arr.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] += 1;
            } else {
                return arr[i];
            }
        }
        return 0;
    }
}
