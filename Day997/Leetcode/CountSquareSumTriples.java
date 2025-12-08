//Leetcode
//1925. Count Square Sum Triples - Enumeration (Brute Force)
//Time complexity: O(N^2)
//Space complexity: O(1)

public class CountSquareSumTriples {

    public static void main(String[] args) {
        int n = 5;
        System.out.println(countTriples(n));
    }

    public static int countTriples(int n) {
        int res = 0;
        // enumerate a and b
        for (int a = 1; a <= n; ++a) {
            for (int b = 1; b <= n; ++b) {
                // determine if it meets the requirements
                int c = (int) Math.sqrt(a * a + b * b + 1.0);
                if (c <= n && c * c == a * a + b * b) {
                    ++res;
                }
            }
        }
        return res;
    }
}
