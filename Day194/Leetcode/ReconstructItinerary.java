//Leetcode - Iterative solution
//332. Reconstruct Itinerary
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class ReconstructItinerary {

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

    public static List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> ret = new LinkedList<String>();
        Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
        Stack<String> stack = new Stack<String>();
        for (List<String> t : tickets) {
            if (!map.containsKey(t.get(0)))
                map.put(t.get(0), new PriorityQueue<String>());
            map.get(t.get(0)).offer(t.get(1));
        }
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String next = stack.peek();
            if (map.containsKey(next) && map.get(next).size() > 0)
                stack.push(map.get(next).poll());
            else
                ret.addFirst(stack.pop());
        }
        return ret;
    }
}
