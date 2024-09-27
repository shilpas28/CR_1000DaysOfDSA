//Leetcode
//731. My Calendar II
//Time complexity:
//Space complexity:

import java.util.Map;
import java.util.TreeMap;

public class MyCalendarII {

    static class MyCalendarTwo {

        TreeMap<Integer, Integer> map;

        public MyCalendarTwo() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
            int count = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                count += entry.getValue();
                if (count > 2) {
                    map.put(start, map.get(start) - 1);
                    if (map.get(start) == 0) {
                        map.remove(start);
                    }
                    map.put(end, map.get(end) + 1);
                    if (map.get(end) == 0) {
                        map.remove(end);
                    }
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(50, 60)); // return True, The event can be booked.
        System.out.println(myCalendarTwo.book(10, 40)); // return True, The event can be double booked.
        System.out.println(myCalendarTwo.book(5, 15)); // return False, The event cannot be booked, because it would
                                                       // result in a triple
        // booking.
        System.out.println(myCalendarTwo.book(5, 10)); // return True, The event can be booked, as it does not use time
                                                       // 10 which is
        // already double booked.
        System.out.println(myCalendarTwo.book(25, 55)); // return True, The event can be booked, as the time in [25, 40)
                                                        // will be double
        // booked with the third event, the time [40, 50) will be single booked, and the
        // time [50, 55) will be double booked with the second event.
    }
}
