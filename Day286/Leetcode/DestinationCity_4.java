//Leetcode
//1436. Destination City - Using Set Operations
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity_4 {

    public static void main(String[] args) {

        List<List<String>> paths = new ArrayList<>();
        paths.add(new ArrayList<>(Arrays.asList("London", "New York")));
        paths.add(new ArrayList<>(Arrays.asList("New York", "Lima")));
        paths.add(new ArrayList<>(Arrays.asList("Lima", "Sao Paulo")));
        System.out.println(destCity(paths));
    }

    public static String destCity(List<List<String>> paths) {
        Set<String> sourceCities = new HashSet<>();
        Set<String> destinationCities = new HashSet<>();
        for (List<String> path : paths) {
            sourceCities.add(path.get(0));
            destinationCities.add(path.get(1));
        }
        destinationCities.removeAll(sourceCities);
        return destinationCities.iterator().next();
    }
}
