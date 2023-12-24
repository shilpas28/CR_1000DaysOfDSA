//GFG
//Buy Maximum Stocks if i stocks can be bought on i-th day
//Time complexity: O(NlogN)
//Space complexity: O(N) 

package GFG;

import java.util.ArrayList;
import java.util.Collections;

public class BuyMaximumStocksIfIStocksCanBeBoughtOnIthDay_2 {

    static class Pair implements Comparable<Pair> {
        int cost, quan;

        Pair(int cost, int quan) {
            this.cost = cost;
            this.quan = quan;
        }

        public int compareTo(Pair a) {
            return this.cost - a.cost;
        }
    }

    public static void main(String[] args) {
        int[] price = { 10, 7, 19 };
        int n = price.length;
        int k = 45;
        System.out.println(buyMaximumProducts(n, k, price));
    }

    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new Pair(price[i], i + 1));
        Collections.sort(arr);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int units = Math.min(arr.get(i).quan, k / arr.get(i).cost);
            ans += units;
            k -= arr.get(i).cost * units;
        }
        return ans;
    }
}
