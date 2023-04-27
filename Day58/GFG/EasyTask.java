//GFG
//Easy Task
//Time complexity: O(N+(Q*logN))
//Space complexity: O(N)

import java.util.ArrayList;

public class EasyTask {

    static class query {
        String type;
        String a;
        String b;
        String c;

        public query(String type, String a, String b, String c) {
            this.type = type;
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        int n = 4;
        String s = "abab";
        int q = 2;
        query[] queries = {};
        //queries.add(new query("1","2","d"));
        //queries.add(new query("2","1","3","1");
        System.out.println(easyTask(n, s, q, queries));
    }

    public static ArrayList<Character> easyTask(int n, String s, int q, query queries[]) {
        // Create a character array from the input string
        char[] charArray = s.toCharArray();
        // Initialize an array list to store the results of type 2 queries
        ArrayList<Character> res = new ArrayList<>();

        for (int i = 0; i < q; i++) {
            query currQuery = queries[i];
            String type = currQuery.type;
            if (type.equals("1")) {
                // Type 1 query
                int index = Integer.parseInt(currQuery.a);
                char character = currQuery.b.charAt(0);
                charArray[index] = character;
            } else {
                // Type 2 query
                int left = Integer.parseInt(currQuery.a);
                int right = Integer.parseInt(currQuery.b);
                int k = Integer.parseInt(currQuery.c);

                // Create a frequency array to count the occurrence of each character
                int[] freq = new int[26];
                for (int j = left; j <= right; j++) {
                    freq[charArray[j] - 'a']++;
                }

                // Find the kth largest character by iterating over the frequency array
                int count = 0;
                for (int j = 25; j >= 0; j--) {
                    count += freq[j];
                    if (count >= k) {
                        res.add((char) ('a' + j));
                        break;
                    }
                }
            }
        }
        return res;
    }
}
