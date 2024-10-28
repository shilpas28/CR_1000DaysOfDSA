//GFG
//Remove duplicates in array
//Time complexity: O(N)
//Space complexity: O(1) 

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveDuplicatesInArray {

    public static void main(String[] args) {
        int arr[] = { 2, 2, 3, 3, 7, 5 };
        System.out.println(removeDuplicate(arr));
    }

    static ArrayList<Integer> removeDuplicate(int arr[]) {
        // code here
        int mm[] = new int[101];
        Arrays.fill(mm, 0);
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : arr) {
            if (mm[x] == 0) {
                ans.add(x);
                mm[x] = 1;
            }
        }
        return ans;
    }
}
