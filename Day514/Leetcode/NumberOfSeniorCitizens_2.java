//Leetcode
//2678. Number of Senior Citizens
//Time complexity: O(N)
//Space complexity: O(1) 

public class NumberOfSeniorCitizens_2 {

    public static void main(String[] args) {
        String[] details = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
        System.out.println(countSeniors(details));
    }

    static final int AGE_THRESHOLD = 60;
    static final char TENS_DIGIT_THRESHOLD = '6';
    static final int AGE_TENS_INDEX = 11;
    static final int AGE_ONES_INDEX = 12;

    public static int countSeniors(String[] details) {
        int seniorCount = 0;
        for (String passenger : details) {
            if (isOverSixty(passenger))
                seniorCount++;
        }
        return seniorCount;
    }

    static boolean isOverSixty(String passenger) {
        char tensDigit = passenger.charAt(AGE_TENS_INDEX);
        if (tensDigit > TENS_DIGIT_THRESHOLD)
            return true;
        if (tensDigit == TENS_DIGIT_THRESHOLD)
            return passenger.charAt(AGE_ONES_INDEX) > '0';
        return false;
    }
}
