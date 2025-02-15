//Leetcode
//2698. Find the Punishment Number of an Integer - Recursion of Strings 
//Time complexity: O(n*(2^log10(n)))
//Space complexity: O(log10(n))

public class FindThePunishmentNumberOfAnInteger_2 {

    public static void main(String[] args) {
        int n = 10;
        System.out.println(punishmentNumber(n));
    }

    public static int punishmentNumber(int n) {
        int punishmentNum = 0;
        // Iterate through numbers in range [1, n]
        for (int currentNum = 1; currentNum <= n; currentNum++) {
            int squareNum = currentNum * currentNum;
            // Check if valid partition can be found and add squared number if so
            if (canPartition(Integer.toString(squareNum), currentNum)) {
                punishmentNum += squareNum;
            }
        }
        return punishmentNum;
    }

    public static boolean canPartition(String stringNum, int target) {
        // Valid Partition Found
        if (stringNum.isEmpty() && target == 0) {
            return true;
        }
        // Invalid Partition Found
        if (target < 0) {
            return false;
        }
        // Recursively check all partitions for a valid partition
        for (int index = 0; index < stringNum.length(); index++) {
            String left = stringNum.substring(0, index + 1);
            String right = stringNum.substring(index + 1);
            int leftNum = Integer.parseInt(left);

            if (canPartition(right, target - leftNum)) {
                return true;
            }
        }
        return false;
    }
}
