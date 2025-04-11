//Leetcode
//2843. Count Symmetric Integers - Brute Force
//Time complexity: O(nlogn)
//Space complexity: O(1)

public class CountSymmetricIntegers {

    public static void main(String[] args) {
        int low = 1, high = 100;
        System.out.println(countSymmetricIntegers(low, high));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for (int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            if (s.length() % 2 == 0 &&
                    sum(s.substring(0, s.length() / 2)) == sum(s.substring(s.length() / 2))) {
                count++;
            }
        }
        return count;
    }

    static int sum(String str) {
        int sum = 0;
        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }
        return sum;
    }
}
