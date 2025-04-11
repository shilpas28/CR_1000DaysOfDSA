//Leetcode
//2843. Count Symmetric Integers - Digit DP
//Time complexity: O(d^3) or O((log n)^3), where d is the number of digits in the number being considered
//Space complexity: O(d^3) or O((log n)^3)

public class CountSymmetricIntegers_3 {

    public static void main(String[] args) {
        int low = 1, high = 100;
        System.out.println(countSymmetricIntegers(low, high));
    }

    // To count symmetric integers within the inclusive range [low, high].
    public static int countSymmetricIntegers(int low, int high) {
        // Count symmetric numbers up to 'high' and subtract those up to 'low - 1'.
        return countUpTo(high) - countUpTo(low - 1);
    }

    // Counts all symmetric numbers up to 'num'.
    public static int countUpTo(int num) {
        String numStr = Integer.toString(num);
        int n = numStr.length();
        // Offsets used to ensure dp table indices are always non-negative.
        int FirstHalfSum = n; // Shifts 'rem' range.
        int diffFromLeft = 9 * n; // Shifts 'diff' range.
        // Parameters explained in solution
        int[][][][][][] dp = new int[n + 1][2][2][2][2 * n + 1][18 * n + 1];
        // Initialize the DP array with -1
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        for (int m = 0; m < 2 * n + 1; m++) {
                            for (int o = 0; o < 18 * n + 1; o++) {
                                dp[i][j][k][l][m][o] = -1;
                            }
                        }
                    }
                }
            }
        }
        // Start recursion from the first digit, with a tight bound (tight = 1),
        // no nonzero digit encountered yet (hasNonZero = 0), and in first half mode
        // (isSecondHalf = 0).
        return countSymmetricRec(numStr, 0, n, 1, 0, 0, 0, 0, FirstHalfSum, diffFromLeft, dp);
    }

    public static int countSymmetricRec(String numStr, int idx, int n, int tight, int hasNonZero, int isSecondHalf,
            int rem, int diff, int FirstHalfSum, int diffFromLeft,
            int[][][][][][] dp) {
        // Base Case: When we have processed all digits,
        // check if the number is valid (i.e., non-zero-started and symmetric).
        if (idx == n)
            return (hasNonZero == 1 && diff == 0 && rem == 0) ? 1 : 0;
        // Get the memoized result for the current state.
        // We add offsets (FirstHalfSum and diffFromLeft) to shift potential negative
        // values to positive indices.
        if (dp[idx][tight][hasNonZero][isSecondHalf][rem + FirstHalfSum][diff + diffFromLeft] != -1)
            return dp[idx][tight][hasNonZero][isSecondHalf][rem + FirstHalfSum][diff + diffFromLeft];
        // Determine the maximum digit available at this index:
        // If 'tight' is true, the maximum is bound by the current digit in numStr.
        // Otherwise, we can choose any digit from 0 to 9.
        int maxDigit = (tight == 1 ? numStr.charAt(idx) - '0' : 9);
        int result = 0;
        // Try every possible digit from 0 to maxDigit at this position.
        for (int digit = 0; digit <= maxDigit; digit++) {
            // Update hasNonZero: becomes true if already true, or if the chosen digit is
            // nonzero.
            int newHasNonZero = hasNonZero == 1 || (digit != 0) ? 1 : 0;
            // Start with current balance and difference values.
            int newRem = rem;
            int newDiff = diff;
            // Update the running difference and balance counter based on the current half.
            if (isSecondHalf == 1) {
                // In the second half, subtract the digit from the running difference.
                newDiff -= digit;
                // Also, decrease the balance counter if a nonzero digit has been set.
                if (newHasNonZero == 1)
                    newRem -= 1;
            } else {
                // In the first half, add the digit to the running difference.
                newDiff += digit;
                // Increase the balance counter if we've started the number.
                if (newHasNonZero == 1)
                    newRem += 1;
            }
            // Determine if the next state remains tight:
            // It's still tight if we chose the maximum allowed digit.
            int newTight = (tight == 1 && (digit == maxDigit)) ? 1 : 0;
            // Continue building the number with the chosen digit.
            result += countSymmetricRec(numStr, idx + 1, n, newTight, newHasNonZero, isSecondHalf, newRem, newDiff,
                    FirstHalfSum, diffFromLeft, dp);
            // Branch into processing the second half if we are currently in the first half
            // and the number has started.
            if (newHasNonZero == 1 && isSecondHalf == 0) {
                result += countSymmetricRec(numStr, idx + 1, n, newTight, newHasNonZero, 1, newRem, newDiff,
                        FirstHalfSum, diffFromLeft, dp);
            }
        }
        // Save the computed result for this state and return.
        dp[idx][tight][hasNonZero][isSecondHalf][rem + FirstHalfSum][diff + diffFromLeft] = result;
        return result;
    }
}
