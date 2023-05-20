//GFG
//Hands Of Straights
//Time complexity: O(NlogN)
//Space complexity: O(N)

package GFG;

import java.util.TreeMap;

public class HandsOfStraights {

    public static void main(String[] args) {
        int N = 9;
        int groupSize = 3;
        int hand[] = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        System.out.println(isStraightHand(N, groupSize, hand));
    }

    static boolean isStraightHand(int N, int groupSize, int hand[]) {
        // code here
        // precheck - if grps can be formed or not
        if (N % groupSize != 0)
            return false;
        // push elewith freq in TM
        TreeMap<Integer, Integer> m = new TreeMap<>();
        for (int x : hand) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        // itr in TM and forms grp
        while (!m.isEmpty()) {
            int a = m.firstKey();
            m.put(a, m.get(a) - 1);
            if (m.get(a) == 0)
                m.remove(a);

            for (int j = 1; j < groupSize; j++) {
                int b = a + j; // since i want consecutive
                if (m.containsKey(b)) {
                    m.put(b, m.get(b) - 1);
                    if (m.get(b) == 0)
                        m.remove(b);
                } else
                    return false;
            }
        }
        return true;
    }
}
