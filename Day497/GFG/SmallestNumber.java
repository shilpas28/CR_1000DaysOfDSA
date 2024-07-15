//GFG
//Smallest number
//Time complexity: O(d)
//Space complexity: O(1)

public class SmallestNumber {

    public static void main(String[] args) {
        int s = 20, d = 3;
        System.out.println(smallestNumber(s, d));
    }

    public static String smallestNumber(int s, int d) {
        // code here
        StringBuilder ans = new StringBuilder();
        int i = 1;
        while (i <= d) {
            int num = s - (d - i) * 9 <= 0 ? 0 : s - (d - i) * 9;
            if (num > 9)
                return "-1";
            if (i == 1 && num == 0)
                num = 1;
            ans.append((char) (num + '0'));
            s -= num;
            i++;
        }
        return ans.toString();
    }
}
