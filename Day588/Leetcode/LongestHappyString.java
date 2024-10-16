//Leetcode
//1405. Longest Happy String - Greedy
//Time complexity: O(N)
//Space complexity:O(1)

public class LongestHappyString {

    public static void main(String[] args) {
        int a = 1, b = 1, c = 7;
        System.out.println(longestDiverseString(a, b, c));
    }

    public static String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();

        int totalLength = a + b + c;
        int continuousA = 0, continuousB = 0, continuousC = 0;

        for (int i = 0; i < totalLength; i++) {
            if ((a >= b && a >= c && continuousA != 2) || (continuousB == 2 && a > 0) || (continuousC == 2 && a > 0)) {
                sb.append("a");
                a--;
                continuousA++;
                continuousB = 0;
                continuousC = 0;
            } else if ((b >= a && b >= c && continuousB != 2) || (continuousA == 2 && b > 0)
                    || (continuousC == 2 && b > 0)) {
                sb.append("b");
                b--;
                continuousB++;
                continuousA = 0;
                continuousC = 0;
            } else if ((c >= a && c >= b && continuousC != 2) || (continuousB == 2 && c > 0)
                    || (continuousA == 2 && c > 0)) {
                sb.append("c");
                c--;
                continuousC++;
                continuousA = 0;
                continuousB = 0;
            }
        }
        return sb.toString();
    }
}
