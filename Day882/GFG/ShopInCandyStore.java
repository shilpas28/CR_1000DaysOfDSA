//GFG
//Shop in Candy Store
//Time complexity: O(NlogN)
//Space complexity: O(1)

import java.util.ArrayList;
import java.util.Arrays;

public class ShopInCandyStore {

    public static void main(String[] args) {
        int prices[] = { 3, 2, 1, 4 };
        int k = 2;
        System.out.println(minMaxCandy(prices, k));
    }

    public static ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        Arrays.sort(prices);
        int min = 0;
        int max = 0;
        int count = 0;
        int N = prices.length;
        for (int i = 0; i < N - count; i++) {
            min += prices[i];
            max += prices[N - 1 - i];
            count += k;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(min);
        ans.add(max);
        return ans;
    }
}
