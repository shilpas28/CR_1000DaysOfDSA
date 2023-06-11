//Leetcode
//Snapshot Array
//Time complexity: Just class design 
//Space complexity: Just class design

package Leetcode;

import java.util.HashMap;

public class SnapShotArray {

    static class SnapshotArray {

        int sid = 0;
        HashMap<Integer, Integer>[] map; // sid vs value

        public SnapshotArray(int length) {
            map = new HashMap[length];
            for (int i = 0; i < length; i++)
                map[i] = new HashMap<>();
        }

        public void set(int index, int val) {
            map[index].put(sid, val);
        }

        public int snap() {
            sid++;
            return sid - 1;
        }

        public int get(int index, int snap_id) {
            while (snap_id >= 0 && !map[index].containsKey(snap_id))
                snap_id--;
            if (snap_id == -1)
                return 0;
            return map[index].get(snap_id);
        }
    }

    public static void main(String[] args) {
        SnapshotArray snapshotArr = new SnapshotArray(3); // set the length to be 3
        snapshotArr.set(0, 5); // Set array[0] = 5
        snapshotArr.snap(); // Take a snapshot, return snap_id = 0
        snapshotArr.set(0, 6);
        snapshotArr.get(0, 0); // Get the value of array[0] with snap_id = 0, return 5
    }
}
