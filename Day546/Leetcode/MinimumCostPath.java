//Leetcode
//1894. Find the Student that Will Replace the Chalk
//Time complexity: O(N)
//Space complexity: O(1)

public class MinimumCostPath {

    public static void main(String[] args) {
        int[] chalk = { 5, 1, 5 };
        int k = 22;
        System.out.println(chalkReplacer(chalk, k));
    }

    public static int chalkReplacer(int[] chalk, int k) {
        long totalChalkNeeded = 0;
        for (int studentChalkUse : chalk) {
            totalChalkNeeded += studentChalkUse;
        }

        int remainingChalk = (int) (k % totalChalkNeeded);

        for (int studentIndex = 0; studentIndex < chalk.length; studentIndex++) {
            if (remainingChalk < chalk[studentIndex]) {
                return studentIndex;
            }
            remainingChalk -= chalk[studentIndex];
        }
        return 0;
    }
}
