//Leetcode
//3508. Implement Router
//Time complexity: O(logN)
//Space complexity: O(MemoryLimit)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ImplementRouter {

    static Map<List<Integer>, Integer> mpp = new HashMap<>(); // to track duplicates
    static Queue<List<Integer>> queue = new LinkedList<>(); // to store packets in FIFO order
    static Map<Integer, List<Integer>> timestamps = new HashMap<>(); // for timestamps tracking
    static Map<Integer, Integer> st = new HashMap<>();
    static int maxSize = 0; // maxSize allowed

    static class Router {

        public Router(int memoryLimit) {
            maxSize = memoryLimit;
        }

        public boolean addPacket(int source, int destination, int timestamp) {
            List<Integer> packet = Arrays.asList(source, destination, timestamp);
            // checking for duplicate
            if (mpp.containsKey(packet))
                return false;
            if (queue.size() == maxSize) { // remove the first element if queue is full
                List<Integer> res = queue.poll();
                mpp.remove(res);
                int temp = res.get(1);
                st.put(temp, st.getOrDefault(temp, 0) + 1);
            }
            queue.offer(packet);
            mpp.put(packet, 1);
            timestamps.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
            return true;
        }

        public int[] forwardPacket() {
            if (queue.isEmpty())
                return new int[0];
            List<Integer> res = queue.poll();
            mpp.remove(res);
            int temp = res.get(1);
            st.put(temp, st.getOrDefault(temp, 0) + 1);
            return new int[] { res.get(0), res.get(1), res.get(2) };
        }

        public int getCount(int destination, int startTime, int endTime) {
            if (!timestamps.containsKey(destination))
                return 0;
            List<Integer> p = timestamps.get(destination);
            int temp = st.getOrDefault(destination, 0);
            int right = lowerBound(p, startTime, temp);
            int left = upperBound(p, endTime, temp);
            return left - right;
        }

        public int lowerBound(List<Integer> p, int target, int start) {
            int l = start, r = p.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (p.get(mid) < target)
                    l = mid + 1;
                else
                    r = mid;
            }
            return l;
        }

        public int upperBound(List<Integer> p, int target, int start) {
            int l = start, r = p.size();
            while (l < r) {
                int mid = (l + r) / 2;
                if (p.get(mid) <= target)
                    l = mid + 1;
                else
                    r = mid;
            }
            return l;
        }
    }

    public static void main(String[] args) {
        Router router = new Router(3); // Initialize Router with memoryLimit of 3.
        System.out.println(router.addPacket(1, 4, 90)); // Packet is added. Return True.
        System.out.println(router.addPacket(2, 5, 90)); // Packet is added. Return True.
        System.out.println(router.addPacket(1, 4, 90)); // This is a duplicate packet. Return False.
        System.out.println(router.addPacket(3, 5, 95)); // Packet is added. Return True
        System.out.println(router.addPacket(4, 5, 105)); // Packet is added, [1, 4, 90] is removed as number of packets
                                                         // exceeds
        // memoryLimit. Return True.
        System.out.println(Arrays.toString(router.forwardPacket())); // Return [2, 5, 90] and remove it from router.
        System.out.println(router.addPacket(5, 2, 110)); // Packet is added. Return True.
        System.out.println(router.getCount(5, 100, 110)); // The only packet with destination 5 and timestamp in the
                                                          // inclusive range [100,
        // 110] is [4, 5, 105]. Return 1.
    }
}
