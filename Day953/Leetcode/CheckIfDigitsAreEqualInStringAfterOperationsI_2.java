//Leetcode
//3461. Check If Digits Are Equal in String After Operations I
//Time complexity: O(N^2)
//Space complexity: O(1) 

public class CheckIfDigitsAreEqualInStringAfterOperationsI_2 {

    public static void main(String[] args) {
        String s = "3902";
        System.out.println(hasSameDigits(s));
    }

    public static boolean hasSameDigits(String s) {
        char[] arr = s.toCharArray();
        int currentLength = arr.length;
        while (currentLength > 2) {
            for (int i = 0; i < currentLength - 1; i++) {
                int d1 = arr[i] - '0';
                int d2 = arr[i + 1] - '0';
                arr[i] = (char) (((d1 + d2) % 10) + '0');
            }
            currentLength--;
        }
        return arr[0] == arr[1];
    }
}
