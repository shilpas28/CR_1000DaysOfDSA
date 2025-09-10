//GFG
//Largest number in one swap
//Time complexity: O(N)
//Space complexity: O(1)

public class LargestNumberInOneSwap {

    public static void main(String[] args) {
        String s = "768";
        System.out.println(largestSwap(s));
    }

    public static String largestSwap(String s) {
        // code here
        int swap1 = 0;
        int swap2 = 0;
        int n = s.length() - 1;
        int i = n;

        for (int j = n; j >= 0; j--) {
            char c1 = s.charAt(j);
            char c2 = s.charAt(i);
            if (c1 > c2)
                i = j;
            else if (c1 < c2) {
                swap1 = i;
                swap2 = j;
            } else
                continue;
        }
        
        if (swap1 == 0 && swap2 == 0)
            return s;

        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(swap1, s.charAt(swap2));
        sb.setCharAt(swap2, s.charAt(swap1));
        return sb.toString();
    }
}
