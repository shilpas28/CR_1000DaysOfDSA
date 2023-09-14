//Leetcode - Using  Hierholzer's algorithm to find a Eulerian path
//332. Reconstruct Itinerary
//Time complexity: O(n + nlogn + n) (build graph O(n + nlogn), Hierholzer O(n))
//Space complexity: O(n), where n is the total number of tickets.

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary_2 {

    public static void main(String[] args) {
        List<List<String>> tickets = new ArrayList<>();
        List<String> lst1 = new ArrayList<>();
        lst1.add("MUC");
        lst1.add("LHR");
        tickets.add(lst1);
        List<String> lst2 = new ArrayList<>();
        lst2.add("JFK");
        lst2.add("MUC");
        tickets.add(lst2);
        List<String> lst3 = new ArrayList<>();
        lst3.add("SFO");
        lst3.add("SJC");
        tickets.add(lst3);
        List<String> lst4 = new ArrayList<>();
        lst4.add("LHR");
        lst4.add("SFO");
        tickets.add(lst4);

        System.out.println(findItinerary(tickets));
    }

    static Map<String, PriorityQueue<String>> flights;
    static LinkedList<String> path;

    public static List<String> findItinerary(List<List<String>> tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for (List<String> ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK");
        return path;
    }

    public static void dfs(String departure) {
        PriorityQueue<String> arrivals = flights.get(departure);
        while (arrivals != null && !arrivals.isEmpty())
            dfs(arrivals.poll());
        path.addFirst(departure);
    }
}
