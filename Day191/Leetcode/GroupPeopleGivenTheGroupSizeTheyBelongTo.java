//Leetcode
//1282. Group the People Given the Group Size They Belong To
//Time complexity: O(N)
//Space complexity: O(N)

package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupPeopleGivenTheGroupSizeTheyBelongTo {

    public static void main(String[] args) {
        int[] groupSizes = { 3, 3, 3, 3, 3, 1, 3 };
        System.out.println(groupThePeople(groupSizes));
    }

    public static List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            list.add(i);
            map.put(groupSizes[i], list);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int key : map.keySet()) {
            int i = 0;
            List<Integer> list = map.get(key);
            do {
                res.add(list.subList(i, i + key));
                i += key;
            } while (i + key <= list.size());
        }
        return res;
    }
}
