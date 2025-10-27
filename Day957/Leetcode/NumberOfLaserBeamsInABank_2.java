//Leetcode
//2125. Number of Laser Beams in a Bank - Greedy
//Time complexity: O(n*m)
//Space complexity: O(1)

public class NumberOfLaserBeamsInABank_2 {

    public static void main(String[] args) {
        String[] bank = { "011001", "000000", "010100", "001000" };
        System.out.println(numberOfBeams(bank));
    }

    public static int numberOfBeams(String[] bank) {
        int ans = 0, temp = 0;
        for (String str : bank) {
            int n = str.replaceAll("[^1]", "").length();
            if (n == 0)
                continue;
            ans += temp * n;
            temp = n;
        }
        return ans;
    }
}
