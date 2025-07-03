//Leetcode
//3304. Find the K-th Character in String Game I
//Time complexity: O(logk)
//Space complexity: O(1)

public class FindTheKthCharacterInStringGameI_2 {

    public static void main(String[] args) {
        int k = 5;
        System.out.println(kthCharacter(k));
    }

    public static char kthCharacter(int k) {
        int letterOffset = 0;
        while (k > 1) {
            int exponent = (int) (Math.log(k - 1) / Math.log(2));
            int groupSize = 1 << exponent;
            k -= groupSize;
            letterOffset++;
        }
        return (char) ('a' + letterOffset);
    }
}
