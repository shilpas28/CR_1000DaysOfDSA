//Leetcode
//3307. Find the K-th Character in String Game II
//Time complexity: O(logk)
//Space complexity: O(1)

public class FindTheKthCharacterInStringGameII_2 {

    public static void main(String[] args) {
        long k = 5;
        int[] operations = { 0, 0, 0 };
        System.out.println(kthCharacter(k, operations));
    }

    public static char kthCharacter(long k, int[] operations) {
        int c = 0;
        k--;
        for (int i = 0; k != 0; i++, k >>= 1)
            c += ((int) (k & 1) & operations[i]);
        return (char) ((c % 26) + 'a');
    }
}
