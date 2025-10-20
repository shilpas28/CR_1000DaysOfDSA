//Leetcode
//2011. Final Value of Variable After Performing Operations
//Time complexity: O(N)
//Space complexity: O(1)

public class FinalValueOfVariableAfterPerformingOperations_2 {

    public static void main(String[] args) {
        String[] operations = { "++X", "++X", "X++" };
        System.out.println(finalValueAfterOperations(operations));
    }

    public static int finalValueAfterOperations(String[] operations) {
        return java.util.Arrays.stream(operations).mapToInt(op -> op.charAt(1) == '+' ? 1 : -1).sum();
    }
}
