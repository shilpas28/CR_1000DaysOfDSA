//Leetcode - TreeMap
//729. My Calendar I - Keep existing books sorted and only check 2 books start right before & after the new book starts
//Time complexity:
//Space complexity:

import java.util.TreeMap;

public class MyCalendarI_3 {

    static class MyCalendar {

        public TreeMap<Integer, Integer> books;
        public MyCalendar() {
            books = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            java.util.Map.Entry<Integer, Integer> floor = books.floorEntry(start), ceiling = books.ceilingEntry(start);
            if (floor != null && start < floor.getValue())
                return false; // (s, e) start within floor
            if (ceiling != null && ceiling.getKey() < end)
                return false; // ceiling start within (s, e)
            books.put(start, end);
            return true;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // return True
        System.out.println(myCalendar.book(15, 25)); // return False, It can not be booked because time 15 is already
                                                     // booked by
        // another event.
        System.out.println(myCalendar.book(20, 30)); // return True, The event can be booked, as the first event takes
                                                     // every time
        // less than 20, but not including 20.
    }
}
