//Leetcode
//1396. Design Underground System
//Time complexity: Just class design
//Space complexity: Just class design

package Leetcode;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class DesignUndergroundSystem {

    static class UndergroundSystem {
        Map<Integer, Pair<String, Integer>> checkInMap = new HashMap<>(); // Uid - {StationName, Time}
        Map<String, Pair<Double, Integer>> routeMap = new HashMap<>(); // RouteName - {TotalTime, Count}

        public UndergroundSystem() {
        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new Pair<>(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Pair<String, Integer> checkIn = checkInMap.get(id);
            checkInMap.remove(id); // Remove after using it which will not make HashTable big

            String routeName = checkIn.getKey() + "_" + stationName;
            int totalTime = t - checkIn.getValue();

            Pair<Double, Integer> route = routeMap.getOrDefault(routeName, new Pair<>(0.0, 0));
            routeMap.put(routeName, new Pair<>(route.getKey() + totalTime, route.getValue() + 1));
        }

        public double getAverageTime(String startStation, String endStation) {
            String routeName = startStation + "_" + endStation;
            Pair<Double, Integer> trip = routeMap.get(routeName);
            return trip.getKey() / trip.getValue();
        }
    }

    public static void main(String[] args) {
        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15); // Customer 45 "Leyton" -> "Waterloo" in 15-3 = 12
        undergroundSystem.checkOut(27, "Waterloo", 20); // Customer 27 "Leyton" -> "Waterloo" in 20-10 = 10
        undergroundSystem.checkOut(32, "Cambridge", 22); // Customer 32 "Paradise" -> "Cambridge" in 22-8 = 14
        undergroundSystem.getAverageTime("Paradise", "Cambridge"); // return 14.00000. One trip "Paradise" ->
                                                                   // "Cambridge", (14) / 1 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo"); // return 11.00000. Two trips "Leyton" -> "Waterloo",
                                                                // (10 + 12) / 2 = 11
        undergroundSystem.checkIn(10, "Leyton", 24);
        undergroundSystem.getAverageTime("Leyton", "Waterloo"); // return 11.00000
        undergroundSystem.checkOut(10, "Waterloo", 38); // Customer 10 "Leyton" -> "Waterloo" in 38-24 = 14
        undergroundSystem.getAverageTime("Leyton", "Waterloo"); // return 12.00000. Three trips "Leyton" -> "Waterloo",
                                                                // (10 + 12 + 14) / 3 = 12
    }
}
