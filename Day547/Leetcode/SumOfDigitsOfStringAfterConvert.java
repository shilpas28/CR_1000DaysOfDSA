//Leetcode
//1945. Sum of Digits of String After Convert
//Time complexity: O(K*N)
//Space complexity: O(N)

public class SumOfDigitsOfStringAfterConvert {

    public static void main(String[] args) {
        String s = "iiii";
        int k = 1;
        System.out.println(getLucky(s, k));
    }

    public static int getLucky(String s, int k) {
        // Convert each character in the string to its corresponding numeric value
        StringBuilder number = new StringBuilder();
        for (char x : s.toCharArray()) {
            number.append(x - 'a' + 1);
        }
        // Perform the transformation `k` times
        while (k > 0) {
            int temp = 0;
            for (char x : number.toString().toCharArray()) {
                temp += x - '0'; // Sum the digits of the current number
            }
            number = new StringBuilder(String.valueOf(temp)); // Convert the sum back to a string
            k--;
        }
        return Integer.parseInt(number.toString()); // Return the final result as an integer
    }
}
