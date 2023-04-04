//Leetcode - using Array (so a bit faster)
//2405. Optimal Partition of String
//Time complexity: O(N)
//Space complexity: O(26)

package Leetcode;

public class OptimalPartitionOfString_1 {

    public static void main(String[] args) {
        String s = "abacaba";
        System.out.println(partitionString(s));
    }

    public static int partitionString(String s) {

        int last_position[] = new int[26];
        int partitions = 0, last_end = 0;
        for (int i = 0; i < s.length(); i++) {
            if (last_position[s.charAt(i) - 'a'] >= last_end) {
                partitions++;
                last_end = i + 1;
            }
            last_position[s.charAt(i) - 'a'] = i + 1;
        }
        return partitions;
    }
}
