//Leetcode
//1105. Filling Bookcase Shelves - Memoization (Top down)
//Time complexity: O(n^2)
//Space complexity: O(n)

public class FillingBookcaseShelves {

    public static void main(String[] args) {
        int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
        int shelfWidth = 4;
        System.out.println(minHeightShelves(books, shelfWidth));
    }

    static int[][] memo;

    public static int minHeightShelves(int[][] books, int shelfWidth) {
        memo = new int[books.length + 1][shelfWidth + 1];
        return minHeight(books, 0, shelfWidth, 0, shelfWidth);
    }

    public static int minHeight(int[][] books, int cur, int widthLeft, int curHeight, int shelf_width) {
        if (cur == books.length) {
            return curHeight;
        }
        if (memo[cur][widthLeft] != 0)
            return memo[cur][widthLeft];
        memo[cur][widthLeft] = curHeight
                + minHeight(books, cur + 1, shelf_width - books[cur][0], books[cur][1], shelf_width);
        if (widthLeft >= books[cur][0]) {
            memo[cur][widthLeft] = Math.min(minHeight(books, cur + 1, widthLeft - books[cur][0],
                    Math.max(curHeight, books[cur][1]), shelf_width), memo[cur][widthLeft]);
        }
        return memo[cur][widthLeft];
    }
}
