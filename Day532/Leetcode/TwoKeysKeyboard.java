//Leetcode
//650. 2 Keys Keyboard - Recursion
//Time complexity: O(2^N)
//Space complexity: O(N)

public class TwoKeysKeyboard {

    public static void main(String[] args) {
        int n = 3;
        TwoKeysKeyboard obj = new TwoKeysKeyboard();
        System.out.println(obj.minSteps(n));
    }

    private int targetLength;

    public int minSteps(int n) {
        if (n == 1)
            return 0;
        this.targetLength = n;
        return 1 + findMinSteps(1, 1);
    }

    private int findMinSteps(int currentLength, int clipboardLength) {
        if (currentLength == targetLength)
            return 0;
        if (currentLength > targetLength)
            return Integer.MAX_VALUE / 2;

        int copyAndPaste = 2 + findMinSteps(currentLength * 2, currentLength);
        int pasteOnly = 1 + findMinSteps(currentLength + clipboardLength, clipboardLength);

        return Math.min(copyAndPaste, pasteOnly);
    }
}
