//GFG
//Buy Maximum Stocks if i stocks can be bought on i-th day
//Time complexity: O(NlogN)
//Space complexity: O(N) 

package GFG;

import java.util.Arrays;

public class BuyMaximumStocksIfIStocksCanBeBoughtOnIthDay {

    public static void main(String[] args) {
        int[] price = { 10, 7, 19 };
        int n = price.length;
        int k = 45;
        System.out.println(buyMaximumProducts(n, k, price));
    }

    public static int buyMaximumProducts(int n, int k, int[] price) {
        // code here
        long arr[] = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = price[i] * 100000 + (i + 1);

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < n; i++) {
            int day = (int) arr[i] % 100000;
            int pr = (int) arr[i] / 100000;

            if (pr * day <= k) {
                count += day;
                k = k - pr * day;
            } else {
                count += (k / pr);
                k = k - pr * (k / pr);
            }
        }
        return count;
    }
}
