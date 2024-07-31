//Leetcode
//1105. Filling Bookcase Shelves - Tabulation (Bottom up)
//Time complexity: O(n * w) where n = no:of books and w = shelf width
//Space complexity: O(n * w) where n = no:of books and w = shelf width

public class FillingBookcaseShelves_2 {

    public static void main(String[] args) {
        int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
        int shelfWidth = 4;
        System.out.println(minHeightShelves(books, shelfWidth));
    }

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        int[] dp = new int[books.length + 1];
        for (int i = 1; i <= books.length; i++) {
            int width = books[i - 1][0];
            int height = books[i - 1][1];
            dp[i] = dp[i - 1] + height;
            for (int j = i - 1; j > 0; j--) {
                if (width + books[j - 1][0] <= shelfWidth) {
                    width += books[j - 1][0];
                    height = Math.max(height, books[j - 1][1]);
                    dp[i] = Math.min(dp[i], dp[j - 1] + height);
                } else {
                    break;
                }
            }
        }
        return dp[books.length];
    }
}
