//Leetcode
//2678. Number of Senior Citizens
//Time complexity: O(N)
//Space complexity: O(1) 

public class NumberOfSeniorCitizens {

    public static void main(String[] args) {
        String[] details = { "7868190130M7522", "5303914400F9211", "9273338290F4010" };
        System.out.println(countSeniors(details));
    }

    public static int countSeniors(String[] details) {
        int seniorCount = 0;
        for (String info : details) {
            char tens = info.charAt(11);
            char ones = info.charAt(12);
            if (tens > '6' || (tens == '6' && ones > '0')) {
                seniorCount++;
            }
        }
        return seniorCount;
    }
}
