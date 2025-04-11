//Leetcode
//2843. Count Symmetric Integers - Enumeration
//Time complexity: O(high−low)
//Space complexity: O(1)

public class CountSymmetricIntegers_2 {

    public static void main(String[] args) {
        int low = 1, high = 100;
        System.out.println(countSymmetricIntegers(low, high));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int i = low; i <= high; i++) {
            if (i < 100 && i % 11 == 0) {
                ans++; // For 2-digit numbers
            } else if (i >= 1000 && i < 10000) {
                // For 4-digit numbers
                int left = i / 1000 + (i % 1000) / 100;
                int right = (i % 100) / 10 + i % 10;
                if (left == right) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
