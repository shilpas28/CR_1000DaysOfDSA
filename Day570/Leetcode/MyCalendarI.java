//Leetcode
//729. My Calendar I - Check every existed book for overlap
//Time complexity:
//Space complexity:

import java.util.ArrayList;
import java.util.List;

class MyCalendarI {

    static class MyCalendar {

        public List<int[]> books;

        public MyCalendar() {
            books = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end))
                    return false;
            books.add(new int[] { start, end });
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
