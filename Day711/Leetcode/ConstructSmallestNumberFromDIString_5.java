//Leetcode
//2375. Construct Smallest Number From DI String - Greedy Approach with Sliding Window Reversal
//Time complexity: O(n^2)
//Space complexity: O(n) 

public class ConstructSmallestNumberFromDIString_5 {

    public static void main(String[] args) {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern));
    }

    public static String smallestNumber(String pattern) {
        StringBuilder result = new StringBuilder();
        // Iterate through the pattern and build the result
        for (int currentIndex = 0, previousIndex = 0; currentIndex <= pattern.length(); ++currentIndex) {
            result.append(1 + currentIndex);
            // Reverse the substring starting from previousIndex when necessary
            if (currentIndex == pattern.length() ||
                    pattern.charAt(currentIndex) == 'I') {
                StringBuilder temp = new StringBuilder();
                temp
                        .append(result.substring(0, previousIndex))
                        .append(
                                new StringBuilder(
                                        result.substring(previousIndex)).reverse());
                result = temp;
                previousIndex = currentIndex + 1;
            }
        }
        // Return the final result as a string
        return result.toString();
    }
}
