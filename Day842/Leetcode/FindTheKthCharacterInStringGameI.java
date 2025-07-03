//Leetcode
//3304. Find the K-th Character in String Game I
//Time complexity: O(k^2)
//Space complexity: O(k)

public class FindTheKthCharacterInStringGameI {

    public static void main(String[] args) {
        int k = 5;
        System.out.println(kthCharacter(k));
    }

    public static char kthCharacter(int k) {
        StringBuilder res = new StringBuilder();
        res.append("a");
        while (res.length() < k) {
            StringBuilder sb = new StringBuilder();
            String temp = res.toString();
            for (char j : temp.toCharArray()) {
                sb.append((char) (j + 1));
            }
            res.append(sb);
        }
        return res.charAt(k - 1);
    }
}
