//Leetcode
//49. Group Anagrams
//Time complexity: O(n∗k∗logk) where K is the length of the longest string
//Space complexity: O(n∗k) where K is the length of the longest string

package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_2 {

    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);

            if (mp.containsKey(sortedStr)) {
                ans.get(mp.get(sortedStr)).add(str);
            } else {
                mp.put(sortedStr, ans.size());
                ans.add(new ArrayList<>(Arrays.asList(str)));
            }
        }
        return ans;
    }
}
