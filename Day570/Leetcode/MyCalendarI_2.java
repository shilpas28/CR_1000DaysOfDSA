//Leetcode - TreeSet
//729. My Calendar I - Keep existing books sorted and only check 2 books start right before & after the new book starts
//Time complexity: 
//Space complexity:

import java.util.TreeSet;

public class MyCalendarI_2 {

    static class MyCalendar {

        public TreeSet<int[]> books;

        public MyCalendar() {
            books = new TreeSet<int[]>((int[] a, int[] b) -> a[0] - b[0]);
        }

        public boolean book(int start, int end) {
            int[] book = new int[] { start, end }, floor = books.floor(book), ceiling = books.ceiling(book);
            if (floor != null && start < floor[1])
                return false; // (s, e) start within floor
            if (ceiling != null && ceiling[0] < end)
                return false; // ceiling start within (s, e)
            books.add(book);
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
