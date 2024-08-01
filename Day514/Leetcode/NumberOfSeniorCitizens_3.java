//Leetcode
//2678. Number of Senior Citizens
//Time complexity: O(N)
//Space complexity: O(1) 

public class NumberOfSeniorCitizens_3 {

    public static void main(String[] args) {
        String[] details = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
        System.out.println(countSeniors(details));
    }

    static final int ELDERLY_THRESHOLD = 60;
    static final int AGE_TENS_INDEX = 11;
    static final int AGE_ONES_INDEX = 12;

    public static int countSeniors(String[] details) {
        int elderlyCount = 0;
        for (String passengerInfo : details) {
            if (calculateAge(passengerInfo) > ELDERLY_THRESHOLD)
                elderlyCount++;
        }
        return elderlyCount;
    }

    static int calculateAge(String info) {
        int tens = charToDigit(info.charAt(AGE_TENS_INDEX));
        int ones = charToDigit(info.charAt(AGE_ONES_INDEX));
        return tens * 10 + ones;
    }

    static int charToDigit(char c) {
        return c - '0';
    }
}
