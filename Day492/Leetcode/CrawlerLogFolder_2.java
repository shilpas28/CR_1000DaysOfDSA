//Leetcode
//1598. Crawler Log Folder - Depth Counting
//Time complexity: O(N)
//Space complexity: O(1)

package Leetcode;

public class CrawlerLogFolder_2 {

    public static void main(String[] args) {
        String[] logs = { "d1/", "d2/", "../", "d21/", "./" };
        System.out.println(minOperations(logs));
    }

    public static int minOperations(String[] logs) {
        int res = 0;
        for (String log : logs) {
            if (log.equals("../")) {
                if (res > 0) {
                    res--;
                }
            } else if (!log.equals("./")) {
                res++;
            }
        }
        return res;
    }
}
