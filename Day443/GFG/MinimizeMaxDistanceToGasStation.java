//GFG
//Minimize Max Distance to Gas Station
//Time complexity: O(Nlogk)
//Space complexity: O(1)

package GFG;

public class MinimizeMaxDistanceToGasStation {

    public static void main(String[] args) {
        int[] stations = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int k = 9;
        System.out.println(findSmallestMaxDist(stations, k));
    }

    public static double findSmallestMaxDist(int stations[], int k) {
        // code here
        int n = stations.length;
        double low = 0, high = stations[n - 1] - stations[0], mid = 0, ans = 0;
        ans = high;
        while (high - low >= 1e-6) {
            mid = (low + high) / 2.0;
            if (isPossible(stations, mid, k)) {
                ans = mid;
                high = mid;
            } else
                low = mid;
        }
        return ans;
    }

    static boolean isPossible(int stations[], double mid, int k) {
        int total = 0;
        for (int i = 1; i < stations.length; i++) {
            int dis = stations[i] - stations[i - 1];
            total += Math.ceil(dis / mid) - 1;
        }
        return total <= k;
    }
}
