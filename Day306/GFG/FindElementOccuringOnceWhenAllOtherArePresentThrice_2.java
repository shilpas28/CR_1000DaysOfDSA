//GFG
//Find element occuring once when all other are present thrice
//Time complexity: O(N) 
//Space complexity: O(1) 

import java.util.ArrayList;
import java.util.List;

public class FindElementOccuringOnceWhenAllOtherArePresentThrice_2 {

    public static void main(String[] args) {
        int N = 4;
        int arr[] = { 1, 10, 1, 1 };
        System.out.println(singleElement(arr, N));
    }

    static int singleElement(int[] arr, int N) {
        // code here
        List<Integer> count = new ArrayList<>(32);
        for (int i = 0; i < 32; i++) {
            count.add(0);
        }
        for (int bit = 0; bit < 32; bit++) {
            for (int i = 0; i < arr.length; i++) {
                if ((arr[i] & (1 << bit)) != 0) {
                    count.set(bit, count.get(bit) + 1);
                }
            }
        }
        int ans = 0;
        for (int bit = 0; bit < 32; bit++) {
            if (count.get(bit) % 3 != 0) {
                ans += (1 << bit);
            }
        }
        return ans;
    }
}
