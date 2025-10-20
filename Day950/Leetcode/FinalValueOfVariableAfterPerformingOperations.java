//Leetcode
//2011. Final Value of Variable After Performing Operations
//Time complexity: O(N)
//Space complexity: O(1)

public class FinalValueOfVariableAfterPerformingOperations {

    public static void main(String[] args) {
        String[] operations = { "++X", "++X", "X++" };
        System.out.println(finalValueAfterOperations(operations));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int val = 0;
        for (int i = 0; i < operations.length; i++) {
            if (operations[i].charAt(1) == '+')
                val++;
            else
                val--;
        }
        return val;
    }
}
