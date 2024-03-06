//GFG
//Search Pattern (Rabin-Karp Algorithm)
//Time complexity: O(|text| + |pattern|)
//Space complexity: O(1)

package GFG;

import java.util.ArrayList;

public class SearchPatternRabinKarpAlgorithm_2 {

    public static void main(String[] args) {
        String text = "geeksforgeeks";
        String pattern = "geek";
        System.out.println(search(pattern, text));
    }

    static ArrayList<Integer> search(String pattern, String text) {
        // your code here
        ArrayList<Integer> list = new ArrayList<>();
        int index = text.indexOf(pattern);
        while (index != -1) {
            list.add(index + 1);
            index = text.indexOf(pattern, index + 1);
        }
        return list;
    }
}
