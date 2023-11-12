//Leetcode
//815. Bus Routes
//Time complexity: O(n*m) - The outer loop runs until no more updates can be made, and in each iteration, we iterate through 
//all routes. Therefore, the time complexity is O(n * m), where n is the number of routes and m is the average number of stops 
//in a route.
//Space complexity: O(maxStop) - where maxStop is the maximum bus stop number in any route, as we use 
//an array minBusesToReach of this size.

package Leetcode;

import java.util.Arrays;

public class BusRoutes {

    public static void main(String[] args) {
        int[][] routes = { { 1, 2, 7 }, { 3, 6, 7 } };
        int source = 1, target = 6;
        System.out.println(numBusesToDestination(routes, source, target));
    }

    public static int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int maxStop = -1;
        for (int[] route : routes) {
            for (int stop : route) {
                maxStop = Math.max(maxStop, stop);
            }
        }
        if (maxStop < target) {
            return -1;
        }
        int n = routes.length;
        int[] minBusesToReach = new int[maxStop + 1];
        Arrays.fill(minBusesToReach, n + 1);
        minBusesToReach[source] = 0;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int[] route : routes) {
                int min = n + 1;
                for (int stop : route) {
                    min = Math.min(min, minBusesToReach[stop]);
                }
                min++;
                for (int stop : route) {
                    if (minBusesToReach[stop] > min) {
                        minBusesToReach[stop] = min;
                        flag = true;
                    }
                }
            }

        }
        return (minBusesToReach[target] < n + 1 ? minBusesToReach[target] : -1);
    }
}
