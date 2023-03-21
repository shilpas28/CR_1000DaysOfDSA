//GFG
//Taxi Booking
//Time complexity: O(N)
//Space complexity: O(1)

public class TaxiBooking {

    public static void main(String[] args) {
        int N = 3, cur = 4;
        int pos[] = { 1, 5, 6 };
        int time[] = { 2, 3, 1 };
        System.out.println(minimumTime(N, cur, pos, time));
    }

    public static int minimumTime(int N, int cur, int[] pos, int[] time) {
        // code here
        int res=Integer.MAX_VALUE;
        for(int i=0; i<N ;i++)
        {
            res = Math.min(res, Math.abs(pos[i]-cur) * time[i]);
        }
        return res;
    }

}
