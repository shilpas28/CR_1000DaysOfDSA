//Leetcode
//3304. Find the K-th Character in String Game I
//Time complexity: O(logk)
//Space complexity: O(1)

public class FindTheKthCharacterInStringGameI_3 {

    public static void main(String[] args) {
        int k = 5;
        System.out.println(kthCharacter(k));
    }

    public static char kthCharacter(int k) {
        return (char) ('a' + Integer.bitCount(k - 1));
    }
}
