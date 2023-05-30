//Leetcode
//705. Design HashSet
//Time complexity: Just class design
//Space complexity: Just class design

package Leetcode;

import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {

    static class MyHashSet {
        int numBuckets = 15000;
        List<Integer>[] buckets;

        public int hash_function(int key) {
            return key % numBuckets;
        }

        public MyHashSet() {
            buckets = new LinkedList[numBuckets];
        }

        public void add(int key) {
            int i = hash_function(key);
            if (buckets[i] == null)
                buckets[i] = new LinkedList<>();
            if (buckets[i].indexOf(key) == -1)
                buckets[i].add(key);
        }

        public void remove(int key) {
            int i = hash_function(key);
            if (buckets[i] == null)
                return;
            if (buckets[i].indexOf(key) != -1)
                buckets[i].remove(buckets[i].indexOf(key));
        }

        public boolean contains(int key) {
            int i = hash_function(key);
            if (buckets[i] == null || buckets[i].indexOf(key) == -1)
                return false;
            return true;
        }
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1); // set = [1]
        myHashSet.add(2); // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2); // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2); // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }
}
